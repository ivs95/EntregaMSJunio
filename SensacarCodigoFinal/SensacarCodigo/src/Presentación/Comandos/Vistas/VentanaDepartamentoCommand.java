package Presentación.Comandos.Vistas;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Departamento.VentanaDepartamento;

public class VentanaDepartamentoCommand implements Command {
	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaDepartamento.getInstance().setVisible(true);
		else
			VentanaDepartamento.getInstance().actualizar(contexto);
		return null;
	}

}
