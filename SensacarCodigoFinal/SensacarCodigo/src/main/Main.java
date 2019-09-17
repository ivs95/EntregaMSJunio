package main;

import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;

public class Main {

	public static void main(String[] args) {
		Contexto contexto = new Contexto(Evento.CrearVentanaPrincipal, null);
		ApplicationController.getInstance().ejecutar(contexto);

	}

}
