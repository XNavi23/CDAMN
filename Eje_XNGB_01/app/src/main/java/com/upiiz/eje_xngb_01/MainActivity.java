package com.upiiz.eje_xngb_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declaramos los elementos de la vista para referenciarlos
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Realizar las referencias del codigoy las vistas
        btnSalir = findViewById(R.id.btnSalir);
        //Funcionalidad o interactividad
        //que responda a los clicks
        btnSalir.setOnClickListener(this);
        //Toast - ventana pequeña
        Toast.makeText(this,"Estado onCreate",Toast.LENGTH_SHORT).show();
        //Log de la Aplicacion
        Log.d("Estados", "Estados onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Estado",Toast.LENGTH_SHORT).show();

        Log.d("Estado", "Estados onStar");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Estado onResume", Toast.LENGTH_SHORT).show();
        Log.d("Estado", "Estados onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Estado onDestroy", Toast.LENGTH_SHORT).show();
        Log.d("Estado", "Estados onDestroy");
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}