/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import java.util.Date;

/**
 *
 * @author Ronald Alva
 */
public class Pago {

    private Date fecha;
    private int totalHoras;
    private int valorHoras;
    private double asignacionFamiliar;
    private double porcentajeAFP;
    private Contrato contrato;
    private Concepto concepto;
    private Periodo periodo;

    public Pago() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public int getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(int valorHoras) {
        this.valorHoras = valorHoras;
    }

    public double getAsignacionFamiliar() {
        return asignacionFamiliar;
    }

    public void setAsignacionFamiliar(double asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    public double getPorcentajeAFP() {
        return porcentajeAFP;
    }

    public void setPorcentajeAFP(double porcentajeAFP) {
        this.porcentajeAFP = porcentajeAFP;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    private double calcularSueldoBasico() {
        return totalHoras * valorHoras;
    }

    private double calcularTotalIngreso() {
        return calcularSueldoBasico() + contrato.calcularAsignacionFamiliar() + concepto.calcularIngreso();
    }

    private double calcularDescuento() {
        return calcularSueldoBasico() * porcentajeAFP;
    }

    private double calcularTotalDescuento() {
        return calcularDescuento() + concepto.calcularDescuento();
    }

    private double calcularSueldoNeto() {
        return calcularTotalIngreso() + calcularTotalDescuento();
    }
}
