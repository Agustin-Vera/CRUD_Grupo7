package com.example.ProyectoDBDGrupo7.models;

public class productoCarroDeCompras {
    private long idProducto_Carro;
    private long idProducto;
    private long idCarro;

    public long getIdProductoCarro() {
        return idProducto_Carro;
    }

    public void setIdProductoCarro(long idProductoCarro) {
        this.idProducto_Carro = idProductoCarro;
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
                "idProductoCarro=" + idProducto_Carro +
                ", idProducto=" + idProducto +
                ", idCarro=" + idCarro +
                '}';
    }
}
