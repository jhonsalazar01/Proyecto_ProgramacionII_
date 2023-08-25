package co.edu.uptc.GUI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase configura los sonidos de cada componente de la interfaz
 * @author dilan, jhonS, jhonJ
 *
 */
public class Sonido {

    private AudioInputStream audioInputStream;
    private Clip clip;

    /**
     * Este metodo constructor contiene las direcciones de los sonidos
     * @param opc
     */
    public Sonido(int opc) {
        String nombreSonido = "";
        switch (opc) {
            case 1:
                //Sonido de Fondo
                nombreSonido = "src/Recursos/Sonido/musicaFondo.wav";
                break;
            case 2:
                //Sonido Explosion Cañon
                nombreSonido = "src/Recursos/Sonido/lanzarCanion.wav";
                break;

            case 3:
                //Sonido impacto agua
                nombreSonido = "src/Recursos/Sonido/impactoAgua.wav";
                break;
            case 4:
                //Sonido impacto Barco
                nombreSonido = "src/Recursos/Sonido/impactoBarco.wav";
                break;
        }
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
        }
    }

    /**
     * Este metodo retorna el clip de la musica
     * @return clip ed la musica
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Este metodo cambia el clip de la musica
     * @param clip
     */
    public void setClip(Clip clip) {
        this.clip = clip;
    }
}

