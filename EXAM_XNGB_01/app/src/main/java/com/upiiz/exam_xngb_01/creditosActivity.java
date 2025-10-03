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

public class creditosActivity extends AppCompatActivity implements View.OnClickListener {
    //1.- Vistas
    Button btn_regresar_creditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creditos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2.- Referencias
        btn_regresar_creditos = findViewById(R.id.btn_regresar_creditos);
        //3.- Acciones
        btn_regresar_creditos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_regresar_creditos.getId()){
            regresar();
        }
    }

    private void regresar() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
        finish();
    }

}