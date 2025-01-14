
package Presentación.Empleado;

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


public class VentanaEmpleadoImp extends VentanaEmpleado {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private panelAñadirEmpleado anadir;
	private panelEliminarEmpleado eliminar;
	private panelActualizarEmpleado actualizar;
	private panelMostrarEmpleadoPorID mID;
	private panelMostrarEmpleados mAll;
	private JButton botonanadir;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonMostrarID;
	private JButton botonMostrarTodo;

	public VentanaEmpleadoImp(){
		
		initComponent();
	}
	
	public void initPanel(){
		
		anadir = new panelAñadirEmpleado();
		eliminar = new panelEliminarEmpleado();
		actualizar = new panelActualizarEmpleado();
		mID = new panelMostrarEmpleadoPorID();
		mAll = new panelMostrarEmpleados();
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
		anadir.setVisible(true);
		paneles.add(anadir);

		eliminar.setVisible(true);
		paneles.add(eliminar);

		actualizar.setVisible(true);
		paneles.add(actualizar);

		mID.setVisible(true);
		paneles.add(mID);

		mAll.setVisible(true);
		paneles.add(mAll);


		botonanadir = new JButton("Añadir empleado");
		botonanadir.setForeground(Color.BLACK);
		botonanadir.setBackground(Color.WHITE);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Add empleado");
				anadir.resetCamps();
				panel2.add(paneles.get(0),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
			


			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("<html>Eliminar <br /> empleado</html>");
		botonEliminar.setForeground(Color.BLACK);
		botonEliminar.setBackground(Color.WHITE);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar empleado");
				eliminar.resetCamps();
				panel2.add(paneles.get(1),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonEliminar);

		botonActualizar = new JButton("<html>Actualizar<br /> empleado</html>");
		botonActualizar.setForeground(Color.BLACK);
		botonActualizar.setBackground(Color.WHITE);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel2.removeAll();
				setTitle("Actualizar empleado");
				actualizar.resetCamps();
				panel2.add(paneles.get(2),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonActualizar);

		botonMostrarID = new JButton("<html>Mostrar empleado<br /> por su ID </html>");
		botonMostrarID.setForeground(Color.BLACK);
		botonMostrarID.setBackground(Color.WHITE);

		botonMostrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar empleados por ID");
				mID.resetCamps();
				panel2.add(paneles.get(3),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarID);

		botonMostrarTodo = new JButton("<html>Mostrar todos<br /> los empleados</html>");
		botonMostrarTodo.setForeground(Color.BLACK);
		botonMostrarTodo.setBackground(Color.WHITE);

		botonMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar todos los empleados ");
				mAll.resetCamps();
				panel2.add(paneles.get(4),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarTodo);
		setLocationRelativeTo(null);
		
	}


	@Override
	public void actualizar(Contexto contexto) {
	
		switch (contexto.getEvento()) {
		case AñadirEmpleadoCommand: JOptionPane.showMessageDialog(null, "Se ha creado el empleado nuevo con id" + contexto.getDato()); break;
		case AñadirEmpleadoCommandError: 
			if ((int)contexto.getDato() ==-2)
				JOptionPane.showMessageDialog(null, "El DNI no es válido");
			else if ((int)contexto.getDato() ==-3)
				JOptionPane.showMessageDialog(null, "El departamento está lleno");
			else if ((int)contexto.getDato() ==-4)
				JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese DNI");
			else if ((int)contexto.getDato() ==-5)
				JOptionPane.showMessageDialog(null, "El departamento está inactivo");
			else if ((int)contexto.getDato() ==-6)
				JOptionPane.showMessageDialog(null, "No se admiten parámetros negativos relacionados con el sueldo");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el empleado"); break;
		case EliminarEmpleadoCommand:JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado con id" +contexto.getDato() + "\n existosamente") ;break;
		case EliminarEmpleadoCommandError: if ( (int)contexto.getDato() ==-2)
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		else if( (int)contexto.getDato()==-1)
			JOptionPane.showMessageDialog(null, "El empleado ya esta inactivo");
		case ActualizarEmpleadoCommand: actualizar.actualizar(contexto); break;
		case ActualizarEmpleadoCommand2Vueta: JOptionPane.showMessageDialog(null,  "El empleado se actualizo correctamente");break;
		case ActualizarEmpleadoCommandError:JOptionPane.showMessageDialog(null,  "Error al actualizar"); break;
		case MostrarEmpleadoCommand: mID.actualizar(contexto); break;
		case MostrarEmpleadoCommandError:JOptionPane.showMessageDialog(null, "No existe el empleado");break;
		case MostrarListaEmpleadoCommand : mAll.actualizar(contexto); break;
		case MostrarListaClienteCommandError: JOptionPane.showMessageDialog(null, "No hay empleado registrados \n en la base de datos");break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {
		
		
	}
}