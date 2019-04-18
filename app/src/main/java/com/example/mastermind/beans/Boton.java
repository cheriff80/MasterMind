package com.example.mastermind.beans;


import android.widget.ImageButton;

public class Boton  {

    private int numeroBoton;//indica el número de botón, cada número corresponde a un color
    private boolean opcionJuego;
    private ImageButton imagen;

    public Boton(ImageButton ib) {
        this.imagen = ib;
        opcionJuego=false;
    }



    public int getNumeroBoton() {
        return numeroBoton;
    }

    public void setNumeroBoton(int numeroBoton) {
        this.numeroBoton = numeroBoton;
    }

    public boolean isOpcionJuego() {
        return opcionJuego;
    }

    public void setOpcionJuego(boolean opcionJuego) {
        this.opcionJuego = opcionJuego;
    }

    public ImageButton getImagen() {
        return imagen;
    }

    public void setImagen(ImageButton imagen) {
        this.imagen = imagen;
    }
}
