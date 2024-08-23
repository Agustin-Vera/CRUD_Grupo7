package com.example.ProyectoDBDGrupo7.models;
import java.util.Date;

public class boletadecompra {
    private long IdBoleta;
    private Date FechaBoleta;
    private int montoboleta;
    private Integer IdCarro;
    private Integer IdMedioPago;

    public boletadecompra(long IdBoletadeCompra, Date FechaBoleta, int MontoBoleta, Integer IdCarro, Integer IdMedioPago) {
        this.IdBoleta = IdBoletadeCompra;
        this.FechaBoleta = FechaBoleta;
        this.montoboleta = MontoBoleta;
        this.IdCarro = IdCarro;
        this.IdMedioPago = IdMedioPago;
    }

    public long getIdBoletadeCompra() {
        return IdBoleta;
    }

    public void setIdBoletadeCompra(long IdBoletadeCompra) {
        this.IdBoleta = IdBoletadeCompra;
    }

    public Date getFechaBoleta() {
        return FechaBoleta;
    }

    public void setFechaBoleta(Date FechaBoleta) {
        this.FechaBoleta = FechaBoleta;
    }

    public int getMontoBoleta() {
        return montoboleta;
    }

    public void setMontoBoleta(int montoBoleta) {
        this.montoboleta = montoBoleta;
    }

    public Integer getIdCarro() {
        return IdCarro;
    }

    public void setIdCarro(Integer IdCarro) {
        this.IdCarro = IdCarro;
    }

    public Integer getIdMedioPago() {
        return IdMedioPago;
    }

    public void setIdMedioPago(Integer idMedioPago) {
        this.IdMedioPago = idMedioPago;
    }

    @Override
    public String toString() {
        return "boletadecompra{" +
                "IdBoleta=" + IdBoleta +
                ", FechaBoleta=" + FechaBoleta +
                ", MontoBoleta=" + montoboleta +
                ", IdCarro=" + IdCarro +
                ", IdMedioPago=" + IdMedioPago +
                '}';
    }
}
