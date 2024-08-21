package com.example.ProyectoDBDGrupo7.models;

public class productoCarroDeCompras {
    private long idProductoCarro;
    private long idProducto;
    private long idCarro;

    public long getIdProductoCarro() {
        return idProductoCarro;
    }

    public void setIdProductoCarro(long idProductoCarro) {
        this.idProductoCarro = idProductoCarro;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(long idCarro) {
        this.idCarro = idCarro;
    }

    @Override
    public String toString() {
        return "productoCarroDeCompras{" +
                "idProductoCarro=" + idProductoCarro +
                ", idProducto=" + idProducto +
                ", idCarro=" + idCarro +
                '}';
    }
}
