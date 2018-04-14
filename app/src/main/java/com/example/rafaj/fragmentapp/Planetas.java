package com.example.rafaj.fragmentapp;

import android.widget.ImageView;

/**
 * Created by Erika on 13/4/2018.
 */

public class Planetas {
    String descripcion;
    ImageView img;

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
