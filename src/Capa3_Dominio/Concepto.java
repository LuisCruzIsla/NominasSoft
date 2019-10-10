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
    private Contrato contrato;

    public Concepto() {
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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
