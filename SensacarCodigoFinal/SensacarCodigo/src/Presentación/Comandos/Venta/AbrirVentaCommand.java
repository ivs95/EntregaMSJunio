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
public class AbrirVentaCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		TVenta venta = FactoriaNegocio.getInstance().generaSAVentas().abrirVenta((int) contexto.getDato());
		if(venta ==null){
			contexto.setEvento(Evento.AbrirVentaCommandError);
		}
		contexto.setDato(venta);
		return contexto;
	}
}