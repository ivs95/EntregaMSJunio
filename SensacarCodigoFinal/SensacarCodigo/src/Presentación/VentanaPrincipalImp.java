
package Presentación;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaPrincipalImp extends VentanaPrincipal {
	private static final long serialVersionUID = 1L;
	private JButton btnClientes;
	private JButton btnCompetencia;
	private JButton btnDepartamento;
	private JButton btnModelo;
	private JButton btnEmpleado;
	private JButton btnVentas;

	public VentanaPrincipalImp() {
		initComponent();
	}

	public void initComponent() {

		setResizable(false);
		setBounds(100, 100, 678, 486);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SensaCar");
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(Color.LIGHT_GRAY);
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.crearVentanaCliente, null);
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().setLayout(new GridLayout(7, 1, 0, 0));
		getContentPane().add(btnClientes);

		btnCompetencia = new JButton("Competencia");
		btnCompetencia.setBackground(Color.LIGHT_GRAY);
		btnCompetencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.crearVentanaCompetencia, null);
					ApplicationController.getInstance().ejecutar(contexto);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnEmpleado = new JButton("Empleado");
		btnEmpleado.setBackground(Color.LIGHT_GRAY);
		btnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.crearVentanaEmpleado, null);
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnDepartamento = new JButton("Departamento");
		btnDepartamento.setBackground(Color.LIGHT_GRAY);
		btnDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Contexto contexto = new Contexto(Evento.crearVentanaDepartamento, null);
					ApplicationController.getInstance().ejecutar(contexto);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnVentas = new JButton("Ventas");
		btnVentas.setBackground(Color.LIGHT_GRAY);
		btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVentas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contexto contexto = new Contexto(Evento.crearVentanaVentas, null);
				ApplicationController.getInstance().ejecutar(contexto);

			}
		});

		btnModelo = new JButton("Modelo");
		btnModelo.setBackground(Color.LIGHT_GRAY);
		btnModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.crearVentanaModelo, null);
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnModelo);
		getContentPane().add(btnVentas);

		JButton btnTitulo = new JButton("SensaCar");
		btnTitulo.setOpaque(true);
		btnTitulo.setForeground(Color.WHITE);
		btnTitulo.setBackground(Color.BLACK);
		btnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		btnTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));	
		btnTitulo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Trabajo realizado por: \n \n  -   Ignacio Baena Kuroda \n  -   Ignacio Vítores Sancho \n -    Cristóbal Saraiba Torres");

				
			}
			
		});
		getContentPane().add(btnTitulo);
		getContentPane().add(btnDepartamento);
		getContentPane().add(btnEmpleado);
		getContentPane().add(btnCompetencia);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actualizar(Contexto contexto) {

	}

	@Override
	public void resetCamps() {
		// TODO Auto-generated method stub

	}
}