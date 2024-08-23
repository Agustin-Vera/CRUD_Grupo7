package com.example.ProyectoDBDGrupo7.models;

public class carroDeCompras {
    private Long idCarro;
    private Integer idUsuario;

    public carroDeCompras(Long idCarro, Integer idUsuario) {
        this.idCarro = idCarro;
        this.idUsuario = idUsuario;
    }

    public Long getIdCarro() {return idCarro;}

    public void setIdCarro(Long idCarro) {this.idCarro = idCarro;}

    public Integer getIdUsuario() {return idUsuario;}

    public void setIdUsuario(Integer idUsuario) {this.idUsuario = idUsuario;}

    @Override
    public String toString() {
        return "carroDeCompras{" +
                "idCarro=" + idCarro +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
