/**
 * 
 */
package Presentación.Competencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
public class PanelAsginarComp extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	private JTextField idEmpText;
	private JTextField idCompText;
	private JTextField nivelText;

	
	public PanelAsginarComp(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		idEmpText = new JTextField();
		idEmpText.setHorizontalAlignment(SwingConstants.CENTER);
		idEmpText.setColumns(10);
		idEmpText.setBounds(214, 91, 279, 35);
		add(idEmpText);

		JLabel label = new JLabel("ID empleado");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(37, 101, 124, 14);
		add(label);

		idCompText = new JTextField();
		idCompText.setHorizontalAlignment(SwingConstants.CENTER);
		idCompText.setColumns(10);
		idCompText.setBounds(214, 159, 279, 35);
		add(idCompText);

		JLabel label_1 = new JLabel("ID Competencia");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(37, 169, 124, 14);
		add(label_1);

		nivelText = new JTextField();
		nivelText.setHorizontalAlignment(SwingConstants.CENTER);
		nivelText.setColumns(10);
		nivelText.setBounds(214, 227, 279, 35);
		add(nivelText);

		JLabel label_2 = new JLabel("Nivel");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(37, 237, 124, 14);
		add(label_2);

		
			
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBackground(Color.WHITE);
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ArrayList<Integer> lista = new ArrayList<Integer>();
				lista.add(Integer.valueOf(idEmpText.getText()));
				lista.add(Integer.valueOf(idCompText.getText()));
				lista.add(Integer.valueOf(nivelText.getText()))	;
				Contexto contexto = new Contexto(Evento.AñadirCompetenciaCommand, lista);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		btnAsignar.setBounds(292, 301, 132, 40);
		add(btnAsignar);
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	public void resetCamps(){
		idEmpText.setText(null);
		idCompText.setText(null);
		nivelText.setText(null);
	}

}