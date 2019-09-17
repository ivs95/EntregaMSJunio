/**
 * 
 */
package Presentación.Comandos.Cliente;

import Integración.Cliente.TCliente;
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
public class MostrarClienteCommand implements Command {
	/**
	 * (non-Javadoc)
	 * 
	 * @see Command#execute(Contexto contexto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Contexto contexto) {
		TCliente c = FactoriaNegocio.getInstance().generaSACliente().leerCliente((int) contexto.getDato());
		if (c == null) {
			contexto.setEvento(Evento.MostrarClienteCommandError);
			contexto.setDato(-1);
		} else
			contexto.setDato(c);
		return contexto;
	}
}