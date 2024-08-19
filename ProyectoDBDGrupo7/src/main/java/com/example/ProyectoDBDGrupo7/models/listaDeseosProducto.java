package com.example.ProyectoDBDGrupo7.models;

public class listaDeseosProducto {
    private Long idListaProducto;
    private Integer idListaDeseos;
    private Integer idProducto;

    public listaDeseosProducto(Long idListaProducto, Integer idListaDeseos, Integer idProducto) {
        this.idListaProducto = idListaProducto;
        this.idListaDeseos = idListaDeseos;
        this.idProducto = idProducto;
    }

    public Long getIdListaProducto() {
        return idListaProducto;
    }

    public void setIdListaProducto(Long idListaProducto) {
        this.idListaProducto = idListaProducto;
    }

    public Integer getIdListaDeseos() {
        return idListaDeseos;
    }

    public void setIdListaDeseos(Integer idListaDeseos) {
        this.idListaDeseos = idListaDeseos;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "listaDeseosProducto{" +
                "idListaProducto=" + idListaProducto +
                ", idListaDeseos=" + idListaDeseos +
                ", idProducto=" + idProducto +
                '}';
    }
}
