package com.example.miaplicacion;

public class PlanMovil {
    private String titular;
    private int minutos;
    public PlanMovil(String titular, int minutos) {
        this.titular = titular;
        this.minutos = minutos;
    }

    public double calcularTotal() {
        return this.minutos * 100.0;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}