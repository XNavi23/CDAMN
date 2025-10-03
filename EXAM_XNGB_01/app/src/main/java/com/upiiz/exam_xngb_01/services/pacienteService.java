package com.upiiz.exam_xngb_01.services;

import com.upiiz.exam_xngb_01.models.paciente;

import java.util.ArrayList;
import java.util.List;

public class pacienteService {
    private static final pacienteService instance = new pacienteService();

    public static pacienteService getInstance() {
        return instance;
    }

    private final List<paciente> pacientes; // Lista de Pacientes
    private int lastId; // Contador para el último ID

    private pacienteService() {
        pacientes = new ArrayList<>();
        lastId = 0; // El contador empieza en 0
        create("2024-10-01", "10:30", "Paciente de Prueba", "Revisión");
    }

    // CREATE (Crear)
    public void create(String fecha, String hora, String nombrePaciente, String motivo){
        // Usamos PRE-incremento (++lastId) para que el primer ID sea 1.
        // O `lastId++` y empezar el contador en 1.
        lastId++;
        paciente nuevoPaciente = new paciente(lastId, fecha, hora, nombrePaciente, motivo);
        pacientes.add(nuevoPaciente);
    }

    // READ (Buscar TODOS los pacientes)
    public List<paciente> findAll(){
        return pacientes;
    }

    // READ (Obtener un paciente por ID)
    public paciente pacienteById(int id){
        for (paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Retorna null si el bucle termina y no encontró nada
    }

    // UPDATE (Actualizar)
    public void update(paciente pacienteActualizado) {
        paciente p = pacienteById(pacienteActualizado.getId());
        if (p != null) {
            p.setFecha(pacienteActualizado.getFecha());
            p.setHora(pacienteActualizado.getHora());
            p.setNombre(pacienteActualizado.getNombre());
            p.setMotivo(pacienteActualizado.getMotivo());
        }
    }

    // DELETE
    public boolean delete(int id) {
        return pacientes.removeIf(p -> p.getId() == id);
    }
}
