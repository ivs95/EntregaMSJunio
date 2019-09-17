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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
public class panelAñadirCliente extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	private JTextField dniText;
	private JTextField nombreText;
	private JTextField telefonoText;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;

	
	
	public panelAñadirCliente(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		dniText = new JTextField();
		dniText.setHorizontalAlignment(SwingConstants.CENTER);
		dniText.setColumns(10);
		dniText.setBounds(109, 88, 279, 40);
		add(dniText);

		JLabel label = new JLabel("DNI");
		label.setBounds(37, 101, 46, 14);
		add(label);

		nombreText = new JTextField();
		nombreText.setHorizontalAlignment(SwingConstants.CENTER);
		nombreText.setColumns(10);
		nombreText.setBounds(109, 156, 279, 40);
		add(nombreText);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(37, 169, 75, 14);
		add(label_1);

		telefonoText = new JTextField();
		telefonoText.setHorizontalAlignment(SwingConstants.CENTER);
		telefonoText.setColumns(10);
		telefonoText.setBounds(109, 224, 279, 40);
		add(telefonoText);

		JLabel label_2 = new JLabel("Telefono");
		label_2.setBounds(37, 237, 75, 14);
		add(label_2);

		 activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(140, 293, 109, 23);
		activoRB.setOpaque(false);
		inactivoRB = new JRadioButton("Inactivo");
		activoRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(false);
				activoRB.setSelected(true);
			}
		});
		add(activoRB);

		inactivoRB.setBounds(253, 293, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBackground(Color.WHITE);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				boolean ok = false ;
				if(activoRB.isSelected()) 
					ok = true;
				TCliente cliente = new TCliente(null,dniText.getText(),nombreText.getText(),Integer.valueOf(telefonoText.getText()), ok);
				Contexto contexto = new Contexto(Evento.AñadirClienteCommand, cliente);
				ApplicationController.getInstance().ejecutar(contexto);
				
			}catch(NumberFormatException x){
				JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
			}
			}
		});
		btnAadir.setBounds(172, 338, 132, 40);
		add(btnAadir);

		

	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		dniText.setText(null);
		nombreText.setText(null);
		telefonoText.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
	}


}