package co.edu.uptc.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.uptc.persistencia.Archivo;

/**
 * Esta clas nos sirve para registrar el nombre del jugar y dar unas breves instrucciones
 * @author dilan, jhonS, jhonJ
 *
 */
public class Registro extends JFrame implements ActionListener{
	

	private Image img, newimg;
	private MainWindow mw;
	
	private JLabel imageLabel;
	private JPanel title;
	private Label titulo;
	
	private FondoRegistro fondo;
	
	private JLabel Name;
	private JLabel ingrese;
	
	private JTextField jugador;
	private JTextArea instrucciones; 
	
	public JTextField getJugador() {
		return jugador;
	}

	public void setJugador(JTextField jugador) {
		this.jugador = jugador;
	}

	private JButton iniciar;
	
	private JLabel imboton;
	
	private String RecibirName;
	
	public String getRecibirName() {
		return RecibirName;
	}

	public void setRecibirName(String recibirName) {
		RecibirName = recibirName;
	}

	/**
	 * Este metodo constructor nos configura las propiedades de la ventana
	 */
	public Registro() {
		// TODO Auto-generated constructor stub
		 setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(1090, 563);

	        setBackground(null);

	        setLocationRelativeTo(null);
	        setTitle("Movimiento Parabolico");
	        setResizable(false);
	      
	      //  new MainWindow();
	        iniciarComopentes();
	        GetName();
	       

	}
	
	/**
	 * Este metodo toma el nombre del JTexfield de la interfaz 
	 * @return Nombre del jugador
	 */
	public String GetName() {
		String name="";
		name= jugador.getText();
		
		Animacion an= new Animacion();
		
		//an.recibirTexto(name);
		
		return name;
	}
	

	/**
	 * Este metodo incia los componentes y las propiedades
	 */
	private void iniciarComopentes() {
		// TODO Auto-generated method stub
		
		fondo= new FondoRegistro(this);
		fondo.setVisible(true);
		
		
		title= new JPanel();
		title.setBounds(0, 0, fondo.getWidth(), fondo.getHeight());
		title.setBackground(Color.red);
        title.setLayout(null);
        
     
        
        Name= new JLabel("PIRATES WARS");
        Name.setBounds(650,25,1000,100);
        Name.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 35));
        Name.setLayout(null);
        
        jugador= new JTextField();
        jugador.setBounds(600,200,300,50);
        jugador.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
        jugador.setOpaque(false);
        
        ingrese= new JLabel("INGRESE EL NOMBRE DEL JUGADOR");
        ingrese.setBounds(600,150,400,25);
        ingrese.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
      
        instrucciones= new JTextArea("INSTRUCCIONES"+"\nUN PIRATE ENEMIGO SE ROBO NUESTRO TESOROE\nPARA DETENERLO TENEMOS 5 BALAS DE CAÑON\n"
        		+ "PUEDES CAMBIAR LA VELOCIDAD Y EL ANGULO\n DE TIROPARA IMPACTAR EN DIFERENTES \nPARTES CRITICAS");
        instrucciones.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
        instrucciones.setOpaque(false);
        instrucciones.setBounds(80,250,500,500);
        
        iniciar= new JButton("INICIAR");
        iniciar.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 25));
        iniciar.setBounds(630,340,100,50);
        iniciar.setBorder(BorderFactory.createEmptyBorder());
        iniciar.setBackground(Color.RED);
        iniciar.setOpaque(false);
        iniciar.addActionListener(this);
        
        img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/botonInicio2.png")).getImage();
        newimg = img.getScaledInstance(239, 163, Image.SCALE_SMOOTH);

     
        imboton= new JLabel();
        imboton.setIcon(new ImageIcon(newimg));
        imboton.setBounds(580,300,300,120);
        imboton.setLayout(null);
        
        title.add(jugador);
		
		
		this.add(title);
		 title.add(Name);
		 title.add(ingrese);
		 title.add(instrucciones);
		
		 title.add(iniciar);
		 title.add(imboton);
	
		   
	        title.add(fondo);
        setVisible(true);
		
	}
	
	/**
	 * Este metodo nos ayuda  cambiar de ventana para ir a la ventana del juego
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object componente = e.getSource();
		
		if (componente.equals(iniciar)) {
			setRecibirName(jugador.getText());
			System.out.println(GetName());
		 	new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "----------------\n"+"JUGADOR: "+getRecibirName());
			this.setVisible(false);
			new MainWindow();
		}
		}

	
	}


