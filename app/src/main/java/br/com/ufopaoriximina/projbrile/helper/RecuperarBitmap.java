package br.com.ufopaoriximina.projbrile.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class RecuperarBitmap {

    public Bitmap getBitmap (Context context, int id){
        ImageView i = new ImageView(context);
        i.setImageResource(id);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) i.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return bitmap;
    }
}
