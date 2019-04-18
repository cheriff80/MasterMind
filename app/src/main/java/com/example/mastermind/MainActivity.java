package com.example.mastermind;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //para iniciar el audio
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.videojuegos);
        final MediaPlayer mpPulso = MediaPlayer.create(this,R.raw.mario);
        mp.start();

        ConstraintLayout botonInicial = (ConstraintLayout) findViewById(R.id.mainLayout);

        botonInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mpPulso.start();
                Intent intent = new Intent(MainActivity.this, Juego_Activity.class);
                startActivity(intent);
            }
        });
    }
}
