
package Negocio.Empleado;

import java.util.List;
import Integración.Empleado.TEmpleado;

public interface SAEmpleado {

	public int crearEmpleado(TEmpleado empleado);

	public int actualizarEmpleado(TEmpleado empleado);

	public int borrarEmpleado(int id);

	public TEmpleado leerEmpleado(int id);

	public List<TEmpleado> leerListaEmpleados();

}