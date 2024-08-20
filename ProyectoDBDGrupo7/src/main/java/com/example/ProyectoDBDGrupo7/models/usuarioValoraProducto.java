package com.example.ProyectoDBDGrupo7.models;

public class usuarioValoraProducto {

    private long idValorado;
    private int idUsuario;
    private int idProducto;
    private int valoracion;


    public usuarioValoraProducto(long idValorado, int idUsuario, int idProducto, int valoracion) {
        this.idValorado = idValorado;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.valoracion = valoracion;
    }

    public long getIdValorado() {
        return idValorado;
    }

    public void setIdValorado(long idValorado) {
        this.idValorado = idValorado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}
