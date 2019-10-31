/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia;

import Capa3_Dominio.Concepto;
import Capa3_Dominio.Periodo;
import Capa4_Persistencia.Gestores.GestorJDBC;
import Capa4_Persistencia.Interfaces.IConceptoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public class ConceptoDAO implements IConceptoDAO{
    
    private GestorJDBC gestorJDBC;

    public ConceptoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public Concepto buscarConcepto(int contratoId, String periodoId) throws SQLException{
        Concepto concepto = null;
        ResultSet resultadoConcepto;
        String sentenciaSQL;

        sentenciaSQL = "SELECT "
                + "ConceptoCodigo, "
                + "montoHorasExtras, "
                + "montoReintegros, "
                + "montoOtrosIngresos, "
                + "montoHorasAusentes, "
                + "montoAdelantos, "
                + "montoOtrosDescuentos "
                + "FROM Conceptos "
                + "WHERE ContratoCodigo = '"+contratoId+"' "
                + "AND PeriodoCodigo = '"+periodoId+"'";
        
        resultadoConcepto = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(resultadoConcepto.next()){            
            concepto = new Concepto();
            concepto.setConceptoId(resultadoConcepto.getInt("ConceptoCodigo"));
            concepto.setMontoHorasExtras(resultadoConcepto.getDouble("montoHorasExtras"));
            concepto.setMontoReintegros(resultadoConcepto.getDouble("montoReintegros"));
            concepto.setMontoOtrosIngresos(resultadoConcepto.getDouble("montoOtrosIngresos"));
            concepto.setMontoHoraAusente(resultadoConcepto.getDouble("montoHorasAusentes"));
            concepto.setMontoAdelantado(resultadoConcepto.getDouble("montoAdelantos"));
            concepto.setMontoOtroDescuentos(resultadoConcepto.getDouble("montoOtrosDescuentos"));
        }        
        resultadoConcepto.close();
        return concepto;
    }

}
