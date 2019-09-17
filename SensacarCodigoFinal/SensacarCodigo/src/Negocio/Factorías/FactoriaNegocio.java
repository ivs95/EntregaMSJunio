
package Negocio.Factorías;

import Negocio.Cliente.SACliente;
import Negocio.Modelos.SAModelo;
import Negocio.Ventas.SAVenta;
import Negocio.Departamento.SADepartamento;
import Negocio.Competencia.SACompetencia;
import Negocio.Empleado.SAEmpleado;


public abstract class FactoriaNegocio {

	private static FactoriaNegocio instance;


	public static FactoriaNegocio getInstance() {
		if (instance==null){
			instance= new FactoriaNegocioImp();
		}
		return instance;
	}


	public abstract SACliente generaSACliente();
	
	public abstract SAModelo generaSAModelo();
	
	public abstract SAVenta generaSAVentas();
	
	public abstract SADepartamento generaSADepartamento();
	
	public abstract SACompetencia generaSACompetencia();

	public abstract SAEmpleado generaSAEmpleado();
}