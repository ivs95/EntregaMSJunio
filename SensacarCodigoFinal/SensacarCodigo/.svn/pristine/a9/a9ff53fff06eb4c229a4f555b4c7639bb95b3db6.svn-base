package Presentación.Comandos.Cliente;

import Integración.Cliente.TCliente;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;


public class ActualizarClienteCommand implements Command {

	public Contexto execute(Contexto contexto) {

		if (contexto.getDato() instanceof Integer) {
			TCliente c = FactoriaNegocio.getInstance().generaSACliente().leerCliente((int) contexto.getDato());
			if (c == null) {
				contexto.setEvento(Evento.MostrarClienteCommandError);
				contexto.setDato(-1);
			} else
				contexto.setDato(c);
			return contexto;
		} else {
			int i = FactoriaNegocio.getInstance().generaSACliente().actualizarCliente((TCliente) contexto.getDato());
			if (i < 0) {
				contexto.setEvento(Evento.ActualizarClienteCommandError);
				contexto.setDato(i);
			} else {
				contexto.setEvento(Evento.ActualizarClienteCommand2Vueta);
				contexto.setDato(i);
			}
			return contexto;
		}
	}
}