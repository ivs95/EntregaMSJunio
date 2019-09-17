
package Presentación.Comandos.Modelo;

import Integración.Modelos.TModelo;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;


public class AñadirModeloCommand implements Command {
	
	public Contexto execute(Contexto contexto) {
		int i = FactoriaNegocio.getInstance().generaSAModelo().crearModelo((TModelo) contexto.getDato());
		if (i < 0) {
			contexto.setEvento(Evento.AñadirModeloCommandError);
		}
			contexto.setDato(i);
		return contexto;
	}
}