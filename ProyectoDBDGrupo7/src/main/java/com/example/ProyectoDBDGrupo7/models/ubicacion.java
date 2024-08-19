package com.example.ProyectoDBDGrupo7.models;

public class ubicacion {

    private long IdUbicacion;
    private String Region;
    private String Comuna;
    private String Calle;
    private int Numero;
    private Integer IdUsuario;

    public ubicacion() {
        this.IdUbicacion = IdUbicacion;
        this.Region = Region;
        this.Comuna = Comuna;
        this.Calle = Calle;
        this.Numero = Numero;
        this.IdUsuario = IdUsuario;
    }

    public long getIdUbicacion() {return IdUbicacion;}
    public void setIdUbicacion(long IdUbicacion) {this.IdUbicacion = IdUbicacion;}

    public String getRegion() {return Region;}
    public void setRegion(String Region) {this.Region = Region;}

    public String getComuna() {return Comuna;}
    public void setComuna(String Comuna) {this.Comuna = Comuna;}

    public String getCalle() {return Calle;}
    public void setCalle(String Calle) {this.Calle = Calle;}

    public int getNumero() {return Numero;}
    public void setNumero(int Numero) {this.Numero = Numero;}

    public Integer getIdUsuario() {return IdUsuario;}
    public void setIdUsuario(Integer IdUsuario) {this.IdUsuario = IdUsuario;}

    @Override

    public String toString() {
        return "ubicacion{" +
                "IdUbicacion=" + IdUbicacion +
                ", Region=" + Region + '\'' +
                ", Comuna=" + Comuna + '\'' +
                ", Calle=" + Calle + '\'' +
                ", Numero=" + Numero+
                ", IdUsuario=" + IdUsuario +
                "}";
    }

}
