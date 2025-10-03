package com.upiiz.eje_xngb_08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    //1.- Vistas requeridas
    TextView tv_nombre3;
    Button btn_regresar3;
    //cadena para el nombre de usuario
    String nombreUsuarioRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2.- Referencias
        btn_regresar3 = findViewById(R.id.btn_regresar3);
        tv_nombre3 = findViewById(R.id.tv_nombre3);

        //Recuperamos el nombre de usuario
        String nombreUsuario = getIntent().getStringExtra("Nombre");
        //Muestro el TextView
        tv_nombre3.setText(nombreUsuario);

        //3.- Acciones
        btn_regresar3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        regresar();
    }

    private void regresar() {
        Intent intentSecondActivity = new Intent(this, SecondActivity.class);
        startActivity(intentSecondActivity);
        finish();
    }
}