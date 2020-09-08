package br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter;

public class FragmentAprendPalavras extends Fragment {


    private GridView gridView;
    public FragmentAprendPalavras() {
        // Required empty public constructor
    }

    //ArrayList das Imagens. Ver aprendizagem -> adapters -> GridAdapter
    ArrayList<Integer> imagens = new ArrayList<>();
    //EditText da palavra
    EditText editPalavra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO: ESSA QUE ESTÁ COM PROBLEMAS GRAVES

        //Recupera o View
        final View view = inflater.inflate(R.layout.fragment_fragment_aprend_palavras, container, false);
        //Criação da Grid View (Pesquisar)
        gridView = view.findViewById(R.id.gridViewPalavra);
        //Localização do ediText
        editPalavra = view.findViewById(R.id.textoInformacao);
        //Recuperação das mudanças dinâmicas dos dados
        editPalavra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Tentativa de organizar um array de letras
                String[] a =  editPalavra.getText().toString().split("");
                Toast.makeText(getContext(), a[a.length - 1], Toast.LENGTH_SHORT).show();

                //Verifica se o EditText está vazio
                if(editPalavra.getText().toString().equals("")){
                    imagens.clear();
                }
                //Tenta ir inserindo no Array de Imagens do Grid Layout para aparecer a tradução
                switch (a[a.length - 1]){

                    case "a":
                        imagens.add(R.drawable.letra_a);
                        break;
                    case "A":
                        imagens.add(R.drawable.letra_a_upper);
                        break;
                    case "b":
                        imagens.add(R.drawable.letra_b);
                        break;
                    case "B":
                        imagens.add(R.drawable.letra_b_upper);
                        break;
                    case "c":
                        imagens.add(R.drawable.letra_c);
                        break;
                    case "C":
                        imagens.add(R.drawable.letra_c_upper);
                        break;
                    case "d":
                        imagens.add(R.drawable.letra_d);
                        break;
                    case "D":
                        imagens.add(R.drawable.letra_d_upper);
                        break;
                    case "e":
                        imagens.add(R.drawable.letra_e);
                        break;
                    case "E":
                        imagens.add(R.drawable.letra_e_upper);
                        break;
                    case "f":
                        imagens.add(R.drawable.letra_f);
                        break;
                    case "F":
                        imagens.add(R.drawable.letra_f_upper);
                        break;
                    case "g":
                        imagens.add(R.drawable.letra_g);
                        break;
                    case "G":
                        imagens.add(R.drawable.letra_g_upper);
                        break;
                    case "h":
                        imagens.add(R.drawable.letra_h);
                        break;
                    case "H":
                        imagens.add(R.drawable.letra_h_upper);
                        break;
                    case "i":
                        imagens.add(R.drawable.letra_i);
                        break;
                    case "I":
                        imagens.add(R.drawable.letra_i_upper);
                        break;
                    case "j":
                        imagens.add(R.drawable.letra_j);
                        break;
                    case "J":
                        imagens.add(R.drawable.letra_j_upper);
                        break;
                    case "k":
                        imagens.add(R.drawable.letra_k);
                        break;
                    case "K":
                        imagens.add(R.drawable.letra_k_upper);
                        break;
                    case "l":
                        imagens.add(R.drawable.letra_l);
                        break;
                    case "L":
                        imagens.add(R.drawable.letra_l_upper);
                        break;
                    case "m":
                        imagens.add(R.drawable.letra_m);
                        break;
                    case "M":
                        imagens.add(R.drawable.letra_m_upper);
                        break;
                    case "n":
                        imagens.add(R.drawable.letra_n);
                        break;
                    case "N":
                        imagens.add(R.drawable.letra_m_upper);
                        break;
                    case "o":
                        imagens.add(R.drawable.letra_o);
                        break;
                    case "O":
                        imagens.add(R.drawable.letra_o_upper);
                        break;
                    case "p":
                        imagens.add(R.drawable.letra_p);
                        break;
                    case "P":
                        imagens.add(R.drawable.letra_p_upper);
                        break;
                    case "q":
                        imagens.add(R.drawable.letra_q);
                        break;
                    case "Q":
                        imagens.add(R.drawable.letra_q_upper);
                        break;
                    case "r":
                        imagens.add(R.drawable.letra_r);
                        break;
                    case "R":
                        imagens.add(R.drawable.letra_r_upper);
                        break;
                    case "s":
                        imagens.add(R.drawable.letra_s);
                        break;
                    case "S":
                        imagens.add(R.drawable.letra_s_upper);
                        break;
                    case "t":
                        imagens.add(R.drawable.letra_t);
                        break;
                    case "T":
                        imagens.add(R.drawable.letra_t_upper);
                        break;
                    case "u":
                        imagens.add(R.drawable.letra_u);
                        break;
                    case "U":
                        imagens.add(R.drawable.letra_u_upper);
                        break;
                    case "v":
                        imagens.add(R.drawable.letra_v);
                        break;
                    case "V":
                        imagens.add(R.drawable.letra_v_upper);
                        break;
                    case "w":
                        imagens.add(R.drawable.letra_w);
                        break;
                    case "W":
                        imagens.add(R.drawable.letra_w_upper);
                        break;
                    case "x":
                        imagens.add(R.drawable.letra_x);
                        break;
                    case "X":
                        imagens.add(R.drawable.letra_x_upper);
                        break;
                    case "y":
                        imagens.add(R.drawable.letra_y);
                        break;
                    case "Y":
                        imagens.add(R.drawable.letra_y_upper);
                        break;
                    case "z":
                        imagens.add(R.drawable.letra_z);
                        break;
                    case "Z":
                        imagens.add(R.drawable.letra_z_upper);
                        break;
                    case " " :
                        imagens.clear();
                        Toast.makeText(getContext(), "Espaço", Toast.LENGTH_SHORT).show();
                        break;
                    default:

                        break;
                }



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Recupera e configura o GridAdapter usando a classe aprendizagem.adapters.GridAdapter
        GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
        gridView.setAdapter(gridAdapter);
        return view;
    }




    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
