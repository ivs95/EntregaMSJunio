
package Presentación.Cliente;

import javax.swing.JPanel;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Integración.Cliente.TCliente;
import Integración.Query.TQuery;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.sql.Date;
import java.awt.Color;
import javax.swing.SwingConstants;

public class panelQueryCliente extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fechaText;
	private JTextField ventasText;
	private JTextArea textArea;

	public panelQueryCliente() {
		initComponent();
	}
	
	public void initComponent(){
		setLayout(null);
		setOpaque(false);
		fechaText = new JTextField();
		fechaText.setHorizontalAlignment(SwingConstants.CENTER);
		fechaText.setBounds(66, 51, 265, 59);
		add(fechaText);

		ventasText = new JTextField();
		ventasText.setHorizontalAlignment(SwingConstants.CENTER);
		ventasText.setBounds(66, 145, 265, 59);
		add(ventasText);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(518, 51, 99, 59);
		add(btnNewButton);

		JLabel lblFecha = new JLabel("Fecha (yyyy-mm-dd)");
		lblFecha.setBounds(374, 73, 124, 14);
		add(lblFecha);

		JLabel lblNDeVentas = new JLabel("N\u00BA de ventas");
		lblNDeVentas.setBounds(374, 167, 72, 14);
		add(lblNDeVentas);
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(66, 237, 432, 167);
		add(scroll);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					java.sql.Date d = Date.valueOf(fechaText.getText());
					TQuery query = new TQuery(Integer.valueOf(ventasText.getText()), d);
					Contexto contexto = new Contexto(Evento.QueryClienteCommand, query);
					ApplicationController.getInstance().ejecutar(contexto);
				}
				catch(IllegalArgumentException x) {
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		ArrayList<TCliente> array = (ArrayList<TCliente>) contexto.getDato();
		String texto = "";
		for (TCliente c : array) {
			String s = null;
			if (c.getActivo().toString() == "true")
				s = "activo";
			else
				s = "no activo";
			texto = texto + "ID:		" + c.getId() + "\n" + "DNI:		" + c.getDNI() + "\n" + "Nombre:		"
					+ c.getNombre() + "\n" + "Nº de Telefono:		" + c.getTelefono() + "\n" + "Estado:		" + s
					+ "\n\n";

		}
		textArea.setText(texto);
	}

	@Override
	public void resetCamps() {
		fechaText.setText(null);
		ventasText.setText(null);
		this.textArea.setText(null);

	}
}