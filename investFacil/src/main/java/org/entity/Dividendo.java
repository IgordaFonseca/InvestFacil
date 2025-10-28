package org.entity;

import java.time.LocalDate;

public class Dividendo {
    private int id;
    private LocalDate dataCom;
    private LocalDate dataPagamento;
    private float valorPago;

    public Dividendo(int id, LocalDate dataCom, LocalDate dataPagamento, float valorPago) {
        this.id = id;
        this.dataCom = dataCom;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Dividendo{" +
                "id=" + id +
                ", dataCom=" + dataCom +
                ", dataPagamento=" + dataPagamento +
                ", valorPago=" + valorPago +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataCom() {
        return dataCom;
    }

    public void setDataCom(LocalDate dataCom) {
        this.dataCom = dataCom;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }
}
