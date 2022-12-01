package lineasMetroAtenas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class Interfaz extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton botonAccion;
	private ImageIcon mapa = new ImageIcon(getClass().getResource("/Imagenes/MapaAtenas.jpg"));
	private ImageIcon puntoSalida = new ImageIcon(getClass().getResource("/Imagenes/salida.png"));
	private ImageIcon puntoDestino = new ImageIcon(getClass().getResource("/Imagenes/destino.png"));
	private ImageIcon lineas = new ImageIcon(getClass().getResource("/Imagenes/punto.png"));
    private JLabel planoFondo;
    
    private javax.swing.JComboBox<String> jComboBoxOrigen;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    
	public String estacionO, estacionD;
	public static String[] estacionOrigen, estacionDestino;

	
	private String[] listaEstaciones = new String[58];

	JTextField tiempoViaje;
	JTextField numeroTrasbordos;
	JTextPane recorrido;
	JScrollPane scrollpanel;
	JPanel panel; 
	
	
	public Interfaz() {
		// Caracter�sticas del frame
				setTitle("lineasMetroAtenas");
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setSize(800, 680);
		        this.setResizable(false);
		        this.setVisible(true);
		        this.setLocationRelativeTo(null);
		        
		        // Caracter�sticas del panel
		        panel = (JPanel) this.getContentPane();
		        panel.setLayout(null);
		        
		        // Plano en panel
				planoFondo = new JLabel();
				planoFondo.setIcon(mapa);
				planoFondo.setBounds(0, -180, 1900, 1000);
				panel.add(planoFondo);
				planoFondo.setOpaque(false);
				
				// Literal de estaci�n origen
		        JLabel label1 = new JLabel("Estacion origen:");
		        panel.add(label1);
		        Dimension size1 = label1.getPreferredSize();
		        label1.setBounds(630, 10, size1.width, size1.height);
		     
				
		        // Lista para elegir estaci�n origen
				listaEstaciones = lineasMetroAtenas.listaEstaciones(listaEstaciones);
				jComboBoxOrigen = new javax.swing.JComboBox<>();
				jComboBoxOrigen.setBounds(630, 30, 150, 30);
				jComboBoxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(listaEstaciones));
				panel.add(jComboBoxOrigen);
				//jComboBoxOrigen.addActionListener(this);

		        // Literal de estaci�n destino
		        JLabel label2 = new JLabel("Estacion destino:");
		        panel.add(label2);
		        Dimension size2 = label2.getPreferredSize();
		        label2.setBounds(630, 70, size2.width, size2.height);
		        label2.setOpaque(true);
		        
				// Lista para elegir estaci�n destino
				jComboBoxDestino = new javax.swing.JComboBox<>();
				jComboBoxDestino.setBounds(630, 90, 150, 30);
				jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(listaEstaciones));
				panel.add(jComboBoxDestino);
				//jComboBoxDestino.addActionListener(this);
			 
				// Boton para procesar petici�n
				botonAccion = new JButton();
				botonAccion.setText("Procesar peticion");
				botonAccion.setBounds(630, 200, 150, 40);
				panel.add(botonAccion);
				botonAccion.addActionListener(this);
				
				// Literal de Tiempo de viaje
		        JLabel label5 = new JLabel("Tiempo de viaje:");
		        panel.add(label5);
		        Dimension size5 = label5.getPreferredSize();
		        label5.setBounds(630, 260, size5.width, size5.height);
		  
				// Resultado de tiempo de viaje
		        tiempoViaje = new JTextField();
		        tiempoViaje.setBounds(630, 280, 150, 30);
		        tiempoViaje.setEditable(false);
		        panel.add(tiempoViaje);
		        
				// Literal de Numero de trasbordos
		        JLabel label6 = new JLabel("Numero de trasbordos:");
		        panel.add(label6);
		        Dimension size6 = label6.getPreferredSize();
		        label6.setBounds(630, 310, size6.width, size6.height);
		  
				// Resultado de numero de trasbordos
		        numeroTrasbordos = new JTextField();
		        numeroTrasbordos.setBounds(630, 330, 150, 30);
		        numeroTrasbordos.setEditable(false);
		        panel.add(numeroTrasbordos); 
		        
				// Literal de estaciones recorridas
		        JLabel label7 = new JLabel("Recorrido:");
		        panel.add(label7);
		        Dimension size7 = label7.getPreferredSize();
		        label7.setBounds(630, 400, size7.width, size7.height);
		  
				// Lista de estaciones recorridas
		        recorrido = new JTextPane();
		        recorrido.setEditable(false);
		        add(recorrido); 
		        
		        scrollpanel = new JScrollPane();
		        scrollpanel.setBounds(new Rectangle(630, 420, 150, 190));
		        scrollpanel.setViewportView(recorrido);
		        add(scrollpanel);
		        
		         
		        repaint();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

  }
}	

