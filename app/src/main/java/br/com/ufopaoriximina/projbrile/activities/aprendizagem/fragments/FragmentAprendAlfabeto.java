package br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter;
import br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters.GridAdapter2;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentAprendAlfabeto.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FragmentAprendAlfabeto extends Fragment {

    private EditText letraInfor;
    private ArrayList<Integer> imagens = new ArrayList<>();
    private GridView gridView;
    public FragmentAprendAlfabeto() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Recupera o view da pagina
        final View view = inflater.inflate(R.layout.fragment_fragment_aprend_alfabeto, container, false);
        //EditText do texto digitado
        letraInfor = view.findViewById(R.id.textoInformacao);
        //Grid View
        gridView = view.findViewById(R.id.gridViewPalavra);
        imagens.add(R.drawable.limpa);
        GridAdapter2 gridAdapter = new GridAdapter2(view.getContext(), imagens);
        gridView.setAdapter(gridAdapter);
        //Verifica a mudança dinamica dos dados
        letraInfor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Switch para verificar a letra digitada
                switch (letraInfor.getText().toString()){
                    case "a":
                        imagens.clear();
                        imagens.add(R.drawable.letra_a);
                        break;
                    case "A":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_a);
                        break;
                    case "b":
                        imagens.clear();
                        imagens.add(R.drawable.letra_b);
                        break;
                    case "B":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_b);
                        break;
                    case "c":
                        imagens.clear();
                        imagens.add(R.drawable.letra_c);
                        break;
                    case "C":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_c);
                        break;
                    case "d":
                        imagens.clear();
                        imagens.add(R.drawable.letra_d);
                        break;
                    case "D":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_d);
                        break;
                    case "e":
                        imagens.clear();
                        imagens.add(R.drawable.letra_e);
                        break;
                    case "E":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_e);
                        break;
                    case "f":
                        imagens.clear();
                        imagens.add(R.drawable.letra_f);
                        break;
                    case "F":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_f);
                        break;
                    case "g":
                        imagens.clear();
                        imagens.add(R.drawable.letra_g);
                        break;
                    case "G":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_g);
                        break;
                    case "h":
                        imagens.clear();
                        imagens.add(R.drawable.letra_h);
                        break;
                    case "H":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_h);
                        break;
                    case "i":
                        imagens.clear();
                        imagens.add(R.drawable.letra_i);
                        break;
                    case "I":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_i);
                        break;
                    case "j":
                        imagens.clear();
                        imagens.add(R.drawable.letra_j);
                        break;
                    case "J":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_j);
                        break;
                    case "k":
                        imagens.clear();
                        imagens.add(R.drawable.letra_k);
                        break;
                    case "K":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_k);
                        break;
                    case "l":
                        imagens.clear();
                        imagens.add(R.drawable.letra_l);
                        break;
                    case "L":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_l);
                        break;
                    case "m":
                        imagens.clear();
                        imagens.add(R.drawable.letra_m);
                        break;
                    case "M":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_m);
                        break;
                    case "n":
                        imagens.clear();
                        imagens.add(R.drawable.letra_n);
                        break;
                    case "N":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_n);
                        break;
                    case "o":
                        imagens.clear();
                        imagens.add(R.drawable.letra_m);
                        break;
                    case "O":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_m);
                        break;
                    case "p":
                        imagens.clear();
                        imagens.add(R.drawable.letra_p);
                        break;
                    case "P":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_p);
                        break;
                    case "q":
                        imagens.clear();
                        imagens.add(R.drawable.letra_q);
                        break;
                    case "Q":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_q);
                        break;
                    case "r":
                        imagens.clear();
                        imagens.add(R.drawable.letra_r);
                        break;
                    case "R":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_r);
                        break;
                    case "s":
                        imagens.clear();
                        imagens.add(R.drawable.letra_s);
                        break;
                    case "S":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_s);
                        break;
                    case "t":
                        imagens.clear();
                        imagens.add(R.drawable.letra_t);
                        break;
                    case "T":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_t);
                        break;
                    case "u":
                        imagens.clear();
                        imagens.add(R.drawable.letra_u);
                        break;
                    case "U":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_u);
                        break;
                    case "v":
                        imagens.clear();
                        imagens.add(R.drawable.letra_v);
                        break;
                    case "V":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_v);
                        break;
                    case "w":
                        imagens.clear();
                        imagens.add(R.drawable.letra_w);
                        imagens.add(R.drawable.limpa);
                        break;
                    case "W":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_w);
                        break;
                    case "x":
                        imagens.clear();
                        imagens.add(R.drawable.letra_x);
                        break;
                    case "X":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_x);
                        break;
                    case "y":
                        imagens.clear();
                        imagens.add(R.drawable.letra_y);
                        break;
                    case "Y":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_y);
                        break;
                    case "z":
                        imagens.clear();
                        imagens.add(R.drawable.letra_z);
                        break;
                    case "Z":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.letra_z);
                        break;
                    //Acentuadas
                    case "á":
                        imagens.clear();
                        imagens.add(R.drawable.a_agudo);
                        break;
                    case "Á":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.a_agudo);
                        break;
                    case "â":
                        imagens.clear();
                        imagens.add(R.drawable.a_circunflexo);
                        break;
                    case "Â":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.a_circunflexo);
                        break;
                    case "à":
                        imagens.clear();
                        imagens.add(R.drawable.a_crase);
                        break;
                    case "À":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.a_crase);
                        break;
                    case "ã":
                        imagens.clear();
                        imagens.add(R.drawable.a_til);
                        break;
                    case "Ã":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.a_til);
                        break;
                    case "é":
                        imagens.clear();
                        imagens.add(R.drawable.e_agudo);
                        break;
                    case "É":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.e_agudo);
                        break;
                    case "ê":
                        imagens.clear();
                        imagens.add(R.drawable.e_circunflexo);
                        break;
                    case "Ê":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.e_circunflexo);
                        break;
                    case "è":
                        imagens.clear();
                        imagens.add(R.drawable.e_crase);
                        break;
                    case "È":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.e_crase);
                        break;
                    case "í":
                        imagens.clear();
                        imagens.add(R.drawable.i_agudo);
                        break;
                    case "Í":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.i_agudo);
                        break;
                    case "ì":
                        imagens.clear();
                        imagens.add(R.drawable.i_crase);
                        break;
                    case "Ì":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.i_crase);
                        break;
                    case "ó":
                        imagens.clear();
                        imagens.add(R.drawable.o_agudo);
                        break;
                    case "Ó":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.o_agudo);
                        break;
                    case "ô":
                        imagens.clear();
                        imagens.add(R.drawable.o_circunflexo);
                        break;
                    case "Ô":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.o_circunflexo);
                        break;
                    case "ò":
                        imagens.clear();
                        imagens.add(R.drawable.o_crase);
                        break;
                    case "Ò":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.o_crase);
                        break;
                    case "õ":
                        imagens.clear();
                        imagens.add(R.drawable.o_til);
                        break;
                    case "Õ":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.o_til);
                        break;
                    case "ú":
                        imagens.clear();
                        imagens.add(R.drawable.u_agudo);
                        break;
                    case "Ú":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.u_agudo);
                        break;
                    case "ù":
                        imagens.clear();
                        imagens.add(R.drawable.u_crase);
                        break;
                    case "Ù":
                        imagens.clear();
                        imagens.add(R.drawable.inicial_maiuscula);
                        imagens.add(R.drawable.u_crase);
                        break;
                    default:
                        imagens.clear();
                        imagens.add(R.drawable.limpa);
                        //Toast.makeText(getContext(), "Não foi encontrado uma célula braile correspondente.", Toast.LENGTH_SHORT).show();
                        break;
                }
                GridAdapter2 gridAdapter = new GridAdapter2(view.getContext(), imagens);
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

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("CONFIGCHANGED", "Entrou");
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Log.d("CONFIGCHANGED", "Entrou");


        }
    }
}
