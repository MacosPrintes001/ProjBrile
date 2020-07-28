package br.com.ufopaoriximina.projbrile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yalantis.ucrop.UCrop;

import java.io.File;

public class CutActivity extends AppCompatActivity {
    private ImageView view;
    private  final int CODE_IMAGE_GALERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut);

        init();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent().
                        setAction(Intent.ACTION_GET_CONTENT).
                        setType("image/*"), CODE_IMAGE_GALERY);
            }
        });
    }

    private void init() {
        this.view = findViewById(R.id.imageView);
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
}