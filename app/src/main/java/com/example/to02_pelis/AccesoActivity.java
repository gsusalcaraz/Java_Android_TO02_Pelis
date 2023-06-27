package com.example.to02_pelis;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.to02_pelis.model.Modelo;
import com.example.to02_pelis.model.Usuario;

public class AccesoActivity extends AppCompatActivity {

    TextView tvRegistrarse;
    EditText etUsuario, etPass;
    Button btIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        //ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        String user, pass, email, plataforma, telefono;

        //Creo usuario admin
        user = "admin";
        pass = "1234";
        email = "admin@admin.es";
        plataforma = "Netflix";
        telefono = "950950950";

        Usuario admin = new Usuario (user, pass, email, plataforma, telefono);
        Modelo.insertar(admin);

        tvRegistrarse = (TextView) findViewById(R.id.tvRegistrarse);
        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iRegistro = new Intent(AccesoActivity.this, RegistroActivity.class);
                startActivity(iRegistro);
            }
        });

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPass = (EditText) findViewById(R.id.etPass);
        btIniciarSesion = (Button) findViewById(R.id.btIniciarSesion);

        btIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario nuevo = new Usuario (etUsuario.getText().toString(), "", "", "", "");
               /* if (Modelo.buscar(nuevo)){
                    Toast.makeText(AccesoActivity.this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
                }*/

                boolean existeUsuario = true;
                for (int i = 0; i < Modelo.usuarios.size(); i++) {
                    if (etUsuario.getText().toString().equals(Modelo.usuarios.get(i).getUser())) {
                        if (etPass.getText().toString().equals(Modelo.usuarios.get(i).getPass())) {
                            Intent iplataformas = new Intent(AccesoActivity.this, PlataformasActivity.class);
                            startActivity(iplataformas);
                        } else {
                            Toast.makeText(AccesoActivity.this, "Error de Contraseña", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        existeUsuario = false;
                    }
                }
                if (!existeUsuario) {
                    Toast.makeText(AccesoActivity.this, "Error de Usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

