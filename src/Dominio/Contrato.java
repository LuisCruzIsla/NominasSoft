/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ronald Alva
 */
public class Contrato {
    private Date fechaInicio;
    private Date fechaFin;
    private boolean asignacionFamiliar;
    private int totalHorasSemanal;
    private double valorPorHora;
    private String cargo;
    private Empleado empleado;

    public Contrato() {
    }

    public Contrato(Date fechaInicio, Date fechaFin, boolean asignacionFamiliar, int totalHorasSemanal, double valorPorHora, String cargo,Empleado empleado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.asignacionFamiliar = asignacionFamiliar;
        this.totalHorasSemanal = totalHorasSemanal;
        this.valorPorHora = valorPorHora;
        this.cargo = cargo;
        this.empleado = empleado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isAsignacionFamiliar() {
        return asignacionFamiliar;
    }

    public void setAsignacionFamiliar(boolean asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    public int getTotalHorasSemanal() {
        return totalHorasSemanal;
    }

    public void setTotalHorasSemanal(int totalHorasSemanal) {
        this.totalHorasSemanal = totalHorasSemanal;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

   
    public boolean esVigente( ){
        return false;
    }
    
    public boolean esRenovable(){
        return false;
    }
    
    public boolean esFechaValida(){
        return false;
    }
    
    public boolean esHoraValidaPorSemana(){
        return false;
    }
    
    public boolean esValorizacionAceptada(){
        return false;
    }
    
    public double calcularAsignacionFamiliar(){
        double sueldoMinimo = 0;
        return sueldoMinimo*0.1;
    }
    
    public double calcularTotalHora(){
        return 0;
    }
    
    
}
