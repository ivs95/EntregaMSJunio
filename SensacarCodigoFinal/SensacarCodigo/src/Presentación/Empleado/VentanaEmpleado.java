
package Presentación.Empleado;

import javax.swing.JFrame;
import Presentación.Ventana;


public abstract class VentanaEmpleado extends JFrame implements Ventana {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static VentanaEmpleado instance;


	public static VentanaEmpleado getInstance() {
		if ( instance == null){
			instance = new VentanaEmpleadoImp();
		}
		return instance;
	}

	
	public void inicializar() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}