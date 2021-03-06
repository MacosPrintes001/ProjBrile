package br.com.ufopaoriximina.projbrile.activities;

import android.content.ContentValues;
import android.content.Context;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.config.bdLetra;
import de.hdodenhof.circleimageview.CircleImageView;

public class CutActivity extends AppCompatActivity {
    private ImageView view;
    Uri image_uri;
    private final int CODE_IMAGE_GALERY = 1, IMAGE_CAPTURE_CODE = 2;
    private ImageView  camera;
    private CircleImageView  imagem;
    private boolean escolhido = false;
    private Bitmap grayBitMap, imgBitMap;
    private String texto = " ", textoToSend;
    private TextView indicacao, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut);
        getSupportActionBar().hide();
        OpenCVLoader.initDebug();
        init();


        view.setOnClickListener(new View.OnClickListener() { //perguntar para o usuario se a imagem vai ser da galeria ou da camera
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent().setAction(Intent.ACTION_GET_CONTENT).setType("image/*"), CODE_IMAGE_GALERY);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkExit();
            }
        });

    }

    private void takePicture() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntet = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntet.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntet, IMAGE_CAPTURE_CODE);
    }

    private void init() {
        this.view = findViewById(R.id.imageView);
        cancelar = findViewById(R.id.textCancelar);
        camera = findViewById(R.id.btnCamera);
        imagem = findViewById(R.id.imageView3);
        indicacao = findViewById(R.id.observacaoText);
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

    private void checkExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente cancelar a edição?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), ActivityInicial.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
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

        if (requestCode == CODE_IMAGE_GALERY && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            if (imageUri != null) {
                startCrop(imageUri);
            }
        } else if (requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK) {
            Uri imagemUriResultCrop = UCrop.getOutput(data);
            if (imagemUriResultCrop != null) {
                //imagem.setImageURI(imagemUriResultCrop);
                try {
                    imgBitMap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imagemUriResultCrop);
                    Intent i = new Intent(getApplicationContext(), ActivityConfirmacaoEdit.class);
                    traduzir();
                    i.putExtra("image", imagemUriResultCrop);
                    i.putExtra("string_texto", textoToSend);
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
                    ActivityCompat.startActivity(CutActivity.this, i, activityOptionsCompat.toBundle());
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK){
            if (image_uri != null){
               startCrop(image_uri);
            }
        }
    }

    private Uri getImageUri(Context context, Bitmap inImage) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "imagemUri", null);
        }catch (Exception o){
            Toast.makeText(this, "" + o, Toast.LENGTH_SHORT).show();
        }
        return null;
    }


    private void startCrop(@NonNull Uri uri) {
        String destinationFileName = "SampleCropImg";
        destinationFileName += ".jpg";

        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), destinationFileName)));

//        uCrop.withAspectRatio(1, 1);
//        uCrop.withAspectRatio(3,4);
        uCrop.useSourceImageAspectRatio();
//        uCrop.withAspectRatio(2,3);
//        uCrop.withAspectRatio(16,9);

        uCrop.withMaxResultSize(450, 450);

        uCrop.withOptions(getCropOptions());

        uCrop.start(CutActivity.this);
    }

    private UCrop.Options getCropOptions() {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(70);

        //Compresstype
//        options.setCompressionFormat(Bitmap.CompressFormat.PNG);
//        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);

        //UI
        options.setHideBottomControls(false);
        options.setFreeStyleCropEnabled(true);

        //colors
        options.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        options.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        options.setToolbarTitle("Recortar imagem");
        return options;
    }

    public void traduzir() {
        try {
            if (imgBitMap == null) {
                Toast.makeText(getApplicationContext(), "Nenhuma imagem detectada, por favor selecione uma imagem", Toast.LENGTH_SHORT).show();
            } else {
                Mat Rgba = new Mat();
                Mat grayMat = new Mat();

                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inDither = false;
                o.inSampleSize = 4;

                int width = imgBitMap.getWidth();
                int height = imgBitMap.getHeight();

                //transforma o padrão de cores da imagem para RGB
                grayBitMap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

                //BitMap to Mat
                Utils.bitmapToMat(imgBitMap, Rgba);

                /**exemplo d eque naõ pode usar um BitMap*/
                //Imgproc.cvtColor(imgBitMap, imgBitMap, Imgproc.COLOR_RGB2GRAY);
                //Imgproc.cvtColor
                ;

                //Gray Scale
                Imgproc.cvtColor(Rgba, grayMat, Imgproc.COLOR_RGB2GRAY);
                //ThresHold(Limiarização)
                Imgproc.threshold(grayMat, grayMat, 233, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C);
                //Median Filter(Filtro de Mediana/Morfologia)
                Imgproc.GaussianBlur(grayMat, grayMat, new Size(9, 9), 0.2);
                //Dilate
                Imgproc.dilate(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(2, 2)));
                //Erode
                Imgproc.erode(grayMat, grayMat, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(2, 2)));



                // find contours (Acha o contorno dos circulos)
                List<MatOfPoint> countours = new ArrayList<>();
                Mat hierarchy = new Mat();
                Imgproc.findContours(grayMat, countours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

                //Find centroids (acha p centro de cada circulo e coloca em X(coluna) Y(Linha))
                ArrayList<Integer> arrayX = new ArrayList<>();
                ArrayList<Integer> arrayY = new ArrayList<>();
                List<Moments> mu = new ArrayList<>();


                ArrayList<ArrayList<Integer>> centroids = new ArrayList<>();
                centroids.add(new ArrayList<Integer>());
                centroids.add(new ArrayList<Integer>());


                for (int i = 0; i < countours.size(); i++) {
                    mu.add(i, Imgproc.moments(countours.get(i), true));
                    Moments p = mu.get(i);

                    int x = (int) (p.get_m10() / p.get_m00());
                    int y = (int) (p.get_m01() / p.get_m00());

                    arrayX.add(x);
                    arrayY.add(y);

                    centroids.get(0).add(y);//Linha
                    centroids.get(1).add(x);//coluna
                }

                // Odena os arrays X e Y
                Collections.sort(arrayX);
                Collections.sort(arrayY);

                //removendo 0 do centroids
                for (int i = 0; i < centroids.get(0).size(); i++) {
                    if (centroids.get(0).get(i) == 0 && centroids.get(1).get(i) == 0) {
                        centroids.get(0).remove(i);
                        centroids.get(1).remove(i);
                    }
                }

                //Remove os primeiros valores caso eles serem  0
                if (arrayX.get(0) == 0) {
                    arrayX.remove(arrayX.get(0));
                }
                if (arrayY.get(0) == 0) {
                    arrayY.remove(arrayY.get(0));
                }


                int incremento = 4;

                //Insere UMA coluna antes do primeiro centroid
                Imgproc.line(grayMat, new Point(arrayX.get(0) - incremento, 0), new Point(arrayX.get(0) - incremento, imgBitMap.getHeight()), new Scalar(130, 0, 0));

                //insere as demais Colunas na imagem
                ArrayList<Integer> index_col = new ArrayList<>();

                index_col.add(arrayX.get(0) - incremento); //adicionando a posicao da coluna que foi adicionada manualmente

                int contadorAntesX = 0;
                for (Integer integer : arrayX) {
                    if (integer >= (contadorAntesX + incremento)) {
                        Imgproc.line(grayMat, new Point(integer + incremento, 0), new Point(integer + incremento, imgBitMap.getHeight()), new Scalar(130, 0, 0)); //fazer colunas
                        contadorAntesX = integer;
                        index_col.add(contadorAntesX + incremento);
                    }
                }

                //Insere UMA linha antes do primeiro centroid
                Imgproc.line(grayMat, new Point(0, arrayY.get(0) - incremento), new Point(imgBitMap.getWidth(), arrayY.get(0) - incremento), new Scalar(130, 0, 0));

                //Insere as demais Linhas na imagem
                ArrayList<Integer> index_lin = new ArrayList<>();

                index_lin.add(arrayY.get(0) - incremento); //adicionando a posicao da linha que foi adicionada manualmente

                int contadorAntesY = 0;
                for (Integer integer : arrayY) {
                    if (integer >= (contadorAntesY + incremento)) {
                        Imgproc.line(grayMat, new Point(0, integer + incremento), new Point(imgBitMap.getWidth(), integer + incremento), new Scalar(130, 0, 0)); //fazer linhas
                        contadorAntesY = integer;
                        index_lin.add(contadorAntesY + incremento);
                    }
                }

                index_col = verificao(index_lin, index_col, centroids); // função para verificar se os primeiros pontos são maiusculas
                String espace = " \n ";

                //Reconhecimento das letras
                String flag = "0";
                for (int i = 0; i < (index_lin.size() - 3); i = i + 3) {
                    for (int j = 0; j < (index_col.size() - 2); j = j + 2) {

                        int[] vLetras = {0, 0, 0, 0, 0, 0};
                        int cnt = 0;

                        for (int n = 0; n < 2; n++) {
                            for (int m = 0; m < 3; m++) {
                                for (int k = 0; k < centroids.get(0).size(); k++) {
                                    if (centroids.get(0).get(k) >= index_lin.get(i + m) && centroids.get(0).get(k) <= index_lin.get((i + m) + 1) && centroids.get(1).get(k) >= index_col.get(j + n) && centroids.get(1).get(k) <= index_col.get((j + n) + 1)) {
                                        vLetras[cnt] = 1;
                                    }
                                }cnt = cnt + 1;
                            }
                        }

                        String[] letra = bdLetra.letraBD(vLetras, flag);
                        //System.out.println(letra[0]);
                        texto = texto + letra[0];
                        flag = letra[1];
                    }
                    texto = texto + espace;
                }

//                Utils.matToBitmap(grayMat, imgBitMap);
//                view.setImageBitmap(imgBitMap);
//            }
//        } catch (Exception e) {
//            Log.d("Erro", Objects.requireNonNull(e.getMessage()));
//        }
//    }
//}
                textoToSend = texto.toString();
            }
        } catch (Exception e) {
            Log.d("Erro", Objects.requireNonNull(e.getMessage()));
        }
    }

 private ArrayList<Integer> verificao(ArrayList<Integer> Linha, ArrayList<Integer> Coluna, ArrayList<ArrayList<Integer>> Centroids) {
        ArrayList<Integer> remCol = new ArrayList<>();
        remCol.add(0);

        for (int j = 0; j < 1; j++) {  //Coluna
            for (int i = 0; i <(Linha.size()-3); i=i+3) { //Linha
                int[] vLetras = {0, 0, 0, 0, 0, 0};
                int[] vCent =   {0, 0, 0, 0, 0, 0};
                int cnt = 0;

                //Preenche vLetras para dps fazer a comparação da proximidade dos pontos
                for (int n = 0; n < 3; n++) {  //Linha
                    for (int m = 0; m < 2; m++) {  //Coluna
                        for (int k = 0; k < Centroids.get(0).size(); k++) {
                            if (Centroids.get(0).get(k) >= Linha.get(i + m) && Centroids.get(0).get(k) <= Linha.get((i + m) + 1) && Centroids.get(1).get(k) >= Coluna.get(n) && Centroids.get(1).get(k) <= Coluna.get(n + 1)) {
                                vLetras[cnt] = 1;
                                vCent[cnt] = k;
                            }
                        }cnt = cnt+1;
                    }
                }

                if (vLetras[0] == vLetras[2] && vLetras[0] != vLetras[1]) {

                    double r1 = 0;
                    double r2 = 0;
                    double r3 = 0;
                    double r4 = 0;

                    //nos if's a seguir esta sendo calculado a distancia dos pontos e guaradando em r1, r2, etc.
                    if (vLetras[0] == vLetras[3]) {
                        r1 = distancia(Centroids.get(1).get(vCent[0]), Centroids.get(1).get(vCent[3]),
                                Centroids.get(0).get(vCent[0]), Centroids.get(0).get(vCent[3]));
                    }

                    if(vLetras[2] == vLetras[5]){
                        r2 = distancia(Centroids.get(1).get(vCent[2]), Centroids.get(1).get(vCent[5]),
                                Centroids.get(0).get(vCent[2]), Centroids.get(0).get(vCent[5]));
                    }

                    if(vLetras[0] == vLetras[4]){
                        r3 = distancia(Centroids.get(1).get(vCent[0]), Centroids.get(1).get(vCent[4]),
                                Centroids.get(0).get(vCent[0]), Centroids.get(0).get(vCent[4]));
                    }

                    if(vLetras[2] == vLetras[4]){
                        r4 = distancia(Centroids.get(1).get(vCent[2]), Centroids.get(1).get(vCent[4]),
                                Centroids.get(0).get(vCent[2]), Centroids.get(0).get(vCent[4]));
                    }


                    //se o if for verdadeiro remCol vai receber um valor 1
                    if(r1 >= 12 || r2 >= 12 || r3 >= 14 || r4 >= + 14){
                        remCol.add(1);
                    }
                    //caso contrario recebe 0
                    else {
                        remCol.add(0);
                    }
                }

            }
        }

        //se remCol tiver um valor 1 significa que os primeiros pontos são apenas maiusculos e o descarta
        if (Collections.max(remCol) == 1){
            Coluna.remove(Coluna.get(0));
        }

        return Coluna;
    }

    private float distancia(int x1, int y1, int x2, int y2) { // função para calcular o espacamento entre os pontos
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2) );
    }
}


