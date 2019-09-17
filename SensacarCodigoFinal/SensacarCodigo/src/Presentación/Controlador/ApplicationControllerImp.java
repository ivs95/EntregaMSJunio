
package Presentación.Controlador;

import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Factorias.FactoriaCommand;


public class ApplicationControllerImp extends ApplicationController {

	public void ejecutar(Contexto contexto) {
		
		/* MENSAJE RECORDATORIO DEL FUNCIONAMIENTO TAL Y COMO HABLAMOS EN TUTORIAS
		 * 
		 * El controlador llama a la FactoriaCommand y genera un comando con el evento
		 * Ese comando devuelve un contexto actualizado que en funcion del evento genera un comando de vista a traves de
		 * actualizarVista(contextoDevuelto.getEvento()
		 * Los comandos de las vistas si reciben un contexto con dato que no sea null actualiza dicha vista
		 * 
		 * Las responsabilidad de parsear las vistas estan en cada ventana ( VentanaClienteImp, VentanaModeloImp...) en la 
		 * funcion actualizar donde se parsea el evento recibido y actualiza el panel correspondiente.
		 * 
		 * 
		 * */
		Command comando = FactoriaCommand.getInstance().generarCommand(contexto.getEvento());
		Contexto contextoDevuelto = comando.execute(contexto);
		
		if (contextoDevuelto != null) {
			comando = FactoriaCommand.getInstance().actualizarVista(contextoDevuelto.getEvento());
			comando.execute(contexto);
		}
	}
}