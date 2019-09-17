/**
 * 
 */
package Presentación.Comandos.Venta;

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
public class MostrarVentaCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		TVenta d = FactoriaNegocio.getInstance().generaSAVentas().leerVenta((int)contexto.getDato());
		if(d ==null){
			contexto.setEvento(Evento.MostrarVentasCommandError);
			
		}
		else
			contexto.setDato(d);
		return contexto;
	}
}