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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        imagen = view.findViewById(R.id.imgId);
        descripcion = view.findViewById(R.id.descId);

        Bundle bundle = this.getArguments();

        if(bundle != null){

            Planetas planetaSeleccionada = new Planetas(getResources(),Integer.parseInt(bundle.getString("KEY")));

            text.setText(planetaSeleccionada.getNombre());
            imagen.setImageDrawable(planetaSeleccionada.getImg());
            descripcion.setText(planetaSeleccionada.getDescripcion());
        }
        return view;
    }
}
