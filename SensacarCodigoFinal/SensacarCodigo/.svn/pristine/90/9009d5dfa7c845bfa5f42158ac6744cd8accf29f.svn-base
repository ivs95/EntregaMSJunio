/**
 * 
 */
package Presentación.Comandos.Empleado;

import java.util.ArrayList;

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
public class MostrarTodoEmpleadoCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		ArrayList<TEmpleado> lista = (ArrayList<TEmpleado>) FactoriaNegocio.getInstance().generaSAEmpleado().leerListaEmpleados();
		if(lista==null){
			contexto.setEvento(Evento.MostrarListaEmpleadoCommandError);
		}
		contexto.setDato(lista);
		return contexto;
	}
}