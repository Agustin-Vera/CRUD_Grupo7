package com.example.ProyectoDBDGrupo7.models;

public class usuarioPublicaProducto {
    private long idPublicado;
    private int idProducto;
    private int idUsuario;


    public usuarioPublicaProducto(long idPublicado, int idProducto, int idUsuario) {
        this.idPublicado = idPublicado;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
    }

    public long getIdPublicado() {
        return idPublicado;
    }

    public void setIdPublicado(long idPublicado) {
        this.idPublicado = idPublicado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
