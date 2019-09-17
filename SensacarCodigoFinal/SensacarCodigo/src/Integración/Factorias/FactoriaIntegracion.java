
package Integración.Factorias;

import Integración.Ventas.DAOVentas;
import Integración.Modelos.DAOModelo;
import Integración.Cliente.DAOCliente;

public abstract class FactoriaIntegracion {

	private static FactoriaIntegracion instance;


	public static synchronized FactoriaIntegracion getInstance() {
		if (instance== null){
			instance = new FactoriaIntegracionImp();
		}
		return instance;
		
	}


	public abstract DAOVentas generaDAOVentas();
	public abstract DAOModelo generaDAOModelo();
	public abstract DAOCliente generaDAOCliente();
}