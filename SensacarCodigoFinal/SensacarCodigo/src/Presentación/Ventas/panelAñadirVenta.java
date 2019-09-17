/**
 * 
 */
package Presentación.Ventas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import Integración.Ventas.TVenta;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.SwingConstants;

public class panelAñadirVenta  extends JPanel implements Ventana{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField iDClienteText;
	private JTextField idModeloText;
	private JTextField cantidadText;
	private JButton botonAbrir;
	private JButton btnConfirmar;
	private JButton botonAñadir;
	private JButton botonEliminar;
	private TVenta venta;
	
	public panelAñadirVenta (){
		setLayout(null);
		setOpaque(false);
		iDClienteText = new JTextField();
		iDClienteText.setHorizontalAlignment(SwingConstants.CENTER);
		iDClienteText.setColumns(10);
		iDClienteText.setBounds(49, 86, 279, 45);
		add(iDClienteText);
		
		JLabel lblIdDeCliente = new JLabel("ID de cliente");
		lblIdDeCliente.setBounds(386, 101, 75, 14);
		add(lblIdDeCliente);
		
		btnConfirmar = new JButton("Cerrar venta");
		btnConfirmar.setBackground(Color.WHITE);
		
		btnConfirmar.setBounds(517, 294, 132, 49);
		add(btnConfirmar);
		
		botonAbrir = new JButton("Abrir venta");
		botonAbrir.setBackground(Color.WHITE);
		
		botonAbrir.setBounds(517, 80, 132, 49);
		add(botonAbrir);
		
		botonAñadir = new JButton("Añadir modelo");
		botonAñadir.setBackground(Color.WHITE);
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ArrayList<Object> lista = new ArrayList<Object>();
				lista.add(Integer.valueOf(idModeloText.getText()));
				lista.add(venta);
				lista.add(Integer.valueOf(cantidadText.getText()));
				Contexto contexto = new Contexto(Evento.AñadirModelosVentaCommand,lista);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}}
		);
		botonAñadir.setBounds(517, 148, 132, 49);
		add(botonAñadir);
		
		botonEliminar = new JButton("Eliminar modelo");
		botonEliminar.setBackground(Color.WHITE);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ArrayList<Object> lista = new ArrayList<Object>();
				lista.add(Integer.valueOf(idModeloText.getText()));
				lista.add(venta);
				Contexto contexto = new Contexto(Evento.EliminarModeloVentaCommand,lista);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		botonEliminar.setBounds(517, 221, 132, 49);
		add(botonEliminar);
		
		idModeloText = new JTextField();
		idModeloText.setHorizontalAlignment(SwingConstants.CENTER);
		idModeloText.setBounds(49, 183, 279, 45);
		add(idModeloText);
		idModeloText.setColumns(10);
		
		cantidadText = new JTextField();
		cantidadText.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadText.setBounds(49, 275, 279, 45);
		add(cantidadText);
		cantidadText.setColumns(10);
		
		JLabel lblIdDeModelo = new JLabel("ID de modelo");
		lblIdDeModelo.setBounds(386, 198, 75, 14);
		add(lblIdDeModelo);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(386, 290, 75, 14);
		add(lblCantidad);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Contexto contexto = new Contexto(Evento.CerrarVentaCommand,venta);
				ApplicationController.getInstance().ejecutar(contexto);
				iDClienteText.setEnabled(true);
				botonAbrir.setEnabled(true);
				botonAñadir.setEnabled(false);
				botonEliminar.setEnabled(false);
				btnConfirmar.setEnabled(false);
				idModeloText.setVisible(false);
				cantidadText.setVisible(false);
				lblCantidad.setVisible(false);
				lblIdDeModelo.setVisible(false);
				iDClienteText.setText("");
				idModeloText.setText("");
				cantidadText.setText("");
				
		
			}
		});
		botonAñadir.setEnabled(false);
		botonEliminar.setEnabled(false);
		btnConfirmar.setEnabled(false);
		idModeloText.setVisible(false);
		cantidadText.setVisible(false);
		lblCantidad.setVisible(false);
		lblIdDeModelo.setVisible(false);
		botonAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Contexto contexto = new Contexto(Evento.AbrirVentaCommand,Integer.valueOf(iDClienteText.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
					;
					iDClienteText.setEnabled(false);
					idModeloText.setVisible(true);
					cantidadText.setVisible(true);
					botonAbrir.setEnabled(false);
					botonAñadir.setEnabled(true);
					botonEliminar.setEnabled(true);
					btnConfirmar.setEnabled(true);
					lblCantidad.setVisible(true);
					lblIdDeModelo.setVisible(true);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
			});
		
	}
	@Override
	public void actualizar(Contexto contexto) {
		venta = (TVenta) contexto.getDato();
		
	}
	@Override
	public void resetCamps() {
		cantidadText.setText(null);
		iDClienteText.setText(null);
		iDClienteText.setEnabled(true);
		idModeloText.setText(null);
		botonAñadir.setEnabled(false);
		botonAbrir.setEnabled(true);
		botonEliminar.setEnabled(false);
		btnConfirmar.setEnabled(false);
		idModeloText.setVisible(false);
		cantidadText.setVisible(false);
		
	}
}