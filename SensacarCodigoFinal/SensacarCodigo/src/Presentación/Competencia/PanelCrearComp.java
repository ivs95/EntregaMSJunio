/**
 * 
 */
package Presentación.Competencia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Integración.Competencia.TCompetencia;
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
public class PanelCrearComp extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	
	private JTextField nombreText;
	
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;

	
	
	public PanelCrearComp(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
	

		nombreText = new JTextField();
		nombreText.setHorizontalAlignment(SwingConstants.CENTER);
		nombreText.setColumns(10);
		nombreText.setBounds(193, 79, 279, 35);
		add(nombreText);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(125, 89, 75, 14);
		add(label_1);


		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(223, 193, 109, 23);
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

		inactivoRB.setBounds(334, 193, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(Color.WHITE);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				boolean ok = false ;
				if(activoRB.isSelected()) 
					ok = true;
				TCompetencia c = new TCompetencia(ok, null, nombreText.getText());
				Contexto contexto = new Contexto(Evento.CrearCompetenciaCommmand, c);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}

			}
		});
		btnCrear.setBounds(270, 266, 132, 40);
		add(btnCrear);

		JLabel lblAadirCliente = new JLabel("");
		lblAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirCliente.setBounds(37, 13, 162, 32);
		add(lblAadirCliente);

		

	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		
		nombreText.setText(null);
	
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
	}


}