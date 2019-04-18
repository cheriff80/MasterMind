package com.example.mastermind.beans;

import android.widget.ImageButton;
import android.widget.ImageView;

public class FilaJuego {

    private Boton[] botonesOpciones;
    private ImageView[] botonesSolucion;
    private int numeroAciertos;
    private boolean filaSolucion;

    public FilaJuego(Boton[] botonesOpciones, ImageView[] botonesSolucion) {
        this.botonesOpciones = botonesOpciones;
        this.botonesSolucion = botonesSolucion;
        filaSolucion = false;
        numeroAciertos=0;
    }

    public Boton[] getBotonesOpciones() {
        return botonesOpciones;
    }

    public void setBotonesOpciones(Boton[] botonesOpciones) {
        this.botonesOpciones = botonesOpciones;
    }

    public ImageView[] getBotonesSolucion() {
        return botonesSolucion;
    }

    public void setBotonesSolucion(ImageButton[] botonesSolucion) {
        this.botonesSolucion = botonesSolucion;
    }

    public boolean isFilaSolucion() {
        return filaSolucion;
    }

    public void setFilaSolucion(boolean filaSolucion) {
        this.filaSolucion = filaSolucion;
    }

    public int getNumeroAciertos() {
        return numeroAciertos;
    }

    public void setNumeroAciertos(int numeroAciertos) {
        this.numeroAciertos = numeroAciertos;
    }
}
