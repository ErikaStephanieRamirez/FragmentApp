package com.example.rafaj.fragmentapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Erika on 13/4/2018.
 */

public class Planetas {
    String nombre;
    String descripcion;
    Drawable img;

    public Planetas(Resources recursos,int index) {
        this.nombre = (recursos.obtainTypedArray(R.array.Planets)).getString(index);
        this.img = (recursos.obtainTypedArray(R.array.imagenes)).getDrawable(index);
        this.descripcion = (recursos.obtainTypedArray(R.array.DescriptionPlanets)).getString(index);
    }

    public Drawable getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
