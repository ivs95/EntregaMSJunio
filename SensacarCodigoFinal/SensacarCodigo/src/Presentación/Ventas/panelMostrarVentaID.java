/**
 * 
 */
package Presentación.Ventas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Integración.Cliente.TCliente;
import Integración.Modelos.TCoche;
import Integración.Modelos.TModelo;
import Integración.Modelos.TMoto;
import Integración.Ventas.LineaVenta;
import Integración.Ventas.TVenta;
import Negocio.Ventas.TDetallesVenta;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Color;
/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class panelMostrarVentaID extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private TVenta venta;
	private JTextArea textArea;
	private JTextArea textAreadetalles;
	private JScrollPane scrolldetalles;
	private JTextArea textAreadetalles2;
	private JButton btnMostrarDetalles;
	private JLabel lblVenta;
	private JLabel lblIdDeLa;

	public panelMostrarVentaID() {
		setLayout(null);
		setOpaque(false);
		JButton btnBuscarVenta = new JButton("Buscar venta");
		btnBuscarVenta.setBackground(Color.WHITE);
		btnBuscarVenta.setBounds(434, 54, 141, 23);
		add(btnBuscarVenta);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(28, 54, 141, 23);
		add(textField);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setVisible(true);
	    scroll.setBounds(28, 117, 242, 269);
	    add(scroll);
	    
	    textAreadetalles = new JTextArea();
		scrolldetalles = new JScrollPane(textAreadetalles);
	    scrolldetalles.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrolldetalles.setVisible(true);
	    scrolldetalles.setBounds(494, 153, 204, 233);
	    add(scrolldetalles);
	    
	    textAreadetalles2 = new JTextArea();
		JScrollPane scrolldetalles2 = new JScrollPane(textAreadetalles2);
	    scrolldetalles2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrolldetalles2.setVisible(true);
	    scrolldetalles2.setBounds(280, 153, 204, 233);
	    add(scrolldetalles2);
	    
	    textArea.setVisible(false);
	    textArea.setEditable(false);
	    
	    btnMostrarDetalles = new JButton("Mostrar Detalles");
	    btnMostrarDetalles.setBackground(Color.WHITE);
	    btnMostrarDetalles.setBounds(365, 90, 242, 23);
	    add(btnMostrarDetalles);
	    
	    textAreadetalles.setVisible(false);
	    textAreadetalles.setEditable(false);
	    textAreadetalles2.setVisible(false);
	    textAreadetalles2.setEditable(false);
	    btnMostrarDetalles.setEnabled(false);
	    
	    JLabel lblModelos = new JLabel("Modelos");
	    lblModelos.setBounds(365, 128, 59, 14);
	    add(lblModelos);
	    
	    JLabel lblCliente = new JLabel("Cliente");
	    lblCliente.setBounds(566, 128, 46, 14);
	    add(lblCliente);
	    
	    lblVenta = new JLabel("Venta");
	    lblVenta.setBounds(107, 92, 46, 14);
	    add(lblVenta);
	    
	    lblIdDeLa = new JLabel("ID de la venta");
	    lblIdDeLa.setBounds(192, 58, 92, 14);
	    add(lblIdDeLa);
	    
		btnBuscarVenta.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				Contexto contexto = new Contexto(Evento.MostrarVentasCommand,Integer.valueOf(textField.getText()));
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
				
			}
		});
		
		btnMostrarDetalles.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				Contexto contexto = new Contexto(Evento.ObtenerDetallesVentaCommand,Integer.valueOf(textField.getText()));
				ApplicationController.getInstance().ejecutar(contexto);
			}catch(NumberFormatException x){
				JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
			}
			}
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		btnMostrarDetalles.setEnabled(true);
		textArea.setVisible(true);
		venta= (TVenta) contexto.getDato();
			String s = "";
			int i = 1;
		s = "ID de Cliente:	" + venta.getIdCliente() + "\n" + "Fecha:	"+ venta.getFecha() + "\n";
		for(LineaVenta l: venta.getLineasVenta().values()){
			
			s += "Articulo "+i +"\n" + "	ID: "+ l.getIdArticulo() +"\n"+ "	Cantidad: "+ l.getCantidad()+"\n"+"	PrecioTotal: "+ l.getPrecioTotal() + "\n\n";
			i++;
		}
			s+= "Precio Total:		"+ venta.getPrecioTotal()+"\n" ;
			String activo="Activo";
			if(!venta.isActivo()) activo = "Inactivo";
				
			s+="Estado:		"+ activo ;
		textArea.setText(s);
		
		
	}
	public void CompletarDetalles(Contexto contexto){
		
			textAreadetalles.setVisible(true);
			textAreadetalles2.setVisible(true);
			TDetallesVenta detalles = (TDetallesVenta) contexto.getDato();
			TCliente c = detalles.getCliente();
				String s1 = "";
				String s2= "";
				if(c.getActivo().toString()== "true")
					s2= "activo";
				else s2= "no activo";
				textAreadetalles.setText("DNI:	"+ c.getDNI() + "\n" + "Nombre:	" +c.getNombre() +"\n" + "Nº de Telefono:	"+c.getTelefono() + "\n" + "Estado:	"+s2+  "\n" );
				
				ArrayList<TModelo> modelos = (ArrayList<TModelo>) detalles.getModelos();
				
				for(TModelo m : modelos){
					
				
				s1+= "ID:	"+ m.getID() + "\n"+ "Nombre: 	" + m.getNombre() +"\n"+ "Precio:	"+m.getPrecio() +"\n"+ "Stock:	"+ m.getStock() + "\n" +
						"Tipo:	" + m.getTipoVehiculo() + "\n";
						if (m.getTipoVehiculo().toLowerCase() == "coche"){
							TCoche co = (TCoche)m;
							s1+="Nº de puertas:	" + co.getNumPuertas()+ "\n" ;
						}
						else{
							TMoto co = (TMoto)m;
							s1+="Cilindrada:	" + co.getCilindrada()+ "\n";
						}
						String a="";
						if(m.getActivo()== true)
							a= "Activo";
						else a= "No activo";
						s1+= "Estado:	"+ a +"\n\n";	
				
				}
				textAreadetalles2.setText(s1);
			}
	

	@Override
	public void resetCamps() {
		this.textArea.setText(null);
		this.textAreadetalles.setText(null);
		this.textAreadetalles2.setText(null);
		this.textField.setText(null);
		this.btnMostrarDetalles.setEnabled(false);
		// TODO Auto-generated method stub
		
	}
}