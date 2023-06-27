package com.example.to02_pelis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.to02_pelis.model.Modelo;
import com.example.to02_pelis.model.Plataformas;
import com.example.to02_pelis.model.Usuario;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {
    
    EditText etUsuarioNuevo, etMail, etTelefono, etPassRegistro, etPassConfirmar;
    Spinner spPlataforma;
    Button btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Se inicia el componente Spinner en un método dentro de la clas
        //para simplicar este método
        initPlataformas();

        //ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        etUsuarioNuevo = (EditText) findViewById(R.id.etUsuarioNuevo);
        etMail = (EditText) findViewById(R.id.etMail);
        etPassRegistro = (EditText) findViewById(R.id.etPassRegistro);
        etPassConfirmar = (EditText) findViewById(R.id.etPassConfirmar);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        spPlataforma = (Spinner) findViewById(R.id.spPlataforma);
        btRegistrar = (Button) findViewById(R.id.btRegistrar);

        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Comprobar que no haya campos vacíos
                if ((etUsuarioNuevo.getText().toString().equals(""))){
                    Toast.makeText(RegistroActivity.this, "Campo usuario vacío", Toast.LENGTH_SHORT).show();
                }else{
                    if (etMail.getText().toString().equals("")){
                        Toast.makeText(RegistroActivity.this, "Campo email vacío", Toast.LENGTH_SHORT).show();
                    }else{
                        if (etTelefono.getText().toString().equals("")){
                            Toast.makeText(RegistroActivity.this, "Campo teléfono vacío", Toast.LENGTH_SHORT).show();
                        }else{
                            if (etPassRegistro.getText().toString().equals("")){
                                Toast.makeText(RegistroActivity.this, "Campo contraseña vacío", Toast.LENGTH_SHORT).show();
                            }else
                            if (etPassRegistro.getText().toString().equals((etPassConfirmar.getText().toString()))){

                                Usuario nuevo = new Usuario (etUsuarioNuevo.getText().toString(), etPassRegistro.getText().toString(), etMail.getText().toString(), spPlataforma.toString(), etTelefono.getText().toString());
                                if (Modelo.buscar(nuevo)) {
                                    Toast.makeText(RegistroActivity.this, "EXISTE YA", Toast.LENGTH_SHORT).show();
                                }else{
                                    Modelo.insertar(nuevo);
                                    Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                    //finish();
                                }
                            }else{
                                Toast.makeText(RegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });

    }
    private void initPlataformas() {
        //Se declara la colección de datos

        ArrayList<Plataformas> listPlataforma = new ArrayList<>();
        listPlataforma.add(new Plataformas(1, "Netflix"));
        listPlataforma.add(new Plataformas(2, "HBO"));
        listPlataforma.add(new Plataformas(3, "Disney+"));
        listPlataforma.add(new Plataformas(4, "Amazon Prime"));
        listPlataforma.add(new Plataformas(5, "DAZN"));
        listPlataforma.add(new Plataformas(6, "Movistar TV"));
        listPlataforma.add(new Plataformas(7, "Vodafone TV"));

        //Se crea el Adapter
        ArrayAdapter<Plataformas> arrayAdapter = new ArrayAdapter<Plataformas>(this, android.R.layout.simple_spinner_item, listPlataforma);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Se identifica el spinner

        spPlataforma = findViewById(R.id.spPlataforma);
        //Se une el control Spinner con su Adapter
        spPlataforma.setAdapter(arrayAdapter);
        spPlataforma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RegistroActivity.this, "Elemento seleccionado " + parent.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}