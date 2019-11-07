/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.util.Date;

/**
 *
 * @author Ronald Alva
 */
public class Pago extends RecursiveTreeObject<Pago>{

    private Date fecha;
    private int totalHoras;
    private double valorHoras;
    private double asignacionFamiliar;
    private double porcentajeAFP;
    private Contrato contrato;
    private Concepto concepto;
    private Periodo periodo;
    public String nombre;

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

    public double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(double valorHoras) {
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

    //R2 - Procesar Pagos
    public double calcularSueldoBasico() {
        return totalHoras * valorHoras;
    }

    //R4 - Procesar Pagos
    public double calcularTotalIngreso() {
        return calcularSueldoBasico() + asignacionFamiliar + concepto.calcularIngreso();
    }

    //R5 - Procesar Pagos
    public double calcularDescuento() {
        return calcularSueldoBasico() * (porcentajeAFP/100D);
    }

    //R6 - Procesar Pagos
    public double calcularTotalDescuento() {
        return calcularDescuento() + concepto.calcularDescuento();
    }

    //R7 - Procesar Pagos
    public double calcularSueldoNeto() {
        return calcularTotalIngreso() - calcularTotalDescuento();
    }
    
    //R8 - Procesar Pagos
    public int calcularTotalHoras(){
        return periodo.calcularTotalSemanas() * contrato.getTotalHorasSemanal();
    }
    
}
