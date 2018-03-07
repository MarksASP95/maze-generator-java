package interfazgrafica;

import background.Labyrinth;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class LabyrinthInterface extends JFrame{ // FRAME
    
    private Labyrinth miLaberinto;  
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    public LabyrinthInterface(String dims) throws FileNotFoundException{ // LA EXCEPCION SE DEVUELVE EN CADENA (CLASE LABERINTO)
                
        LaminaInterfazLaberinto miLamina;
        setSize(600,600);
        setLocation(dim.width / 2 - this.getSize().width, (dim.height / 2 - this.getSize().height / 2));
        setResizable(false);

        switch(dims){
            case "10x10":        
                miLaberinto = new Labyrinth(10);
                miLamina = new LaminaInterfazLaberinto(10,48,60);
                add(miLamina);
                setVisible(true);
                break;
            case "20x20":
                miLaberinto = new Labyrinth(20);
                miLamina = new LaminaInterfazLaberinto(20,23,45);
                add(miLamina);
                setVisible(true);
                break;
            case "50x50":
                miLaberinto = new Labyrinth(50);
                miLamina = new LaminaInterfazLaberinto(50,9,38);
                add(miLamina);
                setVisible(true);
                break;
            case "100x100":
                miLaberinto = new Labyrinth(100);
                miLamina = new LaminaInterfazLaberinto(100,4,34);
                add(miLamina);
                setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Set the dimensions", "MazeGenerator", JOptionPane.WARNING_MESSAGE);
        } 
    }
}

class LaminaInterfazLaberinto extends JComponent{ // PANEL
    
    private int dims, trazo, margen;
    
    public LaminaInterfazLaberinto(int d, int t, int m){
        dims = d;
        trazo = t;
        margen = m;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(trazo); //SE ESTABLECE GROSOR DE LINEA
        g2.setStroke(stroke); //SE APLICA GROSOR
        int j = 0;
        
        for (int i = 0; i < dims*dims; i++) {  // SE DIBUJAN LINEAS QUE FORMARAN EL LABERINTO UTILIZANDO LOS ARREGLOS ESTATICOS CORRESPONDIENTES
            g2.drawLine(Labyrinth.starts[i][j] * (500/dims) + margen, 
                        Labyrinth.starts[i][j+1] * (500/dims) + margen, 
                        Labyrinth.ends[i][j] * (500/dims) + margen, 
                        Labyrinth.ends[i][j+1] * (500/dims) + margen);
        }
    }
        
}
