package com.example.ejemplostiposmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 09/11/2022
Clase: Clase de la 2º Actividad dónde se recoge y se muestra el texto pasado por la principal. Se implementa
un OptionsMenu con la única opción de volver a la Actividad principal
*/

public class NSPActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsp);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Se recoge y muestra el texto pasado de la Actividad principal
        TextView tvMarca = (TextView) findViewById(R.id.tvMensajeMarca);
        Intent recibirDato = getIntent();
        tvMarca.setText(recibirDato.getStringExtra("textoMarca"));
    }

    // Método para inflar el OptionsMenu del recurso inicio.xml en la Actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inicio, menu);
        return true;
    }

    // Listener del OptionsMenu que inciará la Actividad principal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, MainActivity.class);
        switch (item.getItemId()) {
            case R.id.Inicio:
                startActivity(cambiarActividad);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}