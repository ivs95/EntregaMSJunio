/**
 * 
 */
package Presentación.Comandos.Modelo;

import java.util.ArrayList;

import Integración.Modelos.TModelo;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class MostrarListaModeloCommand implements Command {
	
	public Contexto execute(Contexto contexto) {
		ArrayList<TModelo> lista = FactoriaNegocio.getInstance().generaSAModelo().leerListaModelos();
		if(lista==null){
			contexto.setEvento(Evento.MostrarListaModeloCommandError);
		}
		contexto.setDato(lista);
		return contexto;
	}
}