 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia;

import Capa3_Dominio.AFP;
import Capa3_Dominio.Contrato;
import Capa3_Dominio.Empleado;
import Capa4_Persistencia.Interfaces.IContratoDAO;
import Capa4_Persistencia.Gestores.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LuisCriz
 */
public class ContratoDAO implements IContratoDAO{
    
    private GestorJDBC gestorJDBC;

    public ContratoDAO(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Contrato contrato) throws SQLException {
        String sentenciaSQL = "insert into contratos("
                + "contratofechainicio, "
                + "contratofechafin, "
                + "contratoasignacionfamiliar, "
                + "contratototalhorassemanal, "
                + "contratovalorhoras, "
                + "contratocargo, "
                + "afpid, "
                + "empleadocodigo) "
                + "values(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1, new Date(contrato.getFechaInicio().getTime()));
        sentencia.setDate(2, new Date(contrato.getFechaFin().getTime()));
        sentencia.setString(3, contrato.isAsignacionFamiliar() ? "T" : "F");
        sentencia.setInt(4, contrato.getTotalHorasSemanal());
        sentencia.setDouble(5, contrato.getValorPorHora());
        sentencia.setString(6, contrato.getCargo());
        sentencia.setInt(7, contrato.getAfp().getId());
        sentencia.setString(8, contrato.getEmpleado().getId());
        return sentencia.executeUpdate();
    }
    
    @Override
    public int actualizar(Contrato contrato) throws SQLException {
        String sentenciaSQL = "UPDATE contratos "
                + "SET contratofechainicio=?, "
                + "contratofechafin=?, "
                + "contratoasignacionfamiliar=?, "
                + "contratototalhorassemanal=?, "
                + "contratovalorhoras=?, "
                + "contratocargo=?, "
                + "afpid=?, "
                + "empleadocodigo=? "
                + "WHERE contratocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setDate(1, new Date(contrato.getFechaInicio().getTime()));
        sentencia.setDate(2, new Date(contrato.getFechaFin().getTime()));
        sentencia.setString(3, contrato.isAsignacionFamiliar() ? "T" : "F");
        sentencia.setInt(4, contrato.getTotalHorasSemanal());
        sentencia.setDouble(5, contrato.getValorPorHora());
        sentencia.setString(6, contrato.getCargo());
        sentencia.setInt(7, contrato.getAfp().getId());
        sentencia.setString(8, contrato.getEmpleado().getId());
        sentencia.setInt(9, contrato.getContratoId());
        return sentencia.executeUpdate();
    }
    
    @Override
    public Contrato obtenerUltimoPorEmpleado(Empleado empleado) throws SQLException {
        return buscar(empleado, false);
    }

    @Override
    public Contrato obtenerAntepenultimoPorEmpleado(Empleado empleado) throws SQLException {
        return buscar(empleado, true);
    }
    
    private Contrato buscar(Empleado empleado, boolean antepenultimo) throws SQLException {
        Contrato contrato = null;
        AFP afp = null;
        ResultSet resultadoContrato;
        String sentenciaSQL;
        int afpid = -1;

        sentenciaSQL = "SELECT "
                + "contratocodigo, "
                + "contratofechainicio, "
                + "contratofechafin, "
                + "contratoasignacionfamiliar, "
                + "contratototalhorassemanal, "
                + "contratovalorhoras, "
                + "contratocargo, "
                + "afpid, "
                + "contratotipo "
                + "FROM contratos "
                + "WHERE empleadocodigo = '"+empleado.getId()+"' "
                + "ORDER BY contratofechafin DESC LIMIT 1";
        
        resultadoContrato = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if(antepenultimo) resultadoContrato.next();
        if(resultadoContrato.next()){            
            contrato = new Contrato();
            contrato.setContratoId(resultadoContrato.getInt("contratocodigo"));
            contrato.setFechaInicio(resultadoContrato.getDate("contratofechainicio"));
            contrato.setFechaFin(resultadoContrato.getDate("contratofechafin"));
            contrato.setAsignacionFamiliar(resultadoContrato.getString("contratoasignacionfamiliar").charAt(0)=='T');
            contrato.setTotalHorasSemanal(resultadoContrato.getInt("contratototalhorassemanal"));
            contrato.setValorPorHora(resultadoContrato.getDouble("contratovalorhoras"));
            contrato.setCargo(resultadoContrato.getString("contratocargo"));
            contrato.setEstado(resultadoContrato.getString("contratotipo").charAt(0));
            afpid = resultadoContrato.getInt("afpid");
        }
        
        if(contrato!=null){
            AFPDAO afpdao = new AFPDAO(gestorJDBC);
            afp = afpdao.buscar(afpid);
            contrato.setAfp(afp);
        }
        
        resultadoContrato.close();
        return contrato; 
    }

    @Override
    public int anular(Contrato contrato) throws SQLException  {
        String sentenciaSQL = "UPDATE contratos "
                + "SET contratotipo = 'A' "
                + "WHERE contratocodigo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1,contrato.getContratoId());
        return sentencia.executeUpdate();
    }
    
}
