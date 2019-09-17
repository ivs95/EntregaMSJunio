
package Presentación.Departamento;

import javax.swing.JFrame;
import Presentación.Ventana;


public abstract class VentanaDepartamento extends JFrame implements Ventana {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VentanaDepartamento instance;


	public static VentanaDepartamento getInstance() {
		if(instance == null){
			instance= new VentanaDepartamentoImp();
		}
		return instance;
	}


	
}