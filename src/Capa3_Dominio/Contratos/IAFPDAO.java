/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Contratos;

import Capa3_Dominio.Entidades.AFP;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuisCriz
 */
public interface IAFPDAO {
    
    public List<AFP> obtenerTodosLosAFP() throws SQLException;
    public AFP buscar(int id) throws SQLException;
    
}
