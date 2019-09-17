package Presentación.Competencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanelActulizarComp extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;


	private JTextField idEmpText;
	private JTextField idCompText;
	private JTextField nivelText;

	
	public PanelActulizarComp(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		idEmpText = new JTextField();
		idEmpText.setHorizontalAlignment(SwingConstants.CENTER);
		idEmpText.setColumns(10);
		idEmpText.setBounds(208, 91, 279, 35);
		add(idEmpText);

		JLabel label = new JLabel("ID empleado");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(37, 101, 137, 14);
		add(label);

		idCompText = new JTextField();
		idCompText.setHorizontalAlignment(SwingConstants.CENTER);
		idCompText.setColumns(10);
		idCompText.setBounds(208, 159, 279, 35);
		add(idCompText);

		JLabel lblIdCompetencia = new JLabel("ID competencia");
		lblIdCompetencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCompetencia.setBounds(37, 169, 137, 14);
		add(lblIdCompetencia);

		nivelText = new JTextField();
		nivelText.setHorizontalAlignment(SwingConstants.CENTER);
		nivelText.setColumns(10);
		nivelText.setBounds(208, 227, 279, 35);
		add(nivelText);

		JLabel label_2 = new JLabel("Nivel");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(37, 237, 137, 14);
		add(label_2);

		
			
		JButton button = new JButton("Actualizar");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ArrayList<Object> lista = new ArrayList<Object>();
				lista.add(Integer.valueOf(idEmpText.getText()));
				lista.add(Integer.valueOf(idCompText.getText()));
				lista.add(Integer.valueOf(nivelText.getText()))	;
				Contexto contexto = new Contexto(Evento.ActualizarCompetenciaCommand, lista);
				ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});
		button.setBounds(271, 307, 132, 40);
		add(button);
	
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		idEmpText.setText(null);
		idCompText.setText(null);
		nivelText.setText(null);
	}

}