package br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter3;


public class FragmentAprendExpressoes extends Fragment {

    private GridView gridView;
    public FragmentAprendExpressoes() {
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
        //TODO: ESSA QUE ESTÁ COM PROBLEMAS GRAVES


        //Recupera o View
        final View view = inflater.inflate(R.layout.fragment_fragment_aprend_expressoes, container, false);
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
                String[] a =  editPalavra.getText().toString().split("");
                //Verifica se o EditText está vazio
                if(editPalavra.getText().toString().isEmpty()){
                    imagens.clear();
                    GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                    gridView.setAdapter(gridAdapter);
                }

                int cont = 0;
                while (cont < a.length){
                    switch (a[cont]){
                        case "0":
                            imagens.add(R.drawable.n0);
                            break;
                        case "1":
                            imagens.add(R.drawable.n1);
                            break;
                        case "2":
                            imagens.add(R.drawable.n2);
                            break;
                        case "3":
                            imagens.add(R.drawable.n3);
                            break;
                        case "4":
                            imagens.add(R.drawable.n4);
                            break;
                        case "5":
                            imagens.add(R.drawable.n5);
                            break;
                        case "6":
                            imagens.add(R.drawable.n6);
                            break;
                        case "7":
                            imagens.add(R.drawable.n7);
                            break;
                        case "8":
                            imagens.add(R.drawable.n8);
                            break;
                        case "9":
                            imagens.add(R.drawable.n9);
                            break;
                        case "+":
                            imagens.add(R.drawable.soma);
                            break;
                        case "-":
                            imagens.add(R.drawable.subtracao);
                            break;
                        case "*":
                            imagens.add(R.drawable.multiplicacao);
                            break;
                        case "/":
                            imagens.add(R.drawable.divisao);
                            break;
                        case "^":
                            imagens.add(R.drawable.expoente);
                            break;
                        case "(":
                            imagens.add(R.drawable.abre);
                            break;
                        case ")":
                            imagens.add(R.drawable.fecha);
                            break;
                        case "=":
                            imagens.add(R.drawable.igualdade);
                            break;
                        case ",":
                            imagens.add(R.drawable.decimal);
                            break;
                        case ".":
                            imagens.add(R.drawable.milhar);
                            break;
                        //Variaveis
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
                            imagens.add(R.drawable.letra_n);
                            break;
                        case "o":
                            imagens.add(R.drawable.letra_m);
                            break;
                        case "O":
                            imagens.add(R.drawable.inicial_maiuscula);
                            imagens.add(R.drawable.letra_m);
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
                        default:
                            break;
                    }
                    cont += 1;
                }
                GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                gridView.setAdapter(gridAdapter);
            }
        });

        //Recupera e configura o GridAdapter usando a classe aprendizagem.adapters.GridAdapter
        GridAdapter3 gridAdapter = new GridAdapter3(view.getContext(), imagens);
        gridView.setAdapter(gridAdapter);
        return view;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
