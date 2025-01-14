/**
 * 
 */
package Presentación.Ventas;

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
public class panelDevolucionVenta extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;

	private JTextField idVentaText;
	private JTextField idModeloText;
	private JTextField CantidadText;

	
	public panelDevolucionVenta(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		idVentaText = new JTextField();
		idVentaText.setHorizontalAlignment(SwingConstants.CENTER);
		idVentaText.setColumns(10);
		idVentaText.setBounds(158, 86, 279, 45);
		add(idVentaText);

		JLabel lblIdDeLa = new JLabel("ID de la venta");
		lblIdDeLa.setBounds(37, 101, 111, 14);
		add(lblIdDeLa);

		idModeloText = new JTextField();
		idModeloText.setHorizontalAlignment(SwingConstants.CENTER);
		idModeloText.setColumns(10);
		idModeloText.setBounds(158, 154, 279, 45);
		add(idModeloText);

		JLabel lblIdDelModelo = new JLabel("ID del modelo");
		lblIdDelModelo.setBounds(37, 169, 111, 14);
		add(lblIdDelModelo);

		CantidadText = new JTextField();
		CantidadText.setHorizontalAlignment(SwingConstants.CENTER);
		CantidadText.setColumns(10);
		CantidadText.setBounds(158, 222, 279, 45);
		add(CantidadText);

		JLabel label_2 = new JLabel("Cantidad");
		label_2.setBounds(37, 237, 111, 14);
		add(label_2);

		
			
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setBackground(Color.WHITE);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ArrayList<Integer> lista = new ArrayList<Integer>();
				lista.add(Integer.valueOf(idVentaText.getText()));
				lista.add(Integer.valueOf(idModeloText.getText()));
				lista.add(Integer.valueOf(CantidadText.getText()))	;
				Contexto contexto = new Contexto(Evento.DevolverVentasCommand, lista);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		btnDevolver.setBounds(158, 317, 132, 40);
		add(btnDevolver);
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	public void resetCamps(){
		idVentaText.setText(null);
		idModeloText.setText(null);
		CantidadText.setText(null);
	}
	
}