package com.example.ProyectoDBDGrupo7.models;

public class permiso {
    private long idPermiso;
    private String nombrePermiso;
    private String descripcionPermiso;

    public permiso(long idPermiso, String nombrePermiso, String descripcionPermiso) {
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
        this.descripcionPermiso = descripcionPermiso;
    }

    public long getIdPermiso() {
        return idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setIdPermiso(long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    @Override
    public String toString() {
        return "permiso{" +
                "idPermiso=" + idPermiso +
                ", nombrePermiso='" + nombrePermiso + '\'' +
                ", descripcionPermiso='" + descripcionPermiso + '\'' +
                '}';
    }
}
