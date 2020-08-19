package br.com.ufopaoriximina.projbrile.activities.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import br.com.ufopaoriximina.projbrile.R;


public class FragmentAprendNumero extends Fragment {

    private EditText letraInfor;
    private ImageView letra;
    public FragmentAprendNumero() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_aprend_alfabeto, container, false);
        letraInfor = view.findViewById(R.id.textoInformacao);
        letra = view.findViewById(R.id.imageViewLetra);
        letraInfor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                switch (letraInfor.getText().toString()){
                    case "0":
                        letra.setImageResource(R.drawable.n0);
                        break;
                    case "1":
                        letra.setImageResource(R.drawable.n1);
                        break;
                    case "2":
                        letra.setImageResource(R.drawable.n2);
                        break;
                    case "3":
                        letra.setImageResource(R.drawable.n3);
                        break;
                    case "4":
                        letra.setImageResource(R.drawable.n4);
                        break;
                    case "5":
                        letra.setImageResource(R.drawable.n5);
                        break;
                    case "6":
                        letra.setImageResource(R.drawable.n6);
                        break;
                    case "7":
                        letra.setImageResource(R.drawable.n7);
                        break;
                    case "8":
                        letra.setImageResource(R.drawable.n8);
                        break;
                    case "9":
                        letra.setImageResource(R.drawable.n9);
                        break;
                    default:
                        letra.setImageResource(R.drawable.test);
                        break;
                }
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
