package Presentación.Competencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Integración.Competencia.TTiene;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelMostrarEmpleadosDeComp extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnMostrarEmpleados;
	private JTextArea textArea;
	private JScrollPane scroll;

	/**
	 * Create the panel.
	 */

	public PanelMostrarEmpleadosDeComp() {
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnMostrarEmpleados = new JButton("Mostrar empleados");
		btnMostrarEmpleados.setBackground(Color.WHITE);
		btnMostrarEmpleados.setBounds(434, 68, 171, 42);
		add(btnMostrarEmpleados);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 72, 339, 35);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("ID de la competencia");
		lblIntroduceElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElId.setBounds(133, 45, 261, 16);
		add(lblIntroduceElId);

		btnMostrarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.MostrarEmpleadosCompetenciaCommand,
							Integer.valueOf(textField.getText()));
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
		ArrayList<TTiene> lista = (ArrayList<TTiene>) contexto.getDato();
		if (!lista.isEmpty()) {
			String s = "Competencia: " + lista.get(0).getCompetencia().getNombre() + "\n";
			for (TTiene e : lista) {
				s += "Empleado: " + e.getEmpleado().getNombre() + "\t" + "Nivel: " + e.getNivel() + "\n";
			}
			textArea.setText(s);
		}
		textArea.setVisible(true);
	}

	public void resetCamps() {
		textField.setText(null);
		textArea.setText(null);

	}

}
