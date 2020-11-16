package br.com.ufopaoriximina.projbrile.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import java.util.Locale;
import br.com.ufopaoriximina.projbrile.R;

public class TranslatedTexActivity extends AppCompatActivity {

    private TextToSpeech mTTS;
    private TextView txtTraduced;
    private Button mButtonSpeak;
    private String recebeTxt;
    private Button sendText;
    private ImageView retornar;
    //AA
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated_tex);
        getSupportActionBar().hide();
        init();
        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkExit();
            }
        });
        Intent intentRecebedora = getIntent();
        Bundle recebeTraducao = intentRecebedora.getExtras();
        if(recebeTraducao != null){
            recebeTxt = recebeTraducao.getString("string_texto");
        }
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


        txtTraduced.setText(recebeTxt);

        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Clicado", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Tradução: " + "\n\n" + txtTraduced.getText());
                sendIntent.putExtra(Intent.EXTRA_TITLE, "Tradução Feita no App Muiraputã - Braile");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "Escolha por onde enviar:");
                startActivity(shareIntent);

            }
        });

    }

    public void init(){
        txtTraduced = findViewById(R.id.textView);
        mButtonSpeak = findViewById(R.id.button_speak);
        sendText = findViewById(R.id.button_send_tradu);
        retornar = findViewById(R.id.imagemReturnResult);
    }

    public void setSendText(){

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            checkExit();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void checkExit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente voltar?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), CutActivity.class);
                        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext()
                                , R.transition.fade_in, R.transition.fade_out);
                        ActivityCompat.startActivity(TranslatedTexActivity.this, i, activityOptionsCompat.toBundle());
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