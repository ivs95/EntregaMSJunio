/**
 * 
 */
package Presentación.Departamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class PanelEliminarDep extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public PanelEliminarDep() {
		initComponent();

	}

	public void initComponent() {

		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(125, 139, 231, 45);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.EliminarDepartamentoCommand,
							Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		btnNewButton.setBounds(125, 289, 174, 66);
		add(btnNewButton);

		JLabel lblIdDelDepartamento = new JLabel("ID del departamento");
		lblIdDelDepartamento.setBounds(397, 154, 135, 14);
		add(lblIdDelDepartamento);

	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetCamps() {
		textField.setText(null);
	}
}