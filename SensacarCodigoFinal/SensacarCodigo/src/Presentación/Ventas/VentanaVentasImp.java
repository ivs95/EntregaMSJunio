package Presentación.Ventas;

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

import Integración.Transaction.TransactionManager;
import Integración.Ventas.TVenta;
import Presentación.Comandos.Contexto;

public class VentanaVentasImp extends VentanaVentas {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private panelAñadirVenta anadir;
	private panelEliminarVenta eliminar;
	private panelDevolucionVenta actualizar;
	private panelMostrarVentaID mID;
	private panelMostrarTodoVenta mAll;
	private JButton botonanadir;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonMostrarID;
	private JButton botonMostrarTodo;

	public VentanaVentasImp() {

		initComponent();
	}

	public void initPanel() {

		anadir = new panelAñadirVenta();
		eliminar = new panelEliminarVenta();
		actualizar = new panelDevolucionVenta();
		mID = new panelMostrarVentaID();
		mAll = new panelMostrarTodoVenta();
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

		botonanadir = new JButton("Crear venta");
		botonanadir.setForeground(Color.BLACK);
		botonanadir.setBackground(Color.WHITE);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				anadir.resetCamps();
				setTitle("Crear venta");
				panel2.add(paneles.get(0), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("Eliminar venta");
		botonEliminar.setForeground(Color.BLACK);
		botonEliminar.setBackground(Color.WHITE);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar venta");
				panel2.add(paneles.get(1), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonEliminar);

		botonActualizar = new JButton("Devolver venta");
		botonActualizar.setForeground(Color.BLACK);
		botonActualizar.setBackground(Color.WHITE);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel2.removeAll();
				setTitle("Devolver venta");
				actualizar.resetCamps();
				panel2.add(paneles.get(2), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());

			}
		});
		panel_1.add(botonActualizar);

		botonMostrarID = new JButton("<html>Mostrar venta<br /> por su ID </html>");
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

		botonMostrarTodo = new JButton("<html>Mostrar todas<br /> las ventas</html>");
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
		setLocationRelativeTo(null);

	}

	@Override
	public void actualizar(Contexto contexto) {

		switch (contexto.getEvento()) {
		case AbrirVentaCommand:
			anadir.actualizar(contexto);
			JOptionPane.showMessageDialog(null,
					"Se ha abierto la venta para el cliente con id: " + ((TVenta) contexto.getDato()).getIdCliente());
			break;
		case CrearVentaCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El producto introducido ya existe");
			else
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el modelo");
			break;
		case AñadirModelosVentaCommand:
			JOptionPane.showMessageDialog(null, "Modelo añadido correctamente");
			anadir.actualizar(contexto);
			break;
		case AñadirModelosVentaCommandError:
			JOptionPane.showMessageDialog(null, "No se ha podido añadir el modelo ");
			break;
		case EliminarModeloVentaCommand:
			JOptionPane.showMessageDialog(null, "Modelo eliminado correctamente");
			anadir.actualizar(contexto);
			break;
		case EliminarModelosVentaCommandError:
			JOptionPane.showMessageDialog(null, "No se ha podido añadir el modelo ");
			break;
		case DevolverVentasCommand:
			JOptionPane.showMessageDialog(null, "Se ha devuelto la venta con id " + contexto.getDato() + "\n");
			break;
		case DevolverVentaCommandError:

			if ((int) contexto.getDato() == -7)
				JOptionPane.showMessageDialog(null, "La venta esta inactiva");
			else if ((int) contexto.getDato() == -6)
				JOptionPane.showMessageDialog(null, "La venta no existe");
			else if ((int) contexto.getDato() == -5)
				JOptionPane.showMessageDialog(null, "El modelo no existe");
			else if ((int) contexto.getDato() == -4)
				JOptionPane.showMessageDialog(null, "El modelo no se encontraba en la venta");
			else if ((int) contexto.getDato() == -3)
				JOptionPane.showMessageDialog(null, "La cantidad no puede ser mayor a la vendida");
			else if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "La venta ya esta devuelta");
			break;
		case EliminarVentasCommand:
			JOptionPane.showMessageDialog(null, "Se ha eliminado la venta con id " + contexto.getDato() + "\n");
			break;
		case EliminarVentasCommandError:
			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "La venta no existe");
			else if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "La venta ya esta eliminada");
			;
			break;
		case MostrarVentasCommand:
			mID.actualizar(contexto);
			break;
		case MostrarVentasCommandError:
			JOptionPane.showMessageDialog(null, "No existe la venta");
			break;
		case ObtenerDetallesVentaCommand:
			mID.CompletarDetalles(contexto);
			break;
		case ObtenerDetallesVentaCommandError:
			JOptionPane.showMessageDialog(null, "La venta esta inactiva");
			break;
		case CerrarVentaCommand:
			JOptionPane.showMessageDialog(null,
					"La venta se cerró correctamente con el id " + (int) contexto.getDato());
			break;
		case CerrarVentaCommandError:
			if ((int) contexto.getDato() == -1) {
				JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos");
			} else if ((int) contexto.getDato() == -2) {
				JOptionPane.showMessageDialog(null, "Cantidad superior al stock en alguno de los modelos");
			} else if ((int) contexto.getDato() == -3) {
				JOptionPane.showMessageDialog(null, "Algún modelo se encuentra inactivo");
			} else if ((int) contexto.getDato() == -4) {
				JOptionPane.showMessageDialog(null, "Algún modelo introducido no existe");
			} else if ((int) contexto.getDato() == -5) {
				JOptionPane.showMessageDialog(null, "El cliente no es valido");
			} else
				JOptionPane.showMessageDialog(null, "La venta está vacía");
			break;

		case MostrarListaVentasCommand:
			mAll.actualizar(contexto);
			break;
		case MostrarListaVentasCommandError:
			JOptionPane.showMessageDialog(null, "No hay ventas activas en la base de datos");
			break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {

	}
}