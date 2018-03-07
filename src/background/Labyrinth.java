package background;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import static interfazgrafica.Home.direc;
import static interfazgrafica.Home.directorio;

public class Labyrinth {
    
    // ARREGLOS QUE UTILIZARAN PARA GENERAL EL LABERINTO GRAFICAMENTE
    public static int[][] starts;
    public static int[][] ends;
    
    private int inicialX, inicialY;
    private Random random = new Random();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private String t1;
    private int seg1, seg2, tiempo = 0, i = 0, j = 0, fila, columna;
    private PrintStream out;
    static int numArchivo = 0;

    public Labyrinth(int dimensiones) throws FileNotFoundException{
        
        starts = new int[dimensiones*dimensiones][2];
        ends = new int[dimensiones*dimensiones][2];
        
        Calendar cal = Calendar.getInstance(); // SE OBTIENE HORA DEL SISTEMA AL INICIAL EL PROCESO
        t1 = sdf.format(cal.getTime());    
        
        String[][] celdas = new String[dimensiones][dimensiones];
        
        for (int i = 0; i < celdas.length; i++) {     //SE INICIAN LAS CELDAS DEL LABERINTO
            for (int j = 0; j < celdas[i].length; j++) {
                celdas[i][j] = "0";
            }    
        }
        
        inicialX = random.nextInt(dimensiones); // SE ESTABLECE LA CELDA AL AZAR
        inicialY = random.nextInt(dimensiones);
        fila = inicialX;
        columna = inicialY;
        starts[i][j] = fila;
        j++;
        starts[i][j] = columna;
        j  = 0;
        
        aldousBroder(inicialX, inicialY, celdas, dimensiones);
    }
    
    public void aldousBroder(int actX, int actY, String[][] celdas, int dimensiones) throws FileNotFoundException{ // DEBE DEVOLVER EXCEPCION AL NO ENCONTRAR ARCHIVO DE TEXTO
        
        int nueva;
        int visited = 0;
        int fil_col;
        int mas_menos;

        Calendar cal;

        numArchivo++;          
        direc.mkdir();
        File file = new File(directorio + "/" + "output" + Integer.toString(numArchivo) + ".txt");   // AHORA LA NUEVA FORMA DE OUTPUT ES ARCHIVO DE TEXTO
        out  = new PrintStream(new FileOutputStream(file));                       //
        
        
        System.setOut(out);
        
        cal = Calendar.getInstance();
        t1 = sdf.format(cal.getTime());
        t1 = t1.substring(6,8);
        seg1 = Integer.parseInt(t1); //SE OBTIENEN LOS SEGUNDOS 
        
        while(!checkIfDone(celdas))
        {

            fil_col = random.nextInt(2);
            mas_menos = random.nextInt(2);
            
            if (fil_col == 0) { //------------------------CAMBIAR DE FILA
                
                if (mas_menos == 1) {  // AUMENTAR 1 (SI ES POSIBLE)
                    nueva = actX + 1;
                    if (nueva == dimensiones) {
                        nueva = actX - 2;
                    }
                }
                else{                  // DISMINUIR 1 (SI ES POSIBLE)
                    nueva = actX - 1;
                    if (nueva < 0) {
                        nueva = actX + 2;
                    }
                }
                
                if (celdas[actX][actY].equals("0")) {
                    visited++;
                    celdas[actX][actY] = "|";
                    starts[i][j] = fila;
                    j++;
                    starts[i][j] = columna;        // SE ACTUALIZAN LOS ARREGLOS HISTORIA
                    j=0;
                    ends[i][j] = actX;
                    j++;
                    ends[i][j] = actY;
                    j = 0;
                    i++;
                }
                
                fila = actX;
                columna = actY;
                
                actX = nueva;      
            }
            else{ //----------------------------------CAMBIAR DE COLUMNA
                
                if (mas_menos == 1) {
                    nueva = actY + 1;
                    if (nueva == dimensiones) {
                        nueva = actY - 2;
                    }
                }
                else{
                    nueva = actY - 1;
                    if (nueva < 0) {
                        nueva = actY + 2;
                    }
                }
                if (celdas[actX][actY].equals("0")) {
                    visited++;
                    celdas[actX][actY] = "-";
                    starts[i][j] = fila;
                    j++;
                    starts[i][j] = columna;
                    j=0;
                    ends[i][j] = actX;
                    j++;
                    ends[i][j] = actY;
                    j = 0;
                    i++;

                }
                fila = actX;
                columna = actY;
                
                actY = nueva;
            }    
            checkIfDone(celdas);
        }
        
        for (int i = 0; i < celdas.length; i++) {     //SE INICIAN LAS CELDAS DEL LABERINTO
            for (int j = 0; j < celdas[i].length; j++) {
                System.out.print(celdas[i][j]);
            }    
            System.out.println();
        }
        cal = Calendar.getInstance();
        t1 = sdf.format(cal.getTime());
        t1 = t1.substring(6,8);
        seg2 = Integer.parseInt(t1);
        if (seg1 > seg2) 
        {
            tiempo = 60 - seg1 + seg2;
        }
        else{
            tiempo = seg2 - seg1;
        }
        System.out.println("Generation time: " + tiempo + " second(s)");
        System.out.println("Dimensions: " + dimensiones + "x" + dimensiones);
    }
    
    public Boolean checkIfDone(String[][] celdas){ // DEVUELVE UN BOOLEANO QUE ESTABLECE SI EL ALGORITMO ESTA COMPLETO
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j].equals("0")) {
                    return false;
                }
            }
        }
        return true;
    }
 
}