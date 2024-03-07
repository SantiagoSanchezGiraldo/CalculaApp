package com.calculaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class respuesta extends AppCompatActivity {
    TextView solvSeno, solvCoseno, solvArea, solvPerim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_respuesta);

        solvSeno = (TextView) findViewById(R.id.sinres);
        solvCoseno = (TextView) findViewById(R.id.cosres);
        solvArea = (TextView) findViewById(R.id.areares);
        solvPerim = (TextView) findViewById(R.id.perimres);


        Bundle recibirDatos = getIntent().getExtras();
        String rSeno = recibirDatos.getString("datoSeno");
        String rCos = recibirDatos.getString("datoCos");
        String rArea = recibirDatos.getString("datoArea");
        String rPerim = recibirDatos.getString("datoPerim");

        float vSeno, vCos, vArea, vPerim, resSeno, resCos, resArea, resPerim;
        vSeno = Float.parseFloat(rSeno);
        //vCos = Float.parseFloat(coseno.getText().toString());
        //vArea = Float.parseFloat(area.getText().toString());
        //vPerim = Float.parseFloat(perim.getText().toString());

        resSeno = vSeno + 1;
        //resCos = 1;
        // resArea = (vArea * vArea);
        //resPerim = (vPerim * 4);

        solvSeno.setText(resSeno);
        solvCoseno.setText(rCos);
        solvArea.setText(rArea);
        solvPerim.setText(rPerim);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}