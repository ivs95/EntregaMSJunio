/**
 * 
 */
package Presentación.Cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Integración.Cliente.TCliente;
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
public class panelMostrarClienteID extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscarCliente;
	private JTextArea textArea ;
	private JScrollPane scroll;
	/**
	 * Create the panel.
	 */

	public panelMostrarClienteID(){
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setBackground(Color.WHITE);
		btnBuscarCliente.setBounds(434, 68, 171, 42);
		add(btnBuscarCliente);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(83, 68, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("ID del cliente");
		lblIntroduceElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntroduceElId.setBounds(196, 41, 110, 16);
		add(lblIntroduceElId);

		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Contexto contexto = new Contexto (Evento.MostrarClienteCommand,Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}

			}
		});

	}
	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		String s = null;
		TCliente c = (TCliente) contexto.getDato();
		if(c.getActivo())
			s= "Activo";
		else s= "No activo";
		textArea.setText("DNI: "+ c.getDNI() + "\n" + "Nombre: " +c.getNombre() +"\n" + "Numero de telefono: "+c.getTelefono() + "\n" +"Estado: "+s+  "\n" );

	}
	
	public void resetCamps(){
		textField.setText(null);
		textArea.setText(null);
		
		
		
	}
}