package com.upiiz.exam_xngb_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //1.- Clases
    Button btn_agregar_main, btn_actualizar_main, btn_eliminar_main,
    btn_creditos_main, btn_salir_main;

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
        //2.- Referencias
        btn_agregar_main = findViewById(R.id.btn_agregar_main);
        btn_actualizar_main = findViewById(R.id.btn_actualizar_main);
        btn_creditos_main = findViewById(R.id.btn_creditos_main);
        btn_salir_main = findViewById(R.id.btn_salir_main);
        btn_eliminar_main = findViewById(R.id.btn_eliminar_main);
        //3.- Acciones
        btn_agregar_main.setOnClickListener(this);
        btn_actualizar_main.setOnClickListener(this);
        btn_creditos_main.setOnClickListener(this);
        btn_salir_main.setOnClickListener(this);
        btn_eliminar_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_agregar_main) {
            Intent intentAgregarActivity = new Intent(this, agregarActivity.class);
            startActivity(intentAgregarActivity);
        }
        else if(v.getId() == R.id.btn_actualizar_main) {
            Intent intentActualizarActivity = new Intent(this, actualizarActivity.class);
            startActivity(intentActualizarActivity);
        }
        else if(v.getId() == R.id.btn_creditos_main) {
            Intent intentCreditosActivity = new Intent(this, creditosActivity.class);
            startActivity(intentCreditosActivity);
        }
        else if(v.getId() == R.id.btn_salir_main) {
            finish();
        }
        else if(v.getId() == R.id.btn_eliminar_main) {
            Intent intentEliminarActivity = new Intent(this, eliminarActivity.class);
            startActivity(intentEliminarActivity);
        }


    }
}