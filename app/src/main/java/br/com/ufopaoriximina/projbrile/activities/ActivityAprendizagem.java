package br.com.ufopaoriximina.projbrile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.ufopaoriximina.projbrile.R;

public class ActivityAprendizagem extends AppCompatActivity {

    private EditText informacao;
    private ImageView letra;
    private Button btnCarregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprendizagem);
        carregarComponentes();
        //informacao.;
        btnCarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (informacao.getText().toString()){
                    case "a":
                        letra.setImageResource(R.drawable.letra_a);
                        break;
                    case "A":
                        letra.setImageResource(R.drawable.letra_a_upper);
                        break;
                    case "b":
                        letra.setImageResource(R.drawable.letra_b);
                        break;
                    case "B":
                        letra.setImageResource(R.drawable.letra_b_upper);
                        break;
                    case "c":
                        letra.setImageResource(R.drawable.letra_c);
                        break;
                    case "C":
                        letra.setImageResource(R.drawable.letra_c_upper);
                        break;
                    case "d":
                        letra.setImageResource(R.drawable.letra_d);
                        break;
                    case "D":
                        letra.setImageResource(R.drawable.letra_d_upper);
                        break;
                    case "e":
                        letra.setImageResource(R.drawable.letra_e);
                        break;
                    case "E":
                        letra.setImageResource(R.drawable.letra_e_upper);
                        break;
                    case "f":
                        letra.setImageResource(R.drawable.letra_f);
                        break;
                    case "F":
                        letra.setImageResource(R.drawable.letra_f_upper);
                        break;
                    case "g":
                        letra.setImageResource(R.drawable.letra_g);
                        break;
                    case "G":
                        letra.setImageResource(R.drawable.letra_g_upper);
                        break;
                    case "h":
                        letra.setImageResource(R.drawable.letra_h);
                        break;
                    case "H":
                        letra.setImageResource(R.drawable.letra_h_upper);
                        break;
                    case "i":
                        letra.setImageResource(R.drawable.letra_i);
                        break;
                    case "I":
                        letra.setImageResource(R.drawable.letra_i_upper);
                        break;
                    case "j":
                        letra.setImageResource(R.drawable.letra_j);
                        break;
                    case "J":
                        letra.setImageResource(R.drawable.letra_j_upper);
                        break;
                    case "k":
                        letra.setImageResource(R.drawable.letra_k);
                        break;
                    case "K":
                        letra.setImageResource(R.drawable.letra_k_upper);
                        break;
                    case "l":
                        letra.setImageResource(R.drawable.letra_l);
                        break;
                    case "L":
                        letra.setImageResource(R.drawable.letra_l_upper);
                        break;
                    case "m":
                        letra.setImageResource(R.drawable.letra_m);
                        break;
                    case "M":
                        letra.setImageResource(R.drawable.letra_m_upper);
                        break;
                    case "n":
                        letra.setImageResource(R.drawable.letra_n);
                        break;
                    case "N":
                        letra.setImageResource(R.drawable.letra_n_upper);
                        break;
                    case "o":
                        letra.setImageResource(R.drawable.letra_o);
                        break;
                    case "O":
                        letra.setImageResource(R.drawable.letra_o_upper);
                        break;
                    case "p":
                        letra.setImageResource(R.drawable.letra_p);
                        break;
                    case "P":
                        letra.setImageResource(R.drawable.letra_p_upper);
                        break;
                    case "q":
                        letra.setImageResource(R.drawable.letra_q);
                        break;
                    case "Q":
                        letra.setImageResource(R.drawable.letra_q_upper);
                        break;
                    case "r":
                        letra.setImageResource(R.drawable.letra_r);
                        break;
                    case "R":
                        letra.setImageResource(R.drawable.letra_r_upper);
                        break;
                    case "s":
                        letra.setImageResource(R.drawable.letra_s);
                        break;
                    case "S":
                        letra.setImageResource(R.drawable.letra_s_upper);
                        break;
                    case "t":
                        letra.setImageResource(R.drawable.letra_t);
                        break;
                    case "T":
                        letra.setImageResource(R.drawable.letra_t_upper);
                        break;
                    case "u":
                        letra.setImageResource(R.drawable.letra_u);
                        break;
                    case "U":
                        letra.setImageResource(R.drawable.letra_u_upper);
                        break;
                    case "v":
                        letra.setImageResource(R.drawable.letra_v);
                        break;
                    case "V":
                        letra.setImageResource(R.drawable.letra_v_upper);
                        break;
                    case "w":
                        letra.setImageResource(R.drawable.letra_w);
                        break;
                    case "W":
                        letra.setImageResource(R.drawable.letra_w_upper);
                        break;
                    case "x":
                        letra.setImageResource(R.drawable.letra_x);
                        break;
                    case "X":
                        letra.setImageResource(R.drawable.letra_x_upper);
                        break;
                    case "y":
                        letra.setImageResource(R.drawable.letra_y);
                        break;
                    case "Y":
                        letra.setImageResource(R.drawable.letra_y_upper);
                        break;
                    case "z":
                        letra.setImageResource(R.drawable.letra_z);
                        break;
                    case "Z":
                        letra.setImageResource(R.drawable.letra_z_upper);
                        break;
                    default:
                        letra.setImageResource(R.drawable.test);
                        break;
                }
            }
        });

    }

    private void carregarComponentes(){
        btnCarregar = findViewById(R.id.btnCarregarImagem);
        informacao = findViewById(R.id.textoInformacao);
        letra = findViewById(R.id.imageViewLetra);
    }
}
