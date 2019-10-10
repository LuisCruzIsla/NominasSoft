/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

/**
 *
 * @author Ronald Alva
 */
public class Concepto {
    private double montoHoras;
    private double montoReIngresos;
    private double montoOtrosIngresos;
    private double montoHoraAusente;
    private double montoAdelantado;
    private double montoOtroDescuentos;

    public Concepto() {
    }

    public Concepto(double montoHoras, double montoReIngresos, double montoOtrosIngresos, double montoHoraAusente, double montoAdelantado, double montoOtroDescuentos) {
        this.montoHoras = montoHoras;
        this.montoReIngresos = montoReIngresos;
        this.montoOtrosIngresos = montoOtrosIngresos;
        this.montoHoraAusente = montoHoraAusente;
        this.montoAdelantado = montoAdelantado;
        this.montoOtroDescuentos = montoOtroDescuentos;
    }

    public double getMontoHoras() {
        return montoHoras;
    }

    public void setMontoHoras(double montoHoras) {
        this.montoHoras = montoHoras;
    }

    public double getMontoReIngresos() {
        return montoReIngresos;
    }

    public void setMontoReIngresos(double montoReIngresos) {
        this.montoReIngresos = montoReIngresos;
    }

    public double getMontoOtrosIngresos() {
        return montoOtrosIngresos;
    }

    public void setMontoOtrosIngresos(double montoOtrosIngresos) {
        this.montoOtrosIngresos = montoOtrosIngresos;
    }

    public double getMontoHoraAusente() {
        return montoHoraAusente;
    }

    public void setMontoHoraAusente(double montoHoraAusente) {
        this.montoHoraAusente = montoHoraAusente;
    }

    public double getMontoAdelantado() {
        return montoAdelantado;
    }

    public void setMontoAdelantado(double montoAdelantado) {
        this.montoAdelantado = montoAdelantado;
    }

    public double getMontoOtroDescuentos() {
        return montoOtroDescuentos;
    }

    public void setMontoOtroDescuentos(double montoOtroDescuentos) {
        this.montoOtroDescuentos = montoOtroDescuentos;
    }
    
    public double calcularIngreso(){
        return montoHoras+montoReIngresos+montoOtrosIngresos;
    }
    
    public double calcularDescuento(){
        return montoHoraAusente+montoAdelantado+montoOtroDescuentos;
    }
}
