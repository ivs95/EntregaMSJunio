package Presentación.Comandos.Competencia;

import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

public class BorrarCompetenciaCommand implements Command{

	@Override
	public Contexto execute(Contexto contexto) {
		int i = FactoriaNegocio.getInstance().generaSACompetencia().eliminarCompetencia((int) contexto.getDato());
		if(i<0){
			contexto.setEvento(Evento.EliminarCompetenciaCommandError);
		}
		contexto.setDato(i);
		return contexto;
	}

}
