package co.edu.uptc.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Esta clase nos da las propiedes de una imagen para colocarla de fondo
 * @author dilan jhonS, jhonJ
 *
 */
public class FondoRegistro extends JPanel{
	
	private Image img, newimg;
	private Registro reg;
	
	
	/**
	 * Este metodo constructor nos configura la imagen del fondo del panel
	 * @param rog
	 */
	 public FondoRegistro(Registro rog) {
		// TODO Auto-generated constructor stub
	
		
		this.reg = rog;
		
		setSize(reg.getWidth(), reg.getHeight());
		setLayout(null);
		setOpaque(true);

		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/HD-wallpaper-pirates-map-pirates-map-flag-boat.jpg")).getImage();
		newimg = img.getScaledInstance(1080, 519, Image.SCALE_SMOOTH);

		//setVisible(true);

	}

	 /**
	  * Este metodo nos grafica la imagen de fondo
	  */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(newimg, -5, 0, getWidth(), getHeight(), new Color(23, 222, 226), reg);
	}


}


