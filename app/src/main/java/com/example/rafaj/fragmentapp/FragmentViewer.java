package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView text;
    ImageView imagen;
    TextView descripcion;
    TextView gravedad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        imagen = view.findViewById(R.id.imgId);
        gravedad = view.findViewById(R.id.gravId);
        descripcion = view.findViewById(R.id.descId);

        Bundle bundle = this.getArguments();

        if(bundle != null){
            //instancia de Planetas enviando los recursos y el indice del item seleccionado a traves de la llave recibida de FragmentList
            Planetas planetaSeleccionada = new Planetas(getResources(),Integer.parseInt(bundle.getString("KEY")));

            //settea la imagen y los strings utilizando la instancia planetaSeleccionada para obtener los objetos de la clase Planeta
            text.setText(planetaSeleccionada.getNombre());
            imagen.setImageDrawable(planetaSeleccionada.getImg());
            gravedad.setText(planetaSeleccionada.getGravedad());
            descripcion.setText(planetaSeleccionada.getDescripcion());
        }
        return view;
    }
}
