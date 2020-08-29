package br.com.ufopaoriximina.projbrile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;

public class GridAdapter extends BaseAdapter {

    Context context;
    private final ArrayList<Integer> imagens;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<Integer> imagens) {
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
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){

            view = new View(context);
            view = layoutInflater.inflate(R.layout.single_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
            imageView.setImageResource(imagens.get(i));
        }
        return view;
    }
}
