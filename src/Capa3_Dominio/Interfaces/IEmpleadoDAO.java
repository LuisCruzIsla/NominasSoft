/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Interfaces;

import Capa3_Dominio.Empleado;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public interface IEmpleadoDAO {

    public Empleado buscarPorDNI(String dni) throws SQLException;

}
