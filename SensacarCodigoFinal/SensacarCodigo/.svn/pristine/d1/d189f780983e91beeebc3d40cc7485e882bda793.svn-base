/**
 * 
 */
package Presentación.Comandos.Cliente;

import java.util.ArrayList;

import Integración.Cliente.TCliente;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

public class MostrarListaClienteCommand implements Command {
	
	public Contexto execute(Contexto contexto) {
		ArrayList<TCliente> lista = FactoriaNegocio.getInstance().generaSACliente().leerListaClientes();
		if(lista==null){
			contexto.setEvento(Evento.MostrarListaClienteCommandError);
		}
		contexto.setDato(lista);
		return contexto;
	}
}