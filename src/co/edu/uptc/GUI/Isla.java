package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase confifura la parte grafica de la isla
 * @author dilan, jhongS, jhonJ
 *
 */
public class Isla extends JPanel{
	
	private Image img, newimg;
	private MainWindow mw;
	

	/**
	 * Este metodo constructor nos permite alterrar las propiedades de la imagen
	 * @param mwn
	 */
	public Isla(MainWindow mwn) {
		
		setSize(350, 280);
		setLayout(null);
		setBackground(null);
		setOpaque(false);

		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/isla.png")).getImage();
		newimg = img.getScaledInstance(350, 280, Image.SCALE_SMOOTH);

		this.mw = mwn;
	}
	
	/**
	 * Este metodo nos grafica la imagen
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(newimg, 0, 0, 300, 180, null, mw);
	}
}
