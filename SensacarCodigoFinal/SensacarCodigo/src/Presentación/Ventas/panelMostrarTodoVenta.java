/**
 * 
 */
package Presentación.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integración.Ventas.TVenta;
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
public class panelMostrarTodoVenta extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JButton btnVerLasVentas;
	private JTextArea textArea;
	private JScrollPane scroll;


	public panelMostrarTodoVenta(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnVerLasVentas = new JButton("Ver las ventas");
		btnVerLasVentas.setBackground(Color.WHITE);
		btnVerLasVentas.setBounds(208, 36, 262, 57);
		add(btnVerLasVentas);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		btnVerLasVentas.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				Contexto contexto = new Contexto(Evento.MostrarListaVentasCommand,0);
				ApplicationController.getInstance().ejecutar(contexto);
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		ArrayList<TVenta> array = (ArrayList<TVenta>) contexto.getDato();
		String s = "";
		for(TVenta venta : array){
			s+= "ID de la Venta:		"+ venta.getId()+ "\n"+ "ID de Cliente:		" + venta.getIdCliente() + "\n" + "Fecha:		"+ venta.getFecha() + "\n";
			s+= "Precio Total:		"+ venta.getPrecioTotal() + "\n\n";
		}
		textArea.setText(s);
	}

	public void resetCamps(){
		textArea.setText(null);
	}
}