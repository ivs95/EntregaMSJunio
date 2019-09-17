/**
 * 
 */
package Presentación.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integración.Cliente.TCliente;
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
public class panelMostrarTodoCliente extends JPanel implements Ventana{
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static final long serialVersionUID = 1L;
	private JButton btnVerLosClientes;
	private JTextArea textArea;
	private JScrollPane scroll;


	public panelMostrarTodoCliente(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnVerLosClientes = new JButton("Ver los clientes");
		btnVerLosClientes.setBackground(Color.WHITE);
		btnVerLosClientes.setBounds(208, 36, 262, 57);
		add(btnVerLosClientes);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		btnVerLosClientes.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				Contexto contexto = new Contexto(Evento.MostrarListaClienteCommand,null);
				ApplicationController.getInstance().ejecutar(contexto);
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		ArrayList<TCliente> array = (ArrayList<TCliente>) contexto.getDato();
		String texto = "";
		for (TCliente c : array) {
			String s = null;
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";
			texto = texto + "ID: " + c.getId() + "\n" + "DNI: " + c.getDNI() + "\n"
					+ "Nombre: " + c.getNombre() + "\n" + "Numero de Telefono: " + c.getTelefono() + "\n" +
					"Estado: " + s + "\n\n";

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}