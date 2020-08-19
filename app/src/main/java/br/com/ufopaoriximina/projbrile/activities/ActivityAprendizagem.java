package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.fragments.FragmentAprendAlfabeto;
import br.com.ufopaoriximina.projbrile.activities.fragments.FragmentAprendExpressoes;
import br.com.ufopaoriximina.projbrile.activities.fragments.FragmentAprendNumero;
import br.com.ufopaoriximina.projbrile.activities.fragments.FragmentAprendPalavras;

public class ActivityAprendizagem extends AppCompatActivity implements
        FragmentAprendAlfabeto.OnFragmentInteractionListener,
        FragmentAprendPalavras.OnFragmentInteractionListener,
        FragmentAprendNumero.OnFragmentInteractionListener,
        FragmentAprendExpressoes.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprendizagem);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Aprendizagem");

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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent i = new Intent(getApplicationContext(),ActivityInicial.class);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                    , R.transition.fade_in, R.transition.fade_out);
            ActivityCompat.startActivity(ActivityAprendizagem.this, i, activityOptionsCompat.toBundle());
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
