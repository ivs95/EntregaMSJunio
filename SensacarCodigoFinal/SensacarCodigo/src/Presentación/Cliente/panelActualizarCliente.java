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

public class panelActualizarCliente extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField dni;
	private JTextField nombre;
	private JTextField telefono;

	private JTextField botonfindtext;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	private TCliente c;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	private JButton botonFind;
	private JButton button;
	private JLabel lblId;

	/**
	 * Create the panel.
	 */
	public panelActualizarCliente() {
		// TODO Auto-generated constructor stub {
		setLayout(null);
		setOpaque(false);
		dni = new JTextField();
		dni.setHorizontalAlignment(SwingConstants.CENTER);
		dni.setColumns(10);
		dni.setBounds(49, 80, 279, 57);
		dni.setVisible(false);
		add(dni);

		label = new JLabel("DNI");
		label.setBounds(386, 101, 46, 14);
		label.setVisible(false);
		add(label);

		nombre = new JTextField();
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setColumns(10);
		nombre.setBounds(49, 148, 279, 57);
		nombre.setVisible(false);
		add(nombre);

		label_1 = new JLabel("Nombre");
		label_1.setBounds(386, 169, 46, 14);
		label_1.setVisible(false);

		add(label_1);

		telefono = new JTextField();
		telefono.setHorizontalAlignment(SwingConstants.CENTER);
		telefono.setColumns(10);
		telefono.setBounds(49, 216, 279, 57);
		telefono.setVisible(false);
		add(telefono);

		label_2 = new JLabel("Telefono");
		label_2.setBounds(386, 237, 75, 14);
		label_2.setVisible(false);
		add(label_2);

		button = new JButton("Actualizar");
		button.setBackground(Color.WHITE);

		button.setBounds(364, 322, 132, 43);
		// add(button);
		add(button);
		button.setVisible(false);
		botonfindtext = new JTextField();
		botonfindtext.setHorizontalAlignment(SwingConstants.CENTER);
		botonfindtext.setBounds(49, 29, 186, 20);
		botonfindtext.setVisible(true);
		add(botonfindtext);
		botonfindtext.setColumns(10);

		botonFind = new JButton("Buscar");
		botonFind.setBackground(Color.WHITE);

		botonFind.setBounds(317, 28, 222, 23);
		botonFind.setVisible(true);
		add(botonFind);

		activoRB = new JRadioButton("Activo");
		inactivoRB = new JRadioButton("Inactivo");
		activoRB.setVisible(false);
		inactivoRB.setVisible(false);
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(84, 322, 109, 23);
		activoRB.setOpaque(false);
		botonFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.ActualizarClienteCommand,
							Integer.valueOf(botonfindtext.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});

		activoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(false);
				activoRB.setSelected(true);
			}
		});
		add(activoRB);

		inactivoRB.setBounds(193, 322, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);

		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(245, 32, 46, 14);
		add(lblId);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
				try {
					if (activoRB.isSelected())
						ok = true;
					c.setDNI(dni.getText());

					c.setNombre(nombre.getText());
					c.setTelefono(Integer.valueOf(telefono.getText()));
					c.setActivo(ok);

					Contexto contexto = new Contexto(Evento.ActualizarClienteCommand, (TCliente) c);
					ApplicationController.getInstance().ejecutar(contexto);

				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		try {
			c = (TCliente) contexto.getDato();
			dni.setText(c.getDNI());
			nombre.setText(c.getNombre());
			telefono.setText(c.getTelefono().toString());
			inactivoRB.setSelected(false);
			activoRB.setSelected(false);
			if (c.getActivo())
				activoRB.setSelected(true);
			else
				inactivoRB.setSelected(true);
			activoRB.setVisible(true);
			inactivoRB.setVisible(true);
			label.setVisible(true);
			label_1.setVisible(true);
			label_2.setVisible(true);
			nombre.setVisible(true);
			botonfindtext.setEditable(true);
			dni.setVisible(true);
			telefono.setVisible(true);
			button.setVisible(true);
			botonFind.setVisible(true);

			repaint();
		}

		catch (Exception ex) {
			dni.setText("");
			nombre.setText("");
			telefono.setText("");

		}

	}

	public void resetCamps() {

		dni.setText(null);
		nombre.setText(null);
		telefono.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
		botonfindtext.setText(null);

	}
}