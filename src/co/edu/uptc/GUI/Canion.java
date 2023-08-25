package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Este clase nos sirve para darle las propiedades del ca�on
 * @author dilan jhonS, jhonJ
 *
 */
public class Canion extends JPanel {

    private Image img, newimg;
    private MainWindow mw;
    private double angle = -80;
    private double angleFina = 0;

    /**
     * Este metodo constructor no sirve para anadir la imagen al Jpanel
     * @param mwn
     */
    public Canion(MainWindow mwn) {
        setSize(240, 140);
        setLayout(null);
        setBackground(null);
        setOpaque(false);

        img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/canion.png")).getImage();
        newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);

        this.mw = mwn;


    }
    
    /**
     * Este metodo grafica el imgaen en el panel
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Crea una transformación de afine que rota la imagen según el ángulo actual
        AffineTransform transform = new AffineTransform();
        transform.translate(0, 0);
        transform.rotate(Math.toRadians(angle), newimg.getWidth(null) / 2, newimg.getHeight(null) / 2);

        // Dibuja la imagen rotada
        g2d.drawImage(newimg, transform, mw);
    }


    public void setAngle(double angle) {
        this.angle = angle;
    }


}