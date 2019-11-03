/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio;

/**
 *
 * @author COMPUTO-INGENIERIA
 */
public enum EGrados {
    GRADOPRIMARIA_SECUNDARIA("PRIMARIA Y SECUNDARIA",5,10),
    GRADOBACHILLER("BACHILLER",11,20),
    GRADOPROFESIONAL("PROFESIONAL",21,30),
    GRADOMAGISTER("MAGISTER",31,40),
    GRADODOCTOR("DOCTOR",41,60);
    
    private final String nombreGrado;
    private final double rangoMinimo;
    private final double rangoMaximo;

    private EGrados(String grado, double rangoMinimo, double rangoMaximo) {
        this.nombreGrado = grado;
        this.rangoMinimo = rangoMinimo;
        this.rangoMaximo = rangoMaximo;
    }
    
    public boolean estaEnElRango(double valor){
        boolean valoracion  = false;
        if(rangoMinimo<=valor && valor<=rangoMaximo){
            valoracion = true;
        }
        return valoracion;
    }
    public static EGrados fromString(String text) {
        for (EGrados eGrados : EGrados.values()) {
            if (eGrados.getNombreGrado().equalsIgnoreCase(text)) {
                return eGrados;
            }
        }
        return null;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }
    
}
