/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.sqlite;

import Capa4_Persistencia.postgresql.*;
import Capa3_Dominio.Entidades.AFP;
import Capa3_Dominio.Contratos.IAFPDAO;
import Capa4_Persistencia.Gestor.Gestores.GestorJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisCriz
 */
public class AFPDAOSQLite implements IAFPDAO{
    
    private GestorJDBC gestorJDBC;

    public AFPDAOSQLite(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public List<AFP> obtenerTodosLosAFP() throws SQLException {
        List<AFP> listaAFP = new ArrayList();
        AFP afp;
        ResultSet resultado;
        String sentenciaSQL;

        sentenciaSQL = "SELECT * FROM afp";

        resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while(resultado.next()){            
            afp = new AFP();
            afp.setId(resultado.getInt("afpid"));
            afp.setNombre(resultado.getString("afpnombre"));
            afp.setDescuento(resultado.getDouble("afpdescuento"));
            listaAFP.add(afp);
        }
        resultado.close();
        return listaAFP;    
    }

    @Override
    public AFP buscar(int id) throws SQLException {
        AFP afp = null;
        ResultSet resultadoAFP;
        String sentenciaSQL; 
        
        sentenciaSQL = "SELECT * FROM afp "
                + "WHERE afpid = '"+id+"'";  
        
                
        resultadoAFP = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        
        if(resultadoAFP.next()){            
            afp = new AFP();
            afp.setId(id);
            afp.setNombre(resultadoAFP.getString("afpnombre"));
            afp.setDescuento(resultadoAFP.getDouble("afpdescuento"));
        }
        
        return afp;
    }
    
}
