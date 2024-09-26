package mongo;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class VentanaConexion extends JFrame {

    public static void main(String[] args) {
        new VentanaConexion();  
    }
    
    public VentanaConexion() {
    	getContentPane().setBackground(new Color(240, 240, 240));
        
        setTitle("Conexión a MongoDB");
        setSize(400, 300);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);  
        getContentPane().setLayout(null);  
    
        JLabel mensajeURL = new JLabel("URL:");
        mensajeURL.setBounds(30, 30, 100, 30);
        getContentPane().add(mensajeURL);
        
        JTextField txtURL = new JTextField();
        txtURL.setBounds(130, 30, 200, 30);
        getContentPane().add(txtURL);
        
        JLabel mensajeBaseDatos = new JLabel("Base de Datos:");
        mensajeBaseDatos.setHorizontalAlignment(SwingConstants.LEFT);
        mensajeBaseDatos.setBounds(30, 80, 100, 30);
        getContentPane().add(mensajeBaseDatos);
        
        JTextField txtBaseDatos = new JTextField();
        txtBaseDatos.setBounds(130, 80, 200, 30);
        getContentPane().add(txtBaseDatos);
        
        JLabel mensajeColeccion = new JLabel("Colección:");
        mensajeColeccion.setBounds(30, 130, 100, 30);
        getContentPane().add(mensajeColeccion);
        
        JTextField txtColeccion = new JTextField();
        txtColeccion.setBounds(130, 130, 200, 30);
        getContentPane().add(txtColeccion);

        JButton botonConectar = new JButton("Conectar");
        botonConectar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String url = txtURL.getText();
                String nombreBaseDatos = txtBaseDatos.getText();
                String coleccion = txtColeccion.getText();
                
                if (!url.isEmpty() && !nombreBaseDatos.isEmpty() && !coleccion.isEmpty()) {
                    try {
                        MongoClient client = MongoClients.create(url);
                        MongoDatabase db = client.getDatabase(nombreBaseDatos);
                        MongoCollection col = db.getCollection(coleccion);

                        JOptionPane.showMessageDialog(null, "Conectado correctamente.");
                        dispose();  
                        new opciones().setVisible(true);  
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al conectar: " + ex);
                    }
        	    
                }
        	}
        });
        botonConectar.setBounds(213, 220, 117, 30);
        getContentPane().add(botonConectar);

        setVisible(true);
    }
}
