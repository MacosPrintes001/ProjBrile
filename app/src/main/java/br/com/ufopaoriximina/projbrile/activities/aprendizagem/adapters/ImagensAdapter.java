package br.com.ufopaoriximina.projbrile.activities.aprendizagem.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.ufopaoriximina.projbrile.R;

public class ImagensAdapter extends RecyclerView.Adapter<ImagensAdapter.MyViewHolder> {
    ArrayList<Integer> imagens;

    public ImagensAdapter(ArrayList<Integer> imagens) {
        this.imagens = imagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_recyvler, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imagemBraile.setImageResource(imagens.get(position));
    }

    @Override
    public int getItemCount() {
        return imagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemBraile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemBraile = itemView.findViewById(R.id.imageBraile);
            //Lista de imagens

        }
    }
}
