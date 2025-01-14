/**
 * 
 */
package Presentación.Departamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Integración.Departamento.TDepartamento;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.SwingConstants;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class PanelAñadirDep extends JPanel implements Ventana {
	
	//xd
	
	private static final long serialVersionUID = 1L;

	private JTextField funcion;
	private JTextField capacidadText;
	
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	
	public PanelAñadirDep(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		funcion = new JTextField();
		funcion.setHorizontalAlignment(SwingConstants.CENTER);
		funcion.setColumns(10);
		funcion.setBounds(209, 86, 279, 45);
		add(funcion);

		JLabel lblFuncin = new JLabel("Función");
		lblFuncin.setBounds(37, 101, 100, 14);
		add(lblFuncin);

		capacidadText = new JTextField();
		capacidadText.setHorizontalAlignment(SwingConstants.CENTER);
		capacidadText.setColumns(10);
		capacidadText.setBounds(209, 154, 279, 45);
		add(capacidadText);

		JLabel lblCapacidadMxima = new JLabel("Capacidad máxima");
		lblCapacidadMxima.setBounds(37, 169, 139, 14);
		add(lblCapacidadMxima);

		 activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(254, 228, 109, 23);
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

		inactivoRB.setBounds(368, 228, 109, 23);
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
					TDepartamento cliente = new TDepartamento( ok,Integer.valueOf(capacidadText.getText()),funcion.getText(),null);
					Contexto contexto = new Contexto(Evento.AñadirDepartamentoCommand, cliente);
					ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		btnAadir.setBounds(209, 296, 132, 40);
		add(btnAadir);



	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		funcion.setText(null);
		capacidadText.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
	}


}