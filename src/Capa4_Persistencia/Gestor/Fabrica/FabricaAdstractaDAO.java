package Capa4_Persistencia.Gestor.Fabrica;

import Capa3_Dominio.Contratos.IAFPDAO;
import Capa3_Dominio.Contratos.IConceptoDAO;
import Capa3_Dominio.Contratos.IContratoDAO;
import Capa3_Dominio.Contratos.IEmpleadoDAO;
import Capa3_Dominio.Contratos.IPagoDAO;
import Capa3_Dominio.Contratos.IPeriodo;
import Capa4_Persistencia.Gestor.Gestores.GestorJDBC;
import Capa5_Infraestructura.parametros.LectorDeParametros;

/**
 *
 * @author LuisCriz
 */
public abstract class FabricaAdstractaDAO {

    public static FabricaAdstractaDAO getInstancia() {
        String nombreClaseFabricaDAO;
        FabricaAdstractaDAO FabricaDAO;
        try {
            LectorDeParametros lectorDeParametros = new LectorDeParametros();
            nombreClaseFabricaDAO = lectorDeParametros.getValorParametro("claseFabricaDAO","Parametros.properties");
            //nombreClaseFabricaDAO = "Capa4_Persistencia.Gestor.Fabrica.FabricaPostgreSQL";

            FabricaDAO = (FabricaAdstractaDAO) Class.forName(nombreClaseFabricaDAO).newInstance();
            return FabricaDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();

    public abstract IAFPDAO crearIAFPDAO(GestorJDBC gestorJDBC);

    public abstract IConceptoDAO crearIConceptoDAO(GestorJDBC gestorJDBC);

    public abstract IContratoDAO crearIContratoDAO(GestorJDBC gestorJDBC);

    public abstract IEmpleadoDAO crearIEmpleadoDAO(GestorJDBC gestorJDBC);

    public abstract IPagoDAO crearIPagoDAO(GestorJDBC gestorJDBC);

    public abstract IPeriodo crearIPeriodo(GestorJDBC gestorJDBC);

}
