package com.upiiz.exam_xngb_01.controllers;

import com.upiiz.exam_xngb_01.models.paciente;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import com.upiiz.exam_xngb_01.services.pacienteService;

public class pacienteController extends paciente {
    //Mostrar listado
    //pacienteService pacienteServices = new pacienteService();
    //ArrayList<pacienteController> listaPacientes = pacienteService.listaPacientes();


    //-----------------------------------//
    private final AtomicInteger contadorId;

    public pacienteController() {
        super();
        contadorId = null;
    }

    //Llamadas del CRUD
    //Agregar
    public void agregarPaciente(String fecha, float hora, String paciente, String motivo){
        int id = contadorId.getAndIncrement();
    }
    //Actualizar
    public boolean actualizarPaciente(int id, String fecha, String hora, String nombre, String motivo){
        pacienteController p = buscarPacienteById(id);
        if(p != null){
            p.setFecha(fecha);
            p.setHora(hora);
            p.setNombre(nombre);
            p.setMotivo(motivo);
            return true;
        }
        return false;
    }


    //Eliminar
    public boolean eliminarPaciente(int id){
        pacienteController p = buscarPacienteById(id);
        if(p != null){
            listaPacientes.remove(p);
            return true;
        }
        return false;
    }
    //Buscar (leer)
    public ArrayList<pacienteController> listaPacientes;
    public ArrayList<pacienteController> listaPacientes(){
        return listaPacientes;
    }
    public pacienteController buscarPacienteById(int id){
        for (pacienteController p : listaPacientes()){
            if(p.getId() == id){
                return p;
            }
            return null;
        }
        return null;
    }


}
