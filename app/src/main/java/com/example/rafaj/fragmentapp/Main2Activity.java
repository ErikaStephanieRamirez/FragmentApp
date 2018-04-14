package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    ImageView imagen;
    TextView descripcion;
    TextView gravedad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textId);
        imagen = findViewById(R.id.imgId);
        gravedad = findViewById(R.id.gravId);
        descripcion = findViewById(R.id.descId);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if (intentType.equals("text/text")){
                handleReceivedText(callingIntent);
            }
        }
    }

    private void handleReceivedText(Intent intent){
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        //instancia de Planetas enviando los recursos y el indice del item seleccionado
        Planetas planetaSeleccionada = new Planetas(getResources(),Integer.parseInt(intentText));

        //settea la imagen y los strings utilizando la instancia planetaSeleccionada para obtener los objetos de la clase Planeta
        if (text != null){
            text.setText(planetaSeleccionada.getNombre());
            imagen.setImageDrawable(planetaSeleccionada.getImg());
            gravedad.setText(planetaSeleccionada.getGravedad());
            descripcion.setText(planetaSeleccionada.getDescripcion());
        }
    }
}