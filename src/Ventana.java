import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	JPanel contenido = new JPanel();
	
	public Ventana() {
		this.setVisible(true);
		this.setSize(900, 550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("GYM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel barra_lateral = new JPanel();
		barra_lateral.setSize(250, 550);
		barra_lateral.setLocation(0, 0);
		barra_lateral.setBackground(Color.decode("#713587"));
		barra_lateral.setLayout(null);
		this.add(barra_lateral);
		
		
		contenido.setSize(650, 550);
		contenido.setLocation(250, 0);
		contenido.setBackground(Color.decode("#EEE5DA"));
		contenido.setLayout(null);
		this.add(contenido);
		
		JButton btn_Clientes = new JButton ("Clientes");
		btn_Clientes.setSize(150,40);
		btn_Clientes.setLocation(50,230);
		btn_Clientes.setFont(new Font("Arial", Font.BOLD, 23));
		barra_lateral.add(btn_Clientes);
		
		JButton btn_Tarifas = new JButton ("Tarifas");
		btn_Tarifas.setSize(150,40);
		btn_Tarifas.setLocation(50,300);
		btn_Tarifas.setFont(new Font("Arial", Font.BOLD, 23));
		barra_lateral.add(btn_Tarifas);
		
		btn_Tarifas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Tarifas();
				contenido.revalidate();
				contenido.repaint();
			}
		});
		
		JButton btn_Checador = new JButton ("Checador");
		btn_Checador.setSize(150,40);
		btn_Checador.setLocation(50,370);
		btn_Checador.setFont(new Font("Arial", Font.BOLD, 23));
		barra_lateral.add(btn_Checador);
		
		JButton btn_CerrarSesion = new JButton ("Cerrar Sesión");
		btn_CerrarSesion.setSize(150,40);
		btn_CerrarSesion.setLocation(50,440);
		btn_CerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
		barra_lateral.add(btn_CerrarSesion);
		
		ImageIcon foto = new ImageIcon("logogym.png");
		JLabel icono = new JLabel();
		icono.setSize(100,100);
		icono.setLocation(75,60);
		icono.setIcon(new ImageIcon(foto.getImage().getScaledInstance(icono.getWidth(), icono.getHeight(), Image.SCALE_SMOOTH)));
		barra_lateral.add(icono);
		
		this.revalidate();
		this.repaint();
	}
	
	public void panel_Tarifas() {
		JButton btn_Consultar = new JButton ("Consultar");
		btn_Consultar.setSize(150,40);
		btn_Consultar.setLocation(100,300);
		btn_Consultar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Consultar);
		
		JButton btn_Crear = new JButton ("Crear");
		btn_Crear.setSize(150,40);
		btn_Crear.setLocation(400,300);
		btn_Crear.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Crear);
		
		JButton btn_Editar = new JButton ("Editar");
		btn_Editar.setSize(150,40);
		btn_Editar.setLocation(100,440);
		btn_Editar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Editar);
		
		JButton btn_Eliminar = new JButton ("Eliminar");
		btn_Eliminar.setSize(150,40);
		btn_Eliminar.setLocation(400,440);
		btn_Eliminar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Eliminar);
	}
}
