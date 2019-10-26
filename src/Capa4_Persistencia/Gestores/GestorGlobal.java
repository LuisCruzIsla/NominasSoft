/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Gestores;

/**
 *
 * @author user
 */
public class GestorGlobal {
    
    private GestorJDBC gestorJDBC;
    private static GestorGlobal gestorGlobal;
    
    public static GestorGlobal getInstance(){
        if(gestorGlobal==null) gestorGlobal = new GestorGlobal();
        return gestorGlobal;
    }
    
    public GestorGlobal(){
        gestorJDBC = new GestorJDBCSQLite();
    }
    
    public GestorJDBC getGestor(){
        return gestorJDBC;
    }
    
}
