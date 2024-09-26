package mongo;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.client.MongoClient;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class opciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opciones frame = new opciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public opciones() {
		setTitle("Gestion de la base de datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 80, 448);
		contentPane.add(panel);
		
		JButton botonCrear = new JButton("Crear");
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String codigo = JOptionPane.showInputDialog("Ingrese el código de la IA:");
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la IA:");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de IA:");
                int añoAparicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de aparición:"));
                String imagen = JOptionPane.showInputDialog("Ingrese la ruta de la imagen:");
                
				//consultasDB consulta = new consultasDB();
				//consulta.insertar(ALLBITS, getTitle(), getWarningString(), ABORT, getName());
			}
		});
		botonCrear.setBackground(new Color(255, 255, 255));
		botonCrear.setBounds(90, 11, 105, 39);
		contentPane.add(botonCrear);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBackground(new Color(255, 255, 255));
		botonActualizar.setBounds(207, 11, 112, 39);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBackground(new Color(255, 255, 255));
		botonEliminar.setBounds(329, 11, 89, 39);
		contentPane.add(botonEliminar);
		
		JButton botonConsultar = new JButton("Consultar");
		botonConsultar.setBackground(new Color(255, 255, 255));
		botonConsultar.setBounds(428, 11, 89, 39);
		contentPane.add(botonConsultar);
		
		JButton botonSalir = new JButton("Salir del programa");
		botonSalir.setBackground(new Color(255, 255, 255));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		botonSalir.setBounds(562, 11, 147, 39);
		contentPane.add(botonSalir);
		
		table = new JTable();
		table.setBounds(90, 239, 619, 198);
		contentPane.add(table);
	}
}
