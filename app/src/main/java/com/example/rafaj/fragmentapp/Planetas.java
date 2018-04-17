package com.example.rafaj.fragmentapp;

import java.io.Serializable;

/**
 * Created by Erika on 13/4/2018.
 */

//clase para obtener los strings y la imagen

public class Planetas implements Serializable {
    String Nombre;
    String Descripcion;
    String Gravedad;
    String Img;

    //constructor que recibe los las posiciones de cada array desde la clase FragmentList

    public Planetas(String nombre, String gravedad, String descripcion, String img) {

        //obtiene cada valor recibido desde el constructor a traves de los get
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Gravedad = gravedad;
        this.Img = img;

    }

    //Setter y getter
    public String getImg() {
        return Img;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getGravedad() {
        return Gravedad;
    }

    public void setGravedad(String gravedad) {
        this.Gravedad = gravedad;
    }

    public void setImg(String img) {
        this.Img = img;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
}
