package com.upiiz.exam_xngb_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.exam_xngb_01.models.paciente;
import com.upiiz.exam_xngb_01.services.pacienteService;

public class actualizarActivity extends AppCompatActivity implements View.OnClickListener {

    // 1.- Vistas
    EditText et_id_buscar, et_fecha_act_update, et_hora_act_update, et_nombre_act_update, et_motivo_act_update;
    Button btn_buscar_act_update, btn_actualizar_act_update, btn_regresar_act_update;

    // 2.- Lógica
    pacienteService servicioPaciente = pacienteService.getInstance();
    paciente pacienteEncontrado; // Para guardar el paciente que buscamos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actualizar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3.- Referencias (Asegúrate que los IDs coincidan con tu activity_actualizar.xml)
        et_id_buscar = findViewById(R.id.et_id_buscar);
        et_fecha_act_update = findViewById(R.id.et_fecha_act_update);
        et_hora_act_update = findViewById(R.id.et_hora_act_update);
        et_nombre_act_update = findViewById(R.id.et_nombre_act_update);
        et_motivo_act_update = findViewById(R.id.et_motivo_act_update);

        btn_buscar_act_update = findViewById(R.id.btn_buscar_act_update);
        btn_actualizar_act_update = findViewById(R.id.btn_actualizar_act_update);
        btn_regresar_act_update = findViewById(R.id.btn_regresar_act_update);

        // 4.- Acciones
        btn_buscar_act_update.setOnClickListener(this);
        btn_actualizar_act_update.setOnClickListener(this);
        btn_regresar_act_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_buscar_act_update){
            buscar();
        } else if(v.getId() == R.id.btn_actualizar_act_update){
            actualizar();
        } else if(v.getId() == R.id.btn_regresar_act_update){
            regresar();
        }
    }

    private void buscar() {
        String idStr = et_id_buscar.getText().toString();
        if (idStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un ID para buscar", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            pacienteEncontrado = servicioPaciente.pacienteById(id);
            if (pacienteEncontrado != null) {
                // Rellenamos los campos con los datos del paciente
                et_fecha_act_update.setText(pacienteEncontrado.getFecha());
                et_hora_act_update.setText(String.valueOf(pacienteEncontrado.getHora()));
                et_nombre_act_update.setText(pacienteEncontrado.getNombre());
                et_motivo_act_update.setText(pacienteEncontrado.getMotivo());
                Toast.makeText(this, "Paciente encontrado. Puede actualizar los datos.", Toast.LENGTH_SHORT).show();
            } else {
                // Limpiamos los campos si no se encuentra
                et_fecha_act_update.setText("");
                et_hora_act_update.setText("");
                et_nombre_act_update.setText("");
                et_motivo_act_update.setText("");
                Toast.makeText(this, "Paciente con ID " + id + " no encontrado.", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "El ID debe ser un número.", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizar() {
        if (pacienteEncontrado == null) {
            Toast.makeText(this, "Primero debe buscar un paciente válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        String fecha = et_fecha_act_update.getText().toString();
        String horaStr = et_hora_act_update.getText().toString();
        String nombre = et_nombre_act_update.getText().toString();
        String motivo = et_motivo_act_update.getText().toString();

        if (nombre.isEmpty() || fecha.isEmpty() || horaStr.isEmpty() || motivo.isEmpty()) {
            Toast.makeText(this, "Todos los campos deben estar llenos.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String hora = String.valueOf(pacienteEncontrado.getHora());
            // Creamos un objeto paciente con los datos actualizados y el ID original
            paciente pacienteActualizado = new paciente(pacienteEncontrado.getId(), fecha, hora, nombre, motivo);

            // Llamamos al servicio para actualizar
            servicioPaciente.update(pacienteActualizado);

            Toast.makeText(this, "Paciente actualizado con éxito.", Toast.LENGTH_SHORT).show();
            finish(); // Regresar a la pantalla principal

        } catch (NumberFormatException e) {
            Toast.makeText(this, "La hora debe ser un número válido.", Toast.LENGTH_SHORT).show();
        }
    }

    private void regresar() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }
}
