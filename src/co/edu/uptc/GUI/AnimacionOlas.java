package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase sirve para colocar el fondo de la interfaz
 * @author dilan, jhonJ, jhonJ
 *
 */
public class AnimacionOlas extends JPanel{
	
	private Image img, newimg;
	private MainWindow mw;
	
	/**
	 * Este metodo contructor sirve para crear el fondo de la interfaz
	 * @param mwn
	 */
	public AnimacionOlas(MainWindow mwn) {
		
		this.mw = mwn;
		
		setSize(mw.getWidth(), mw.getHeight());
		setLayout(null);
		setOpaque(true);

		img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/fonda.gif")).getImage();
		newimg = img.getScaledInstance(1080, 519, Image.SCALE_SMOOTH);

		

	}

	/**
	 * Este metodo nos anima el fondo
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(newimg, -5, 0, getWidth(), getHeight(), new Color(23, 222, 226), mw);
	}


}
