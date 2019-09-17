package Presentación.Comandos.Competencia;

import java.util.ArrayList;

import Integración.Competencia.TTiene;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

public class MostrarEmpleadosCompentenciaCommand implements Command{

	@Override
	public Contexto execute(Contexto contexto) {
		ArrayList<TTiene> lista = (ArrayList<TTiene>) FactoriaNegocio.getInstance().generaSACompetencia().leerEmpleadosDeCompetencia((int)contexto.getDato());
		if(lista==null){
			contexto.setEvento(Evento.MostrarEmpleadosCompetenciaCommandError);
		}
		contexto.setDato(lista);
		return contexto;
	}
	
}
