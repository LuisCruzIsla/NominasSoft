/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

import Capa1_Presentacion.Utils.Constantes;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Ronald Alva
 */
public class Periodo {

    private String idPeriodo;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
    private char estado;

    public Periodo() {
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
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

    //R1 - Procesar Pagos
    public boolean esActivo() {
        boolean activo = false;
        if (new Date().compareTo(fechaFin) >= 0) {
            activo = true;
        }
        return activo;
    }

    public int calcularTotalSemanas() {
        LocalDate startDate = Constantes.DATE_TO_LOCALDATE_UTC(fechaInicio);
        LocalDate endDate = Constantes.DATE_TO_LOCALDATE_UTC(fechaFin);
        return (int) ChronoUnit.WEEKS.between(startDate, endDate);
    }

}
