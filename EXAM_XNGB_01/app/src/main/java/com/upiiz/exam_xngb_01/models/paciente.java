package com.upiiz.exam_xngb_01.models;

public class paciente {
    //**-- 12) Tabla de citas
    //CREATE TABLE citas (
    //    id INT AUTO_INCREMENT PRIMARY KEY,
    //    fecha DATE NOT NULL,
    //    hora TIME NOT NULL,
    //    paciente VARCHAR(100),
    //    motivo VARCHAR(150)
    //);**//
    private int id;
    private String fecha;
    private String hora;
    private String nombre;
    private String motivo;
    public paciente(int id, String fecha, String hora, String nombre, String motivo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.motivo = motivo;
    }

    public paciente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
