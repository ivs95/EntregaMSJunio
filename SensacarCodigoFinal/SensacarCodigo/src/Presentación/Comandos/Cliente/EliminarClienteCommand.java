/**
 * 
 */
package Presentación.Comandos.Cliente;

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
public class EliminarClienteCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		int i = FactoriaNegocio.getInstance().generaSACliente().borrarCliente((int) contexto.getDato());
		if(i<0){
			contexto.setEvento(Evento.EliminarClienteCommandError);
			// -2 no existe
			// -1 ya esta inactivo
		}
		contexto.setDato(i);
		return contexto;
	}
}