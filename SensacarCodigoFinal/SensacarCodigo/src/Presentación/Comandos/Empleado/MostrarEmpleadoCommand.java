/**
 * 
 */
package Presentación.Comandos.Empleado;

import Integración.Empleado.TEmpleado;
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
public class MostrarEmpleadoCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		TEmpleado e = FactoriaNegocio.getInstance().generaSAEmpleado().leerEmpleado((int) contexto.getDato());
		if (e == null) {
			contexto.setEvento(Evento.MostrarEmpleadoCommandError);
			contexto.setDato(-1);
		} else
			contexto.setDato(e);
		return contexto;
	}
}