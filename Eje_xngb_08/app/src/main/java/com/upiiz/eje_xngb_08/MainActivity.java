package com.upiiz.eje_xngb_08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1.- Clases/vistas que requerimos
    Button btn_ingresar, btn_cerrar;
    EditText et_usuario, et_clave;

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
        btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_cerrar = findViewById(R.id.btn_cerrar);
        et_usuario = findViewById(R.id.et_usuario);
        et_clave = findViewById(R.id.et_clave);

        //3.- Acciones
        btn_ingresar.setOnClickListener(this);
        btn_cerrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btn_cerrar.getId())
            finish();
        else
            login();
    }

    private void login(){
        String usuario = et_usuario.getText().toString();
        String clave = et_clave.getText().toString();
        if (clave.equals("1234")){
            Intent intentSecondActivity = new Intent(this, SecondActivity.class);
            intentSecondActivity.putExtra("Nombre", usuario);
            startActivity(intentSecondActivity);
        }else
            Toast.makeText(this,"Credenciales incorrectas",Toast.LENGTH_LONG).show();

    }

}