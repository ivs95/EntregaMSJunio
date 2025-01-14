/**
 * 
 */
package Presentación.Departamento;

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
import javax.swing.SwingConstants;

import Integración.Departamento.TDepartamento;
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
public class PanelLeerDep extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnBuscarDepartamento;
	private JTextArea textArea ;
	private JScrollPane scroll;
	/**
	 * Create the panel.
	 */

	public PanelLeerDep() {
	
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnBuscarDepartamento = new JButton("Buscar departamento");
		btnBuscarDepartamento.setBackground(Color.WHITE);
		btnBuscarDepartamento.setBounds(434, 68, 171, 42);
		add(btnBuscarDepartamento);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 68, 339, 45);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("ID del departamento");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntroduceElId.setBounds(174, 41, 171, 16);
		add(lblIntroduceElId);

		btnBuscarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Contexto contexto = new Contexto (Evento.LeerDepartamentoCommand,Integer.valueOf(textField.getText()));
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
		String a;
		String s = "";
		TDepartamento m = (TDepartamento) contexto.getDato();
		s+= "ID:		"+ m.getId() + "\n"+ "Nombre:		" + m.getFuncion() +"\n"+ "Capacidad maxima:	"+m.getCapacidad_max() +"\n" + "Número de empleados:	" + m.getEmpleados().size()+"\n";
		
		if(m.getActivo()== true)
					a= "Activo";
		else a= "No activo";
		s+= "Estado:		"+ a;	
				
		textArea.setText(s);

	}
	
	public void resetCamps(){
		
		this.textArea.setText(null);
		this.textField.setText(null);
		
	}
	
}