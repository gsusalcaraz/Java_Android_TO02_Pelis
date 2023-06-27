package com.example.to02_pelis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercadeActivity extends AppCompatActivity {

    Button btVolverAcercade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        btVolverAcercade = (Button) findViewById(R.id.btVolverAcercade);

        btVolverAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}