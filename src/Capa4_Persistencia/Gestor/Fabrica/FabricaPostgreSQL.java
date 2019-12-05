/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa4_Persistencia.Gestor.Fabrica;

import Capa3_Dominio.Contratos.IAFPDAO;
import Capa3_Dominio.Contratos.IConceptoDAO;
import Capa3_Dominio.Contratos.IContratoDAO;
import Capa3_Dominio.Contratos.IEmpleadoDAO;
import Capa3_Dominio.Contratos.IPagoDAO;
import Capa3_Dominio.Contratos.IPeriodo;
import Capa4_Persistencia.Gestor.GestorJDBC;
import Capa4_Persistencia.postgresql.AFPDAOPostgre;
import Capa4_Persistencia.postgresql.ConceptoDAOPostgre;
import Capa4_Persistencia.postgresql.ContratoDAOPostgre;
import Capa4_Persistencia.postgresql.EmpleadoDAOPostgre;
import Capa4_Persistencia.postgresql.PagoDAOPostgre;
import Capa4_Persistencia.postgresql.PeriodoDAOPostgre;

/**
 *
 * @author LuisCriz
 */
public class FabricaPostgreSQL  extends FabricaAdstractaDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new GestorJDBCPostgre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAFPDAO crearIAFPDAO(GestorJDBC gestorJDBC) {
        return new AFPDAOPostgre(gestorJDBC);
    }

    @Override
    public IConceptoDAO crearIConceptoDAO(GestorJDBC gestorJDBC) {
        return new ConceptoDAOPostgre(gestorJDBC);
    }

    @Override
    public IContratoDAO crearIContratoDAO(GestorJDBC gestorJDBC) {
        return new ContratoDAOPostgre(gestorJDBC);
    }

    @Override
    public IEmpleadoDAO crearIEmpleadoDAO(GestorJDBC gestorJDBC) {
        return new EmpleadoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPagoDAO crearIPagoDAO(GestorJDBC gestorJDBC) {
        return new PagoDAOPostgre(gestorJDBC);
    }

    @Override
    public IPeriodo crearIPeriodo(GestorJDBC gestorJDBC) {
        return new PeriodoDAOPostgre(gestorJDBC);
    }
    
}
