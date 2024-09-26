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
		panel.setBounds(0, 0, 156, 448);
		contentPane.add(panel);
		
		JButton botonCrear = new JButton("Crear");
		botonCrear.setBounds(166, 11, 89, 39);
		contentPane.add(botonCrear);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.setBounds(265, 11, 89, 39);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(364, 11, 89, 39);
		contentPane.add(botonEliminar);
		
		JButton botonConsultar = new JButton("Consultar");
		botonConsultar.setBounds(463, 11, 89, 39);
		contentPane.add(botonConsultar);
		
		JButton botonSalir = new JButton("Salir del programa");
		botonSalir.setBackground(new Color(255, 255, 255));
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		botonSalir.setBounds(577, 11, 132, 39);
		contentPane.add(botonSalir);
		
		table = new JTable();
		table.setBounds(166, 239, 543, 198);
		contentPane.add(table);
	}
}
