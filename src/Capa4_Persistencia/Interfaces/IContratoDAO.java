/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Interfaces;

import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public interface IContratoDAO {
    int ingresar(Contrato contrato) throws SQLException ;
    int actualizar(Contrato contrato) throws SQLException ;
    Contrato obtenerUltimoPorEmpleado(Empleado empleado) throws SQLException;
    Contrato obtenerAntepenultimoPorEmpleado(Empleado empleado) throws SQLException;
    int anular(Contrato contrato) throws SQLException ;
}