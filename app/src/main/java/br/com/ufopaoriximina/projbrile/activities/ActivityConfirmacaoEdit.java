package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.ufopaoriximina.projbrile.R;

public class ActivityConfirmacaoEdit extends AppCompatActivity {

    private ImageView imageConcluir, imageVoltar, imageRecebida, imageCancelar;
    String texto;
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


        imageCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityInicial.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
                ActivityCompat.startActivity(ActivityConfirmacaoEdit.this, i, activityOptionsCompat.toBundle());
                finish();
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
        imageCancelar = findViewById(R.id.imagemCancelEdition);
    }

    public void voltarTela(){
        Intent i = new Intent(getApplicationContext(), CutActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(ActivityConfirmacaoEdit.this, i, activityOptionsCompat.toBundle());
        finish();
    }
}
