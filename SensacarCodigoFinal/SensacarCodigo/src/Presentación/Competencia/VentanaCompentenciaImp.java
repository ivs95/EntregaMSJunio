package Presentación.Competencia;

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


public class VentanaCompentenciaImp extends VentanaCompetencia {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelCrearComp crear;
	private PanelAsginarComp add;
	private PanelDesasignarComp quitar;
	private PanelActulizarComp actualizar;
	private PanelBorrarComp borrar;
	private PanelMostrarEmpleadosDeComp mostrar;

	private JButton botonacrear;
	private JButton botonAdd;
	private JButton botonQuitar;
	private JButton botonActualizar;
	private JButton botonBorrar;
	private JButton botonMostrar;

	public VentanaCompentenciaImp() {

		initComponent();
	}

	public void initPanel() {

		crear = new PanelCrearComp();
		borrar = new PanelBorrarComp();
		add = new PanelAsginarComp();
		quitar = new PanelDesasignarComp();

		actualizar = new PanelActulizarComp();
		mostrar = new PanelMostrarEmpleadosDeComp();

		contentPane = new JPanel();

	}

	public void initComponent() {
		initPanel();

		setResizable(false);
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
		crear.setVisible(true);
		paneles.add(crear);

		add.setVisible(true);
		paneles.add(add);

		quitar.setVisible(true);
		paneles.add(quitar);

		actualizar.setVisible(true);
		paneles.add(actualizar);

		borrar.setVisible(true);
		paneles.add(borrar);
		mostrar.setVisible(true);
		paneles.add(mostrar);

		botonacrear = new JButton("<html>Crear<br /> competencia</html>");
		botonacrear.setForeground(Color.BLACK);
		botonacrear.setBackground(Color.WHITE);

		botonacrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Crear competencia");
				crear.resetCamps();
				panel2.add(paneles.get(0), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonacrear);

		botonAdd = new JButton("<html>Asignar competencia <br /> a empleado</html>");
		botonAdd.setForeground(Color.BLACK);
		botonAdd.setBackground(Color.WHITE);
		botonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Asignar compentencia");
				panel2.add(paneles.get(1), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});

		botonBorrar = new JButton("<html>Eliminar<br /> competencia</html>");
		botonBorrar.setForeground(Color.BLACK);
		botonBorrar.setBackground(Color.WHITE);

		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar Compentecia");
				actualizar.resetCamps();
				panel2.add(paneles.get(4), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonBorrar);
		panel_1.add(botonAdd);

		botonQuitar = new JButton("<html>Desasignar competencia <br /> a empleado</html>");
		botonQuitar.setForeground(Color.BLACK);
		botonQuitar.setBackground(Color.WHITE);
		botonQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel2.removeAll();
				setTitle("Desasignar competencia");
				quitar.resetCamps();
				panel2.add(paneles.get(2), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonQuitar);

		botonActualizar = new JButton("<html>Actualizar competencia <br /> de empleado</html>");
		botonActualizar.setForeground(Color.BLACK);
		botonActualizar.setBackground(Color.WHITE);

		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Actualizar compentencia");
				actualizar.resetCamps();
				panel2.add(paneles.get(3), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonActualizar);

		botonMostrar = new JButton("<html>Mostrar empleados<br /> de competencia</html>");
		botonMostrar.setForeground(Color.BLACK);
		botonMostrar.setBackground(Color.WHITE);

		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar empleados");
				actualizar.resetCamps();
				panel2.add(paneles.get(5), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrar);

		setLocationRelativeTo(null);

	}

	@Override
	public void actualizar(Contexto contexto) {

		switch (contexto.getEvento()) {
		case CrearCompetenciaCommmand:
			JOptionPane.showMessageDialog(null, "Se ha creado la competencia con el id " + contexto.getDato());
			break;
		case CrearCompetenciaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "Ya existe una competencia activa con ese nombre");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido crear la competencia");
			break;
		case AñadirCompetenciaCommand:
			JOptionPane.showMessageDialog(null, "Se ha asignado la competencia correctamente");
			break;
		case AñadirCompetenciaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El nivel no puede ser negativo");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido añadir la competencia al empleado");
			break;
		case EliminarCompetenciaCommand:
			JOptionPane.showMessageDialog(null, "Se ha eliminado la competencia con id " + contexto.getDato());
			break;
		case EliminarCompetenciaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "La competencia tiene empleados activos");
			else
				JOptionPane.showMessageDialog(null, "La competencia no existe");
			break;
		case DesasignarCompetenciaCommand:
			JOptionPane.showMessageDialog(null, "Se ha desasignado la competencia exitosamente");
			break;
		case DesasignarCompetenciaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El id de empleado no existe");
			else
				JOptionPane.showMessageDialog(null, "EL id de competencia no existe");
			break;
		case ActualizarCompetenciaCommand:
			JOptionPane.showMessageDialog(null, "Competencia actualizada correctamente");
			break;
		case ActualizarCompetenciaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El nivel no puede ser negativo");
			else
			JOptionPane.showMessageDialog(null, "No se ha podido actualizar la competencia");
			break;
		case MostrarEmpleadosCompetenciaCommand:
			mostrar.actualizar(contexto);
			break;
		case MostrarEmpleadosCompetenciaCommandError:
			JOptionPane.showMessageDialog(null, "No existe la competencia");
			break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {

	}
}