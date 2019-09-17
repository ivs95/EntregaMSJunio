/**
 * 
 */
package Presentación.Modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integración.Modelos.TModelo;
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
public class panelMostrarTodoModelo extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;


	public panelMostrarTodoModelo(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Ver todos los modelos");
		button.setBackground(Color.WHITE);
		button.setBounds(208, 36, 262, 57);
		add(button);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		button.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				Contexto contexto = new Contexto(Evento.MostrarListaModeloCommnad,null);
				ApplicationController.getInstance().ejecutar(contexto);
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		ArrayList<TModelo> array = (ArrayList<TModelo>) contexto.getDato();
		String s = "";
		for ( TModelo m : array){
			s+= "ID:		"+ m.getID() + "\n "+ "Nombre: 		" + m.getNombre() +"\n "+ "Precio:		"+m.getPrecio() +"\nStock:		"+ m.getStock() +"\nTipo:		"+ m.getTipoVehiculo() + "\n\n";	
		}
		textArea.setText(s);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}