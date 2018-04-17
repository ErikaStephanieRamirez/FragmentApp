package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    ImageView imagen;
    TextView descripcion;
    TextView gravedad;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //selecciona a que textview o imageview va a enviar cada recurso
        text = findViewById(R.id.textId);
        imagen = findViewById(R.id.imgId);
        gravedad = findViewById(R.id.gravId);
        descripcion = findViewById(R.id.descId);

        Intent callingIntent = this.getIntent();
        bundle = callingIntent.getExtras();


        Planetas planets = (Planetas)bundle.getSerializable("KEY"); //crea instancia de la clase Planeta y recibe de manera serializada la llave desde FragmentList

        //para obbtener la imagen desde recursos:
        Resources resources = getResources();
        TypedArray imagenes = resources.obtainTypedArray(R.array.imagenes);
        Drawable drawable = imagenes.getDrawable(Integer.parseInt(planets.getImg()));

        //setea al layout cada valor en el textview o imageview
        text.setText(planets.getNombre());
        gravedad.setText(planets.getGravedad());
        descripcion.setText(planets.getDescripcion());
        imagen.setImageDrawable(drawable);


        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();
    }
}