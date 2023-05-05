import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	JPanel padre = new JPanel();
	JPanel contenido = new JPanel();
	JPanel barra_lateral = new JPanel();
	String[] datos = null;

	public Ventana() {
		this.setVisible(true);
		this.setSize(900, 550);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("GYM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		padre = panel_Login();
		this.add(padre);

		barra_lateral.setSize(250, 550);
		barra_lateral.setLocation(0, 0);
		barra_lateral.setBackground(Color.decode("#713587"));
		barra_lateral.setLayout(null);

		contenido.setSize(650, 550);
		contenido.setLocation(250, 0);
		contenido.setBackground(Color.decode("#EEE5DA"));
		contenido.setLayout(null);

		JButton btn_Clientes = new JButton("Clientes");
		btn_Clientes.setSize(150, 40);
		btn_Clientes.setLocation(50, 230);
		btn_Clientes.setFont(new Font("Arial", Font.BOLD, 23));
		barra_lateral.add(btn_Clientes);

		JButton btn_Tarifas = new JButton("Tarifas");
		btn_Tarifas.setSize(150, 40);
		btn_Tarifas.setLocation(50, 300);
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

		JButton btn_Checador = new JButton("Checador");
		btn_Checador.setSize(150, 40);
		btn_Checador.setLocation(50, 370);
		btn_Checador.setFont(new Font("Arial", Font.BOLD, 23));
		barra_lateral.add(btn_Checador);

		JButton btn_CerrarSesion = new JButton("Cerrar Sesión");
		btn_CerrarSesion.setSize(150, 40);
		btn_CerrarSesion.setLocation(50, 440);
		btn_CerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
		barra_lateral.add(btn_CerrarSesion);

		ImageIcon foto = new ImageIcon("logogym.png");
		JLabel icono = new JLabel();
		icono.setSize(100, 100);
		icono.setLocation(75, 60);
		icono.setIcon(new ImageIcon(
				foto.getImage().getScaledInstance(icono.getWidth(), icono.getHeight(), Image.SCALE_SMOOTH)));
		barra_lateral.add(icono);

		this.revalidate();
		this.repaint();
	}

	public JPanel panel_Login() {
		JPanel login = new JPanel();
		login.setVisible(true);
		login.setSize(900, 550);
		login.setLocation(0, 0);
		login.setBackground(Color.decode("#EEE5DA"));
		login.setLayout(null);

		JLabel userName = new JLabel("Ingresa tu nombre: ");
		userName.setSize(200, 20);
		userName.setLocation(140, 120);
		userName.setFont(new Font("Arial", Font.BOLD, 20));
		login.add(userName);

		JTextField in_UserName = new JTextField();
		in_UserName.setSize(310, 30);
		in_UserName.setLocation(70, 170);
		in_UserName.setFont(new Font("Arial", Font.BOLD, 17));
		login.add(in_UserName);

		JLabel userLastName = new JLabel("Ingresa tus apellidos: ");
		userLastName.setSize(220, 20);
		userLastName.setLocation(130, 210);
		userLastName.setFont(new Font("Arial", Font.BOLD, 20));
		login.add(userLastName);

		JTextField in_UserLastName = new JTextField();
		in_UserLastName.setSize(310, 30);
		in_UserLastName.setLocation(70, 260);
		in_UserLastName.setFont(new Font("Arial", Font.BOLD, 17));
		login.add(in_UserLastName);

		JLabel telefono = new JLabel("Ingresa tu número de teléfono: ");
		telefono.setSize(300, 20);
		telefono.setLocation(80, 300);
		telefono.setFont(new Font("Arial", Font.BOLD, 20));
		login.add(telefono);

		JTextField in_Telefono = new JTextField();
		in_Telefono.setSize(310, 30);
		in_Telefono.setLocation(70, 350);
		in_Telefono.setFont(new Font("Arial", Font.BOLD, 17));
		login.add(in_Telefono);

		JButton acceder = new JButton("Iniciar Sesión");
		acceder.setSize(200, 35);
		acceder.setLocation(125, 410);
		acceder.setForeground(Color.decode("#EEE5DA"));
		acceder.setOpaque(true);
		acceder.setBackground(Color.decode("#713587"));
		login.add(acceder);

		acceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre = in_UserName.getText();
				String apellidos = in_UserLastName.getText();
				String telefono = in_Telefono.getText();
				BufferedReader reader;
				Boolean acceso = false;
				if (in_UserName.getText().isEmpty() || in_UserLastName.getText().isEmpty()
						|| in_Telefono.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error. Para iniciar sesión debes llenar todos los campos.");
				} else {
					try {
						reader = new BufferedReader(new FileReader("Users.txt"));
						String line = reader.readLine();
						while (line != null) {
							datos = line.split(",");
							if (datos[0].equals(nombre) && datos[1].equals(apellidos) && datos[3].equals(telefono)) {
								acceso = true;
								break;
							}
							// Leer la siguiente linea
							line = reader.readLine();
						}
						if (acceso) {
							JOptionPane.showMessageDialog(null, "Bienvenido " + datos[0]);
							padre.removeAll();
							padre.add(barra_lateral);
							padre.add(contenido);
							padre.revalidate();
							padre.repaint();
						} else {
							JOptionPane.showMessageDialog(null, "Error. El usuario y contraseña no coinciden");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		return login;
	}

	public void panel_Tarifas() {
		JButton btn_Consultar = new JButton("Consultar");
		btn_Consultar.setSize(150, 40);
		btn_Consultar.setLocation(100, 300);
		btn_Consultar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Consultar);

		JButton btn_Crear = new JButton("Crear");
		btn_Crear.setSize(150, 40);
		btn_Crear.setLocation(400, 300);
		btn_Crear.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Crear);

		JButton btn_Editar = new JButton("Editar");
		btn_Editar.setSize(150, 40);
		btn_Editar.setLocation(100, 440);
		btn_Editar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Editar);

		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setSize(150, 40);
		btn_Eliminar.setLocation(400, 440);
		btn_Eliminar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Eliminar);
	}
}
