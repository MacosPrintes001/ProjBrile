package br.com.ufopaoriximina.projbrile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

import br.com.ufopaoriximina.projbrile.R;

public class translatedTexActivity extends AppCompatActivity {

    private TextToSpeech mTTS;
    private TextView txtTraduced;
    private Button mButtonSpeak;
    private String recebeTxt;
    //AA
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated_tex);

        Intent intentRecebedora = getIntent();
        Bundle recebeTraducao = intentRecebedora.getExtras();
        recebeTxt = recebeTraducao.getString("string_texto");


        mButtonSpeak = findViewById(R.id.button_speak);
        mTTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    int lingua = mTTS.setLanguage(Locale.getDefault());
                    if (lingua == TextToSpeech.LANG_MISSING_DATA || lingua == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        txtTraduced = findViewById(R.id.textView);
        txtTraduced.setText(recebeTxt);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        //pega o valor do TextView
        String s = txtTraduced.getText().toString();
        //convete para fala
        int speech = mTTS.speak(s, TextToSpeech.QUEUE_FLUSH, null);

    }
    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }
}