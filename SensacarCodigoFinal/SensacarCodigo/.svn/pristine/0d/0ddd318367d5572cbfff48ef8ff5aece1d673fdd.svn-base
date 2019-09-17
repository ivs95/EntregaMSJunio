
package Presentación.Modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class panelEliminarModelo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public panelEliminarModelo() {
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(125, 126, 295, 45);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.EliminarModeloCommand,
							Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		btnNewButton.setBounds(196, 256, 174, 66);
		add(btnNewButton);

		JLabel lblIdDelModelo = new JLabel("ID del modelo");
		lblIdDelModelo.setBounds(460, 141, 113, 14);
		add(lblIdDelModelo);

	}
}