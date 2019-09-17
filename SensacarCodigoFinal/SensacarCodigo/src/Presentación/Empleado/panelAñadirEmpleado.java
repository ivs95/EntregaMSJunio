/**
 * 
 */
package Presentación.Empleado;

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
import javax.swing.SwingUtilities;

import Integración.Empleado.TEmpleadoCompleto;
import Integración.Empleado.TEmpleadoParcial;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author nacho710
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class panelAñadirEmpleado extends JPanel implements Ventana {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField dniText;
	private JTextField nombretext;
	private JTextField extra1Text;
	private JTextField extra2Text;
	private JLabel lblStock;
	private JLabel lblSueldohora;
	private JLabel label_3;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	private JTextField textField;
	private JLabel lblDepartamento;

	public panelAñadirEmpleado() {
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		dniText = new JTextField();
		dniText.setHorizontalAlignment(SwingConstants.CENTER);
		dniText.setColumns(10);
		dniText.setBounds(49, 80, 279, 57);
		add(dniText);

		JLabel label = new JLabel("DNI");
		label.setBounds(386, 101, 46, 14);
		add(label);

		nombretext = new JTextField();
		nombretext.setHorizontalAlignment(SwingConstants.CENTER);
		nombretext.setColumns(10);
		nombretext.setBounds(49, 148, 279, 57);
		add(nombretext);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(386, 169, 46, 14);
		add(label_1);

		extra1Text = new JTextField();
		extra1Text.setHorizontalAlignment(SwingConstants.CENTER);
		extra1Text.setColumns(10);
		extra1Text.setBounds(49, 284, 279, 38);
		add(extra1Text);

		lblSueldohora = new JLabel("Sueldo / hora");
		lblSueldohora.setBounds(386, 305, 121, 14);
		add(lblSueldohora);

		label_3 = new JLabel("Contrato");
		label_3.setBounds(386, 237, 75, 14);
		add(label_3);

		JButton button = new JButton("Añadir");
		button.setBackground(Color.WHITE);

		button.setBounds(518, 359, 132, 62);
		add(button);
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tiempo Parcial", "Tiempo Completo" }));
		comboBox.setBounds(121, 230, 163, 28);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Tiempo Parcial") {
					lblSueldohora.setText("Sueldo / hora");
					lblStock.setText("Horas / semana");
				} else {
					lblSueldohora.setText("Sueldo base");
					lblStock.setText("Dietas");
				}
				SwingUtilities.updateComponentTreeUI(lblSueldohora);
			}
		});
		add(comboBox);
		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(121, 329, 109, 23);
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
		inactivoRB.setBounds(232, 329, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});
		extra2Text = new JTextField();
		extra2Text.setHorizontalAlignment(SwingConstants.CENTER);
		extra2Text.setBounds(49, 359, 279, 27);
		add(extra2Text);
		extra2Text.setColumns(10);

		lblStock = new JLabel("Horas / semana");
		lblStock.setBounds(386, 359, 130, 17);
		add(lblStock);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(49, 397, 279, 27);
		add(textField);

		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(386, 404, 130, 17);
		add(lblDepartamento);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean ok = false;
					if (activoRB.isSelected())
						ok = true;
					if (comboBox.getSelectedItem() == "Tiempo Parcial") {

						TEmpleadoParcial empl = new TEmpleadoParcial(ok, dniText.getText(), nombretext.getText(), null,
								Integer.valueOf(textField.getText()), Integer.valueOf(extra1Text.getText()),
								Integer.valueOf(extra2Text.getText()));
						Contexto contexto = new Contexto(Evento.AñadirEmpleadoCommand, empl);
						ApplicationController.getInstance().ejecutar(contexto);

					} else {
						TEmpleadoCompleto empl = new TEmpleadoCompleto(ok, dniText.getText(), nombretext.getText(),
								null, Integer.valueOf(textField.getText()), Integer.valueOf(extra1Text.getText()),
								Integer.valueOf(extra2Text.getText()));
						Contexto contexto = new Contexto(Evento.AñadirEmpleadoCommand, empl);
						ApplicationController.getInstance().ejecutar(contexto);

					}
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
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
		dniText.setText(null);
		nombretext.setText(null);
		extra1Text.setText(null);
		extra2Text.setText(null);
		textField.setText(null);
	}
}