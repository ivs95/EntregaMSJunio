package Presentación.Ventas;

import javax.swing.JFrame;
import Presentación.Ventana;


public abstract class VentanaVentas extends JFrame implements Ventana {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VentanaVentas instance;

	
	public static VentanaVentas getInstance() {
	if(instance== null)
		instance= new VentanaVentasImp();
	return instance;
	}
}