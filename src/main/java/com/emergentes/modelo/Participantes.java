package com.emergentes.modelo;

public class Participantes {

    private int id;
    private String apellidos;
    private String nombres;
    private int id_seminario;
    private int confirmado;

    public Participantes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return "Participantes{" + "id=" + id + ", apellidos=" + apellidos + ", nombres=" + nombres + ", id_seminario=" + id_seminario + ", confirmado=" + confirmado + '}';
    }
    
    
}
