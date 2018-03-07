package interfazgrafica;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import static mazegenerator.MazeGenerator.home;

public class MainMenu extends JFrame{
    
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    private LaminaMenuP miLamina = new LaminaMenuP();
    
    private WindowAdapter exitListener = new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            home.setVisible(true);
        }
    };
    
    public MainMenu(){
        
        addWindowListener(exitListener);
        setResizable(false);
        setSize(300,200);
        setTitle("Maze Generator");
        setLocation(dim.width / 2, (dim.height / 2 - this.getSize().height / 2));
        add(miLamina);

        setVisible(true);
        
    }
    
    class LaminaMenuP extends JPanel implements ActionListener{
    
        private JButton aceptar = new JButton("Generate");

        private String[] comboItems = new String[] {"Select dimensions","10x10","20x20","50x50","100x100"};

        private JComboBox comboBox = new JComboBox(comboItems);

        private String dims;
       
        public LaminaMenuP(){

            setLayout(null);
            aceptar.addActionListener(this);
            aceptar.setBounds(95,80, 110, 40);
            comboBox.setBounds(40,20,220,30);
            add(comboBox);
            add(aceptar);

        }
    
        public void actionPerformed(ActionEvent e){

            dims = comboBox.getSelectedItem().toString();
            try {
                LabyrinthInterface nuevoLab = new LabyrinthInterface(dims);
            } catch (FileNotFoundException ex) {
                System.out.println("Error: " + ex);
            }

        }
    
    }
    
}

