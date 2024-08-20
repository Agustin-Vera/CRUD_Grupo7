package com.example.ProyectoDBDGrupo7.models;

public class rol {
    private Long idRol;
    private String nombreRol;

    public rol(Long idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public Long getIdRol() {return idRol;}

    public void setIdRol(Long idRol) {this.idRol = idRol;}

    public String getNombreRol() {return nombreRol;}

    public void setNombreRol(String nombreRol) {this.nombreRol = nombreRol;}


    @Override
    public String toString() {
        return "rol{" +
                "idRol=" + idRol +
                ", nombreRol=" + nombreRol +
                '}';

    }
}