package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase nos sirve para darle las propiedades al barco
 * @author dilan, jhons, jhonJ
 *
 */
public class Barco extends JPanel{

	private Image img, newimg;
	private MainWindow mw;
	
	/**
	 * Este metodo constructor para darle crear el barco
	 * @param mwn
	 */
	public Barco(MainWindow mwn) {
		
		setSize(180, 90);
		setLayout(null);
		setOpaque(false);

		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/barco.png")).getImage();
		newimg = img.getScaledInstance(239, 163, Image.SCALE_SMOOTH);

		this.mw = mwn;
	}
	

	/**
	 * Este metodo grafica el barco
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(newimg, 0, 0, 239, 163, null, mw);
	}
}
