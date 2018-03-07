package interfazgrafica;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;

public class Info extends JFrame{
    
    
    private laminaInfo miLamina = new laminaInfo();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Info(){
        
        setSize(485,500);
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setResizable(false);
        add(miLamina);
        setVisible(true);
        
    }    
}

class laminaInfo extends JPanel{
    
    private String nL = System.getProperty("line.separator");
    
    private JLabel bienvenido = new JLabel("Bienvenido a MazeGenerator");
    
    private JTextArea textoInfo = new JTextArea(
                    "MazeGenerator es un programa que genera laberintos utilizando el algoritmo Aldous-Broder. " + 
                    "Para generar un laberinto, primero debes especificar el nombre del lugar donde serán guardados como archivo de texto, es decir, "+
                    "los laberintos que crees se guardarán en una carpeta con el nombre que especifiques en la ventana principal del programa, " + 
                    "esta carpeta se guardará en el directorio de MazeGenerator. Después de escribir el nombre de la carpeta, haz clic en 'Comenzar'" + nL + nL +
                    "El algoritmo Aldous-Broder toma decisiones de forma aleatoria, por lo cual, si deseas generar un laberinto de 50x50 o 100x100, " +
                    "lo más probable es que tengas que esperar unos segundos hasta que termine (los laberintos de 100x100 pueden tardar hasta un minuto en generarse)." + nL + nL +
                    "Los laberintos guardados en archivos de texto estarán dibujados con caracteres, por eso es óptimo que establezcas la fuente de tu " + 
                    "editor de texto por defecto a una fuente consistente en medidas de ancho y alto para ciertos caracteres, te recomendamos que la fuente de tu editor de texto sea 'Lucida Console'." + nL + nL +
                    "Para que MazeGenerator funcione debes tener instalado JDK 7 o cualquier versión superior." + nL + nL +
                    "Para cualquier comentario, duda o sugerencia, puedes contactar a los autores de este proyecto, cuya informacion encontrarás en el archivo AUTORES."
    );
    
    public laminaInfo(){
        setLayout(null);
        bienvenido.setBounds(132,20,220,20);
        bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        textoInfo.setBounds(15,60, 440, 400);
        textoInfo.setLineWrap(true);
        textoInfo.setWrapStyleWord(true);
        textoInfo.setOpaque(false);
        textoInfo.setEditable(false);
        bienvenido.setFont(new Font("Arial", Font.BOLD, 15));
        add(bienvenido);
        add(textoInfo);
    }   
}
