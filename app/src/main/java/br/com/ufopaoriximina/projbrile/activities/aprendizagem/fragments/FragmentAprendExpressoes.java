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
                        case " " :
                            //imagens.clear();
                            //Toast.makeText(getContext(), "Espaço", Toast.LENGTH_SHORT).show();
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
