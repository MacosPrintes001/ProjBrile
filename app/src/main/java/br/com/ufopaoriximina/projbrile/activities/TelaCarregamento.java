package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.ActivityAprendizagem;

public class TelaCarregamento extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carregamento);
        getSupportActionBar().hide();
        apresentarTelaSplash();
    }

    public void apresentarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abriTelaInicialLogin();

            }
        }, 3000);
    }


    public void abriTelaInicialLogin() {
        Intent i = new Intent(getApplicationContext(), ActivityInicial.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                , R.transition.fade_in, R.transition.fade_out);
        ActivityCompat.startActivity(TelaCarregamento.this, i, activityOptionsCompat.toBundle());
        finish();
    }
}
