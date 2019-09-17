/**
 * 
 */
package Presentación.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import javax.swing.SwingConstants;
import java.awt.Color;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nacho710
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class panelEliminarCliente extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;


	public panelEliminarCliente(){
		initComponent();
	}

	public void initComponent(){
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(157, 93, 250, 35);
		add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Contexto contexto = new Contexto(Evento.EliminarClienteCommand, Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
			}catch(NumberFormatException x){
				JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
			}
				
			}	
		});
		btnNewButton.setBounds(157, 199, 250, 42);
		add(btnNewButton);

		JLabel lblIntroduceElId = new JLabel("ID del cliente");
		lblIntroduceElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElId.setBounds(398, 102, 250, 16);
		add(lblIntroduceElId);
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();

	}
	
	public void resetCamps(){
		textField.setText(null);
		
	}

}