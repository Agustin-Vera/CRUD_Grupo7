package com.example.ProyectoDBDGrupo7.models;

public class usuario {

    private long idusuario;
    private String nombreusuario;
    private String correo;
    private String contraseña;
    private int idrol;

    public usuario(String nombreusuario, String correo, String contraseña, int idrol) {
        this.nombreusuario = nombreusuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.idrol = idrol;
    }

    public void setId(long id){
        this.idusuario = id;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "idusuario=" + idusuario +
                ", nombreusuario='" + nombreusuario + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", idrol=" + idrol +
                '}';
    }
}
