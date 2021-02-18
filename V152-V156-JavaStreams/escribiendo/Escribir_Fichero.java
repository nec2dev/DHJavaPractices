/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribiendo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Escribir_Fichero {
    
    public static void main(String[] arg){
        
        escribiendo acceder = new escribiendo();
        
        acceder.escribir();
    }
}

class escribiendo{
    
    public void escribir(){
        
        String frase = "Esto es una prueba de escritura";
        
        try {
            FileWriter escribir = new FileWriter("F:/Codo a Codo/Acceso_Ficheros/src/escribiendo/nuevo_texto.txt", true);
            //true reescribe el fichero
        
            for(int i=0; i<frase.length(); i++){
                
                escribir.write(frase.charAt(i));
            }
            
            escribir.close();
        
        } catch (IOException ex) {
            Logger.getLogger(escribiendo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}