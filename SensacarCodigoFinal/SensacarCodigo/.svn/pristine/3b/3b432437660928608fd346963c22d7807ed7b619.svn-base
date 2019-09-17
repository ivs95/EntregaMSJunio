package Presentación.Comandos.Vistas;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Ventas.VentanaVentas;

public class VentanaVentaCommand implements Command {
	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaVentas.getInstance().setVisible(true);
		else
			VentanaVentas.getInstance().actualizar(contexto);
		return null;
	}

}
