package Presentación.Comandos.Vistas;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Empleado.VentanaEmpleado;

public class VentanaEmpleadoCommand implements Command {
	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaEmpleado.getInstance().setVisible(true);
		else
			VentanaEmpleado.getInstance().actualizar(contexto);
		return null;
	}

}
