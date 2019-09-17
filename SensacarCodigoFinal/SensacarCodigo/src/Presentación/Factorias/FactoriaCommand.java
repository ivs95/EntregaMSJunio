/**
 * 
 */
package Presentación.Factorias;

import Presentación.Comandos.Evento;
import Presentación.Comandos.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class FactoriaCommand {

	private static FactoriaCommand instance;

	public static FactoriaCommand getInstance() {
		if ( instance==null){
			instance= new FactoriaCommandImp();
		}
		return instance;
	}

	public abstract Command generarCommand(Evento evento);
	public abstract Command actualizarVista(Evento evento);
}