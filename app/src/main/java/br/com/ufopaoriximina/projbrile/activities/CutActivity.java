package br.com.ufopaoriximina.projbrile.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.ucrop.UCrop;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.config.bdLetra;

public class CutActivity extends AppCompatActivity {
    private ImageView view;
    private  final int CODE_IMAGE_GALERY = 1;
    private ImageView concluir, cancelar;
    private boolean escolhido = false;
    private Bitmap grayBitMap, imgBitMap;
    private String texto;
    private TextView indicacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut);
        getSupportActionBar().hide();
        OpenCVLoader.initDebug();
        init();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent().
                        setAction(Intent.ACTION_GET_CONTENT).
                        setType("image/*"), CODE_IMAGE_GALERY);
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkExit();
            }
        });
        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traduzir();
            }
        });
    }

    private void init() {
        this.view = findViewById(R.id.imageView);
        concluir = findViewById(R.id.imagemConcluirEdition);
        cancelar = findViewById(R.id.imagemCancelEdition);
        indicacao  = findViewById(R.id.observacaoText);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void checkExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente cancelar a edição?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(),ActivityInicial.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(CutActivity.this, i, activityOptionsCompat.toBundle());
                        finish();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== CODE_IMAGE_GALERY && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            if (imageUri!=null){
                startCrop(imageUri);
            }
        }else  if (requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK){
            Uri imagemUriResultCrop = UCrop.getOutput(data);
            if (imagemUriResultCrop!=null){
                view.setImageURI(imagemUriResultCrop);
                try {
                    imgBitMap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imagemUriResultCrop);
                    indicacao.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private  void startCrop(@NonNull Uri uri){
        String destinationFileName = "SampleCropImg";
        destinationFileName +=".jpg";

        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), destinationFileName)));

        uCrop.withAspectRatio(1, 1);
//        uCrop.withAspectRatio(3,4);
//        uCrop.useSourceImageAspectRatio();
//        uCrop.withAspectRatio(2,3);
//        uCrop.withAspectRatio(16,9);

        uCrop.withMaxResultSize(450, 450);

        uCrop.withOptions(getCropOptions());

        uCrop.start(CutActivity.this);
    }

    private UCrop.Options getCropOptions(){
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(70);

        //Compresstype
        //options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        //options.setCompressionFormat(Bitmap.CompressFormat.JPEG);


        //UI
        options.setHideBottomControls(false);
        options.setFreeStyleCropEnabled(true);

        //colors
        options.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        options.setToolbarColor(getResources().getColor(R.color.colorPrimary));

        options.setToolbarTitle("Recortar imagem");
        return options;
    }

    public void traduzir(){
        try {
            if(imgBitMap == null){
                Toast.makeText(getApplicationContext(), "ImageView não selecionada, por favor selecione uma imagem", Toast.LENGTH_SHORT).show();
            }else{
                Mat Rgba = new Mat();
                Mat grayMat = new Mat();

                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inDither = false;
                o.inSampleSize = 4;

                int width = imgBitMap.getWidth();
                int height = imgBitMap.getHeight();

                grayBitMap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

                //BitMap to mat
                Utils.bitmapToMat(imgBitMap, Rgba);

                //Gray Scale
                Imgproc.cvtColor(Rgba, grayMat, Imgproc.COLOR_RGB2GRAY);

                //ThresHold(Limiarização)
                Imgproc.threshold(grayMat, grayMat, 233, 255, Imgproc.THRESH_BINARY_INV);

                //Median Filter(Filtro de Mediana/Morfologia)
                Imgproc.medianBlur(grayMat, grayMat, 3);

                //Erode
                Imgproc.erode(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(1, 2)));

                //Dilate
                Imgproc.dilate(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(1, 2)));

                //Toast.makeText(this, "The image was loaded", Toast.LENGTH_SHORT ).show();

                // find contours (Acha o contorno dos circulos)
                List<MatOfPoint> countours = new ArrayList<>();
                Mat hierarchy = new Mat();
                Imgproc.findContours(grayMat, countours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

                //Find centroids (acha p centro de cada circulo e coloca em X(coluna) Y(Linha))
                ArrayList<Integer> arrayX = new ArrayList<>();
                ArrayList<Integer> arrayY = new ArrayList<>();
                List<Moments> mu = new ArrayList<>();

                for (int i = 0; i < countours.size(); i++) {

                    mu.add(i, Imgproc.moments(countours.get(i), true));
                    Moments p = mu.get(i);
                    int x = (int) (p.get_m10() / p.get_m00());
                    int y = (int) (p.get_m01() / p.get_m00());
                    arrayX.add(x);
                    arrayY.add(y);
                }

                int[][] centroids = new int[arrayX.size()][2];
                for (int i = 0; i < arrayX.size(); i++) {
                    centroids[i][0] = arrayX.get(i);
                    centroids[i][1] = arrayY.get(i);
                }

                //draw lines
                Collections.sort(arrayX);
                Collections.sort(arrayY);

                Set<Integer> xSemRepetir = new LinkedHashSet<>(arrayX);

                Set<Integer> ySemRepetir = new LinkedHashSet<>(arrayY);

                Integer[] arrayXSemRep = new Integer[xSemRepetir.size()];
                xSemRepetir.toArray(arrayXSemRep);

                Integer[] arrayYSemRep = new Integer[ySemRepetir.size()];
                ySemRepetir.toArray(arrayYSemRep);

                ArrayList<Integer> index_col = new ArrayList<>();
                index_col.add(0);
                Integer contadorAntesX = 0;
                for (Integer integer : arrayXSemRep) {
                    if (integer > contadorAntesX) {
                        Imgproc.line(grayMat, new Point(integer + 6, 0), new Point(integer + 6, 1800), new Scalar(130, 0, 0)); //fazer colunas
                        contadorAntesX = integer + 6;
                        index_col.add(contadorAntesX);
                    }
                }

                ArrayList<Integer> index_lin = new ArrayList<>();
                index_lin.add(0);
                Integer contadorAntesY = 0;
                for (Integer integer : arrayYSemRep) {
                    if (integer > contadorAntesY) {
                        Imgproc.line(grayMat, new Point(0, integer + 6), new Point(900, integer + 6), new Scalar(130, 0, 0)); //fazer linhas
                        contadorAntesY = integer + 6;
                        index_lin.add(contadorAntesY);
                    }
                }

                //Recognition of word
                String flag = "0";

                for (int i = 0; i <= (index_lin.size() - 3); i = i + 3) {
                    for (int j = 0; j < (index_col.size() - 2); j += 2) {
                        int[] Vlinha = new int[4];
                        int[] Vcoluna = new int[3];
                        int[] Vletra = {0, 0, 0, 0, 0, 0};
                        int m = 0, cnt = 0;
                        for (int p = i; p <= (i + 3); p++) {
                            Vlinha[m] = index_lin.get(p);
                            m++;
                        }
                        int n = 0;
                        for (int t = j; t <= (j + 2); t++) {
                            Vcoluna[n] = index_col.get(t);
                            n++;
                        }
                        for (m = 0; m < (Vcoluna.length) - 1; m++) {
                            for (n = 0; n < (Vlinha.length) - 1; n++) {
                                for (int k = 0; k < centroids.length; k++) {
                                    if (centroids[k][0] >= Vcoluna[m] && centroids[k][0] <= Vcoluna[m + 1] && centroids[k][1] >= Vlinha[n] && centroids[k][1] <= Vlinha[n + 1]) {                                    //centroids[0][k] >= Vcoluna[m] && centroids[0][k] <= Vcoluna[m+1] && centroids[1][k] >= Vlinha[n] && centroids[1][k] <= Vlinha[n+1]){
                                        Vletra[cnt] = 1;
                                    }
                                }
                                cnt = cnt + 1;
                            }
                        }

                        bdLetra carac = new bdLetra();
                        String[] letra = carac.letraBD(Vletra, flag);
                        texto = texto+letra[0];
                        flag = letra[1];
                    }
                }
                Utils.matToBitmap(grayMat, grayBitMap);
                //set to the Imageview
                Intent intentEnviadora = new Intent(this, translatedTexActivity.class);
                Bundle enviaTraducao = new Bundle();
                enviaTraducao.putString("string_texto", texto);
                intentEnviadora.putExtras(enviaTraducao);
                startActivity(intentEnviadora);
                finish();
            }
        }catch (Exception e){
            Log.d("Erro", e.getMessage());
        }
    }
}