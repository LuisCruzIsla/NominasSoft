/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Interfaces;

import Capa3_Dominio.Pago;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public interface IPagoDAO {
     int ingresar(Pago pago) throws SQLException ;
}
