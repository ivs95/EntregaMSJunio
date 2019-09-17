/**
 * 
 */
package Presentación.Modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Integración.Modelos.TCoche;
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
public class panelAñadirModelo extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreText;
	private JTextField preciotext;
	private JTextField tipoText;
	private JTextField stockText;

	public panelAñadirModelo() {
		setLayout(null);
		setOpaque(false);
		nombreText = new JTextField();
		nombreText.setHorizontalAlignment(SwingConstants.CENTER);
		nombreText.setColumns(10);
		nombreText.setBounds(49, 86, 279, 45);
		add(nombreText);

		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(360, 99, 46, 14);
		add(label);

		preciotext = new JTextField();
		preciotext.setHorizontalAlignment(SwingConstants.CENTER);
		preciotext.setColumns(10);
		preciotext.setBounds(49, 154, 279, 45);
		add(preciotext);

		JLabel label_1 = new JLabel("Precio");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(360, 167, 46, 14);
		add(label_1);

		tipoText = new JTextField();
		tipoText.setHorizontalAlignment(SwingConstants.CENTER);
		tipoText.setColumns(10);
		tipoText.setBounds(49, 290, 279, 45);
		add(tipoText);

		JLabel label_2 = new JLabel("Numero de puertas");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(360, 303, 121, 14);
		add(label_2);

		JLabel label_3 = new JLabel("Tipo");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(360, 235, 75, 14);
		add(label_3);

		JButton button = new JButton("Añadir");
		button.setBackground(Color.WHITE);

		button.setBounds(518, 359, 132, 62);
		add(button);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Coche", "Moto" }));
		comboBox.setBounds(122, 230, 139, 28);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Coche") {
					label_2.setText("Numero de puertas");
				} else
					label_2.setText("Cilindradas");
				SwingUtilities.updateComponentTreeUI(label_2);
			}
		});
		add(comboBox);

		stockText = new JTextField();
		stockText.setHorizontalAlignment(SwingConstants.CENTER);
		stockText.setBounds(49, 368, 279, 45);
		add(stockText);
		stockText.setColumns(10);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(360, 381, 46, 14);
		add(lblStock);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if (comboBox.getSelectedItem() == "Coche") {

						TCoche coche = new TCoche(0, Float.valueOf(preciotext.getText()), true,
								Integer.valueOf(tipoText.getText()), Integer.valueOf(stockText.getText()),
								nombreText.getText());
						Contexto contexto = new Contexto(Evento.AñadirModeloCommand,coche) ;
						ApplicationController.getInstance().ejecutar(contexto);


					} else {

						TMoto moto = new TMoto(0, Float.valueOf(preciotext.getText()), true,
								Integer.valueOf(tipoText.getText()), Integer.valueOf(stockText.getText()),
								nombreText.getText());
						Contexto contexto = new Contexto(Evento.AñadirModeloCommand,moto) ;
						ApplicationController.getInstance().ejecutar(contexto);

					}
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});

	}
	
	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetCamps() {
		// TODO Auto-generated method stub
		
	}
}