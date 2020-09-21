package br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;

public class GridAdapter3 extends BaseAdapter {

    //Verifica o contexto da aplicação
    Context context;
    //Lista de imagens
    private final ArrayList<Integer> imagens;
    //O view
    View view;
    //Layout
    LayoutInflater layoutInflater;

    //Constutor da Classe
    public GridAdapter3(Context context, ArrayList<Integer> imagens) {
        this.context = context;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //Recupera o Layout
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            //Insere os dados do ArrayList do GridView
            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_item_2, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
            imageView.setImageResource(imagens.get(i));
        }
        return view;
    }
}
