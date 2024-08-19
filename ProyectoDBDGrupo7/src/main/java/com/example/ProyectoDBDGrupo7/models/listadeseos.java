package com.example.ProyectoDBDGrupo7.models;

public class listadeseos {
    private long IdListaDeseos;
    private Integer IdUsuario;

    public listadeseos(long IdListaDeseos, Integer IdUsuario) {
        this.IdListaDeseos = IdListaDeseos;
        this.IdUsuario = IdUsuario;
    }

    public long getIdListaDeseos() { return IdListaDeseos;}
    public void setIdListaDeseos(long IdListaDeseos) { this.IdListaDeseos = IdListaDeseos;}

    public Integer getIdUsuario() { return IdUsuario;}
    public void setIdUsuario(Integer IdUsuario) { this.IdUsuario = IdUsuario;}

    @Override
    public String toString() {
        return "lista de deseos{" +
                "IdListaDeseos = " + IdListaDeseos
                + ", IdUsuario = " + IdUsuario + '}';
    }
}

