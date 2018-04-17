package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

        //selecciona a que textview o imageview va a enviar cada recurso
        text = view.findViewById(R.id.textId);
        imagen = view.findViewById(R.id.imgId);
        gravedad = view.findViewById(R.id.gravId);
        descripcion = view.findViewById(R.id.descId);

        Bundle bundle = this.getArguments();

        if(bundle != null){
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
        }
        return view;
    }

}
