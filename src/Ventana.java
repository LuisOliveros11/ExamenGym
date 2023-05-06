import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {
	JPanel padre = new JPanel();
	JPanel contenido = new JPanel();
	JPanel barra_lateral = new JPanel();
	String[] datos_Clientes = null;
	String[] datos_Tarifas = null;

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
							datos_Clientes = line.split(",");
							if (datos_Clientes[0].equals(nombre) && datos_Clientes[1].equals(apellidos)
									&& datos_Clientes[3].equals(telefono)) {
								acceso = true;
								break;
							}
							// Leer la siguiente linea
							line = reader.readLine();
						}
						if (acceso) {
							JOptionPane.showMessageDialog(null, "Bienvenido " + datos_Clientes[0]);
							padre.removeAll();
							padre.add(barra_lateral);
							padre.add(contenido);
							padre.revalidate();
							padre.repaint();
							reader.close();
						} else {
							JOptionPane.showMessageDialog(null, "Error. El usuario y teléfono no coinciden");
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
		contenido.removeAll();

		JButton btn_Consultar = new JButton("Consultar");
		btn_Consultar.setSize(150, 40);
		btn_Consultar.setLocation(100, 300);
		btn_Consultar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Consultar);

		btn_Consultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Tarifas_Consultar();
			}
		});

		JButton btn_Crear = new JButton("Crear");
		btn_Crear.setSize(150, 40);
		btn_Crear.setLocation(400, 300);
		btn_Crear.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Crear);

		btn_Crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Tarifas_Crear();
			}
		});

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

	public void panel_Tarifas_Consultar() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Datos de las tarifas", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		String nombresColumna[] = { "Cliente", "Cuota mensual", "Fecha valida inicial", "Fecha valida final" };
		BufferedReader reader_Tarifa, reader_Cliente;
		FileInputStream cliente;
		datos_Tarifas = null;
		datos_Clientes = null;

		try {
			cliente = new FileInputStream("Users.txt");
			reader_Tarifa = new BufferedReader(new FileReader("Tarifas.txt"));
			reader_Cliente = new BufferedReader(new InputStreamReader(cliente));

			String line_Tarifa = reader_Tarifa.readLine();
			String line_Cliente = reader_Cliente.readLine();
			JTable tabla = new JTable();
			DefaultTableModel tablaModel = new DefaultTableModel();
			tablaModel.setColumnIdentifiers(nombresColumna);

			while (line_Tarifa != null) {
				datos_Tarifas = line_Tarifa.split(",");
				datos_Clientes = line_Cliente.split(",");
				while (!datos_Tarifas[0].equals(datos_Clientes[3])) {
					if (line_Cliente == null) {
						break;
					} else {
						line_Cliente = reader_Cliente.readLine();
						if (line_Cliente != null) {
							datos_Clientes = line_Cliente.split(",");
						}
					}
				}
				if (line_Cliente != null) {
					tablaModel.addRow(new Object[] { datos_Clientes[0] + " " + datos_Clientes[1], datos_Tarifas[1],
							datos_Tarifas[2], datos_Tarifas[3] });
				}
				// Leer siguiente linea del archivo de tarifas
				line_Tarifa = reader_Tarifa.readLine();
				/*
				 * Las siguientes lineas sirven para reiniciar el bufferedReader Clientes a la
				 * posicion inicial del txt Users
				 */
				cliente.getChannel().position(0);
				reader_Cliente = new BufferedReader(new InputStreamReader(cliente));
				line_Cliente = reader_Cliente.readLine();
			}

			tabla.setModel(tablaModel);
			JScrollPane sp = new JScrollPane(tabla);
			sp.setSize(530, 300);
			sp.setLocation(50, 140);
			contenido.add(sp);
			reader_Tarifa.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(210, 470);
		volver.setForeground(Color.decode("#EEE5DA"));
		volver.setOpaque(true);
		volver.setBackground(Color.decode("#713587"));
		contenido.add(volver);

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contenido.removeAll();
				panel_Tarifas();
				contenido.revalidate();
				contenido.repaint();
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}

	public void panel_Tarifas_Crear() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Crear tarifa", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JLabel telefono = new JLabel("Cliente (Número de teléfono)");
		telefono.setSize(280, 30);
		telefono.setLocation(60, 170);
		telefono.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono);

		JTextField in_Telefono = new JTextField();
		in_Telefono.setSize(250, 30);
		in_Telefono.setLocation(50, 220);
		in_Telefono.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Telefono);

		JLabel cuota = new JLabel("Cuota mensual");
		cuota.setSize(150, 30);
		cuota.setLocation(405, 170);
		cuota.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(cuota);

		JTextField in_Cuota = new JTextField();
		in_Cuota.setSize(250, 30);
		in_Cuota.setLocation(340, 220);
		in_Cuota.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Cuota);

		JLabel fecha_Inicial = new JLabel("Fecha valida inicial (dd/mm/yyyy)");
		fecha_Inicial.setSize(280, 30);
		fecha_Inicial.setLocation(45, 300);
		fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Inicial);

		JTextField in_Fecha_Inicial = new JTextField();
		in_Fecha_Inicial.setSize(250, 30);
		in_Fecha_Inicial.setLocation(50, 350);
		in_Fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Fecha_Inicial);

		JLabel fecha_Final = new JLabel("Fecha valida final (dd/mm/yyyy)");
		fecha_Final.setSize(280, 30);
		fecha_Final.setLocation(345, 300);
		fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Final);

		JTextField in_Fecha_Final = new JTextField();
		in_Fecha_Final.setSize(250, 30);
		in_Fecha_Final.setLocation(340, 350);
		in_Fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Fecha_Final);

		JButton crear = new JButton("Crear tarifa");
		crear.setSize(200, 35);
		crear.setLocation(340, 470);
		crear.setForeground(Color.decode("#EEE5DA"));
		crear.setOpaque(true);
		crear.setBackground(Color.decode("#713587"));
		contenido.add(crear);

		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				datos_Tarifas = null;
				BufferedReader reader_Tarifas;
				BufferedReader reader_Clientes;
				String newUser = "";
				newUser += in_Telefono.getText() + ",";
				newUser += in_Cuota.getText() + ",";
				newUser += in_Fecha_Inicial.getText() + ",";
				newUser += in_Fecha_Final.getText();

				if (!in_Telefono.getText().isEmpty() && !in_Cuota.getText().isEmpty()
						&& !in_Fecha_Inicial.getText().isEmpty() && !in_Fecha_Final.getText().isEmpty()) {
					try {
						reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
						reader_Clientes = new BufferedReader(new FileReader("Users.txt"));
						String line_Tarifas = reader_Tarifas.readLine();
						String line_Clientes = reader_Clientes.readLine();

						while (line_Tarifas != null) {
							datos_Tarifas = line_Tarifas.split(",");
							if (in_Telefono.getText().equals(datos_Tarifas[0])) {
								JOptionPane.showMessageDialog(null,
										"Error, ya hay un tarifa registrada para este cliente");
								newUser = "";
								break;
							} else {
								line_Tarifas = reader_Tarifas.readLine();
							}
						}

						if (newUser != "") {
							while (line_Clientes != null) {
								if (datos_Clientes[3].equals(in_Telefono.getText())) {
									FileWriter fw = new FileWriter("Tarifas.txt", true);
									PrintWriter writer = new PrintWriter(fw);
									writer.println(newUser);
									JOptionPane.showMessageDialog(null, "Tarifa creada");
									writer.close();
									fw.close();
									break;
								} else {
									line_Clientes = reader_Clientes.readLine();
									if (line_Clientes != null) {
										datos_Clientes = line_Clientes.split(",");
									}
								}
							}
							if (line_Clientes == null) {
								JOptionPane.showMessageDialog(null,
										"Error. Este número de teléfono no está asociado a ningun cliente");
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Error. Para crear una nueva tarifa debes llenar todos los campos");
				}
			}
		});

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 470);
		volver.setForeground(Color.decode("#EEE5DA"));
		volver.setOpaque(true);
		volver.setBackground(Color.decode("#713587"));
		contenido.add(volver);
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contenido.removeAll();
				panel_Tarifas();
				contenido.revalidate();
				contenido.repaint();
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}
}
