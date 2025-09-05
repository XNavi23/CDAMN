package com.upiiz.eje_xngb_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1.- Declaracion
    TextView tvMensaje;
    Button btnMensaje;
    Button btnCerrar;

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

        //2.- Referencia
        tvMensaje = findViewById(R.id.tvMensaje);
        btnMensaje = findViewById(R.id.btnMensaje);
        btnCerrar = findViewById(R.id.btnCerrar);
        //3.- Acciones - Clicks - Touch
        btnCerrar.setOnClickListener(this);
        btnMensaje.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        //Necesario saber sobre cual boton se dió el click
        //En caso de dar el click btnCerrar
        if(v.getId()==btnCerrar.getId()){
            finish();
        }
        //En caso de dar touch en btnMensaje
        if(v.getId()==btnMensaje.getId()){
            tvMensaje.setText(R.string.hola_usuario);
        }
    };

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}