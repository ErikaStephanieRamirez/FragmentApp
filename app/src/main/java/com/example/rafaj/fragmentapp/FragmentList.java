package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaj on 8/4/2018.
 *
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    private String[] Nombre;
    private String[] Gravedad;
    private String[] Descripcion;
    private String[] Img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        //obtiene los recursos con los valores de los arreglos para poder enviarlos posteriormente
        Nombre = getResources().getStringArray(R.array.Planets);
        Gravedad = getResources().getStringArray(R.array.gravedad);
        Descripcion = getResources().getStringArray(R.array.DescriptionPlanets);
        Img = getResources().getStringArray(R.array.num);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Planetas planets = new Planetas(Nombre[i], Gravedad[i], Descripcion[i], Img[i]); //instancia de la clase planeta donde le envia la posicion para cada arreglo del item que se a seleccionado

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY", planets); //envia como llave directamente la instancia de planeta a MainActivity2
            newIntent.putExtras(bundle);
            startActivity(newIntent);
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            FragmentViewer frag = new FragmentViewer();
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY",planets); //envia como llave directamente la instancia de planeta a MainActivity2
            frag.setArguments(bundle);

            final FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }
    }
}
