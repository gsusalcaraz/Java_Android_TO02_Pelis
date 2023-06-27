package com.example.to02_pelis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PlataformasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plataformas);
    }

    // Crear submenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.submenu, menu);
        return true;
    }

    // Asignar los items del menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.historial:
                Intent iHistorial = new Intent(PlataformasActivity.this, HistorialActivity.class);
                startActivity(iHistorial);
                return true;
            case R.id.ayuda:
                Intent iAyuda = new Intent(PlataformasActivity.this, AyudaActivity.class);
                startActivity(iAyuda);
                return true;
            case R.id.acercade:
                Intent iAcercade = new Intent(PlataformasActivity.this, AcercadeActivity.class);
                startActivity(iAcercade);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}