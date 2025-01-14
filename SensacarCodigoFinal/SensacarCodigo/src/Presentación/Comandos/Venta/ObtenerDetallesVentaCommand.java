package Presentación.Comandos.Venta;

import Negocio.Factorías.FactoriaNegocio;
import Negocio.Ventas.TDetallesVenta;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;


public class ObtenerDetallesVentaCommand implements Command {
	
	public Contexto execute(Contexto contexto) {
		TDetallesVenta d = FactoriaNegocio.getInstance().generaSAVentas().obtenerDetallesVenta((int)contexto.getDato());
		if(d==null){
			contexto.setEvento(Evento.ObtenerDetallesVentaCommandError);
		//	contexto.setDato(-1);
		}
		else
			contexto.setDato(d);
		return contexto;
	}
}