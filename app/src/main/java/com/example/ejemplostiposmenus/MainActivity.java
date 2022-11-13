package com.example.ejemplostiposmenus;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/*
Autor: Juan Francisco Sánchez González
Fecha: 09/11/2022
Clase: Actividad principal dónde se inflan un OptionsMenu y un ContextMenu (sobre una imagen). Los 2 menús
utilizan el mismo XML (se implementa un submenú en un elemento) y se define su escuchador para cada uno de
ellos, la pulsación de un elemento iniciará una nueva Actividad. Se ha cambiado el icono y el color de la
barra principal de la aplicación.
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Se asocia el ContextMenu al objeto imagen
        ImageView imagenInicio = (ImageView) findViewById(R.id.ivMenu);
        registerForContextMenu(imagenInicio);
    }

    // Método para inflar el OptionsMenu del recurso main.xml en la Actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    // Listener del OptionsMenu que inciará la 2º Actividad pasándole el texto del elemento pulsado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, NSPActivity2.class);
        switch (item.getItemId()) {
            case R.id.NSP:
                cambiarActividad.putExtra("textoMarca",getResources().getString(R.string.marcaNSP));
                startActivity(cambiarActividad);
                return true;
            case R.id.Lost:
                cambiarActividad.putExtra("textoMarca",getResources().getString(R.string.marcaLost));
                startActivity(cambiarActividad);
                return true;
            /*case R.id.Pukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas));
                startActivity(cambiarActividad);
                return true;*/
            case R.id.SkatePukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas) + " -- " + getResources().getString(R.string.pukasSkate));
                startActivity(cambiarActividad);
                return true;
            case R.id.SurfPukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas) + " -- " + getResources().getString(R.string.pukasSurf));
                startActivity(cambiarActividad);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Método para inflar el ContextMenu del recurso main.xml en la Actividad
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
    }

    // Listener del ContextMenu que inciará la 2º Actividad pasándole el texto del elemento pulsado
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, NSPActivity2.class);
        switch (item.getItemId()) {
            case R.id.NSP:
                cambiarActividad.putExtra("textoMarca",getResources().getString(R.string.marcaNSP));
                startActivity(cambiarActividad);
                return true;
            case R.id.Lost:
                cambiarActividad.putExtra("textoMarca",getResources().getString(R.string.marcaLost));
                startActivity(cambiarActividad);
                return true;
            /*case R.id.Pukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas));
                startActivity(cambiarActividad);
                return true;*/
            case R.id.SkatePukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas) + " -- " + getResources().getString(R.string.pukasSkate));
                startActivity(cambiarActividad);
                return true;
            case R.id.SurfPukas:
                cambiarActividad.putExtra("textoMarca", getResources().getString(R.string.marcaPukas) + " -- " + getResources().getString(R.string.pukasSurf));
                startActivity(cambiarActividad);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}