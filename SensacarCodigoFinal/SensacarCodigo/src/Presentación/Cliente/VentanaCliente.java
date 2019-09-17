/**
 * 
 */
package Presentación.Cliente;

import javax.swing.JFrame;
import Presentación.Ventana;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class VentanaCliente extends JFrame implements Ventana {
	
	private static final long serialVersionUID = 1L;
	private static VentanaCliente instance;

	
	public static VentanaCliente getInstance() {
		if ( instance==null){
			instance= new VentanaClienteImp();
		}
		return instance;
	}
	

}