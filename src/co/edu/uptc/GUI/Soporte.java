package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase nos configura las propiedades del soportel cañon
 * @author dilan, jhonS, jhonJ
 *
 */
public class Soporte extends JPanel{

	private Image img, newimg;
	private MainWindow mw;
	
	/**
	 * Este metodo constructor nos configura los componentes del soporte del cañon
	 * @param mwn
	 */
	public Soporte( MainWindow mwn) {
		
		setSize(40, 70);
		setLayout(null);
		setOpaque(false);

		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/soporte.png")).getImage();
		newimg = img.getScaledInstance(40, 70, Image.SCALE_SMOOTH);

		this.mw = mwn;
	}
	
	/**
	 * este metodo grafica la imagen del soporte del cañon
	 */
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(newimg, 0, 0, 40, 70, null, mw);
	}
}
