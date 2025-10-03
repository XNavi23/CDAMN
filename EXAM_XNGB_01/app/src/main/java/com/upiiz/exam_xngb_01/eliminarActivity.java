package com.upiiz.exam_xngb_01;

import static com.upiiz.exam_xngb_01.R.id.et_id_buscar_delete;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; // Importa TextView
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.exam_xngb_01.models.paciente;
import com.upiiz.exam_xngb_01.services.pacienteService;

public class eliminarActivity extends AppCompatActivity implements View.OnClickListener {

    // 1.- Vistas
    EditText et_id_buscar_delete ;
    TextView tv_nombre_act_delete, tv_motivo_act_delete, tv_fecha_act_delete, tv_hora_act_delete;
    Button btn_buscar_act_delete, btn_eliminar_act_delete, btn_regresar_act_delete;

    // 2.- Lógica
    pacienteService servicioPaciente = pacienteService.getInstance();
    paciente pacienteAEliminar; // Para guardar el paciente encontrado

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eliminar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2.- Referencias
        et_id_buscar_delete = findViewById(R.id.et_id_buscar_delete);
        tv_nombre_act_delete = findViewById(R.id.tv_nombre_act_delete);
        tv_motivo_act_delete = findViewById(R.id.tv_motivo_act_delete);
        tv_fecha_act_delete = findViewById(R.id.tv_fecha_act_delete);
        tv_hora_act_delete = findViewById(R.id.tv_hora_act_delete);
        btn_buscar_act_delete = findViewById(R.id.btn_buscar_act_delete);
        btn_eliminar_act_delete = findViewById(R.id.btn_eliminar_act_delete);
        btn_regresar_act_delete = findViewById(R.id.btn_regresar_act_delete);

        // 3.- Acciones
        btn_buscar_act_delete.setOnClickListener(this);
        btn_eliminar_act_delete.setOnClickListener(this);
        btn_regresar_act_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Es más seguro comparar directamente con el ID del recurso
        int id = v.getId();
        if (id == R.id.btn_buscar_act_delete) {
            buscar();
        } else if (id == R.id.btn_eliminar_act_delete) {
            eliminar();
        } else if (id == R.id.btn_regresar_act_delete) {
            regresar();
        }
    }

    private void buscar() {
        String idStr = et_id_buscar_delete.getText().toString();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Ingrese un ID para buscar", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            pacienteAEliminar = servicioPaciente.pacienteById(id);

            if (pacienteAEliminar != null) {
                // Mostramos los datos en los TextView para confirmar
                tv_nombre_act_delete.setText("Paciente: " + pacienteAEliminar.getNombre());
                tv_motivo_act_delete.setText("Motivo: " + pacienteAEliminar.getMotivo());
                tv_fecha_act_delete.setText("Fecha: " + pacienteAEliminar.getFecha());
                tv_hora_act_delete.setText("Hora: " + pacienteAEliminar.getHora());
                Toast.makeText(this, "Paciente encontrado. Confirme para eliminar.", Toast.LENGTH_SHORT).show();
            } else {
                pacienteAEliminar = null; // Nos aseguramos que esté nulo
                tv_nombre_act_delete.setText("Paciente no encontrado");
                tv_motivo_act_delete.setText("");
                Toast.makeText(this, "No se encontró un paciente con el ID " + id, Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El ID debe ser un número válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminar() {
        if (pacienteAEliminar == null) {
            Toast.makeText(this, "Primero debe buscar un paciente válido para eliminar.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Llamamos al método delete de nuestro servicio
        boolean exito = servicioPaciente.delete(pacienteAEliminar.getId());

        if (exito) {
            Toast.makeText(this, "Paciente '" + pacienteAEliminar.getNombre() + "' eliminado con éxito.", Toast.LENGTH_LONG).show();
            finish(); // Cierra la actividad y regresa a MainActivity
        } else {
            // Este caso es raro si la búsqueda fue exitosa, pero es una buena práctica tenerlo
            Toast.makeText(this, "Error: No se pudo eliminar el paciente.", Toast.LENGTH_SHORT).show();
        }
    }

    private void regresar() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
        finish();
    }
}