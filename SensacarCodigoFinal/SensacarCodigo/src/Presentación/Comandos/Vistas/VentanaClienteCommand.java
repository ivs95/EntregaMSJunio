package Presentación.Comandos.Vistas;

import Presentación.Cliente.VentanaCliente;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;

public class VentanaClienteCommand implements Command {

	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaCliente.getInstance().setVisible(true);
		else
			VentanaCliente.getInstance().actualizar(contexto);
		return null;
	}

}
