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
import android.widget.ImageView;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter;


public class FragmentAprendNumero extends Fragment {

    private EditText letraInfor;
    private ArrayList<Integer> imagens = new ArrayList<>();
    private GridView gridView;
    public FragmentAprendNumero() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Recupera o view da pagina
        final View view = inflater.inflate(R.layout.fragment_fragment_aprend_numero, container, false);
        //EditText do texto digitado
        letraInfor = view.findViewById(R.id.textoInformacao);
        gridView = view.findViewById(R.id.gridViewPalavra);
        imagens.add(R.drawable.inicial_numerico);
        imagens.add(R.drawable.limpa);
        GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
        gridView.setAdapter(gridAdapter);
        //ImageView para a número (Falta fazer)
        //Verifica a mudança dinamica dos dados
        letraInfor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Switch para verificar o número digitado (Falta terminar)
                imagens.clear();
                //Tentativa de organizar um array de letras
                String[] a =  letraInfor.getText().toString().split("");
                //Verifica se o EditText está vazio
                if(letraInfor.getText().toString().isEmpty()){
                    imagens.clear();
                    GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                    gridView.setAdapter(gridAdapter);
                }
                imagens.add(R.drawable.inicial_numerico);
                int cont = 0;
                while (cont < a.length){
                    switch (a[cont]){
                        case "0":
                            imagens.add(R.drawable.letra_j);
                            break;
                        case "1":
                            imagens.add(R.drawable.letra_a);
                            break;
                        case "2":
                            imagens.add(R.drawable.letra_b);
                            break;
                        case "3":
                            imagens.add(R.drawable.letra_c);
                            break;
                        case "4":
                            imagens.add(R.drawable.letra_d);
                            break;
                        case "5":
                            imagens.add(R.drawable.letra_e);
                            break;
                        case "6":
                            imagens.add(R.drawable.letra_f);
                            break;
                        case "7":
                            imagens.add(R.drawable.letra_g);
                            break;
                        case "8":
                            imagens.add(R.drawable.letra_h);
                            break;
                        case "9":
                            imagens.add(R.drawable.letra_i);
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

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
