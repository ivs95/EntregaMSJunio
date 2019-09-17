/**
 * 
 */
package Presentación.Modelos;

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

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author nacho710
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VentanaModelosImp extends VentanaModelos {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private panelAñadirModelo anadir;
	private panelEliminarModelo eliminar;
	private panelActualizarModelo actualizar;
	private panelMostrarModeloID mID;
	private panelMostrarTodoModelo mAll;
	private panelQueryModelo query;
	private JButton botonanadir;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonMostrarID;
	private JButton botonMostrarTodo;
	private JButton botonquery;

	public VentanaModelosImp() {

		initComponent();
	}

	public void initPanel() {

		anadir = new panelAñadirModelo();
		eliminar = new panelEliminarModelo();
		actualizar = new panelActualizarModelo();
		mID = new panelMostrarModeloID();
		mAll = new panelMostrarTodoModelo();
		query = new panelQueryModelo();
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

		query.setVisible(true);
		paneles.add(query);

		botonanadir = new JButton("Añadir modelo");
		botonanadir.setForeground(Color.BLACK);
		botonanadir.setBackground(Color.WHITE);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Add modelo");
				anadir.resetCamps();
				panel2.add(paneles.get(0), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("<html>Eliminar modelo</html>");
		botonEliminar.setForeground(Color.BLACK);
		botonEliminar.setBackground(Color.WHITE);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar Modelo");
				panel2.add(paneles.get(1), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonEliminar);

		botonActualizar = new JButton("<html>Actualizar<br /> modelo</html>");
		botonActualizar.setForeground(Color.BLACK);
		botonActualizar.setBackground(Color.WHITE);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel2.removeAll();
				setTitle("Actualizar Modelo");
				actualizar.resetCamps();
				panel2.add(paneles.get(2), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonActualizar);

		botonMostrarID = new JButton("<html>Mostrar modelo<br /> por su ID </html>");
		botonMostrarID.setForeground(Color.BLACK);
		botonMostrarID.setBackground(Color.WHITE);

		botonMostrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar Modelo por ID");
				mID.resetCamps();
				panel2.add(paneles.get(3), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarID);

		botonMostrarTodo = new JButton("<html>Mostrar todos<br /> los modelos</html>");
		botonMostrarTodo.setForeground(Color.BLACK);
		botonMostrarTodo.setBackground(Color.WHITE);

		botonMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar todos los Modelo ");
				mAll.resetCamps();
				panel2.add(paneles.get(4), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarTodo);

		botonquery = new JButton("<html>Query modelo</html>");
		botonquery.setForeground(Color.BLACK);
		botonquery.setBackground(Color.WHITE);

		botonquery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Query modelo");
				panel2.add(paneles.get(5), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonquery);

		setLocationRelativeTo(null);

	}

	@Override
	public void actualizar(Contexto contexto) {

		switch (contexto.getEvento()) {
		case AñadirModeloCommand:
			JOptionPane.showMessageDialog(null, "Se ha creado el producto nuevo con id " + contexto.getDato());
			break;
		case AñadirModeloCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "Ya existe un modelo con ese nombre");
			else if ((int) contexto.getDato() == -3)
				JOptionPane.showMessageDialog(null, "No se puede añadir un modelo con stock negativo");
			else if ((int) contexto.getDato() == -4)
				JOptionPane.showMessageDialog(null, "No se puede añadir un modelo con precio negativo");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el modelo");
			break;
		case EliminarModeloCommand:
			JOptionPane.showMessageDialog(null,
					"Se ha eliminado el modelo con id" + contexto.getDato() + "\n existosamente");
			break;
		case EliminarModeloCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El modelo no existe");
			else if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "El modelo ya esta inactivo");
		case ActualizarModeloCommand:
			actualizar.actualizar(contexto);
			break;
		case ActualizarModeloCommand2Vuelta:
			if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "Error al insertar en la BBDD");

			else if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El precio no puede ser negativo");

			else if ((int) contexto.getDato() == -3)
				JOptionPane.showMessageDialog(null, "El stock no puede ser negativo");

			else
				JOptionPane.showMessageDialog(null, "Modelo actualizado correctamente");
			break;
		case ActualizarModeloCommandError:
			JOptionPane.showMessageDialog(null, "No se ha podido actualizar el modelo");
			break;
		case MostrarModeloCommand:
			mID.actualizar(contexto);
			;
			break;
		case MostrarModeloCommandError:
			JOptionPane.showMessageDialog(null, "No existe el modelo");
			break;
		case MostrarListaModeloCommnad:
			mAll.actualizar(contexto);
			break;
		case MostrarListaModeloCommandError:
			JOptionPane.showMessageDialog(null, "No hay modelos registrados \n en la base de datos");
			break;
		case QueryModeloCommand:
			query.actualizar(contexto);
			break;
		case QueryModeloCommandError:
			JOptionPane.showMessageDialog(null, "No se han encontrado resultados para la query indicada");
			break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {

	}
}