/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa5_Infraestructura.parametros;

//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author LuisCriz
 */
public class LectorDeParametros {
final static String PROPS_FILE  = "Capa5_Infraestructura/parametros/";
    
    public String getValorParametro(String parametro, String propiedad){
        String valorParametro;
        InputStream canalDeEntrada;
        Properties propiedades = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            canalDeEntrada = classLoader.getResourceAsStream(PROPS_FILE+propiedad);
            System.out.println(canalDeEntrada);
            propiedades.load(canalDeEntrada);            
            valorParametro = propiedades.getProperty(parametro);
            return valorParametro;
        } catch (IOException e) {
            return null;
        }
    }
    
}
