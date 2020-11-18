package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ufopaoriximina.projbrile.R;

public class ActivityConfirmacaoEdit extends AppCompatActivity {

    private ImageView imageConcluir, imageVoltar, imageRecebida;
    private String texto;
    private TextView cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_edit);
        getSupportActionBar().hide();
        init();
        Bundle dados = getIntent().getExtras();
        if(dados != null){
            Uri uiImage = (Uri) dados.get("image");
            texto  = dados.getString("string_texto");
            imageRecebida.setImageURI(uiImage);
        }


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkExit();
            }
        });

        imageVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTela();
            }
        });

        imageConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TranslatedTexActivity.class);
                i.putExtra("string_texto", texto);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(ActivityConfirmacaoEdit.this, i, activityOptionsCompat.toBundle());
                finish();
            }
        });
    }

    private void init() {
        imageConcluir = findViewById(R.id.imagemConcluirEdition);
        imageVoltar = findViewById(R.id.imageReturn);
        imageRecebida = findViewById(R.id.imageRecebida);
        cancelar = findViewById(R.id.textCancelar);
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
                        ActivityCompat.startActivity(ActivityConfirmacaoEdit.this, i, activityOptionsCompat.toBundle());
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

    public void voltarTela(){
        Intent i = new Intent(getApplicationContext(), CutActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(ActivityConfirmacaoEdit.this, i, activityOptionsCompat.toBundle());
        finish();
    }
}
