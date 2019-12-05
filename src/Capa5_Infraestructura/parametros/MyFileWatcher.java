/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa5_Infraestructura.parametros;

/**
 *
 * @author user
 */
public class MyFileWatcher extends FileWatcher {

    public MyFileWatcher(String watchFile) {
        super(watchFile);
    }

    @Override
    public void onModified() {
        System.out.println("Modified!");
    }
    
}
