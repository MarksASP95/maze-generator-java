package interfazgrafica;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import static mazegenerator.MazeGenerator.home;

public class Home extends JFrame{
    
    private laminaHome miLamina = new laminaHome();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public static String directorio;
    public static File direc;
 
    public Home(){
              
        setSize(380,240);
        setLocation(dim.width / 2 - this.getSize().width / 2, (dim.height / 2 - this.getSize().height / 2));
        setTitle("MazeGenerator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(miLamina);
        setVisible(true);
        
    }
    class laminaHome extends JComponent{
    
    private JButton comenzar = new JButton("Start");
    private JButton info = new JButton("Help");
    private JLabel titulo = new JLabel("MazeGenerator");
    private JLabel inst = new JLabel("Directory name for the labyrinths:");
    private JTextField campo = new JTextField();
    
    public laminaHome(){
        setLayout(null);
        titulo.setFont(new Font("Lucida Console", Font.BOLD, 18));
        comenzar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                directorio = campo.getText();
                if ( // START IF
                        directorio.equals("") ||
                        directorio.substring(0,1).equals(" ") ||
                        directorio.contains("/") ||
                        directorio.contains(":") ||
                        directorio.contains("*") ||
                        directorio.contains("?") ||
                        directorio.contains("<") ||
                        directorio.contains(">") ||
                        directorio.contains("|")
                        ) //END IF
                {
                    JOptionPane.showMessageDialog(null, "You must assign a valid name for the directory", "MazeGenerator", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    direc = new File(directorio);
                    if (direc.exists()) {
                        JOptionPane.showMessageDialog(null, "This directory already exists", "MazeGenerator", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        home.setVisible(false);
                        MainMenu menu = new MainMenu();
                    }
                    
                }
                
            }
        });
        
        info.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Info informacion = new Info();
            }
        });
        
        titulo.setBounds(40,10,300,20);
        inst.setBounds(40,50,300,20);
        campo.setBounds(110,70, 160, 25);
        comenzar.setBounds(140,110,110,40);
        info.setBounds(140,160,110,40);
        
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        inst.setHorizontalAlignment(SwingConstants.CENTER);

        add(titulo);
        add(comenzar);
        add(inst);
        add(info);
        add(campo);
        }
    
    }

    
}

