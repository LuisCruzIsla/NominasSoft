/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Contratos;

import Capa3_Dominio.Entidades.Periodo;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public interface IPeriodo {
    Periodo buscarPeriodoActivo() throws SQLException ;
    int procesarPeriodo(String periodoID) throws SQLException;
}
