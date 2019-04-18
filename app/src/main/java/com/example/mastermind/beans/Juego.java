package com.example.mastermind.beans;

import android.widget.Toast;

import com.example.mastermind.Juego_Activity;
import com.example.mastermind.R;

public class Juego {


    private int puntuacion; //voy sumando la puntuación fila a fila
    private FilaJuego[] filaJuego; //conjunto de filas que componen el juego
    private int[] solucion; //conjunto de 4 números que suponen la solución del juego
    private boolean juegoAcabado;
    private int filasRestantes;//número de filas que faltan para llegar al final en caso de acertar antes

    public Juego( FilaJuego[] filasJuego) {
        puntuacion = 0;//en el momento de iniciar el juego la puntuación es 0
        this.filaJuego = filasJuego;
        solucion= combinacionSolucion();//genero la combinación al construir el juego
        juegoAcabado=false;
        filasRestantes=10;

    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public FilaJuego[] getFilaJuego() {
        return filaJuego;
    }

    public void setFilaJuego(FilaJuego[] filaJuego) {
        this.filaJuego = filaJuego;
    }

    public int[] getSolucion() {
        return solucion;
    }

    public void setSolucion(int[] solucion) {
        this.solucion = solucion;
    }

    public boolean isJuegoAcabado() {
        return juegoAcabado;
    }

    public void setJuegoAcabado(boolean juegoAcabado) {
        this.juegoAcabado = juegoAcabado;
    }

    /**
     * Método que me devuelve la combinación de números que serán la solución de mi juego
     */
    public int[] combinacionSolucion(){
        int[] combinacion = new int[4];
        //inicio el bucle para generar mis cuatro números
        for(int i=0;i<combinacion.length;i++){
            int numero = (int)(Math.random()*6);//genero el número
            combinacion[i]=numero;//devuelvo el número
        }
        return combinacion;
    }

    /**
     * Método para comprobar fila a fila mi combinación
     */
    public void comprobarFila(FilaJuego fila){

        int aciertos=0;
        if(fila.isFilaSolucion()){//si la fila está acabada
            for(int i=0;i<fila.getBotonesOpciones().length;i++){

                //comprobamos cada botón con su solución
                if(fila.getBotonesOpciones()[i].getNumeroBoton() == solucion[i]){
                   aciertos++;//aumentamos el número de aciertos para luego cambiar los ib de las soluciones
                   puntuacion+=10;//sumamos diez puntos por acierto
                }

                if(aciertos == 4){
                    juegoAcabado = true;

                }
            }
        }else{

        }
        fila.setNumeroAciertos(aciertos);//incluyo en mi fila el número de aciertos
        switch(aciertos){

            case 1: fila.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                    break;
            case 2: fila.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                    break;
            case 3: fila.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[2].setImageResource(R.drawable.blanco);
                    break;
            case 4: fila.getBotonesSolucion()[0].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[1].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[2].setImageResource(R.drawable.blanco);
                    fila.getBotonesSolucion()[3].setImageResource(R.drawable.blanco);

                    juegoAcabado=true;//se acaba el juego

                    break;
                    default:break;

        }
    }

    /**
     *
     */


}
