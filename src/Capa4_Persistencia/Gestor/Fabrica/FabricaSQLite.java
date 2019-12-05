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
import Capa4_Persistencia.Gestor.Gestores.GestorJDBC;
import Capa4_Persistencia.sqlite.*;

/**
 *
 * @author LuisCriz
 */
public class FabricaSQLite  extends FabricaAdstractaDAO{

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new GestorJDBCSQLite(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAFPDAO crearIAFPDAO(GestorJDBC gestorJDBC) {
        return new AFPDAOSQLite(gestorJDBC);
    }

    @Override
    public IConceptoDAO crearIConceptoDAO(GestorJDBC gestorJDBC) {
        return new ConceptoDAOSQLite(gestorJDBC);
    }

    @Override
    public IContratoDAO crearIContratoDAO(GestorJDBC gestorJDBC) {
        return new ContratoDAOSQLite(gestorJDBC);
    }

    @Override
    public IEmpleadoDAO crearIEmpleadoDAO(GestorJDBC gestorJDBC) {
        return new EmpleadoDAOSQLite(gestorJDBC);
    }

    @Override
    public IPagoDAO crearIPagoDAO(GestorJDBC gestorJDBC) {
        return new PagoDAOSQLite(gestorJDBC);
    }

    @Override
    public IPeriodo crearIPeriodo(GestorJDBC gestorJDBC) {
        return new PeriodoDAOSQLite(gestorJDBC);
    }
    
}
