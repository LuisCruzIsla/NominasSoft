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
public class Periodo {

    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private char estado;

    public Periodo() {
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public boolean esActivo() {
        boolean activo = false;
        if (fechaFin.compareTo(new Date()) >= 0) {
            activo = true;
        }
        return activo;
    }

    public int calcularTotalSemanas() {

        Calendar inicio = Calendar.getInstance();
        Calendar fin = Calendar.getInstance();
        inicio.setTime(fechaInicio);
        fin.setTime(fechaFin);
        int monthDiff = fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
        return monthDiff * 4;

    }

}
