package Presentación.Comandos.Vistas;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Competencia.VentanaCompetencia;

public class VentanaCompetenciaCommand implements Command{
	@Override
	public Contexto execute(Contexto contexto) {
		if (contexto.getDato() == null)
			VentanaCompetencia.getInstance().setVisible(true);
		else
			VentanaCompetencia.getInstance().actualizar(contexto);
		return null;
	}

}
