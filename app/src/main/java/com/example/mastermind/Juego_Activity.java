package com.example.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mastermind.beans.Boton;
import com.example.mastermind.beans.FilaJuego;
import com.example.mastermind.beans.Juego;

public class Juego_Activity extends AppCompatActivity {

    private TextView textoNumeroFila;//texto de los números de cada línea
    private ImageButton ibFilaUno,ibFilaDos,ibFilaTres,ibFilaCuatro;//botones imágen de cada fila
    private ImageView ivSolucionUno,ivSolucionDos,ivSolucionTres,ivSolucionCuatro;
    private boolean recogerOpcion;
    private Juego juego;
    private FilaJuego[] filas;
    private int[] solucion;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_juego,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //inflamos el menu


        numerosFilas();//ponemos el número a nuestras filas

    }

    /**
     * Comienzo el juego
     */
    @Override
    protected void onStart() {
        super.onStart();

        //inicio mi juego
        juego = new Juego(cargarFilas());
        //creo la combinación
        solucion = juego.getSolucion();

        //inicio el juego por cada fila
        FilaJuego filaHabilitar = juego.getFilaJuego()[0];
        habilitarFila(filaHabilitar);




    }

    /**
     * OnCLick de los botones de Solución de cada fila
     */



    /**
     * Método para poner los números al inicio de cada fila del juego
     */
    public  void numerosFilas(){
        for(int i=0;i<10;i++){

            String strIncludeId = "fila" + i;//el id de las filas tiene en común fila
            int includeId = getResources().getIdentifier(strIncludeId, "id",
                    getPackageName());
            View includeLayout = findViewById(includeId);
            if (includeLayout != null) {//si encuentra la vista
                 textoNumeroFila = (TextView)
                        includeLayout.findViewById(R.id.textoNumeros);
                textoNumeroFila.setText(Integer.toString(i+1));
            }
        }
    }

    /**
     * Carga todas las filas de mi juego
     */
    public FilaJuego[] cargarFilas(){

        filas = new FilaJuego[10];//defino las filas del juego
        for (int j=0;j<10;j++){
            FilaJuego filaJuego = crearFila(j);
            filas[j] = filaJuego;
        }
        return filas;
    }
    /**
     * Crear filas
     */
    public FilaJuego crearFila(int numeroFila) {

        FilaJuego filaNueva=null;
        //creo los dos arrays
        Boton[] botonesSolucion = new Boton[4];
        ImageView[] imagenesSolucion = new ImageView[4];

        int includeId = getResources().getIdentifier("fila" + numeroFila, "id",
                getPackageName());
        View includeLayout = findViewById(includeId);
        if (includeLayout != null) {
            ibFilaUno = (ImageButton) includeLayout.findViewById(R.id.ibUno);
            ibFilaDos = (ImageButton) includeLayout.findViewById(R.id.ibDos);
            ibFilaTres = (ImageButton) includeLayout.findViewById(R.id.ibTres);
            ibFilaCuatro = (ImageButton) includeLayout.findViewById(R.id.ibCuatro);


            //genero los botones
            Boton boton1 = new Boton( ibFilaUno);
            botonesSolucion[0]=boton1;
            Boton boton2 = new Boton( ibFilaDos);
            botonesSolucion[1]=boton2;
            Boton boton3 = new Boton(ibFilaTres);
            botonesSolucion[2]=boton3;
            Boton boton4 = new Boton( ibFilaCuatro);
            botonesSolucion[3]=boton4;

            //genero los botones solucion
            ivSolucionUno = (ImageView) includeLayout.findViewById(R.id.ivAciertosSI);
            imagenesSolucion[0]= ivSolucionUno;
            ivSolucionDos = (ImageView) includeLayout.findViewById(R.id.ivAciertosSD);
            imagenesSolucion[1]= ivSolucionDos;
            ivSolucionTres = (ImageView) includeLayout.findViewById(R.id.ivAciertosII);
            imagenesSolucion[2]= ivSolucionTres;
            ivSolucionCuatro = (ImageView) includeLayout.findViewById(R.id.ivAciertosID);
            imagenesSolucion[3]= ivSolucionCuatro;


            filaNueva = new FilaJuego(botonesSolucion,imagenesSolucion);



        }

        return filaNueva;
    }
    /**
     * Método para hacer clickable la primera fila de botones del fragment
     */
    public void habilitarFila(FilaJuego fila){

        for(int h=0;h<fila.getBotonesOpciones().length;h++){
            fila.getBotonesOpciones()[h].getImagen().setClickable(true);
        }
    }





}
