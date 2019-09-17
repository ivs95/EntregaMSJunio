
package Presentación.Departamento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Presentación.Comandos.Contexto;

public class VentanaDepartamentoImp extends VentanaDepartamento {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelAñadirDep anadir;
	private PanelEliminarDep eliminar;

	private PanelLeerDep mID;
	private panelCalcularNomina nom;

	private JButton botonanadir;
	private JButton botonEliminar;

	private JButton botonMostrarID;
	private JButton botonNom;

	public VentanaDepartamentoImp() {
		setResizable(false);

		initComponent();
	}

	public void initPanel() {

		anadir = new PanelAñadirDep();
		eliminar = new PanelEliminarDep();
		mID = new PanelLeerDep();
		nom = new panelCalcularNomina();
		contentPane = new JPanel();

	}

	public void initComponent() {
		initPanel();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 598);

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 731, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBounds(0, 93, 731, 476);
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		ArrayList<JPanel> paneles = new ArrayList<JPanel>();
		anadir.setVisible(true);
		paneles.add(anadir);

		eliminar.setVisible(true);
		paneles.add(eliminar);

		mID.setVisible(true);
		paneles.add(mID);
		nom.setVisible(true);
		paneles.add(nom);

		botonanadir = new JButton("Añadir departamento");
		botonanadir.setForeground(Color.BLACK);
		botonanadir.setBackground(Color.WHITE);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Añadir departamento");
				anadir.resetCamps();
				panel2.add(paneles.get(0), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("<html>Eliminar <br /> departamento</html>");
		botonEliminar.setForeground(Color.BLACK);
		botonEliminar.setBackground(Color.WHITE);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar departamento");
				eliminar.resetCamps();
				panel2.add(paneles.get(1), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonEliminar);

		botonMostrarID = new JButton("<html>Mostrar departamento<br /> por su ID </html>");
		botonMostrarID.setForeground(Color.BLACK);
		botonMostrarID.setBackground(Color.WHITE);

		botonMostrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar departamento por ID");
				mID.resetCamps();
				panel2.add(paneles.get(2), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarID);

		botonNom = new JButton("<html>Calcular nómina<br /> de departamento </html>");
		botonNom.setForeground(Color.BLACK);
		botonNom.setBackground(Color.WHITE);

		botonNom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Calcular Nomina");
				nom.resetCamps();
				panel2.add(paneles.get(3), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonNom);

		setLocationRelativeTo(null);

	}

	@Override
	public void actualizar(Contexto contexto) {

		switch (contexto.getEvento()) {
		case AñadirDepartamentoCommand:
			JOptionPane.showMessageDialog(null, "Se ha creado el departamento nuevo con id " + contexto.getDato());
			break;
		case AñadirDepartamentoCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El DNI introducido ya existe");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el departamento");
			break;
		case EliminarDepartamentoCommand:
			JOptionPane.showMessageDialog(null,
					"Se ha eliminado el departamento con id " + contexto.getDato() + "\n ");
			break;
		case EliminarDepartamentoCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El departamento no existe");
			else if ((int) contexto.getDato() == -3)
				JOptionPane.showMessageDialog(null, "El departamento tiene empleados activos");
			else if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "El departamento ya esta inactivo");
			break;
		case LeerDepartamentoCommand:
			mID.actualizar(contexto);
			break;
		case LeerDepartamentoCommandError:
			JOptionPane.showMessageDialog(null, "No existe el departamento");
			break;

		case CalcularNominaCommand:
			JOptionPane.showMessageDialog(null, "La suma de la nomina de los empleados es de " + (int)contexto.getDato() + " al mes");

				/*nom.actualizar(contexto);*/
			break;
		case CalcularNominaCommandError:
			if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "Departamento inactivo");
			else
				JOptionPane.showMessageDialog(null, "No existe el departamento");
			break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {

	}
}