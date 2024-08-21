package com.example.ProyectoDBDGrupo7.models;

public class rolPermiso {
    private long idRolPermiso;
    private long idRol;
    private long idPermiso;

    public rolPermiso(long idRolPermiso, long idRol, long idPermiso) {
        this.idRolPermiso = idRolPermiso;
        this.idRol = idRol;
        this.idPermiso = idPermiso;
    }

    public long getIdRolPermiso() {
        return idRolPermiso;
    }

    public long getIdRol() {
        return idRol;
    }

    public long getIdPermiso() {
        return idPermiso;
    }

    public void setIdRolPermiso(long idRolPermiso) {
        this.idRolPermiso = idRolPermiso;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public void setIdPermiso(long idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public String toString() {
        return "rolPermiso{" +
                "idRolPermiso=" + idRolPermiso +
                ", idRol=" + idRol +
                ", idPermiso=" + idPermiso +
                '}';
    }
}
