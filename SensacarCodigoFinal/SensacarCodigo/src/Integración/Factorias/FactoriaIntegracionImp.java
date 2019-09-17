
package Integración.Factorias;

import Integración.Ventas.DAOVentas;
import Integración.Ventas.DAOVentasImp;
import Integración.Modelos.DAOModelo;
import Integración.Modelos.DAOModeloImp;
import Integración.Cliente.DAOCliente;
import Integración.Cliente.DAOClienteImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {

	@Override
	public DAOVentas generaDAOVentas() {
		return new DAOVentasImp();
	}


	public DAOModelo generaDAOModelo() {
		return new DAOModeloImp();
	}


	public DAOCliente generaDAOCliente() {
		return new DAOClienteImp();
	}
}