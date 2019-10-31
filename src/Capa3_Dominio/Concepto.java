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
    
    private int conceptoId;
    private double montoHorasExtras;
    private double montoReintegros;
    private double montoOtrosIngresos;
    private double montoHoraAusente;
    private double montoAdelantado;
    private double montoOtroDescuentos;
    private Contrato contrato;
    private Periodo periodo;

    public Concepto() {
    }

    public int getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(int conceptoId) {
        this.conceptoId = conceptoId;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    public double getMontoHorasExtras() {
        return montoHorasExtras;
    }

    public void setMontoHorasExtras(double montoHorasExtras) {
        this.montoHorasExtras = montoHorasExtras;
    }

    public double getMontoReintegros() {
        return montoReintegros;
    }

    public void setMontoReintegros(double montoReintegros) {
        this.montoReintegros = montoReintegros;
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
    
    //R9 - Procesar Pagos
    public double calcularIngreso(){
        return montoHorasExtras+montoReintegros+montoOtrosIngresos;
    }
    
    //R10 - Procesar Pagos
    public double calcularDescuento(){
        return montoHoraAusente+montoAdelantado+montoOtroDescuentos;
    }
}
