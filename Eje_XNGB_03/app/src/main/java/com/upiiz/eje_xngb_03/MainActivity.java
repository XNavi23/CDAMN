package com.upiiz.eje_xngb_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1.- Definimos nuestras vistas (boton, text
    EditText btn_tx_metros, btn_tx_pies; // cajas de texto
    Button btn_metros,  btn_pies; //botones

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
        btn_tx_metros = findViewById(btn_tx_metros.getId());
        btn_tx_pies = findViewById(btn_tx_pies.getId());
        btn_metros = findViewById(btn_metros.getId());
        btn_pies = findViewById(btn_pies.getId());
        //3.-Acciones
        btn_pies.setOnClickListener(this);
        btn_metros.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        //Determinar sobre
        if(view.getId()==btn_metros.getId()){
            convertirPies();}
        else {
            convertirMetros();}
    }

    private void convertirMetros(){
        //Obtener los datos de Pies
        float pies, resultado;
        pies = Float.parseFloat(btn_tx_pies.getText().toString());
        //Realizar la conversión
        resultado = pies / 3.281f;
        //Mostrar
        btn_tx_metros.setText(String.valueOf(resultado));
    }

    private void convertirPies(){
        //Obtener los datos de Metros
        float metros, resultado;
        metros = Float.parseFloat(btn_tx_metros.getText().toString());
        //Realizar la convercion
        resultado = metros * 3.281f;
        //Mostrar resultado
        btn_tx_metros.setText(String.valueOf(resultado));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}