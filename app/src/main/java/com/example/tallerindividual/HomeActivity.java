package com.example.tallerindividual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText numero;
    Button intentar;
    Integer numero_intentos;
    Integer numero_spinner;
    Integer numero_aleatorio;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spinner = findViewById(R.id.spinner);
        numero = findViewById(R.id.numero);
        intentar = findViewById(R.id.intentar);
        intentar.setOnClickListener(this);
        numero_aleatorio = (int) ((Math.random() * (100 - 0)) + 0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.intentos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        numero_spinner = Integer.parseInt(parent.getItemAtPosition(position).toString());
        numero_intentos = numero_spinner;
        Toast.makeText(getApplicationContext(), "Tienes "+numero_intentos+ " intentos!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.intentar:
                Log.d("El numero es: ", numero_aleatorio.toString());
                if(!numero.getText().toString().isEmpty()) {
                    numero_intentos--;
                    if(numero_intentos != 0) {
                        if (Integer.parseInt(numero.getText().toString()) < numero_aleatorio) {
                            if(Integer.parseInt(numero.getText().toString())>100) {
                                Toast.makeText(getApplicationContext(), "El numero está entre 0 y 100!", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(getApplicationContext(), "El numero es mayor", Toast.LENGTH_SHORT).show();
                        } else if (Integer.parseInt(numero.getText().toString()) > numero_aleatorio) {
                            if(Integer.parseInt(numero.getText().toString())>100) {
                                Toast.makeText(getApplicationContext(), "El numero está entre 0 y 100!", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(getApplicationContext(), "El numero es menor", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Ganaste!", Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Perdiste, el numero era: " + numero_aleatorio, Toast.LENGTH_LONG).show();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Por favor ingresa un numero para jugar", Toast.LENGTH_SHORT).show();
                }
                numero.setText("") ;
                break;
        }
    }

}