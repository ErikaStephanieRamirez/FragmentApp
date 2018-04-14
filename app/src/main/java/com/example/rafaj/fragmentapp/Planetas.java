package com.example.rafaj.fragmentapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Erika on 13/4/2018.
 */

//clase para obtener los strings y la imagen

public class Planetas {
    String nombre;
    String descripcion;
    String gravedad;
    Drawable img;

    //constructor que recibe los recursos y el indece para asi poder obtener una posicion de los arreglos

    public Planetas(Resources recursos,int index) {
        this.nombre = (recursos.obtainTypedArray(R.array.Planets)).getString(index);
        this.img = (recursos.obtainTypedArray(R.array.imagenes)).getDrawable(index);
        this.gravedad = "Gravedad: " +(recursos.obtainTypedArray(R.array.gravedad)).getString(index);
        this.descripcion = (recursos.obtainTypedArray(R.array.DescriptionPlanets)).getString(index);
    }

    //Setter y getter
    public Drawable getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
