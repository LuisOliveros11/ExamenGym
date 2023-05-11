import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


//falta quitar crasheo de eliminar y que los datos se muestren en la tabla
public class Ventana extends JFrame {
	JPanel padre = new JPanel();
	JPanel contenido = new JPanel();
	JPanel barra_lateral = new JPanel();
	String[] datos_Clientes = null;
	String[] datos_Tarifas = null;
	Date fechaActual = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String fechaActualSDF = sdf.format(fechaActual);

	public Ventana() {
		this.setVisible(true);
		this.setSize(900, 550);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setTitle("GYM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		volver_login();

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

		btn_Clientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Clientes();
				contenido.revalidate();
				contenido.repaint();
			}

		});

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

		btn_Checador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Checador();
			}
		});

		JButton btn_CerrarSesion = new JButton("Cerrar Sesión");
		btn_CerrarSesion.setSize(150, 40);
		btn_CerrarSesion.setLocation(50, 440);
		btn_CerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
		barra_lateral.add(btn_CerrarSesion);

		btn_CerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Cerrando sesion...");
				padre.removeAll();
				volver_login();
				padre.revalidate();
				padre.repaint();

			}
		});

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

		// imagen del panel de login
		ImageIcon foto2 = new ImageIcon("mancuerna.png");
		JLabel icono2 = new JLabel();
		icono2.setSize(150, 150);
		icono2.setLocation(580, 180);
		icono2.setIcon(new ImageIcon(
				foto2.getImage().getScaledInstance(icono2.getWidth(), icono2.getHeight(), Image.SCALE_SMOOTH)));
		login.add(icono2);

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

	public void volver_login() {
		contenido.removeAll();
		padre = panel_Login();
		getContentPane().add(padre);
	}

	public void panel_Clientes() {
		contenido.removeAll();

		JLabel titulo2 = new JLabel("Panel de clientes", JLabel.CENTER);
		titulo2.setSize(650, 30);
		titulo2.setLocation(0, 20);
		titulo2.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo2);

		JButton btn_Consultar_clientes = new JButton("Consultar");
		btn_Consultar_clientes.setSize(150, 40);
		btn_Consultar_clientes.setLocation(100, 300);
		btn_Consultar_clientes.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Consultar_clientes);
		
		ImageIcon consultar = new ImageIcon("consultar_icono.png");
		JLabel consultar_icono = new JLabel();
		consultar_icono.setSize(60, 60);
		consultar_icono.setLocation(145, 220);
		consultar_icono.setIcon(new ImageIcon(
				consultar.getImage().getScaledInstance(consultar_icono.getWidth(), consultar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(consultar_icono);

		btn_Consultar_clientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_consultar();
			}
		});

		btn_Consultar_clientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_consultar();
				contenido.revalidate();
				contenido.repaint();
			}

		});

		JButton btn_Crear = new JButton("Crear");
		btn_Crear.setSize(150, 40);
		btn_Crear.setLocation(400, 300);
		btn_Crear.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Crear);
		
		ImageIcon crear = new ImageIcon("crear.png");
		JLabel crear_icono = new JLabel();
		crear_icono.setSize(60, 60);
		crear_icono.setLocation(445, 220);
		crear_icono.setIcon(new ImageIcon(
		crear.getImage().getScaledInstance(crear_icono.getWidth(), crear_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(crear_icono);
		
		btn_Crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_crear();
			}
		});
		
		btn_Crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_crear();
				contenido.revalidate();
				contenido.repaint();
			}

		});

		JButton btn_Editar = new JButton("Editar");
		btn_Editar.setSize(150, 40);
		btn_Editar.setLocation(100, 440);
		btn_Editar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Editar);
		
		ImageIcon editar = new ImageIcon("editar.png");
		JLabel editar_icono = new JLabel();
		editar_icono.setSize(60, 60);
		editar_icono.setLocation(145, 360);
		editar_icono.setIcon(new ImageIcon(
				editar.getImage().getScaledInstance(editar_icono.getWidth(), editar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(editar_icono);
		
		btn_Editar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_editar();
			}
		});
		
		btn_Editar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_clientes_editar();
				contenido.revalidate();
				contenido.repaint();
			}

		});

		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setSize(150, 40);
		btn_Eliminar.setLocation(400, 440);
		btn_Eliminar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Eliminar);
		btn_Eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//panel_clientes_eliminar();
			}
			
		});
		
		ImageIcon eliminar = new ImageIcon("eliminar.png");
		JLabel eliminar_icono = new JLabel();
		eliminar_icono.setSize(60, 60);
		eliminar_icono.setLocation(445, 360);
		eliminar_icono.setIcon(new ImageIcon(
		eliminar.getImage().getScaledInstance(eliminar_icono.getWidth(), eliminar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(eliminar_icono);

	}

	public void panel_Tarifas() {
		contenido.removeAll();

		JLabel titulo3 = new JLabel("Panel de tarifas", JLabel.CENTER);
		titulo3.setSize(650, 30);
		titulo3.setLocation(0, 20);
		titulo3.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo3);

		JButton btn_Consultar = new JButton("Consultar");
		btn_Consultar.setSize(150, 40);
		btn_Consultar.setLocation(100, 300);
		btn_Consultar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Consultar);
		
		ImageIcon consultar = new ImageIcon("consultar_icono.png");
		JLabel consultar_icono = new JLabel();
		consultar_icono.setSize(60, 60);
		consultar_icono.setLocation(145, 220);
		consultar_icono.setIcon(new ImageIcon(
				consultar.getImage().getScaledInstance(consultar_icono.getWidth(), consultar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(consultar_icono);

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

		ImageIcon crear = new ImageIcon("crear.png");
		JLabel crear_icono = new JLabel();
		crear_icono.setSize(60, 60);
		crear_icono.setLocation(445, 220);
		crear_icono.setIcon(new ImageIcon(
				crear.getImage().getScaledInstance(crear_icono.getWidth(), crear_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(crear_icono);
		
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

		ImageIcon editar = new ImageIcon("editar.png");
		JLabel editar_icono = new JLabel();
		editar_icono.setSize(60, 60);
		editar_icono.setLocation(145, 360);
		editar_icono.setIcon(new ImageIcon(
				editar.getImage().getScaledInstance(editar_icono.getWidth(), editar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(editar_icono);
		
		btn_Editar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Tarifas_Editar();
			}
		});

		JButton btn_Eliminar = new JButton("Eliminar");
		btn_Eliminar.setSize(150, 40);
		btn_Eliminar.setLocation(400, 440);
		btn_Eliminar.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(btn_Eliminar);

		ImageIcon eliminar = new ImageIcon("eliminar.png");
		JLabel eliminar_icono = new JLabel();
		eliminar_icono.setSize(60, 60);
		eliminar_icono.setLocation(445, 360);
		eliminar_icono.setIcon(new ImageIcon(
				eliminar.getImage().getScaledInstance(eliminar_icono.getWidth(), eliminar_icono.getHeight(), Image.SCALE_SMOOTH)));
		contenido.add(eliminar_icono);
		
		btn_Eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_Tarifas_Eliminar();
			}
		});
	}

	public void panel_clientes_consultar() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Datos de los clientes", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		String nombresColumna[] = { "Cliente", "Apellidos", "Fecha de nacimiento", "Telefono", "Total pagado" };
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
					tablaModel.addRow(new Object[] { datos_Clientes[0] + " " + datos_Clientes[1], datos_Clientes[1],
							datos_Clientes[2], datos_Clientes[3], datos_Tarifas[1] });
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
				panel_Clientes();
				contenido.revalidate();
				contenido.repaint();
			}
		});

		contenido.revalidate();
		contenido.repaint();
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

	public void panel_clientes_crear() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Añadir cliente", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setSize(280, 30);
		Nombre.setLocation(60, 170);
		Nombre.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(Nombre);

		JTextField in_nombre = new JTextField();
		in_nombre.setSize(250, 30);
		in_nombre.setLocation(50, 220);
		in_nombre.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_nombre);

		JLabel apellidos = new JLabel("Apellidos");
		apellidos.setSize(150, 30);
		apellidos.setLocation(346, 170);
		apellidos.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(apellidos);

		JTextField in_apellidos = new JTextField();
		in_apellidos.setSize(250, 30);
		in_apellidos.setLocation(340, 220);
		in_apellidos.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_apellidos);

		JLabel fecha_nacimiento = new JLabel("Fecha de nacimiento");
		fecha_nacimiento.setSize(280, 30);
		fecha_nacimiento.setLocation(45, 300);
		fecha_nacimiento.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_nacimiento);

		JTextField in_Fecha_nacimiento = new JTextField();
		in_Fecha_nacimiento.setSize(250, 30);
		in_Fecha_nacimiento.setLocation(50, 350);
		in_Fecha_nacimiento.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Fecha_nacimiento);

		JLabel telefono_celular = new JLabel("Telefono celular");
		telefono_celular.setSize(280, 30);
		telefono_celular.setLocation(345, 300);
		telefono_celular.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono_celular);

		JTextField in_telefono_celular = new JTextField();
		in_telefono_celular.setSize(250, 30);
		in_telefono_celular.setLocation(340, 350);
		in_telefono_celular.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_telefono_celular);

		JButton crear = new JButton("Añadir cliente");
		crear.setSize(200, 35);
		crear.setLocation(340, 460);
		crear.setForeground(Color.decode("#EEE5DA"));
		crear.setOpaque(true);
		crear.setBackground(Color.decode("#713587"));
		contenido.add(crear);
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedReader reader_Clientes;
				String newClient = "";
				newClient += in_nombre.getText() + ",";
				newClient += in_apellidos.getText() + ",";
				newClient += in_Fecha_nacimiento.getText() + ",";
				newClient += in_telefono_celular.getText();

				if (!in_nombre.getText().isEmpty() && !in_apellidos.getText().isEmpty()
						&& !in_Fecha_nacimiento.getText().isEmpty() && !in_telefono_celular.getText().isEmpty()) {
					try {
						reader_Clientes = new BufferedReader(new FileReader("Users.txt"));
						String line_Clientes = reader_Clientes.readLine();

						while (line_Clientes != null) {
							String[] datos_Clientes = line_Clientes.split(",");
							if (datos_Clientes[0].equals(newClient.split(",")[0])
									&& datos_Clientes[1].equals(newClient.split(",")[1])) {
								JOptionPane.showMessageDialog(null, "El cliente ya existe.");
								return;
							}
							line_Clientes = reader_Clientes.readLine();
						}
						reader_Clientes.close();

						BufferedWriter writer_Clientes = new BufferedWriter(new FileWriter("Users.txt", true));
						writer_Clientes.write(newClient + "\n");
						writer_Clientes.close();
						JOptionPane.showMessageDialog(null, "El cliente ha sido agregado exitosamente.");
						in_nombre.setText("");
						in_apellidos.setText("");
						in_Fecha_nacimiento.setText("");
						in_telefono_celular.setText("");
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Error al guardar los datos del cliente.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
				}
			}

		});

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 460);
		volver.setForeground(Color.decode("#EEE5DA"));
		volver.setOpaque(true);
		volver.setBackground(Color.decode("#713587"));
		contenido.add(volver);

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contenido.removeAll();
				panel_Clientes();
				contenido.revalidate();
				contenido.repaint();
			}
		});
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
		crear.setLocation(340, 460);
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
		volver.setLocation(100, 460);
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

	public void panel_clientes_editar() {
		contenido.removeAll();
		int contador = 1;

		JLabel titulo = new JLabel("Editar cliente", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JComboBox clientes = new JComboBox();
		clientes.setSize(440, 30);
		clientes.setLocation(100, 120);
		contenido.add(clientes);

		JLabel indicacion = new JLabel("Seleccione el numero de telefono del cliente que quiere hacer cambios",
				JLabel.CENTER);
		indicacion.setSize(650, 20);
		indicacion.setLocation(0, 150);
		indicacion.setFont(new Font("Arial", Font.BOLD, 11));
		contenido.add(indicacion);

		JLabel telefono_c = new JLabel("Cliente (Número de teléfono)");
		telefono_c.setSize(280, 30);
		telefono_c.setLocation(60, 200);
		telefono_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono_c);

		JTextField in_Telefono_c = new JTextField();
		in_Telefono_c.setSize(250, 30);
		in_Telefono_c.setLocation(50, 250);
		in_Telefono_c.setFont(new Font("Arial", Font.BOLD, 17));
		in_Telefono_c.setEditable(false);
		contenido.add(in_Telefono_c);

		JLabel nombre_c = new JLabel("Nombre");
		nombre_c.setSize(150, 30);
		nombre_c.setLocation(405, 200);
		nombre_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(nombre_c);

		JTextField in_nombre_c = new JTextField();
		in_nombre_c.setSize(250, 30);
		in_nombre_c.setLocation(340, 250);
		in_nombre_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_nombre_c);

		JLabel apellidos_c = new JLabel("Apellidos");
		apellidos_c.setSize(280, 30);
		apellidos_c.setLocation(45, 330);
		apellidos_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(apellidos_c);

		JTextField in_apellidos_c = new JTextField();
		in_apellidos_c.setSize(250, 30);
		in_apellidos_c.setLocation(50, 380);
		in_apellidos_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_apellidos_c);

		JLabel telefono_celular_c = new JLabel("Telefono celular");
		telefono_celular_c.setSize(280, 30);
		telefono_celular_c.setLocation(345, 330);
		telefono_celular_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono_celular_c);

		JTextField in_telefono_celular_c = new JTextField();
		in_telefono_celular_c.setSize(250, 30);
		in_telefono_celular_c.setLocation(340, 380);
		in_telefono_celular_c.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_telefono_celular_c);

		datos_Clientes = null;
		BufferedReader reader_Users;
		// CODIGO PARA LLENAR EL COMBOBOX CON LOS CLIENTES REGISTRADOS
		try {
			reader_Users = new BufferedReader(new FileReader("Users.txt"));
			String line = reader_Users.readLine();

			while (line != null) {
				datos_Clientes = line.split(",");
				clientes.addItem(datos_Clientes[0]);
				// Leer la siguiente linea
				line = reader_Users.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in_telefono_celular_c.setText(clientes.getSelectedItem().toString());

				BufferedReader reader_Users;
				try {
					reader_Users = new BufferedReader(new FileReader("Users.txt"));
					String line_Users = reader_Users.readLine();
					while (line_Users != null) {
						datos_Clientes = null;
						datos_Clientes = line_Users.split(",");
						if (datos_Clientes[0].equals(in_telefono_celular_c.getText())) {
							in_apellidos_c.setText(datos_Clientes[1]);
							in_nombre_c.setText(datos_Clientes[0]);
							in_telefono_celular_c.setText(datos_Clientes[3]);
							break;
						} else {
							line_Users = reader_Users.readLine();
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton guardar_Cambios = new JButton("Guardar cambios");
		guardar_Cambios.setSize(200, 35);
		guardar_Cambios.setLocation(340, 460);
		guardar_Cambios.setForeground(Color.decode("#EEE5DA"));
		guardar_Cambios.setOpaque(true);
		guardar_Cambios.setBackground(Color.decode("#713587"));
		contenido.add(guardar_Cambios);
		guardar_Cambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedReader reader_Users;
				if (!in_nombre_c.getText().isEmpty() && !in_apellidos_c.getText().isEmpty()
						&& !in_apellidos_c.getText().isEmpty() && !in_telefono_celular_c.getText().isEmpty()) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de guardar los cambios?");
					if (confirmacion == 0) {
						try {
							// SE GUARDAN LOS DATOS ACTUALIZADOS
							String datos_Actualizados = in_telefono_celular_c.getText() + ",";
							datos_Actualizados += in_nombre_c.getText() + ",";
							datos_Actualizados += in_apellidos_c.getText() + ",";
							datos_Actualizados += in_telefono_celular_c.getText();

							// MATRIZ PARA ALMACENAR LOS DATOS EXISTENTES EN EL TXT QUE DESPUES SERAN
							// VACIADOS
							String[][] copiaDatos = new String[100][1];
							// SE GUARDAN LOS DATOS EXISTENTES DEL TXT ANTES DE ELIMINARLOS
							int i = 0;
							reader_Users = new BufferedReader(new FileReader("Users.txt"));
							String line = reader_Users.readLine();
							while (line != null) {
								copiaDatos[i][0] = line;
								line = reader_Users.readLine();
								i++;
							}
							// SE ELIMINAN LOS DATOS EXISTENTES EN EL TXT
							BufferedWriter writter = new BufferedWriter(new FileWriter("Users.txt"));
							// SE VUELVE A LLENAR EL TXT CON LOS DATOS GUARDADOS EN LA COPIA Y LOS
							// ACTUALIZDOS
							i = 0;
							while (copiaDatos[i][0] != null) {
								if (copiaDatos[i][0].contains(in_telefono_celular_c.getText())) {
									i++;
								} else {
									writter.write(copiaDatos[i][0]);
									writter.newLine();
									i++;
								}
							}

							writter.write(datos_Actualizados);
							writter.newLine();
							writter.close();
							JOptionPane.showMessageDialog(null, "Información actualizada");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("ok");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Error. Para editar a un cliente deben ser llenados todos los camposs");
				}
			}
		});

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 460);
		volver.setForeground(Color.decode("#EEE5DA"));
		volver.setOpaque(true);
		volver.setBackground(Color.decode("#713587"));
		contenido.add(volver);

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contenido.removeAll();
				panel_Clientes();
				contenido.revalidate();
				contenido.repaint();
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}

	public void panel_Tarifas_Editar() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Editar tarifa", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JComboBox clientes = new JComboBox();
		clientes.setSize(440, 30);
		clientes.setLocation(100, 120);
		contenido.add(clientes);

		JLabel indicacion = new JLabel("Selecciona el teléfono de el cliente al que deseas editar su tarifa",
				JLabel.CENTER);
		indicacion.setSize(650, 20);
		indicacion.setLocation(0, 150);
		indicacion.setFont(new Font("Arial", Font.BOLD, 11));
		contenido.add(indicacion);

		JLabel telefono = new JLabel("Cliente (Número de teléfono)");
		telefono.setSize(280, 30);
		telefono.setLocation(60, 200);
		telefono.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono);

		JTextField in_Telefono = new JTextField();
		in_Telefono.setSize(250, 30);
		in_Telefono.setLocation(50, 250);
		in_Telefono.setFont(new Font("Arial", Font.BOLD, 17));
		in_Telefono.setEditable(false);
		contenido.add(in_Telefono);

		JLabel cuota = new JLabel("Cuota mensual");
		cuota.setSize(150, 30);
		cuota.setLocation(405, 200);
		cuota.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(cuota);

		JTextField in_Cuota = new JTextField();
		in_Cuota.setSize(250, 30);
		in_Cuota.setLocation(340, 250);
		in_Cuota.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Cuota);

		JLabel fecha_Inicial = new JLabel("Fecha valida inicial (dd/mm/yyyy)");
		fecha_Inicial.setSize(280, 30);
		fecha_Inicial.setLocation(45, 330);
		fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Inicial);

		JTextField in_Fecha_Inicial = new JTextField();
		in_Fecha_Inicial.setSize(250, 30);
		in_Fecha_Inicial.setLocation(50, 380);
		in_Fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Fecha_Inicial);

		JLabel fecha_Final = new JLabel("Fecha valida final (dd/mm/yyyy)");
		fecha_Final.setSize(280, 30);
		fecha_Final.setLocation(345, 330);
		fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Final);

		JTextField in_Fecha_Final = new JTextField();
		in_Fecha_Final.setSize(250, 30);
		in_Fecha_Final.setLocation(340, 380);
		in_Fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Fecha_Final);

		JButton guardar_Cambios = new JButton("Guardar cambios");
		guardar_Cambios.setSize(200, 35);
		guardar_Cambios.setLocation(340, 460);
		guardar_Cambios.setForeground(Color.decode("#EEE5DA"));
		guardar_Cambios.setOpaque(true);
		guardar_Cambios.setBackground(Color.decode("#713587"));
		contenido.add(guardar_Cambios);

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 460);
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

		datos_Tarifas = null;
		BufferedReader reader_Tarifas;

		// CODIGO PARA LLENAR EL COMBOBOX CON LOS CLIENTES REGISTRADOS
		try {
			reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
			String line = reader_Tarifas.readLine();

			while (line != null) {
				datos_Tarifas = line.split(",");
				clientes.addItem(datos_Tarifas[0]);
				// Leer la siguiente linea
				line = reader_Tarifas.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in_Telefono.setText(clientes.getSelectedItem().toString());

				BufferedReader reader_Tarifas;
				try {
					reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
					String line_Tarifas = reader_Tarifas.readLine();
					while (line_Tarifas != null) {
						datos_Tarifas = null;
						datos_Tarifas = line_Tarifas.split(",");
						if (datos_Tarifas[0].equals(in_Telefono.getText())) {
							in_Cuota.setText(datos_Tarifas[1]);
							in_Fecha_Inicial.setText(datos_Tarifas[2]);
							in_Fecha_Final.setText(datos_Tarifas[3]);
							break;
						} else {
							line_Tarifas = reader_Tarifas.readLine();
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		guardar_Cambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedReader reader_Tarifas;
				if (!in_Cuota.getText().isEmpty() && !in_Fecha_Inicial.getText().isEmpty()
						&& !in_Fecha_Final.getText().isEmpty() && !in_Telefono.getText().isEmpty()) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de guardar los cambios?");
					if (confirmacion == 0) {
						try {
							// SE GUARDAN LOS DATOS ACTUALIZADOS
							String datos_Actualizados = in_Telefono.getText() + ",";
							datos_Actualizados += in_Cuota.getText() + ",";
							datos_Actualizados += in_Fecha_Inicial.getText() + ",";
							datos_Actualizados += in_Fecha_Final.getText();

							// MATRIZ PARA ALMACENAR LOS DATOS EXISTENTES EN EL TXT QUE DESPUES SERAN
							// VACIADOS
							String[][] copiaDatos = new String[100][1];
							// SE GUARDAN LOS DATOS EXISTENTES DEL TXT ANTES DE ELIMINARLOS
							int i = 0;
							reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
							String line = reader_Tarifas.readLine();
							while (line != null) {
								copiaDatos[i][0] = line;
								line = reader_Tarifas.readLine();
								i++;
							}
							// SE ELIMINAN LOS DATOS EXISTENTES EN EL TXT
							BufferedWriter writter = new BufferedWriter(new FileWriter("Tarifas.txt"));
							// SE VUELVE A LLENAR EL TXT CON LOS DATOS GUARDADOS EN LA COPIA Y LOS
							// ACTUALIZDOS
							i = 0;
							while (copiaDatos[i][0] != null) {
								if (copiaDatos[i][0].contains(in_Telefono.getText())) {
									i++;
								} else {
									writter.write(copiaDatos[i][0]);
									writter.newLine();
									i++;
								}
							}

							writter.write(datos_Actualizados);
							writter.newLine();
							writter.close();
							JOptionPane.showMessageDialog(null, "Información actualizada");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("ok");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Error. Para editar una tarifa deben ser llenados todos los campos");
				}
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}

	/*public void panel_clientes_eliminar() {
	contenido.removeAll();

	JLabel titulo = new JLabel("Eliminar a cliente", JLabel.CENTER);
	titulo.setSize(650, 30);
	titulo.setLocation(0, 80);
	titulo.setFont(new Font("Arial", Font.BOLD, 23));
	contenido.add(titulo);

	JComboBox clientes = new JComboBox();
	clientes.setSize(440, 30);
	clientes.setLocation(100, 120);
	contenido.add(clientes);

	JLabel indicacion = new JLabel("Selecciona el teléfono de el cliente al que deseas eliminar",
			JLabel.CENTER);
	indicacion.setSize(650, 20);
	indicacion.setLocation(0, 150);
	indicacion.setFont(new Font("Arial", Font.BOLD, 11));
	contenido.add(indicacion);

	JLabel telefono_c = new JLabel("Cliente (Número de teléfono)");
	telefono_c.setSize(280, 30);
	telefono_c.setLocation(60, 200);
	telefono_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(telefono_c);

	JTextField in_Telefono_c = new JTextField();
	in_Telefono_c.setSize(250, 30);
	in_Telefono_c.setLocation(50, 250);
	in_Telefono_c.setFont(new Font("Arial", Font.BOLD, 17));
	in_Telefono_c.setEditable(false);
	contenido.add(in_Telefono_c);

	JLabel nombre_c = new JLabel("Nombre");
	nombre_c.setSize(150, 30);
	nombre_c.setLocation(405, 200);
	nombre_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(nombre_c);

	JTextField in_nombre_c = new JTextField();
	in_nombre_c.setSize(250, 30);
	in_nombre_c.setLocation(340, 250);
	in_nombre_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(in_nombre_c);

	JLabel apellidos_c = new JLabel("Apellidos");
	apellidos_c.setSize(280, 30);
	apellidos_c.setLocation(45, 330);
	apellidos_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(apellidos_c);

	JTextField in_apellidos_c = new JTextField();
	in_apellidos_c.setSize(250, 30);
	in_apellidos_c.setLocation(50, 380);
	in_apellidos_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(in_apellidos_c);

	JLabel telefono_celular_c = new JLabel("Telefono celular");
	telefono_celular_c.setSize(280, 30);
	telefono_celular_c.setLocation(345, 330);
	telefono_celular_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(telefono_celular_c);

	JTextField in_telefono_celular_c = new JTextField();
	in_telefono_celular_c.setSize(250, 30);
	in_telefono_celular_c.setLocation(340, 380);
	in_telefono_celular_c.setFont(new Font("Arial", Font.BOLD, 17));
	contenido.add(in_telefono_celular_c);

	JButton volver = new JButton("Volver");
	volver.setSize(200, 35);
	volver.setLocation(100, 460);
	volver.setForeground(Color.decode("#EEE5DA"));
	volver.setOpaque(true);
	volver.setBackground(Color.decode("#713587"));
	contenido.add(volver);
	
	datos_Clientes = null;
	BufferedReader reader_Users;
	// CODIGO PARA LLENAR EL COMBOBOX CON LOS CLIENTES REGISTRADOS
	try {
		reader_Users = new BufferedReader(new FileReader("Users.txt"));
		String line = reader_Users.readLine();

		while (line != null) {
			datos_Clientes = line.split(",");
			clientes.addItem(datos_Clientes[0]);
			// Leer la siguiente linea
			line = reader_Users.readLine();
		}
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	volver.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			contenido.removeAll();
			panel_Clientes();
			contenido.revalidate();
			contenido.repaint();
		}
	});

	JButton eliminar = new JButton("Eliminar cliente");
	eliminar.setSize(200, 35);
	eliminar.setLocation(340, 460);
	eliminar.setForeground(Color.decode("#EEE5DA"));
	eliminar.setOpaque(true);
	eliminar.setBackground(Color.decode("#713587"));
	contenido.add(eliminar);
/*			
	eliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			BufferedReader reader_Users;
			if (!in_nombre_c.getText().isEmpty() && !in_apellidos_c.getText().isEmpty()
					&& !in_apellidos_c.getText().isEmpty() && !in_telefono_celular_c.getText().isEmpty()) {
				int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este cliente?");
				if (confirmacion == 0) {
					try {
						// MATRIZ PARA ALMACENAR LOS DATOS EXISTENTES EN EL TXT QUE DESPUES SERAN
						// VACIADOS
						String[][] copiaDatos = new String[100][1];
						// SE GUARDAN LOS DATOS EXISTENTES DEL TXT ANTES DE ELIMINARLOS
						int i = 0;
						reader_Users = new BufferedReader(new FileReader("Users.txt"));
						String line = reader_Users.readLine();
						while (line != null) {
							copiaDatos[i][0] = line;
							line = reader_Users.readLine();
							i++;
						}
						// SE ELIMINAN LOS DATOS EXISTENTES EN EL TXT
						BufferedWriter writter = new BufferedWriter(new FileWriter("Users.txt"));
						// SE VUELVE A LLENAR EL TXT CON LOS DATOS GUARDADOS EN LA COPIA SIN LOS
						// GUARDADOS A ELIMINAR
						i = 0;
						while (copiaDatos[i][0] != null) {
							if (copiaDatos[i][0].contains(in_telefono_celular_c.getText())) {
								i++;
							} else {
								writter.write(copiaDatos[i][0]);
								writter.newLine();
								i++;
							}
						}
						writter.close();
						JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
						in_telefono_celular_c.setText("");
						in_nombre_c.setText("");
						in_apellidos_c.setText("");

						clientes.removeAllItems();
						// SE VUELVE A LLENAR EL COMBOBOX AHORA SIN EL ITEM ELIMINADO
						datos_Clientes = null;
						try {
							reader_Users = new BufferedReader(new FileReader("Users.txt"));
							line = reader_Users.readLine();

							while (line != null) {
								datos_Clientes = line.split(",");
								clientes.addItem(datos_Tarifas[0]);
								// Leer la siguiente linea
								line = reader_Users.readLine();
							}
							clientes.revalidate();
							clientes.repaint();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Error. Para eliminar a un cliente debe seleccionar uno primero.");
			}
		}
		}

	);

	clientes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (clientes.getSelectedItem() != null) {
				in_telefono_celular_c.setText(clientes.getSelectedItem().toString());
			}

			BufferedReader reader_Users;
			try {
				reader_Users = new BufferedReader(new FileReader("Users.txt"));
				String line_Users = reader_Users.readLine();
				while (line_Users != null) {
					datos_Clientes = null;
					datos_Clientes = line_Users.split(",");
					if (datos_Clientes.length > 0 && datos_Clientes[0].equals(in_telefono_celular_c.getText())) {
					    in_apellidos_c.setText(datos_Clientes[1]);
					    in_nombre_c.setText(datos_Clientes[0]);
					    in_telefono_celular_c.setText(datos_Clientes[3]);
					    break;
					} else {
					    line_Users = reader_Users.readLine();
					} {
						line_Users = reader_Users.readLine();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	contenido.revalidate();
	contenido.repaint();
	}*/
	
	public void panel_Tarifas_Eliminar() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Eliminar tarifa", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JComboBox clientes = new JComboBox();
		clientes.setSize(440, 30);
		clientes.setLocation(100, 120);
		contenido.add(clientes);

		JLabel indicacion = new JLabel("Selecciona el teléfono de el cliente al que deseas eliminar su tarifa",
				JLabel.CENTER);
		indicacion.setSize(650, 20);
		indicacion.setLocation(0, 150);
		indicacion.setFont(new Font("Arial", Font.BOLD, 11));
		contenido.add(indicacion);

		JLabel telefono = new JLabel("Cliente (Número de teléfono)");
		telefono.setSize(280, 30);
		telefono.setLocation(60, 200);
		telefono.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(telefono);

		JTextField in_Telefono = new JTextField();
		in_Telefono.setSize(250, 30);
		in_Telefono.setLocation(50, 250);
		in_Telefono.setFont(new Font("Arial", Font.BOLD, 17));
		in_Telefono.setEditable(false);
		contenido.add(in_Telefono);

		JLabel cuota = new JLabel("Cuota mensual");
		cuota.setSize(150, 30);
		cuota.setLocation(405, 200);
		cuota.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(cuota);

		JTextField in_Cuota = new JTextField();
		in_Cuota.setSize(250, 30);
		in_Cuota.setLocation(340, 250);
		in_Cuota.setFont(new Font("Arial", Font.BOLD, 17));
		in_Cuota.setEditable(false);
		contenido.add(in_Cuota);

		JLabel fecha_Inicial = new JLabel("Fecha valida inicial (dd/mm/yyyy)");
		fecha_Inicial.setSize(280, 30);
		fecha_Inicial.setLocation(45, 330);
		fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Inicial);

		JTextField in_Fecha_Inicial = new JTextField();
		in_Fecha_Inicial.setSize(250, 30);
		in_Fecha_Inicial.setLocation(50, 380);
		in_Fecha_Inicial.setFont(new Font("Arial", Font.BOLD, 17));
		in_Fecha_Inicial.setEditable(false);
		contenido.add(in_Fecha_Inicial);

		JLabel fecha_Final = new JLabel("Fecha valida final (dd/mm/yyyy)");
		fecha_Final.setSize(280, 30);
		fecha_Final.setLocation(345, 330);
		fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(fecha_Final);

		JTextField in_Fecha_Final = new JTextField();
		in_Fecha_Final.setSize(250, 30);
		in_Fecha_Final.setLocation(340, 380);
		in_Fecha_Final.setFont(new Font("Arial", Font.BOLD, 17));
		in_Fecha_Final.setEditable(false);
		contenido.add(in_Fecha_Final);

		JButton eliminar = new JButton("Eliminar tarifa");
		eliminar.setSize(200, 35);
		eliminar.setLocation(340, 460);
		eliminar.setForeground(Color.decode("#EEE5DA"));
		eliminar.setOpaque(true);
		eliminar.setBackground(Color.decode("#713587"));
		contenido.add(eliminar);

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 460);
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

		// CODIGO PARA LLENAR EL COMBOBOX CON LOS CLIENTES REGISTRADOS
		datos_Tarifas = null;
		BufferedReader reader_Tarifas;
		try {
			reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
			String line = reader_Tarifas.readLine();

			while (line != null) {
				datos_Tarifas = line.split(",");
				clientes.addItem(datos_Tarifas[0]);
				// Leer la siguiente linea
				line = reader_Tarifas.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clientes.getSelectedItem() != null) {
					in_Telefono.setText(clientes.getSelectedItem().toString());
				}
				BufferedReader reader_Tarifas;
				try {
					reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
					String line_Tarifas = reader_Tarifas.readLine();
					while (line_Tarifas != null) {
						datos_Tarifas = null;
						datos_Tarifas = line_Tarifas.split(",");
						if (datos_Tarifas[0].equals(in_Telefono.getText())) {
							in_Cuota.setText(datos_Tarifas[1]);
							in_Fecha_Inicial.setText(datos_Tarifas[2]);
							in_Fecha_Final.setText(datos_Tarifas[3]);
							break;
						} else {
							line_Tarifas = reader_Tarifas.readLine();
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		eliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BufferedReader reader_Tarifas;
				if (!in_Cuota.getText().isEmpty() && !in_Fecha_Inicial.getText().isEmpty()
						&& !in_Fecha_Final.getText().isEmpty() && !in_Telefono.getText().isEmpty()) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta tarifa?");
					if (confirmacion == 0) {
						try {
							// MATRIZ PARA ALMACENAR LOS DATOS EXISTENTES EN EL TXT QUE DESPUES SERAN
							// VACIADOS
							String[][] copiaDatos = new String[100][1];
							// SE GUARDAN LOS DATOS EXISTENTES DEL TXT ANTES DE ELIMINARLOS
							int i = 0;
							reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
							String line = reader_Tarifas.readLine();
							while (line != null) {
								copiaDatos[i][0] = line;
								line = reader_Tarifas.readLine();
								i++;
							}
							// SE ELIMINAN LOS DATOS EXISTENTES EN EL TXT
							BufferedWriter writter = new BufferedWriter(new FileWriter("Tarifas.txt"));
							// SE VUELVE A LLENAR EL TXT CON LOS DATOS GUARDADOS EN LA COPIA SIN LOS
							// GUARDADOS A ELIMINAR
							i = 0;
							while (copiaDatos[i][0] != null) {
								if (copiaDatos[i][0].contains(in_Telefono.getText())) {
									i++;
								} else {
									writter.write(copiaDatos[i][0]);
									writter.newLine();
									i++;
								}
							}
							writter.close();
							JOptionPane.showMessageDialog(null, "Tarifa eliminada correctamente.");
							in_Telefono.setText("");
							in_Cuota.setText("");
							in_Fecha_Inicial.setText("");
							in_Fecha_Final.setText("");

							clientes.removeAllItems();
							// SE VUELVE A LLENAR EL COMBOBOX AHORA SIN EL ITEM ELIMINADO
							datos_Tarifas = null;
							try {
								reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
								line = reader_Tarifas.readLine();

								while (line != null) {
									datos_Tarifas = line.split(",");
									clientes.addItem(datos_Tarifas[0]);
									// Leer la siguiente linea
									line = reader_Tarifas.readLine();
								}
								clientes.revalidate();
								clientes.repaint();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Error. Para eliminar una tarifa debe seleccionar una primero.");
				}
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}

	public void panel_Checador() {
		contenido.removeAll();

		JLabel titulo = new JLabel("Checar vigencia", JLabel.CENTER);
		titulo.setSize(650, 30);
		titulo.setLocation(0, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 23));
		contenido.add(titulo);

		JLabel indicacion = new JLabel("Ingresa tu PIN (Número de teléfono)");
		indicacion.setSize(300, 30);
		indicacion.setLocation(200, 240);
		indicacion.setFont(new Font("Arial", Font.BOLD, 14));
		contenido.add(indicacion);

		JTextField in_Pin = new JTextField();
		in_Pin.setSize(300, 30);
		in_Pin.setLocation(175, 190);
		in_Pin.setFont(new Font("Arial", Font.BOLD, 17));
		contenido.add(in_Pin);

		JButton verificar = new JButton("Verificar vigencia");
		verificar.setSize(200, 35);
		verificar.setLocation(340, 350);
		verificar.setForeground(Color.decode("#EEE5DA"));
		verificar.setOpaque(true);
		verificar.setBackground(Color.decode("#713587"));
		contenido.add(verificar);

		JButton volver = new JButton("Volver");
		volver.setSize(200, 35);
		volver.setLocation(100, 350);
		volver.setForeground(Color.decode("#EEE5DA"));
		volver.setOpaque(true);
		volver.setBackground(Color.decode("#713587"));
		contenido.add(volver);

		verificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fechaVencimiento_Str;
				if (!in_Pin.getText().isEmpty()) {
					datos_Tarifas = null;
					BufferedReader reader_Tarifas;
					try {
						reader_Tarifas = new BufferedReader(new FileReader("Tarifas.txt"));
						String line = reader_Tarifas.readLine();
						while (line != null) {
							datos_Tarifas = line.split(",");
							if (in_Pin.getText().equals(datos_Tarifas[0])) {
								break;
							} else {
								// Leer la siguiente linea
								line = reader_Tarifas.readLine();
							}
						}
						if (line != null) {
							fechaVencimiento_Str = datos_Tarifas[3];
							Date fechaVencimiento_Date = sdf.parse(fechaVencimiento_Str);
							if (fechaActual.after(fechaVencimiento_Date)) {
								JOptionPane.showMessageDialog(null, "Tu tarifa venció el "
										+ sdf.format(fechaVencimiento_Date) + ". Es necesario renovarla.");
							} else {
								JOptionPane.showMessageDialog(null,
										"Tu tarifa sigue vigente hasta el " + sdf.format(fechaVencimiento_Date));
							}
						} else {
							JOptionPane.showMessageDialog(null, "Error. Este PIN no está vinculado a ningun cliente.");
						}
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Error. Para verificar una fecha debes ingresar un PIN correcto.");
				}
			}
		});

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contenido.removeAll();
				contenido.revalidate();
				contenido.repaint();
			}
		});

		contenido.revalidate();
		contenido.repaint();
	}
}

