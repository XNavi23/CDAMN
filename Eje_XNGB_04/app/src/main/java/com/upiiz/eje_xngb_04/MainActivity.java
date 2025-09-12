package com.upiiz.eje_xngb_04;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1.- Definimos nuestras vistas (botones, texto)
    EditText tx_num; //Caja de texto del numero
    Button btn_restar, btn_sumar; //Botones suma y resta

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
        btn_restar = findViewById(btn_restar.getId());
        btn_sumar = findViewById(btn_sumar.getId());
        tx_num = findViewById(tx_num.getId());
    }

    @Override
    public void onClick(View view) {
        //Determinamos si se oprime en btn sumar o restar
        if(view.getId()==btn_restar.getId()){
            restarNumero();
        }else{
            sumarNumero();
        }
    }

    private void restarNumero() {
        //Obtenemos el numero actual
        int numero, res;
        numero = Integer.parseInt(tx_num.getText().toString());
        res = numero-1;
        tx_num.setText(String.valueOf(res));

    }
    private void sumarNumero() {
        //Obtenemos el numero actual
        int numero, res;
        numero = Integer.parseInt(tx_num.getText().toString());
        res = numero+1;
        tx_num.setText(String.valueOf(res));
    }
}