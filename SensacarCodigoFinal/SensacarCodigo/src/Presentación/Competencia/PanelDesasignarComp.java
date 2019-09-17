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
public class PanelDesasignarComp extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;


		private JTextField idEmpText;
		private JTextField idCompText;
		

		
		public PanelDesasignarComp(){
			initComponent();
		}
		
		public void initComponent() {
			setLayout(null);
			setOpaque(false);
			idEmpText = new JTextField();
			idEmpText.setColumns(10);
			idEmpText.setBounds(225, 91, 279, 35);
			add(idEmpText);

			JLabel label = new JLabel("ID empleado");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(37, 101, 142, 14);
			add(label);

			idCompText = new JTextField();
			idCompText.setColumns(10);
			idCompText.setBounds(225, 159, 279, 35);
			add(idCompText);

			JLabel label_1 = new JLabel("ID Competencia");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(37, 169, 142, 14);
			add(label_1);


			
				
			JButton btnDesasignar = new JButton("Desasignar");
			btnDesasignar.setBackground(Color.WHITE);
			btnDesasignar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					ArrayList<Object> lista = new ArrayList<Object>();
					lista.add(Integer.valueOf(idEmpText.getText()));
					lista.add(Integer.valueOf(idCompText.getText()));
					Contexto contexto = new Contexto(Evento.DesasignarCompetenciaCommand, lista);
					ApplicationController.getInstance().ejecutar(contexto);
					}catch(NumberFormatException x){
						JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
					}

				}
			});
			btnDesasignar.setBounds(304, 278, 132, 40);
			add(btnDesasignar);
		

	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		idCompText.setText(null);
		idEmpText.setText(null);
		
	}

}