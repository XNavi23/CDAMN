package com.upiiz.eje_xngb_05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_num1, et_num2;
    TextView tv_res;
    Button btn_mas, btn_menos, btn_mul, btn_div;

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

        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
        tv_res = findViewById(R.id.tv_res);
        btn_mas = findViewById(R.id.btn_mas);
        btn_menos = findViewById(R.id.btn_menos);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);

        btn_mas.setOnClickListener(this);
        btn_menos.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Obtener los valores DENTRO del onClick
        String num1Str = et_num1.getText().toString();
        String num2Str = et_num2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double resultado = 0.0;

        int viewId = v.getId();
        if (viewId == R.id.btn_mas) {
            resultado = num1 + num2;
        } else if (viewId == R.id.btn_menos) {
            resultado = num1 - num2;
        } else if (viewId == R.id.btn_mul) {
            resultado = num1 * num2;
        } else if (viewId == R.id.btn_div) {
            if (num2 == 0) {
                Toast.makeText(this, "Error: No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                return;
            }
            resultado = num1 / num2;
        }
        tv_res.setText(String.valueOf(resultado));
    }

}
