/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author user
 */
public class Constantes {
    
    private static Constantes constantes;
    
    private static final String PATH_VIEW = "/Capa1_Presentacion/Vista/";
    
    public static Constantes getInstance(){
        if(constantes==null) constantes = new Constantes();
        return constantes;
    }
    
    public FXMLLoader pathViewFXML(String name) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(PATH_VIEW+name+".fxml"));
        return loader;
    }
    
    public Parent pathViewParent(String name) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(PATH_VIEW+name+".fxml"));
        return parent;
    }
    
}
