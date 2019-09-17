package Presentación.Comandos.Modelo;

import java.util.ArrayList;

import Integración.Modelos.TModelo;
import Integración.Query.TQuery;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;


public class QueryModeloCommand implements Command {
	
	public Contexto execute(Contexto contexto) {
		ArrayList<TModelo> c = FactoriaNegocio.getInstance().generaSAModelo().queryModelo((TQuery) contexto.getDato());
		if (c == null|| c.size() == 0) {
			contexto.setEvento(Evento.MostrarModeloCommandError);
			contexto.setDato(-1);
		} else
			contexto.setDato(c);
		return contexto;
	}
}