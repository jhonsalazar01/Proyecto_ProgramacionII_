package co.edu.uptc.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import co.edu.uptc.persistencia.Archivo;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**Esta clase sirve para animar todo la parte grafica del juego
 * @author dilan jhonS, JhonJ
 *
 */
public class Animacion extends JPanel {

	private static final int WIDTH = 1218;
	private static final int HEIGHT = 563;

	private static final double g = 9.8; // aceleraciÃƒÂ³n debido a la gravedad en m/s^2
	private static final double DT = 0.05; // intervalo de tiempo en segundos

	private double x, y, vx, vy, t, tv;

	double v0 = 180; // velocidad inicial en m/s
	double theta = 80; // ÃƒÂ¡ngulo de lanzamiento en grados
	double h0 = 0; // altura inicial en metros
	private Timer timer;
	private int intentos = 5;

	private JPanel zonaGreen;
	private JPanel ZonaOrange;
	private JPanel ZonaRed;

	private Image img, newimg;
	private JLabel imageLabel;
	private JButton JBIniciar;
	private JPanel panelExplosion;

	/**
	 * Este es el metodo contructor en donde se incializa las propiedades
	 */
	public Animacion() {

		setSize(1194, 516);
		setLayout(null);
		setBackground(null);
		setOpaque(false);

		// Inicializar las variables

		x = 0;
		y = h0;
		vx = v0 * Math.cos(Math.toRadians(theta));
		vy = v0 * Math.sin(Math.toRadians(theta));
		t = 0;

		iniciarComponentes();
		iniciarAnimacion();

	}
	
	
	/***
	 * Este metodo es el comienza animacion de la bala
	 */
	private void iniciarAnimacion() {

		Image img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/botonInicio.png")).getImage();

		Image newimg = img.getScaledInstance(110, 52, Image.SCALE_SMOOTH);

		JLabel imageLabel3 = new JLabel();

		imageLabel3.setBounds(285, 395, 110, 52);

		JBIniciar = new JButton();

		JBIniciar.setBounds(285, 395, 146, 69);

		JBIniciar.setBorder(BorderFactory.createEmptyBorder());

		JBIniciar.setBackground(Color.RED);

		JBIniciar.setOpaque(false);

		JBIniciar.setIcon(new ImageIcon(newimg));

		JBIniciar.addActionListener(e -> {

			
			new Sonido(2);
			
			if (intentos != 0) {

				vx = v0 * Math.cos(Math.toRadians(getTheta()));

				vy = v0 * Math.sin(Math.toRadians(getTheta()));

				Toolkit.getDefaultToolkit().beep();

				setTimer(new Timer((int) (DT), evt -> {

					try {

						moverProyectil();

					} catch (InterruptedException ex) {

						throw new RuntimeException(ex);

					}

					repaint();

				}));

				timer.start();

				JBIniciar.setVisible(false);

				intentos--;

			}

			else {

				new Resultados();

			}

		});

		add(JBIniciar);

	}
	/**
	 * Este metodo nos inicia todos lo componentes que usamos
	 */
	private void iniciarComponentes() {
		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes//barco.png")).getImage();
		newimg = img.getScaledInstance(239, 163, Image.SCALE_SMOOTH);

		imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon(newimg));
		add(imageLabel);
		imageLabel.setBounds(820, 300, 239, 163);

		zonaGreen = new JPanel();
		zonaGreen.setBounds(imageLabel.getX(), imageLabel.getY() + 125, 250, 25);
		zonaGreen.setBackground(Color.green);
		zonaGreen.setVisible(false);
		add(zonaGreen);

		ZonaOrange = new JPanel();
		ZonaOrange.setBounds(imageLabel.getX() + 40, imageLabel.getY() + 75, 160, 50);
		ZonaOrange.setBackground(Color.orange);
		ZonaOrange.setVisible(false);
		add(ZonaOrange);

		ZonaRed = new JPanel();
		ZonaRed.setBounds(imageLabel.getX() + 60, imageLabel.getY(), 130, 80);
		ZonaRed.setBackground(Color.red);
		ZonaRed.setVisible(false);
		add(ZonaRed);

		panelExplosion = new JPanel();
		panelExplosion.setBounds(imageLabel.getX(), imageLabel.getY(), 254, 254);

		panelExplosion.setVisible(false);
		add(panelExplosion);

	}

	/**
	 * Este metodo nos grafica la bala de cañon
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gd2 = (Graphics2D) g;
		gd2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Dibujar el proyectil
		gd2.setColor(Color.BLACK);
		gd2.fillOval((int) x + 165, (int) (HEIGHT - y) - 190, 15, 15);
	}
	
	
	/**
	 * Este metedo es el que mueve la bala de cañon
	 * @throws InterruptedException
	 */
	public void moverProyectil() throws InterruptedException {
		// Calcular la nueva posiciÃƒÂ³n y velocidad del proyectil
		double ax = 0;
		double ay = -g;
		x += vx * DT;
		y += vy * DT + 0.5 * ay * DT * DT;
		vx += ax * DT;
		vy += ay * DT;
		t += DT;

		detectarColision(x, y);
		if (!timer.isRunning()) {
			x = 0;
			y = 0;
			vx = 0;
			vy = 0;
			t = 0;
			tv = 0;
			JBIniciar.setVisible(true);
			repaint();
		}

	}
	
	/**
	 * Este metodo nos retorna el tiempo de vuelo por cada tiro
	 * @return tiempo en el que el proyectil se encuentra en el aire
	 */
	public double tiempoVuelo() {
		double tiempo = (2 * v0 * Math.sin(Math.toRadians(theta))) / g;

		return tiempo;

	}
	
	
	/**
	 * Este metodo es para detectar las colocion en un valor X y Y
	 * @param x
	 * @param y
	 * @throws InterruptedException
	 */
	public void detectarColision(double x, double y) throws InterruptedException {

		if (y < -140) {
			timer.stop();
			JBIniciar.setVisible(true);
		}


		
		
		if (x>1100) {
			timer.stop();
			JBIniciar.setVisible(true);
		}
		

		if (y < -140) {
		new Sonido(3);
			// panelExplosion.add(new AnimacionExplosion());
			timer.stop();
			JBIniciar.setVisible(true);
		}
		if (x >= ZonaRed.getLocation().getX() - 190 && x <= ZonaRed.getLocation().getX() + ZonaRed.getWidth() - 190) {
			if (y >= ZonaRed.getLocation().getY() - 320
					&& y <= ZonaRed.getLocation().getY() + ZonaRed.getHeight() - 320) {
				System.out.println("Zona Roja");

				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Impacto: Zona Red");
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en X es de: " + String.valueOf(x));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en Y es de: " + String.valueOf(y));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Su tiempo de Vuelo es de:" + tiempoVuelo());
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Tiro realizado Correctamente su ecuacion es: X= (" + v0 + "^2*sen*" + theta + ")/" + g);
				
				moverObjeto();
				
				new Sonido(4);
				
				timer.stop();
			}
		} else if (x >= ZonaOrange.getLocation().getX() - 200
				&& x <= ZonaOrange.getLocation().getX() + ZonaOrange.getWidth() - 200) {
			if (y >= ZonaOrange.getLocation().getY() - 430
					&& y <= ZonaOrange.getLocation().getY() + ZonaOrange.getHeight() - 430) {
				System.out.println("Zona naranja");
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Impacto: Zona Orange");
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en X es de: " + String.valueOf(x));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en Y es de: " + String.valueOf(y));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Su tiempo de Vuelo es de:" + tiempoVuelo());
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Tiro realizado Correctamente su ecuacion es: X= (" + v0 + "^2*sen*" + theta + ")/" + g);
				moverObjeto();
				new Sonido(4);
				timer.stop();
			}
		} else if (x >= zonaGreen.getLocation().getX() - 220
				&& x <= zonaGreen.getLocation().getX() + zonaGreen.getWidth() - 220) {
			if (y >= zonaGreen.getLocation().getY() - 495
					&& y <= zonaGreen.getLocation().getY() + zonaGreen.getHeight() - 495) {
				System.out.println("Zona green");
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Impacto: Zona Green");
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en X es de: " + String.valueOf(x));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt",
						"Su desplazamiento en Y es de: " + String.valueOf(y));
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Su tiempo de Vuelo es de:" + tiempoVuelo());
				new Archivo().AgregarContenidoArchivo("Puntuacion.txt", "Tiro realizado Correctamente su ecuacion es: X= (" + v0 + "^2*sen*" + theta + ")/" + g);
				moverObjeto();
				new Sonido(4);
				timer.stop();
			}
		}

	}
	
	
	/**
	 * Este metodo nos va mover la zonas de impacto cada vez que sean impactadas
	 */
	public void moverObjeto() {
		int aleatorio = ((int) (Math.random() * (1000 - 450 + 1) + 450));
		System.out.println(aleatorio);
		imageLabel.setBounds(aleatorio, 300, 239, 163);
		zonaGreen.setBounds(aleatorio, 425, 250, 25);
		ZonaOrange.setBounds(aleatorio + 40, 375, 160, 50);
		ZonaRed.setBounds(aleatorio + 60, 300, 130, 80);
	}

	
	/**
	 * Este metedo nos cambia la velocidad por cero
	 * @param v0 velocidad en cero
	 */
	public void setV0(double v0) {
		this.v0 = v0;
	}

	/**
	 * Este metodo nos retorna el valor del angulo
	 * @return angulo del cañon
	 */
	public double getTheta() {
		return theta;
	}
	
	
	/**
	 * Este metodo nos cambia el valor del angulo
	 * @param theta Angulo del cañon
	 */
	public void setTheta(double theta) {
		this.theta = theta;
	}

	/**
	 * Este metodo nos cambia el tiempo
	 * @param timer El tiempo del lanzamineto
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	/**
	 * Este metodo nos returna el numero de intentos
	 * @return
	 */
	public int getIntentos() {
		return intentos;
	}

	/**
	 * Este metodo nos retorna que si la accion del boton
	 * @return
	 */
	public JButton getJBIniciar() {
		return JBIniciar;
	}
}
