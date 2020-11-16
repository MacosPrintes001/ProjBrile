package br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter;

public class FragmentAprendPalavras extends Fragment {


    private GridView gridView;
    public FragmentAprendPalavras() {
        // Required empty public constructor
    }

    //ArrayList das Imagens. Ver aprendizagem -> adapters -> GridAdapter
    ArrayList<Integer> imagens = new ArrayList<>();
    //Button para traduzir
    private Button traduzir;
    //Button para limpar tudo
    private ImageView clearAll;
    //EditText da palavra
    EditText editPalavra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO: ESSA QUE ESTÁ COM PROBLEMAS GRAVES


        //Recupera o View
        final View view = inflater.inflate(R.layout.fragment_fragment_aprend_palavras, container, false);
        //Recupera Buttons
        clearAll = view.findViewById(R.id.apagarAll);
        traduzir = view.findViewById(R.id.button_send_tradu);
        //Criação da Grid View (Pesquisar)
        gridView = view.findViewById(R.id.gridViewPalavra);
        //Localização do ediText
        editPalavra = view.findViewById(R.id.textoInformacao);
        //Recuperação das mudanças dinâmicas dos dados
        //OnClick dos buttons
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPalavra.setText(null);
                imagens.clear();
                GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                gridView.setAdapter(gridAdapter);
            }
        });
        traduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagens.clear();
                //Tentativa de organizar um array de letras
                final String[] a =  editPalavra.getText().toString().split("");
                //Verifica se o EditText está vazio
                if(editPalavra.getText().toString().isEmpty()){
                    imagens.clear();
                    GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                    gridView.setAdapter(gridAdapter);
                }

                int cont = 0;
                while (cont < a.length){
                    switch (a[cont]){
                        case "a":
                            imagens.add(R.drawable.letra_a);
                            break;
                        case "A":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_a);
                            break;
                        case "b":
                            imagens.add(R.drawable.letra_b);
                            break;
                        case "B":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_b);
                            break;
                        case "c":
                            imagens.add(R.drawable.letra_c);
                            break;
                        case "C":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_c);
                            break;
                        case "d":
                            imagens.add(R.drawable.letra_d);
                            break;
                        case "D":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_d);
                            break;
                        case "e":
                            imagens.add(R.drawable.letra_e);
                            break;
                        case "E":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_e);
                            break;
                        case "f":
                            imagens.add(R.drawable.letra_f);
                            break;
                        case "F":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_f);
                            break;
                        case "g":
                            imagens.add(R.drawable.letra_g);
                            break;
                        case "G":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_g);
                            break;
                        case "h":
                            imagens.add(R.drawable.letra_h);
                            break;
                        case "H":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_h);
                            break;
                        case "i":
                            imagens.add(R.drawable.letra_i);
                            break;
                        case "I":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_i);
                            break;
                        case "j":
                            imagens.add(R.drawable.letra_j);
                            break;
                        case "J":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_j);
                            break;
                        case "k":
                            imagens.add(R.drawable.letra_k);
                            break;
                        case "K":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_k);
                            break;
                        case "l":
                            imagens.add(R.drawable.letra_l);
                            break;
                        case "L":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_l);
                            break;
                        case "m":
                            imagens.add(R.drawable.letra_m);
                            break;
                        case "M":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_m);
                            break;
                        case "n":
                            imagens.add(R.drawable.letra_n);
                            break;
                        case "N":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_m);
                            break;
                        case "o":
                            imagens.add(R.drawable.letra_o);
                            break;
                        case "O":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_o);
                            break;
                        case "p":
                            imagens.add(R.drawable.letra_p);
                            break;
                        case "P":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_p);
                            break;
                        case "q":
                            imagens.add(R.drawable.letra_q);
                            break;
                        case "Q":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_q);
                            break;
                        case "r":
                            imagens.add(R.drawable.letra_r);
                            break;
                        case "R":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_r);
                            break;
                        case "s":
                            imagens.add(R.drawable.letra_s);
                            break;
                        case "S":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_s);
                            break;
                        case "t":
                            imagens.add(R.drawable.letra_t);
                            break;
                        case "T":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_t);
                            break;
                        case "u":
                            imagens.add(R.drawable.letra_u);
                            break;
                        case "U":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_u);
                            break;
                        case "v":
                            imagens.add(R.drawable.letra_v);
                            break;
                        case "V":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_v);
                            break;
                        case "w":
                            imagens.add(R.drawable.letra_w);
                            break;
                        case "W":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_w);
                            break;
                        case "x":
                            imagens.add(R.drawable.letra_x);
                            break;
                        case "X":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_x);
                            break;
                        case "y":
                            imagens.add(R.drawable.letra_y);
                            break;
                        case "Y":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_y);
                            break;
                        case "z":
                            imagens.add(R.drawable.letra_z);
                            break;
                        case "Z":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_z);
                            break;
                        case " " :
                            imagens.add(R.drawable.espaco);
                            break;
                        case ",":
                            imagens.add(R.drawable.virgula);
                            break;
                        case ":":
                            imagens.add(R.drawable.dois_pontos);
                            break;
                        case ";":
                            imagens.add(R.drawable.ponto_e_virgula);
                            break;
                        case "'":
                            imagens.add(R.drawable.aspas_simples);
                            break;
                        case "?":
                            imagens.add(R.drawable.interrogacao);
                            break;
                        case "!":
                            imagens.add(R.drawable.exclamacao);
                            break;
                        //Acentuadas
                        case "á":
                            imagens.add(R.drawable.a_agudo);
                            break;
                        case "Á":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.a_agudo);
                            break;
                        case "â":
                            imagens.add(R.drawable.a_circunflexo);
                            break;
                        case "Â":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.a_circunflexo);
                            break;
                        case "à":
                            imagens.add(R.drawable.a_crase);
                            break;
                        case "À":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.a_crase);
                            break;
                        case "ã":
                            imagens.add(R.drawable.a_til);
                            break;
                        case "Ã":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.a_til);
                            break;
                        case "é":
                            imagens.add(R.drawable.e_agudo);
                            break;
                        case "É":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.e_agudo);
                            break;
                        case "ê":
                            imagens.add(R.drawable.e_circunflexo);
                            break;
                        case "Ê":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.e_circunflexo);
                            break;
                        case "è":
                            imagens.add(R.drawable.e_crase);
                            break;
                        case "È":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.e_crase);
                            break;
                        case "í":
                            imagens.add(R.drawable.i_agudo);
                            break;
                        case "Í":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.i_agudo);
                            break;
                        case "ì":
                            imagens.add(R.drawable.i_crase);
                            break;
                        case "Ì":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.i_crase);
                            break;
                        case "ó":
                            imagens.add(R.drawable.o_agudo);
                            break;
                        case "Ó":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.o_agudo);
                            break;
                        case "ô":
                            imagens.add(R.drawable.o_circunflexo);
                            break;
                        case "Ô":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.o_circunflexo);
                            break;
                        case "ò":
                            imagens.add(R.drawable.o_crase);
                            break;
                        case "Ò":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.o_crase);
                            break;
                        case "õ":
                            imagens.add(R.drawable.o_til);
                            break;
                        case "Õ":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.o_til);
                            break;
                        case "ú":
                            imagens.add(R.drawable.u_agudo);
                            break;
                        case "Ú":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.u_agudo);
                            break;
                        case "ù":
                            imagens.add(R.drawable.u_crase);
                            break;
                        case "Ù":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.u_crase);
                            break;
                        default:
                            imagens.add(R.drawable.limpa);
                            break;
                    }
                    cont += 1;
                }
                GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                gridView.setAdapter(gridAdapter);
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
