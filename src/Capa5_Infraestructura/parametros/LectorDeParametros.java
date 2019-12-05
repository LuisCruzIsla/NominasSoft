/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa5_Infraestructura.parametros;

//import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author LuisCriz
 */
public class LectorDeParametros {

    final static String PROPS_FILE = "Capa5_Infraestructura/parametros/";

    public String getValorParametro(String parametro, String propiedad) {
        String valorParametro;
        InputStream canalDeEntrada;
        Properties propiedades = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            canalDeEntrada = classLoader.getResourceAsStream(PROPS_FILE + propiedad);
            System.out.println(canalDeEntrada);
            propiedades.load(canalDeEntrada);
            valorParametro = propiedades.getProperty(parametro);
            
            //Watcher
            /*File file = new File("src/"+PROPS_FILE + propiedad);
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
            String watchFile = absolutePath;
            FileWatcher fileWatcher = new MyFileWatcher(watchFile);
            try {
                fileWatcher.watchFile();
            } catch (Exception ex) {
                System.out.println("Error: "+ex.getMessage());
            }*/
            
            return valorParametro;
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }

}
