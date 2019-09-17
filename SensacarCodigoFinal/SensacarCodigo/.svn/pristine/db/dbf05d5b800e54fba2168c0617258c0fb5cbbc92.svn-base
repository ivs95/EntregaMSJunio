
package Presentación;

import javax.swing.JFrame;

import Presentación.Comandos.Contexto;



public abstract class VentanaPrincipal extends JFrame implements Ventana {
	
	private static final long serialVersionUID = 1L;
	
	public static VentanaPrincipal instance = null;
	public static VentanaPrincipal getInstance() {
		if(instance==null)
			instance = new VentanaPrincipalImp();
		return instance;
	}
	 
	@Override
	public abstract void actualizar(Contexto contexto);
}