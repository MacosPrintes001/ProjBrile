package com.example.myapplication;

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
import java.util.List;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.config.bdLetra;


class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button mGalerryBtn, mApllyBtn;
    Bitmap grayBitMap, imgBitMap;

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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                        //permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

                        //Show pop in runtime
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        //Permission is already granted
                        pickImageGallery();
                    }
                } else {
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
                    //cornvertToGray();
                } catch (Exception o) {
                    o.getSuppressed();
                }
            }
        });

    }

    public void pickImageGallery() {

        // Intent to pick up Image
        Intent intent = new Intent(Intent.ACTION_PICK);
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
                Toast.makeText(this, "Permission denied, pleace Allow the permission", Toast.LENGTH_SHORT).show();
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

            } catch (IOException e) {

                e.printStackTrace();
            }

            mImageView.setImageBitmap(imgBitMap);
        }
    }
}


