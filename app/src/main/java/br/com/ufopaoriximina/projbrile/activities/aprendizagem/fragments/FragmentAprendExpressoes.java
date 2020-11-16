package br.com.ufopaoriximina.projbrile.activities.aprendizagem.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

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
                final String[] a =  editPalavra.getText().toString().split("");
                //Verifica se o EditText está vazio
                if(editPalavra.getText().toString().isEmpty()){
                    imagens.clear();
                    GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                    gridView.setAdapter(gridAdapter);
                }

                int cont = 0;
                while (cont < a.length){
                    if (a[cont].equalsIgnoreCase("a") ||
                            a[cont].equalsIgnoreCase("b") ||
                            a[cont].equalsIgnoreCase("c")||
                            a[cont].equalsIgnoreCase("d")||
                            a[cont].equalsIgnoreCase("e")||
                            a[cont].equalsIgnoreCase("f")||
                            a[cont].equalsIgnoreCase("g")||
                            a[cont].equalsIgnoreCase("h")||
                            a[cont].equalsIgnoreCase("i")||
                            a[cont].equalsIgnoreCase("j")||
                            a[cont].equalsIgnoreCase("k")||
                            a[cont].equalsIgnoreCase("l")||
                            a[cont].equalsIgnoreCase("m")||
                            a[cont].equalsIgnoreCase("n")||
                            a[cont].equalsIgnoreCase("o")||
                            a[cont].equalsIgnoreCase("p")||
                            a[cont].equalsIgnoreCase("q")||
                            a[cont].equalsIgnoreCase("r")||
                            a[cont].equalsIgnoreCase("s")||
                            a[cont].equalsIgnoreCase("t")||
                            a[cont].equalsIgnoreCase("u")||
                            a[cont].equalsIgnoreCase("v")||
                            a[cont].equalsIgnoreCase("x")||
                            a[cont].equalsIgnoreCase("w")||
                            a[cont].equalsIgnoreCase("y")||
                            a[cont].equalsIgnoreCase("z")){
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
                        }
                    }else if (a[cont].equals("1") ||
                            a[cont].equals("2") ||
                            a[cont].equals("3")||
                            a[cont].equals("4")||
                            a[cont].equals("5")||
                            a[cont].equals("6")||
                            a[cont].equals("7")||
                            a[cont].equals("8")||
                            a[cont].equals("9")||
                            a[cont].equals("0")){
                        if(cont >= 1){
                            if (a[cont-1].equalsIgnoreCase(" " )||
                                    a[cont-1].equalsIgnoreCase("a")||
                                    a[cont-1].equalsIgnoreCase("b")||
                                    a[cont-1].equalsIgnoreCase("c")||
                                    a[cont-1].equalsIgnoreCase("d")||
                                    a[cont-1].equalsIgnoreCase("e")||
                                    a[cont-1].equalsIgnoreCase("f")||
                                    a[cont-1].equalsIgnoreCase("g")||
                                    a[cont-1].equalsIgnoreCase("h")||
                                    a[cont-1].equalsIgnoreCase("i")||
                                    a[cont-1].equalsIgnoreCase("j")||
                                    a[cont-1].equalsIgnoreCase("k")||
                                    a[cont-1].equalsIgnoreCase("l")||
                                    a[cont-1].equalsIgnoreCase("m")||
                                    a[cont-1].equalsIgnoreCase("n")||
                                    a[cont-1].equalsIgnoreCase("o")||
                                    a[cont-1].equalsIgnoreCase("p")||
                                    a[cont-1].equalsIgnoreCase("q")||
                                    a[cont-1].equalsIgnoreCase("r")||
                                    a[cont-1].equalsIgnoreCase("s")||
                                    a[cont-1].equalsIgnoreCase("t")||
                                    a[cont-1].equalsIgnoreCase("u")||
                                    a[cont-1].equalsIgnoreCase("v")||
                                    a[cont-1].equalsIgnoreCase("x")||
                                    a[cont-1].equalsIgnoreCase("w")||
                                    a[cont-1].equalsIgnoreCase("y")||
                                    a[cont-1].equalsIgnoreCase("z")||
                                    a[cont-1].equalsIgnoreCase("+") ||
                                    a[cont-1].equalsIgnoreCase("-") ||
                                    a[cont-1].equalsIgnoreCase("*")||
                                    a[cont-1].equalsIgnoreCase("/")||
                                    a[cont-1].equalsIgnoreCase("^")||
                                    a[cont-1].equalsIgnoreCase("(")||
                                    a[cont-1].equalsIgnoreCase(")")||
                                    a[cont-1].equalsIgnoreCase("=")||
                                    a[cont-1].equalsIgnoreCase(",")||
                                    a[cont-1].equalsIgnoreCase(".")
                            ){
                                imagens.add(R.drawable.inicial_numerico);
                            }
                        }else{
                            imagens.add(R.drawable.inicial_numerico);
                        }


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
                        }
                    }else if(a[cont].equalsIgnoreCase("+") ||
                            a[cont].equalsIgnoreCase("-") ||
                            a[cont].equalsIgnoreCase("*")||
                            a[cont].equalsIgnoreCase("/")||
                            a[cont].equalsIgnoreCase("^")||
                            a[cont].equalsIgnoreCase("(")||
                            a[cont].equalsIgnoreCase(")")||
                            a[cont].equalsIgnoreCase("=")||
                            a[cont].equalsIgnoreCase(",")||
                            a[cont].equalsIgnoreCase(".")){
                        switch (a[cont]){
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
                        }
                    }else {
                        imagens.add(R.drawable.limpa);
                    }
                    cont += 1;
                }
                GridAdapter gridAdapter = new GridAdapter(view.getContext(), imagens);
                gridView.setAdapter(gridAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i){
                            default:
                                String representacao = "";
                                switch (imagens.get(i)){
                                    case R.drawable.inicial_maiuscula:
                                        representacao += "Representação de Maiúsuculas";
                                        break;
                                    case R.drawable.inicial_numerico:
                                        representacao += "Representação de Número";
                                        break;
                                    case R.drawable.soma:
                                        representacao += "Soma";
                                        break;
                                    case R.drawable.subtracao:
                                        representacao += "Subtração";
                                        break;
                                    case R.drawable.multiplicacao:
                                        representacao += "Multiplicação";
                                        break;
                                    case R.drawable.divisao:
                                        representacao += "Divisão";
                                        break;
                                    case R.drawable.expoente:
                                        representacao += "Expoente";
                                        break;
                                    case R.drawable.abre:
                                        representacao += "Abre parênteses";
                                        break;
                                    case R.drawable.fecha:
                                        representacao += "Fecha parênteses";
                                        break;
                                    case R.drawable.igualdade:
                                        representacao += "Igualdade";
                                        break;
                                    case R.drawable.decimal:
                                        representacao += "Vírgula";
                                        break;
                                    case R.drawable.milhar:
                                        representacao += "Ponto";
                                        break;
                                    //Variaveis
                                    case R.drawable.letra_a:
                                        representacao += "Dependendo do caso representa a letra 'a' ou 1 ";
                                        break;
                                    case R.drawable.letra_b:
                                        representacao += "Dependendo do caso representa a letra 'b' ou 2";
                                        break;
                                    case R.drawable.letra_c:
                                        representacao += "Dependendo do caso representa a letra 'c' ou 3";
                                        break;
                                    case R.drawable.letra_d:
                                        representacao += "Dependendo do caso representa a letra 'd' ou 4";
                                        break;
                                    case R.drawable.letra_e:
                                        representacao += "Dependendo do caso representa a letra 'e' ou 5";
                                        break;
                                    case R.drawable.letra_f:
                                        representacao += "Dependendo do caso representa a letra 'f' ou 6";
                                        break;
                                    case R.drawable.letra_g:
                                        representacao += "Dependendo do caso representa a letra 'g' ou 7";
                                        break;
                                    case R.drawable.letra_h:
                                        representacao += "Dependendo do caso representa a letra 'h' ou 8";
                                        break;
                                    case R.drawable.letra_i:
                                        representacao += "Dependendo do caso representa a letra 'i' ou 9";
                                        break;
                                    case R.drawable.letra_j:
                                        representacao += "Dependendo do caso representa a letra 'j' ou 0";
                                        break;
                                    case R.drawable.letra_k:
                                        representacao += "Letra k";
                                        break;
                                    case R.drawable.letra_l:
                                        representacao += "Letra l";
                                        break;
                                    case R.drawable.letra_m:
                                        representacao += "Letra m";
                                        break;
                                    case R.drawable.letra_n:
                                        representacao += "Letra n";
                                        break;
                                    case R.drawable.letra_o:
                                        representacao += "Letra o";
                                        break;
                                    case R.drawable.letra_p:
                                        representacao += "Letra p";
                                        break;
                                    case R.drawable.letra_q:
                                        representacao += "Letra q";
                                        break;
                                    case R.drawable.letra_r:
                                        representacao += "Letra r";
                                        break;
                                    case R.drawable.letra_s:
                                        representacao += "Letra s";
                                        break;
                                    case R.drawable.letra_t:
                                        representacao += "Letra t";
                                        break;
                                    case R.drawable.letra_u:
                                        representacao += "Letra u";
                                        break;
                                    case R.drawable.letra_v:
                                        representacao += "Letra v";
                                        break;
                                    case R.drawable.letra_w:
                                        representacao += "Letra w";
                                        break;
                                    case R.drawable.letra_x:
                                        representacao += "Letra x";
                                        break;
                                    case R.drawable.letra_y:
                                        representacao += "Letra y";
                                        break;
                                    case R.drawable.letra_z:
                                        representacao += "Letra z";
                                        break;
                                    //acentuadas
                                    case R.drawable.a_agudo:
                                        representacao += "Letra a com acento agudo";
                                        break;
                                    case R.drawable.a_circunflexo:
                                        representacao += "Letra a com acento circunflexo";
                                        break;
                                    case R.drawable.a_crase:
                                        representacao += "Letra a com crase";
                                        break;
                                    case R.drawable.a_til:
                                        representacao += "Letra a com acento til";
                                        break;
                                    case R.drawable.e_agudo:
                                        representacao += "Letra e com acento agudo";
                                        break;
                                    case R.drawable.e_circunflexo:
                                        representacao += "Letra e com acento circunflexo";
                                        break;
                                    case R.drawable.e_crase:
                                        representacao += "Letra e com crase";
                                        break;
                                    case R.drawable.i_agudo:
                                        representacao += "Letra i com acento agudo";
                                        break;
                                    case R.drawable.i_crase:
                                        representacao += "Letra i com crase";
                                        break;
                                    case R.drawable.o_agudo:
                                        representacao += "Letra o com acento agudo";
                                        break;
                                    case R.drawable.o_circunflexo:
                                        representacao += "Letra o com acento circunflexo";
                                        break;
                                    case R.drawable.o_crase:
                                        representacao += "Letra o com crase";
                                        break;
                                    case R.drawable.o_til:
                                        representacao += "Letra o com acento til";
                                        break;
                                    case R.drawable.u_agudo:
                                        representacao += "Letra u com acento agudo";
                                        break;
                                    case R.drawable.u_crase:
                                        representacao += "Letra u com crase";
                                        break;


                                }

                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setMessage("A célula clicada representa: " + representacao + ".")
                                        .setCancelable(true)
                                        .setPositiveButton("Entendi", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                               dialog.cancel();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();
                                break;
                        }
                    }
                });
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
