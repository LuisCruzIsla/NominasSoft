/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa1_Presentacion.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author user
 */
public class Constantes {
    
    private static Constantes constantes;
    
    private static final String PATH_VIEW = "/Capa1_Presentacion/Formularios/Vista/";
    
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
    
    public static final LocalDate DATE_TO_LOCALDATE (Date dateValue){
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        String date = simple.format(dateValue);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    
    public static final LocalDate DATE_TO_LOCALDATE_UTC (Date dateValue){
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        simple.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = simple.format(dateValue);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    
}
