
package Presentación.Empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.SwingConstants;


public class panelEliminarEmpleado extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;

	public panelEliminarEmpleado() {
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(209, 135, 300, 35);
		add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Eliminar empleado");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.EliminarEmpleadoCommand,
							Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}

			}
		});
		btnNewButton.setBounds(212, 205, 250, 42);
		add(btnNewButton);

		JLabel lblIntroduceElId = new JLabel("ID empleado");
		lblIntroduceElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElId.setBounds(32, 144, 131, 16);
		add(lblIntroduceElId);
	}

	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();

	}

	public void resetCamps() {
		textField.setText(null);
	}
}