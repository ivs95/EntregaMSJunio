package Presentación.Comandos.Departamento;

import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

public class CalcularNominaCommand implements Command {

	@Override
	public Contexto execute(Contexto contexto) {
		int i = FactoriaNegocio.getInstance().generaSADepartamento()
				.calcularNominaDeDepartamento((int) contexto.getDato());
		if (i < 0) {
			contexto.setEvento(Evento.CalcularNominaCommandError);
			
		}
		contexto.setDato(i);
		return contexto;
	}

}
