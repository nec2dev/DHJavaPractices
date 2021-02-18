/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendo;

//import java.io.FileNotFoundException;esta es la subclase de la superclase IOException
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 */
public class Acceso_Fichero {
    
    public static void main(String[] args){
        
        Leer_Fichero acceder = new Leer_Fichero();
        
        acceder.lee();
        
    }
    
    
}

class Leer_Fichero{
    
    public void lee(){
        
        try{
            
        entrada = new FileReader("F:/Codo a Codo/Acceso_Ficheros/src/leyendo/ejemplo.txt");
    
        BufferedReader mibuffer = new BufferedReader(entrada);//Buffer, tambien llemado filtro
        
        String linea = "";
        
        while(linea != null){
            
            linea = mibuffer.readLine();
            
            if(linea != null)//en el if no necesita llave si hay solo una linea despues
            
                System.out.println(linea);//Sin el if devuelve la ultima linea como null
            
        }
    
        //int c = 0;
        
        /*while(c != -1){
            
            c = entrada.read();
            
            char letra = (char)c;
            
            System.out.print(letra);
            
        }*/
        
        //entrada.close();
        
        }catch(IOException fnfe){
        
            System.out.println("No se ha encontrado el archivo");
              
    }finally{
            
            try {
                entrada.close();
                
            } catch (IOException fnfe) {
                
                fnfe.printStackTrace();
            }
        }
        
}
    FileReader entrada;
}