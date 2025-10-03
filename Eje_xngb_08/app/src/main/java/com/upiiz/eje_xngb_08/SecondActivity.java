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

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    //1.- Vistas requeridas
    TextView tx_nombre;
    Button btn_continuar, btn_atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //2.- Referencias a las vistas
        tx_nombre = findViewById(R.id.tx_nombre);
        btn_atras = findViewById(R.id.btn_atras);
        btn_continuar = findViewById(R.id.btn_continuar);
        //Recuperamos el nombre de usuario
        String nombreUsuario = getIntent().getStringExtra("Nombre");
        //Muestro el TextView
        tx_nombre.setText(nombreUsuario);

        //3.-Acciones
        btn_atras.setOnClickListener(this);
        btn_continuar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_atras.getId()){
            regresar();
        }else
            continuar();
    }

    private void regresar() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
        finish();
    }
    private void continuar(){
        Intent intentThirdActivity = new Intent(this, ThirdActivity.class);
        startActivity(intentThirdActivity);
        finish();
    }

}