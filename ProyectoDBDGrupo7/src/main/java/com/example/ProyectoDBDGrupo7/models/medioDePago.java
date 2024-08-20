package com.example.ProyectoDBDGrupo7.models;

public class medioDePago {
    private Long idMedioDePago;
    private String nombreMedioDePago;
    private String descripcionMedioDePago;

    public medioDePago(Long idMedioDePago, String nombreMedioDePago, String descripcionMedioDePago) {
        this.idMedioDePago = idMedioDePago;
        this.nombreMedioDePago = nombreMedioDePago;
        this.descripcionMedioDePago = descripcionMedioDePago;
    }

    public Long getIdMedioDePago() {return idMedioDePago;}

    public void setIdMedioDePago(Long idMedioDePago) {this.idMedioDePago = idMedioDePago;}

    public String getNombreMedioDePago() {return nombreMedioDePago;}

    public void setNombreMedioDePago(String nombreMedioDePago) {this.nombreMedioDePago = nombreMedioDePago;}

    public String getDescripcionMedioDePago() {return descripcionMedioDePago;}

    public void setDescripcionMedioDePago(String descripcionMedioDePago) {this.descripcionMedioDePago = descripcionMedioDePago;}

    @Override
    public String toString() {
        return "medioDePago{" +
                "idMedioDePago=" + idMedioDePago +
                ", nombreMedioDePago='" + nombreMedioDePago + '\'' +
                ", descripcionMedioDePago='" + descripcionMedioDePago + '\'' +
                '}';
    }
}
