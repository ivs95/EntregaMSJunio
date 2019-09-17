/**
 * 
 */
package Presentación.Comandos.Cliente;

import java.util.ArrayList;

import Integración.Cliente.TCliente;
import Integración.Query.TQuery;
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
public class QueryClienteCommand implements Command {
	/**
	 * (non-Javadoc)
	 * 
	 * @see Command#execute(Contexto contexto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Contexto contexto) {
		ArrayList<TCliente> c = FactoriaNegocio.getInstance().generaSACliente()
				.queryCliente((TQuery) contexto.getDato());
		if (c == null || c.size() == 0) {
			contexto.setEvento(Evento.QueryClienteCommandError);
		}
		contexto.setDato(c);
		return contexto;
	}
}