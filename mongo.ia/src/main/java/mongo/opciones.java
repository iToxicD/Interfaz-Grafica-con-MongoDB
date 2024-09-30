package mongo;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.MongoClient;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

public class opciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	consultasDB consultas= new consultasDB();
	DefaultTableModel tabla;
	
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
		botonCrear.setSelectedIcon(null);
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Introducimos por teclado los diferentes apartados
                String codigo = JOptionPane.showInputDialog("Código de la IA:");
                String nombre = JOptionPane.showInputDialog("Introduzca el nombre:");
                String tipo = JOptionPane.showInputDialog("Introduzca el  tipo de IA:");
                int aparicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
                String imagen = JOptionPane.showInputDialog("Ingrese la nueva ruta de la imagen:");
                // Añadimos a la base de datos los datos
				consultas.insertar(codigo, nombre, tipo, aparicion, imagen);
			}
		});
		botonCrear.setBackground(new Color(255, 255, 255));
		botonCrear.setBounds(90, 11, 105, 39);
		contentPane.add(botonCrear);
		
		JButton botonActualizar = new JButton("Actualizar");
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Introducimos los nuevos datos para actualizar
				String codigo = JOptionPane.showInputDialog("Ingrese el código de la IA:");
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la IA:");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de IA:");
                int aparicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de aparición:"));
                String imagen = JOptionPane.showInputDialog("Ingrese la ruta de la imagen:");
                // Actualizamos los datos
				consultas.actualizar(codigo, nombre, tipo, aparicion, imagen);
			}
		});
		botonActualizar.setBackground(new Color(255, 255, 255));
		botonActualizar.setBounds(207, 11, 112, 39);
		contentPane.add(botonActualizar);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Eliminamos la IA a partir del codigo de la misma
				String codigo = JOptionPane.showInputDialog("Código de la IA a eliminar:");
				consultas.eliminar(codigo);
				JOptionPane.showMessageDialog(null, "¡IA eliminada con existo!");
			}
		});
		botonEliminar.setBackground(new Color(255, 255, 255));
		botonEliminar.setBounds(329, 11, 89, 39);
		contentPane.add(botonEliminar);
		
		JLabel imagenes = new JLabel("");
	    imagenes.setBounds(517, 206, 192, 231);
	    contentPane.add(imagenes);
	    
		JButton botonConsultar = new JButton("Consultar");
		botonConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vacia la tabla previamente
				tabla.setRowCount(0);
				String tipo = JOptionPane.showInputDialog("Ingrese el tipo de IA:");
				Document resultado = consultas.consultar(tipo);
				// Coge los datos del documento y los pone en la tabla
				if (resultado != null) {
					String codigo = resultado.getString("_id");
			        String nombre = resultado.getString("nombre");
			        tipo = resultado.getString("tipo");
			        int aparicion = resultado.getInteger("añoAparicion");
			        String imagen = resultado.getString("imagen");
			        // Añade los datos en la tabla
			        tabla.addRow(new Object[]{codigo, nombre, tipo, aparicion, imagen});
			     
			        try {
			        	// Crea un objeto file usando la url de la imagen
			        	File url = new File(imagen);
			        	// Lee y almacena la imagen en un bufferedImage
		                BufferedImage bufi = ImageIO.read(url);
		                // Crea un icono con el buffered
		                ImageIcon icon = new ImageIcon(bufi);
		                // Si el buffered es nulo muestra un mensaje de que no se pudo leer la imagen
		                if(bufi == null) System.out.print("No se pudo leer la imagen: "+ imagen);
		                // Ajusta la escala de la imagen  al JLabel que se mostrará
		                Image foto = icon.getImage().getScaledInstance(imagenes.getWidth(), imagenes.getHeight(), Image.SCALE_SMOOTH);
		                // Establece el icono
		                imagenes.setIcon(new ImageIcon(foto));
		                // Valida y "repinta" para mostrar la imagen (podriamos entenderlo como que recarga la imagen)
		                imagenes.revalidate();
		                imagenes.repaint();
					} catch (Exception ex) {
						System.out.print("Error en la imagen: " + ex);
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se han encontrado datos.", tipo, JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
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
		
		tabla = new DefaultTableModel(new String[]{"Código", "Nombre", "Tipo", "Año Aparición", "Imagen"}, 0);
	    table = new JTable(tabla);
	    table.setBackground(new Color(255, 255, 255));
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(90, 206, 417, 231);
	    contentPane.add(scrollPane);
	    
	    JLabel info = new JLabel("Tabla donde se muestran los datos.");
	    info.setBounds(90, 181, 229, 14);
	    contentPane.add(info);
	}
}
