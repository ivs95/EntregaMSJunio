
package Presentación.Empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integración.Empleado.TEmpleado;
import Integración.Empleado.TEmpleadoCompleto;
import Integración.Empleado.TEmpleadoParcial;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;

public class panelMostrarEmpleados extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;

	public panelMostrarEmpleados() {
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Ver los empleados");
		button.setBackground(Color.WHITE);
		button.setBounds(208, 36, 262, 57);
		add(button);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contexto contexto = new Contexto(Evento.MostrarListaEmpleadoCommand, null);
				ApplicationController.getInstance().ejecutar(contexto);
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		String s;
		ArrayList<TEmpleado> array = (ArrayList<TEmpleado>) contexto.getDato();
		String text = "";
		for (TEmpleado c : array) {
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";

			text += "ID: " + c.getID() + "\n" + "DNI: " + c.getDNI() + "\n" + "Nombre: " + c.getNombre() + "\n"
					+ "Estado: " + s + "\n" + "Departamento " + c.getDepartamento() + "\n";
			if (c instanceof TEmpleadoCompleto) {
				text += "Dietas : " + ((TEmpleadoCompleto) c).getDietas() + "\n";
				text += "Sueldo base : " + ((TEmpleadoCompleto) c).getDietas() + "\n";
			} else {
				text += "Horas / Semana : " + ((TEmpleadoParcial) c).getHorasSemana() + "\n";
				text += "Sueldo / Hora : " + ((TEmpleadoParcial) c).getSueldoHora() + "\n\n\n";
			}

		}
		textArea.setText(text);

	}

	public void resetCamps() {
		//initComponent();
	}
}