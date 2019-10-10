/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */

public class EmpleadoDAO {
        GestorJDBC gestorJDBC;

    public EmpleadoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
}
