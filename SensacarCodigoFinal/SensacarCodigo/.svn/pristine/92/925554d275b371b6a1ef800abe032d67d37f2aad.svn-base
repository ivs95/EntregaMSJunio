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
public class AñadirModeloAVentaCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		ArrayList<Object> lista = (ArrayList<Object>) contexto.getDato();
		TVenta venta = FactoriaNegocio.getInstance().generaSAVentas().anadirModeloAVenta((TVenta)lista.get(1), (int)lista.get(0),(int)lista.get(2));
		if(venta ==null){
			contexto.setEvento(Evento.AñadirModelosVentaCommandError);
		}
		contexto.setDato(venta);
		return contexto;
	}
}