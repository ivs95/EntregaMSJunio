package Presentación.Comandos.Vistas;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Modelos.VentanaModelos;

public class VentanaModeloCommand implements Command {

	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaModelos.getInstance().setVisible(true);
		else
			VentanaModelos.getInstance().actualizar(contexto);
		return null;
	}

}
