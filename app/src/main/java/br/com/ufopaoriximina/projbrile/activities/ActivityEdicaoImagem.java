package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.helper.RecuperarBitmap;

public class ActivityEdicaoImagem extends AppCompatActivity {

    private ImageView img;
    private ImageView concluir, cancelar;
    private boolean escolhido = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_imagem);
        getSupportActionBar().hide();
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON_TOUCH)
                .setAspectRatio(1,1)
                .setAllowFlipping(true)
                .setActivityTitle("Editar Imagem")
                .setAutoZoomEnabled(true)
                .setAllowCounterRotation(true)
                .setFixAspectRatio(false)
                .setAllowRotation(true)
                .setMinCropResultSize(20, 20)
                .setCropShape(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P ? CropImageView.CropShape.RECTANGLE : CropImageView.CropShape.OVAL)
                .start(this);

        init();
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkExit();
            }
        });
        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(escolhido){
                    Toast.makeText(getApplicationContext(),"Selecione um imagem", Toast.LENGTH_SHORT).show();
                }
                convertImage();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                img.setImageURI(resultUri);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
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
                        ActivityCompat.startActivity(ActivityEdicaoImagem.this, i, activityOptionsCompat.toBundle());
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
    private void init(){
        this.img = findViewById(R.id.imagemRecuperada);
        cancelar = findViewById(R.id.imagemCancelEdition);
        concluir = findViewById(R.id.imagemConcluirEdition);
    }

    public void convertImage(){
        try {

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
