package co.edu.uptc.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase es la principal que invoca las propiedades de las demas
 * @author dilan
 *
 */
public class MainWindow extends JFrame {

    private Barco barco;
    private Canion canion;
    private Isla isla;
    private Animacion aiAnimacion;
    private AnimacionOlas animacionOlas;
    private Soporte soporte;

    private JPanel panelFondo;
    private JPanel panelBarco;
    private JPanel panelOlas;
    private JPanel panelCanion;
    private JPanel panelSopCanion;
    private JPanel panelIsla;
    private JPanel panelAnimacionMUR;
    private JSlider sliderAngulo;
    private JSlider sliderVelocidad;
    private JLabel jLabelAngulo;
    private JLabel jLabelVelocidad;
    private JLabel jLabelFormula;
    private Sonido sonido;
    private JPanel jp;


    private JButton JBIniciar;

    /**
     * este metodo contructor nos configura las propiedades de nuestra ventana
     */
    public MainWindow() {
        //sonido = new Sonido(1);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1218, 563);

        setBackground(null);

        setLocationRelativeTo(null);
        setTitle("Movimiento Parabolico");
        setResizable(false);

        inicarComponentes();

        setVisible(true);
    }

    /**
     * Este metodo nos inicializa las propiedades de los componentes
     */
    private void inicarComponentes() {
        jp = new JPanel();
        jp.setBounds(750, 60, 350, 60);
        jp.setOpaque(false);

        jp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        new Sonido(1);

        Image img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/boton.png")).getImage();
        Image newimg = img.getScaledInstance(550, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel3 = new JLabel();
        imageLabel3.setIcon(new ImageIcon(newimg));
        imageLabel3.setBounds(660, 0, 800, 150);

        Image img2 = new ImageIcon(getClass().getResource("/Recursos/Imagenes/marco.png")).getImage();
        Image newimg2 = img2.getScaledInstance(1195, 525, Image.SCALE_SMOOTH);
        JLabel imageLabel33 = new JLabel();
        imageLabel33.setIcon(new ImageIcon(newimg2));
        imageLabel33.setBounds(5, 5, 1218, 518);
        add(imageLabel33);

        aiAnimacion = new Animacion();
        aiAnimacion.setVisible(true);

        barco = new Barco(this);
        barco.setVisible(true);

        canion = new Canion(this);
        canion.setVisible(true);

        isla = new Isla(this);
        isla.setVisible(true);

        animacionOlas = new AnimacionOlas(this);
        animacionOlas.setVisible(true);

        soporte = new Soporte(this);
        soporte.setVisible(true);

        panelFondo = new JPanel();
        panelFondo.setOpaque(false);
        panelFondo.setBounds(5, 5, 1194, 516);
        panelFondo.setLayout(null);

        panelBarco = new JPanel();
        panelBarco.setBackground(null);
        panelBarco.setOpaque(false);
        panelBarco.setBounds(818, 300, 139, 63);
        panelBarco.setLayout(null);


        panelAnimacionMUR = new JPanel();
        panelAnimacionMUR.setBackground(null);
        panelAnimacionMUR.setOpaque(false);
        panelAnimacionMUR.setBounds(0, 0, panelFondo.getWidth(), panelFondo.getHeight());
        panelAnimacionMUR.setLayout(null);

        panelCanion = new JPanel();
        panelCanion.setBackground(null);
        panelCanion.setOpaque(false);
        panelCanion.setBounds(100, 305, 1194, 516);
        panelCanion.setLayout(null);
        //panelCanion.setVisible(false);


        panelSopCanion = new JPanel();
        panelSopCanion.setBackground(null);
        panelSopCanion.setOpaque(false);
        panelSopCanion.setBounds(150, 370, 1194, 516);
        panelSopCanion.setLayout(null);

        panelIsla = new JPanel();
        panelIsla.setBackground(null);
        panelIsla.setOpaque(false);
        panelIsla.setBounds(0, 290, 250, 180);
        panelIsla.setLayout(null);

        panelOlas = new JPanel();
        panelOlas.setBounds(5, 5, panelFondo.getWidth(), panelFondo.getHeight());
        panelOlas.setLayout(null);


        add(jp);
        add(imageLabel3);


        validarIntentos(aiAnimacion.getIntentos());
        // Creamos una instancia de la clase JLabel y le pasamos la imagen que queremos agregar
        aiAnimacion.getJBIniciar().

                addActionListener(e ->
                {
                    validarIntentos(aiAnimacion.getIntentos() - 1);
                });


        Image imagenPanelAnguloVista = new ImageIcon(getClass().getResource("/Recursos/Imagenes/boton.png")).getImage();
        Image newimagenPanelAnguloVista = imagenPanelAnguloVista.getScaledInstance(80, 160, Image.SCALE_SMOOTH);
        JLabel imageLabelAnguloVista = new JLabel();
        imageLabelAnguloVista.setIcon(new ImageIcon(newimagenPanelAnguloVista));
        imageLabelAnguloVista.setBounds(30, 0, 80, 160);


        JPanel jPanelAnguloVista = new JPanel();
        jPanelAnguloVista.setBounds(35, 60, 70, 70);
        jPanelAnguloVista.setBackground(Color.white);
        jPanelAnguloVista.add(new JLabel("Angulo"));
        jPanelAnguloVista.setOpaque(false);
        add(jPanelAnguloVista);
        add(imageLabelAnguloVista);


        Image imagenPanelVelocidadVista = new ImageIcon(getClass().getResource("/Recursos/Imagenes/boton.png")).getImage();
        Image newimagenPanelVelocidadVista = imagenPanelVelocidadVista.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
        JLabel imageLabelVelocidadVista = new JLabel();
        imageLabelVelocidadVista.setIcon(new ImageIcon(newimagenPanelVelocidadVista));
        imageLabelVelocidadVista.setBounds(110, 0, 100, 160);
        

        JPanel jPanelVelocidadVista = new JPanel();
        jPanelVelocidadVista.setBounds(132, 60, 70, 70);
        jPanelVelocidadVista.setBackground(Color.white);
        jPanelVelocidadVista.add(new JLabel("Velocidad"));
        jPanelVelocidadVista.setOpaque(false);
        add(jPanelVelocidadVista);
        add(imageLabelVelocidadVista);

        Image imagenPanelFormulaVista = new ImageIcon(getClass().getResource("/Recursos/Imagenes/boton.png")).getImage();
        Image newimagenPanelFormulaVista = imagenPanelFormulaVista.getScaledInstance(200, 160, Image.SCALE_SMOOTH);
        JLabel imageLabelFormulaVista = new JLabel();
        imageLabelFormulaVista.setIcon(new ImageIcon(newimagenPanelFormulaVista));
        imageLabelFormulaVista.setBounds(210, 0, 200, 160);
        
        Image imagenSliderVelocidad = new ImageIcon(getClass().getResource("/Recursos/Imagenes/slider-mayor.png")).getImage();
        Image newimagenSliderVelocidad = imagenSliderVelocidad.getScaledInstance(300, 36, Image.SCALE_SMOOTH);
        JLabel LabelSliderVelocidad = new JLabel();
        LabelSliderVelocidad.setIcon(new ImageIcon(newimagenSliderVelocidad));
        LabelSliderVelocidad.setBounds(38, 142, 674, 66);
        
        Image imagenSliderAngulo = new ImageIcon(getClass().getResource("/Recursos/Imagenes/slider-menor.png")).getImage();
        Image newimagenSliderAngulo = imagenSliderAngulo.getScaledInstance(205, 36, Image.SCALE_SMOOTH);
        JLabel LabelSliderAngulo = new JLabel();
        LabelSliderAngulo.setIcon(new ImageIcon(newimagenSliderAngulo));
        LabelSliderAngulo.setBounds(38, 205, 205, 36);

        JPanel jPanelFormula = new JPanel();
        jPanelFormula.setBounds(243, 60, 130, 80);
        jPanelFormula.setBackground(Color.white);
        jPanelFormula.add(new JLabel("Alcance"));
        jPanelFormula.setOpaque(false);
        add(jPanelFormula);
        add(imageLabelFormulaVista);


        // Crea el JSlider y lo configura seg�n tus necesidades
        sliderAngulo = new JSlider(0, 30, 80, 80);
        sliderAngulo.setBounds(40, 200, 200, 50);
        sliderAngulo.setMajorTickSpacing(10);
        sliderAngulo.setMinorTickSpacing(1);
        sliderAngulo.setPaintTicks(false);
        sliderAngulo.setPaintLabels(false);
        sliderAngulo.setPaintTrack(false);
        sliderAngulo.setOpaque(false);
       
        //Color azul a los numeros y divisiones
        sliderAngulo.setForeground(Color.blue);
        sliderAngulo.addChangeListener(e ->

        {
            canion.setAngle(-sliderAngulo.getValue()); // Obtiene el valor actual del slider y lo guarda en la variable de �ngulo
            repaint(); // Vuelve a dibujar el ca��n con el nuevo �ngulo
            aiAnimacion.setTheta(sliderAngulo.getValue());
            
            asignarAlcanceJlabelFormula();
            jLabelAngulo.setText(String.valueOf(sliderAngulo.getValue()));
        });

        add(sliderAngulo);


        sliderVelocidad = new JSlider(0 , 80, 180, 180);
        sliderVelocidad.setBounds(40,150 , 300, 50);
        sliderVelocidad.setMajorTickSpacing(10);
        sliderVelocidad.setMinorTickSpacing(1);
        sliderVelocidad.setPaintTicks(false);
        sliderVelocidad.setPaintLabels(false);
        sliderVelocidad.setPaintTrack(false);
        sliderVelocidad.setOpaque(false);
       
        //Color azul a los numeros y divisiones
        sliderVelocidad.setForeground(Color.blue);
        sliderVelocidad.addChangeListener(e ->

        {
            aiAnimacion.setV0(sliderVelocidad.getValue());
            asignarAlcanceJlabelFormula();
            jLabelVelocidad.setText(Integer.toString(sliderVelocidad.getValue()));
            
        });

        add(sliderVelocidad);
        

        add(LabelSliderVelocidad);
        add(LabelSliderAngulo);

//Crear Jlabel resultado de la formula
        jLabelFormula = new

                JLabel();
        jLabelFormula.setBounds(0, 0, 30, 40);

        asignarAlcanceJlabelFormula();
        jLabelFormula.setVisible(true);
        //   jLabelFormula.setText();
        Font font = new Font("Bahnschrift Light", Font.BOLD + Font.ITALIC, 36);
        jLabelFormula.setFont(font);
        jPanelFormula.add(jLabelFormula);


//Crear Jlabel para mostrar el angulo
        jLabelAngulo = new JLabel();
        jLabelAngulo.setBounds(0, 0, 30, 40);
        jLabelAngulo.setText(Integer.toString(sliderAngulo.getValue()));
        jLabelAngulo.setVisible(true);
        font = new Font("Bahnschrift Light", Font.BOLD + Font.ITALIC, 36);
        jLabelAngulo.setFont(font);
        jPanelAnguloVista.add(jLabelAngulo);
        //Crear Jlabel para mostrar la velocidad
        jLabelVelocidad = new JLabel();
        jLabelVelocidad.setBounds(0, 0, 30, 40);
        jLabelVelocidad.setText(Integer.toString(sliderVelocidad.getValue()));
        jLabelVelocidad.setVisible(true);
        font = new Font("Bahnschrift Light", Font.BOLD + Font.ITALIC, 36);
        jLabelVelocidad.setFont(font);
        jPanelVelocidadVista.add(jLabelVelocidad);


        // Crea el JSlider y lo configura seg�n tus necesidades


        panelBarco.add(barco);
        panelAnimacionMUR.add(aiAnimacion);
        panelSopCanion.add(soporte);
        panelCanion.add(canion);
        panelIsla.add(isla);
        panelOlas.add(animacionOlas);

        panelFondo.add(panelSopCanion);
        panelFondo.add(panelCanion);
        panelFondo.add(panelAnimacionMUR);
        panelFondo.add(panelIsla);


        this.

                add(panelFondo);
        this.

                add(panelOlas);


    }

    
    /**
     * Este metodo nos anima la accion de la bomba cuando impacta
     * @param intentos
     */
    private void validarIntentos(int intentos) {
        jp.removeAll();
        Image img = new ImageIcon(getClass().getResource("/Recursos/Imagenes/bomba.png")).getImage();
        Image newimg = img.getScaledInstance(62, 55, Image.SCALE_SMOOTH);
        for (int i = 0; i < intentos; i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon(newimg));
            jp.add(imageLabel); // Agregamos la etiqueta al panel jp
        }
    }
    
    /**
     * Este metodo nos ayuda da saber cual es el alcance de la bala
     */

    public void asignarAlcanceJlabelFormula() {
        double g = 9.81;
        double radianes = Math.toRadians(sliderAngulo.getValue());
        double alcance = Math.pow(sliderVelocidad.getValue(), 2) * Math.sin(2 * radianes) / g;
        jLabelFormula.setText((String.format("%.0f", alcance) + " m"));

    }
}

