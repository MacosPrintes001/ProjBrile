package br.com.ufopaoriximina.projbrile.activities.aprendizagem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.ActivityInicial;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments.FragmentAprendAlfabeto;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments.FragmentAprendExpressoes;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments.FragmentAprendNumero;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments.FragmentAprendPalavras;

public class ActivityAprendizagem extends AppCompatActivity implements
        FragmentAprendAlfabeto.OnFragmentInteractionListener,
        FragmentAprendPalavras.OnFragmentInteractionListener,
        FragmentAprendNumero.OnFragmentInteractionListener,
        FragmentAprendExpressoes.OnFragmentInteractionListener {


    //Essa é a Activity da Tela de Aprendizagem
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprendizagem);
        //Ajeita o Elevation  e título da Toolbar (Só visual)
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Aprendizagem");

        //Essa parte recupera os fragments que estão sendo usados. Os fragments estão em - > acvities -> aprendizagem -> fragments
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Alfabeto", FragmentAprendAlfabeto.class)
                        .add("Palavras", FragmentAprendPalavras.class)
                        .add("Números", FragmentAprendNumero.class)
                        .add("Expressões", FragmentAprendExpressoes.class)
                        .create()
        );
        ViewPager viewPager = findViewById(R.id.viewpager2);
        viewPager.setAdapter( adapter );
        SmartTabLayout viewPagerTab = findViewById(R.id.smartTabLayout);
        viewPagerTab.setViewPager( viewPager );

    }

    //Verifica o clique no botão para voltar para o menu principal
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(), ActivityInicial.class);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                    , R.transition.fade_in, R.transition.fade_out);
            ActivityCompat.startActivity(ActivityAprendizagem.this, i, activityOptionsCompat.toBundle());
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    //Implementação da Interface dos Fragments
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
