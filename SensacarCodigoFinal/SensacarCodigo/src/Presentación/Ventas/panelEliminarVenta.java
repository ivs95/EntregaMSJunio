/**
 * 
 */
package Presentación.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class panelEliminarVenta extends JPanel implements Ventana{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	 public panelEliminarVenta() 		{
			setLayout(null);
			setOpaque(false);
			textField = new JTextField();
			textField.setBounds(70, 126, 295, 45);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			add(textField);
			textField.setColumns(10);

			JButton btnNewButton = new JButton("Eliminar");
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{																	
						Contexto contexto = new Contexto(Evento.EliminarVentasCommand,Integer.valueOf(textField.getText()));
						ApplicationController.getInstance().ejecutar(contexto);
					}catch(NumberFormatException x){
						JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
					}
				}
			});
			btnNewButton.setBounds(141, 222, 174, 66);
			add(btnNewButton);
			
			JLabel lblIdDeLa = new JLabel("ID de la venta");
			lblIdDeLa.setBounds(429, 141, 147, 14);
			add(lblIdDeLa);

		}

		@Override
		public void actualizar(Contexto contexto) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resetCamps() {
			// TODO Auto-generated method stub
			
		}
}