/**
 * 
 */
package Presentación.Comandos.Venta;

import java.util.ArrayList;

import Integración.Ventas.TVenta;
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
public class MostrarListaVentasCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		ArrayList<TVenta>  lista = FactoriaNegocio.getInstance().generaSAVentas().leerListaVentas();
		if(lista ==null){
			contexto.setEvento(Evento.MostrarListaVentasCommandError);
		}
		else 
			contexto.setDato(lista);
		return contexto;
	}
}