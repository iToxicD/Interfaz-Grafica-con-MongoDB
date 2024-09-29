package mongo.ia;

import java.awt.EventQueue;



import mongo.VentanaConexion;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.bson.Document;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Interfaz {

	private JFrame frmBaseDeDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmBaseDeDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmBaseDeDatos = new JFrame();
		frmBaseDeDatos.setTitle("Base de Datos de IAs - MongoDB");
		frmBaseDeDatos.getContentPane().setBackground(new Color(255, 255, 255));
		frmBaseDeDatos.setBounds(100, 100, 558, 460);
		frmBaseDeDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBaseDeDatos.getContentPane().setLayout(null);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBaseDeDatos.setVisible(false);
			}
		});
		botonSalir.setBackground(new Color(255, 255, 255));
		botonSalir.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		botonSalir.setBounds(416, 373, 116, 37);
		frmBaseDeDatos.getContentPane().add(botonSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 165, 419);
		frmBaseDeDatos.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:\\Users\\vader\\Desktop\\Interfaz-Grafica-con-MongoDB\\mongo.ia\\src\\imagen\\database-security.png"));
		imagen.setBounds(10, 0, 155, 419);
		imagen.setSize(100, 100);
		panel.add(imagen);
		
		JButton botonEntrar = new JButton("Entrar");
		botonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new VentanaConexion();
			}
		});
		botonEntrar.setBackground(new Color(255, 255, 255));
		botonEntrar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		botonEntrar.setBounds(290, 373, 116, 37);
		frmBaseDeDatos.getContentPane().add(botonEntrar);
		
		JLabel mensajeBienvenido = new JLabel("¡Bienvenido!");
		mensajeBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenido.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
		mensajeBienvenido.setBounds(175, 11, 357, 51);
		frmBaseDeDatos.getContentPane().add(mensajeBienvenido);
	}
}
