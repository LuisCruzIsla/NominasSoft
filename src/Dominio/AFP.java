/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Ronald Alva
 */
public class AFP {
    private int dni;
    private float nombre;
    private String descuento;
    private Contrato contrato;

    public AFP() {
    }

    public AFP(int dni, float nombre, String descuento, Contrato contrato) {
        this.dni = dni;
        this.nombre = nombre;
        this.descuento = descuento;
        this.contrato = contrato;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public float getNombre() {
        return nombre;
    }

    public void setNombre(float nombre) {
        this.nombre = nombre;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
}
