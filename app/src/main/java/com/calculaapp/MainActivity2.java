package com.calculaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText seno,coseno,area,perim;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        seno = (EditText) findViewById(R.id.seno);
        coseno = (EditText) findViewById(R.id.cosin);
        area = (EditText) findViewById(R.id.area);
        perim = (EditText) findViewById(R.id.peri);
        calcular = (Button) findViewById(R.id.cal);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle enviarR1 = new Bundle();
                enviarR1.putString("datoSeno", seno.getText().toString());
                enviarR1.putString("datoCos", coseno.getText().toString());
                enviarR1.putString("datoArea", area.getText().toString());
                enviarR1.putString("datoPerim", perim.getText().toString());

                Intent intent = new Intent(MainActivity2.this, respuesta.class);
                intent.putExtras(enviarR1);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}