/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Contratos;

import Capa3_Dominio.Entidades.Contrato;
import Capa3_Dominio.Entidades.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuisCriz
 */
public interface IContratoDAO {
    int ingresar(Contrato contrato) throws SQLException ;
    int actualizar(Contrato contrato) throws SQLException ;
    Contrato obtenerUltimoPorEmpleado(String empleadoID) throws SQLException;
    Contrato obtenerAntepenultimoPorEmpleado(String empleadoID) throws SQLException;
    int anular(Contrato contrato) throws SQLException ;
    List<Contrato> obtenerTodosLosContratos() throws SQLException;
}