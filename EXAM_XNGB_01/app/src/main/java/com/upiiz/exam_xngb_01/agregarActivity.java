package com.upiiz.exam_xngb_01;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.upiiz.exam_xngb_01.models.paciente;
import com.upiiz.exam_xngb_01.services.pacienteService;

public class agregarActivity extends AppCompatActivity implements View.OnClickListener {

    //1.- Vistas requeridas
    EditText et_fecha_act_add,et_motivo_act_add, et_nombre_act_add, et_hora_act_add;
    Button btn_agregar_act_add, btn_regresar_act_add;
    pacienteService servicioPaciente = pacienteService.getInstance(); //Instancia de paciente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //2.-Referencias
        et_fecha_act_add = findViewById(R.id.et_fecha_act_add);
        et_motivo_act_add = findViewById(R.id.et_motivo_act_add);
        et_nombre_act_add = findViewById(R.id.et_nombre_act_add);
        et_hora_act_add = findViewById(R.id.et_hora_act_add);
        btn_agregar_act_add = findViewById(R.id.btn_agregar_act_add);
        btn_regresar_act_add = findViewById(R.id.btn_regresar_act_add);

        //3.- Acciones
        btn_regresar_act_add.setOnClickListener(this);
        btn_agregar_act_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_regresar_act_add.getId()){
            regresar();
        }else if (v.getId() == R.id.btn_agregar_act_add) {
            agregar();
        }
    }

    private void regresar() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }
    private void agregar() {
        // Obtener los datos de los EditText
        String fecha = et_fecha_act_add.getText().toString();
        String horaStr = et_hora_act_add.getText().toString();
        String nombre = et_nombre_act_add.getText().toString();
        String motivo = et_motivo_act_add.getText().toString();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || fecha.isEmpty() || horaStr.isEmpty() || motivo.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String hora = horaStr;
            // Llamamos al método de nuestro gestor de servicios
            servicioPaciente.create(fecha, hora, nombre, motivo);

            Toast.makeText(this, "Paciente agregado con éxito", Toast.LENGTH_SHORT).show();
            finish(); // Cierra esta actividad y regresa a MainActivity

        } catch (NumberFormatException e) {
            Toast.makeText(this, "La hora debe ser un número válido", Toast.LENGTH_SHORT).show();
        }
    }
}