package com.example.mastermind;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentOpciones extends Fragment {

    /**
     * Método para llamar a setArguments() en el momento de crear el fragment, si existen los
     * añade al fragment
     * @param arguments
     * @return
     */

    public static FragmentOpciones newInstance(Bundle arguments){
        FragmentOpciones f = new FragmentOpciones();
        if(arguments != null){
            f.setArguments(arguments);
        }
        return f;
    }

    /**
     * Constructor sin parámetros del fragment
     */

    public FragmentOpciones() {
    }

    /**
     * Adjunta el fragment a la activity
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * Creamos el fragment
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Método para inflar la vista del fragment con mi layout
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate( R.layout.fragment_fragement_opciones, container, false);

    }
}
