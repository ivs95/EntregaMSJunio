/**
 * 
 */
package Presentación.Modelos;

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

import Integración.Modelos.TCoche;
import Integración.Modelos.TModelo;
import Integración.Modelos.TMoto;
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
public class panelMostrarModeloID extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscarModelo;
	private JTextArea textArea ;
	private JScrollPane scroll;
	/**
	 * Create the panel.
	 */

	public panelMostrarModeloID(){
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnBuscarModelo = new JButton("Buscar modelo");
		btnBuscarModelo.setBackground(Color.WHITE);
		btnBuscarModelo.setBounds(434, 68, 171, 42);
		add(btnBuscarModelo);

		textField = new JTextField();
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

		JLabel lblIntroduceElId = new JLabel("ID del modelo");
		lblIntroduceElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntroduceElId.setBounds(200, 43, 110, 16);
		add(lblIntroduceElId);

		btnBuscarModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
				Contexto contexto = new Contexto (Evento.MostrarModeloCommand,Integer.valueOf(textField.getText()));
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
		TModelo m = (TModelo) contexto.getDato();
		s+= "ID:		"+ m.getID() + "\n"+ "Nombre: 		" + m.getNombre() +"\n"+ "Precio:		"+m.getPrecio() +"\n"+ "Stock:		"+ m.getStock() + "\n" +
				"Tipo:		" + m.getTipoVehiculo() + "\n";
				if (m.getTipoVehiculo().toLowerCase() == "coche"){
					TCoche c = (TCoche)m;
					s+="Número de puertas:	" + c.getNumPuertas()+ "\n" ;
				}
				else{
					TMoto c = (TMoto)m;
					s+="Cilindrada:		" + c.getCilindrada()+ "\n";
				}
				String a="";
				if(m.getActivo()== true)
					a= "Activo";
				else a= "No activo";
				s+= "Estado:		"+ a;	
				
		textArea.setText(s);

	}
	
	public void resetCamps(){
		textField.setText(null);
		textArea.setText(null);
		
		
		
	}
	
}