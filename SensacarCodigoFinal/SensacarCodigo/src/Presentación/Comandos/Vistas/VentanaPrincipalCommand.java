package Presentación.Comandos.Vistas;

import Presentación.VentanaPrincipal;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;

public class VentanaPrincipalCommand implements Command {

	@Override
	public Contexto execute(Contexto contexto) {
		// TODO Auto-generated method stub
		VentanaPrincipal.getInstance();
		return null;
	}

}
