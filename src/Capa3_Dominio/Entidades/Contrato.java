/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Entidades;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    private char estado;
    private Empleado empleado;
    private AFP afp;
    
    private static final double SUELDO_MINIMO = 930D;

    public Contrato() {
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
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

    //R1 - Gestionar Contrato
    public boolean esVigente() {
        boolean vigencia = false;
        if (fechaFin.compareTo(new Date()) >= 0 && estado != 'A') {
            vigencia = true;
        }
        return vigencia;
    }

    //R3 -  Gestionar Contrato
    public boolean esFechaValida() {
        boolean fechaValida = false;
        if (fechaFin.compareTo(fechaInicio) > 0) {
            SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
            String dateStart = simple.format(fechaInicio);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDateStart = LocalDate.parse(dateStart , formatter);
            String dateFin = simple.format(fechaFin);
            LocalDate localDateFin = LocalDate.parse(dateFin , formatter);
            long dias = ChronoUnit.DAYS.between(localDateStart, localDateFin);
            int meses = (int) (dias/30);
            if (meses>= 3 && meses<=12) {
                fechaValida = true;
            }
        }
        return fechaValida;
    }

    //R4 -  Gestionar Contrato
    public boolean esHoraValidaPorSemana() {
        boolean horaValida = false;
        if (totalHorasSemanal >= 8 && totalHorasSemanal <= 40) {
            horaValida = true;
        }
        return horaValida;
    }
    
    //R5 -  Gestionar Contrato
    public boolean esValorizacionAceptada(){
        return empleado.getGradoAcademico().estaEnElRango(valorPorHora);
    }

    //R3 - Procesar Pagos
    public double calcularAsignacionFamiliar(){
        double resultadoAsignacionFamiliar = 0;
        if(asignacionFamiliar){
            resultadoAsignacionFamiliar = SUELDO_MINIMO * 0.1; 
        }
        return resultadoAsignacionFamiliar;
    }
    
}
