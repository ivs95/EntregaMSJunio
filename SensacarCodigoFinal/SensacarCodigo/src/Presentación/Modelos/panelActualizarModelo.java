/**
 * 
 */
package Presentación.Modelos;

import java.awt.Color;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nacho710
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Integración.Modelos.TCoche;
import Integración.Modelos.TModelo;
import Integración.Modelos.TMoto;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;

public class panelActualizarModelo extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreText;
	private JTextField precioText;
	private JTextField tipoText;
	private JTextField botonfindtext;
	private JTextField stockText;

	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JComboBox comboBox;
	
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnInactivo;
	private JButton button;
	private JLabel lblStock;

	public panelActualizarModelo() {
		setLayout(null);
		setOpaque(false);
		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(49, 101, 279, 28);
		nombreText.setHorizontalAlignment(SwingConstants.CENTER);

		// add(nombreText);

		label = new JLabel("Nombre");
		label.setBounds(386, 101, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		// add(label);

		precioText = new JTextField();
		precioText.setColumns(10);
		precioText.setBounds(49, 169, 279, 28);
		precioText.setHorizontalAlignment(SwingConstants.CENTER);
		// add(precioText);

		label_1 = new JLabel("Precio");
		label_1.setBounds(386, 169, 46, 14);
		// add(label_1);

		tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(49, 284, 279, 35);
		tipoText.setHorizontalAlignment(SwingConstants.CENTER);
		// add(tipoText);

		
		label_3 = new JLabel("Tipo");
		label_3.setBounds(386, 237, 30, 14);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		// add(label_3);

		label_2 = new JLabel("Numero de puertas");
		label_2.setBounds(386, 294, 121, 14);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);

		// add(label_2);

		


		button = new JButton("OK");
		button.setBackground(Color.WHITE);
		button.setHorizontalAlignment(SwingConstants.CENTER);


		button.setBounds(513, 404, 132, 28);
		// add(button);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Coche", "Moto" }));
		
		comboBox.setBounds(121, 230, 163, 28);
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

		stockText = new JTextField();
		stockText.setBounds(49, 350, 279, 35);
		stockText.setHorizontalAlignment(SwingConstants.CENTER);


		stockText.setColumns(10);

		lblStock = new JLabel("Stock");
		lblStock.setBounds(386, 364, 46, 14);
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);


		botonfindtext = new JTextField();
		botonfindtext.setBounds(49, 29, 283, 20);
		add(botonfindtext);
		botonfindtext.setColumns(10);
		rdbtnActivo = new JRadioButton("Activo");
		rdbtnInactivo = new JRadioButton("Inactivo");
		JButton botonFind = new JButton("Buscar");
		botonFind.setBackground(Color.WHITE);
		botonFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rdbtnInactivo.setSelected(false);
					rdbtnActivo.setSelected(false);
					Contexto contexto = new Contexto(Evento.ActualizarModeloCommand,
							Integer.valueOf(botonfindtext.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					if (comboBox.getSelectedItem() == "Coche") {

						TCoche coche = new TCoche(Integer.valueOf(botonfindtext.getText()),
								Float.valueOf(precioText.getText()), true, Integer.valueOf(tipoText.getText()),
								Integer.valueOf(stockText.getText()), nombreText.getText());
						Contexto contexto = new Contexto(Evento.ActualizarModeloCommand, coche);
						ApplicationController.getInstance().ejecutar(contexto);
						// ApplicationController.getInstance().ejecutar(("Coche
						// añadido con el id = " + i),
						// Evento.MostrarMensajeCommand.getValor());

					} else {

						TMoto moto = new TMoto(Integer.valueOf(botonfindtext.getText()),
								Float.valueOf(precioText.getText()), true, Integer.valueOf(tipoText.getText()),
								Integer.valueOf(stockText.getText()), nombreText.getText());
						Contexto contexto = new Contexto(Evento.ActualizarModeloCommand, moto);
						ApplicationController.getInstance().ejecutar(contexto);
						// ApplicationController.getInstance().ejecutar(("Moto
						// añadida con el id = " + i),
						// Evento.MostrarMensajeCommand.getValor());

					}

				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}

			}
		});

		botonFind.setBounds(427, 28, 222, 23);
		add(botonFind);

		rdbtnActivo.setBounds(65, 409, 109, 23);
		rdbtnActivo.setOpaque(false);
		rdbtnInactivo.setOpaque(false);
		rdbtnActivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnInactivo.setSelected(false);
				rdbtnActivo.setSelected(true);

			}
		});

		rdbtnInactivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnInactivo.setSelected(true);
				rdbtnActivo.setSelected(false);

			}
		});
		rdbtnInactivo.setBounds(238, 409, 109, 23);

	}

	@Override
	public void actualizar(Contexto contexto) {
		TModelo modelo = (TModelo) contexto.getDato();
		nombreText.setText(modelo.getNombre());
		add(nombreText);
		add(label);
		precioText.setText(String.valueOf(modelo.getPrecio()));
		add(precioText);
		add(label_1);
		if (modelo.getTipoVehiculo().toLowerCase() == "coche") {
			TCoche c = (TCoche) modelo;
			comboBox.setSelectedItem("Coche");
			tipoText.setText(c.getNumPuertas().toString());
		} else {
			TMoto m = (TMoto) modelo;
			comboBox.setSelectedItem("Moto");
			tipoText.setText(m.getCilindrada().toString());
		}

		if (modelo.getActivo() == true)
			rdbtnActivo.setSelected(true);
		else
			rdbtnInactivo.setSelected(true);
		add(tipoText);
		add(label_2);
		add(button);
		add(label_3);
		add(lblStock);
		stockText.setText(modelo.getStock().toString());
		add(stockText);
		add(comboBox);
		add(rdbtnActivo);
		add(rdbtnInactivo);
		repaint();

	}

	@Override
	public void resetCamps() {
		nombreText.setText(null);
		precioText.setText(null);
		tipoText.setText(null);
		botonfindtext.setText(null);
		stockText.setText(null);
		rdbtnActivo.setSelected(false);
		rdbtnInactivo.setSelected(false);
	}
}
