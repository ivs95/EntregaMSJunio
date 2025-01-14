/**
 * 
 */
package Presentación.Comandos.Venta;

import java.util.ArrayList;

import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author nacho710
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DevolverVentaCommand implements Command {
	/**
	 * (non-Javadoc)
	 * 
	 * @see Command#execute(Contexto contexto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Contexto contexto) {
		ArrayList<Integer> lista = (ArrayList<Integer>) contexto.getDato();
		int i = FactoriaNegocio.getInstance().generaSAVentas().devolverVenta(lista.get(0), lista.get(1), lista.get(2));
		if (i < 0) {
			contexto.setEvento(Evento.DevolverVentaCommandError);
			contexto.setDato(i);
		} else
			contexto.setDato(i);
		return contexto;
	}
}