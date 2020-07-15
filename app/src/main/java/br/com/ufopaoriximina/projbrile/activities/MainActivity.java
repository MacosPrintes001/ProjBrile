package br.com.ufopaoriximina.projbrile.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.config.bdLetra;


public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button mGalerryBtn, mApllyBtn, clearBtn;
    Bitmap grayBitMap, imgBitMap;
    String texto;
//
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenCVLoader.initDebug();

        mImageView = findViewById(R.id.imageView);

        mGalerryBtn = findViewById(R.id.btnChooseImg);
        mGalerryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){

                        //permission not granted, request it
                        String[] permissions ={Manifest.permission.READ_EXTERNAL_STORAGE};

                        //Show pop in runtime
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else{
                        //Permission is already granted
                        pickImageGallery();
                    }
                }
                else{
                    //System OS is less them MARSHMALLOW
                    pickImageGallery();
                }
            }
        });

        //cria evento de click no botão "APLLY"
        mApllyBtn = findViewById(R.id.grayBtn);
        mApllyBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    cornvertToGray();
                }
                catch (Exception o){
                    o.getSuppressed();
                }
            }
        });

        clearBtn = findViewById(R.id.btnClear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testClear();
            }
        });

    }

    public void pickImageGallery(){

        // Intent to pick up Image
        Intent  intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    //handle result of runtime permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission was granted
                pickImageGallery();
            } else {
                //permission was Denied
                Toast.makeText(this, "A permissão está desativada, por favor aceite-a para poder continuar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override //carrega a imagem para a tela
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {


            assert data != null;

            //pega a imagem e coloca em "SelectedImage"
            Uri selectedImage = data.getData();

            try {

                imgBitMap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);

            }catch (IOException e){

                e.printStackTrace();
            }

            mImageView.setImageBitmap(imgBitMap);
        }

    }

    private void testClear() {
        if (imgBitMap == null){
            Toast.makeText(getApplicationContext(), "O imageview já está vazio", Toast.LENGTH_SHORT).show();
        }else {
            imgBitMap = null;
            mImageView.setImageBitmap(imgBitMap);
        }
    }

    public void cornvertToGray() {
        try {
            if (imgBitMap == null) { //se nenhuma imagem selecionada

                Toast.makeText(this, "ImageView esta vazio, por favor selecione uma imagem", Toast.LENGTH_SHORT).show();

            } else {// tem imagem hora de trabalhar
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
                        //System.out.println(letra[0]);
                        texto = texto+letra[0];
                        flag = letra[1];
                    }
                }

                Utils.matToBitmap(grayMat, grayBitMap);
                //set to the Imageview
                mImageView.setImageBitmap(grayBitMap);


                Intent intentEnviadora = new Intent(this, translatedTexActivity.class);
                Bundle enviaTraducao = new Bundle();
                enviaTraducao.putString("string_texto", texto);
                intentEnviadora.putExtras(enviaTraducao);
                startActivity(intentEnviadora);
            }

        } catch (Exception p) {
            p.printStackTrace();
        }
    }

}