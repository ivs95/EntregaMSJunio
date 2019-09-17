/**
 * 
 */
package Presentación.Comandos.Modelo;

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
public class ActualizarModeloCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		if(contexto.getDato() instanceof Integer){
			TModelo c = FactoriaNegocio.getInstance().generaSAModelo().leerModelo((int) contexto.getDato());
			if (c == null) {
				contexto.setEvento(Evento.MostrarModeloCommandError);
				contexto.setDato(-1);
			} else
				contexto.setDato(c);
			return contexto;
		}
		else {
		int i = FactoriaNegocio.getInstance().generaSAModelo().actualizarModelo((TModelo) contexto.getDato());
		
		if(i<0){
			contexto.setEvento(Evento.ActualizarModeloCommandError);
		}
		contexto.setEvento(Evento.ActualizarModeloCommand2Vuelta);
		contexto.setDato(i);
		return contexto;}
	}
}