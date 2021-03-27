package com.example.tallerindividual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button iniciar_juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar_juego= findViewById(R.id.iniciar_juego);
        iniciar_juego.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iniciar_juego:
                Intent i= new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                break;
        }
    }
}