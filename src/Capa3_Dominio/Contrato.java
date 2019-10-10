/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ronald Alva
 */
public class Contrato {

    private int contratoId;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean asignacionFamiliar;
    private int totalHorasSemanal;
    private double valorPorHora;
    private String cargo;
    private char tipo;
    private Empleado empleado;
    private AFP afp;
    
    public static final String GRADOPRIMARIA_SECUNDARIA = "PRIMARIA Y SECUNDARIA";
    public static final String GRADOBACHILLER = "BACHILLER";
    public static final String GRADOPROFESIONAL = "PROFESIONAL";
    public static final String GRADOMAGISTER = "MAGISTER";
    public static final String GRADODOCTOR = "DOCTOR";

    public Contrato() {
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
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

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public AFP getAfp() {
        return afp;
    }

    public void setAfp(AFP afp) {
        this.afp = afp;
    }

    public boolean esVigente() {
        boolean vigencia = false;
        if (fechaFin.compareTo(new Date()) >= 0 && tipo != 'A') {
            vigencia = true;
        }
        return vigencia;
    }

    public boolean esRenovable(Date FechaFinContratoAnterior) {
        boolean renovable = false;
        if (fechaFin.compareTo(FechaFinContratoAnterior) > 0) {
            renovable = true;
        }
        return renovable;
    }

    public boolean esFechaValida() {
        boolean fechaValida = false;
        if (fechaFin.compareTo(fechaInicio) > 0) {
            Calendar inicio = Calendar.getInstance();
            Calendar fin = Calendar.getInstance();
            inicio.setTime(fechaInicio);
            fin.setTime(fechaFin);

            int monthDiff = fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            if (monthDiff >= 3) {
                fechaValida = true;
            }
        }

        return fechaValida;
    }

    public boolean esHoraValidaPorSemana() {
        boolean horaValida = false;
        if (totalHorasSemanal >= 8 && totalHorasSemanal <= 40) {
            horaValida = true;
        }
        return horaValida;
    }

    public boolean esValorizacionAceptada() {
        return false;
 
    }

    public double calcularAsignacionFamiliar() {
        double sueldoMinimo = 0;
        return sueldoMinimo * 0.1;
    }

    public int calcularTotalHora(){
        return 0;
    }
    public boolean calcularValorHora(){
        if(empleado.getGradoAcademico().equals(GRADOPRIMARIA_SECUNDARIA) && (valorPorHora>5 && valorPorHora<10)){
                return true;
             } else if(empleado.getGradoAcademico().equals(GRADOBACHILLER) && (valorPorHora>11 && valorPorHora<20)){
                return true;
            } else if(empleado.getGradoAcademico().equals(GRADOPROFESIONAL) && (valorPorHora>21 && valorPorHora<30)){
                return true;
            } else if(empleado.getGradoAcademico().equals(GRADOMAGISTER) && (valorPorHora>31 && valorPorHora<40)){
                return true;
            } else if(empleado.getGradoAcademico().equals(GRADODOCTOR) && (valorPorHora>41 && valorPorHora<60)){
	return true;        
}
        return false;
 }       
}
