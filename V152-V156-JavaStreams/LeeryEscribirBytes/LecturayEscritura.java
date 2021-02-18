/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeeryEscribirBytes;

import java.io.*;


/**
 *
 * @author Mayra
 * 
 */
public class LecturayEscritura {
    
    public static void main (String[] args){
        
        int contador_byte = 0;
        
        int datos_entrada[] = new int[1004507];
        
        try{
            
            FileInputStream archivo_lectura = new FileInputStream("I:\\Codo a Codo\\Recursos\\1prim.jpg");
            
            boolean final_archivo = false;
            
            while(!final_archivo){
                
                int byte_entrada = archivo_lectura.read();
                
                if (byte_entrada != -1)
                    
                   datos_entrada[contador_byte] = byte_entrada;
                
                if (byte_entrada == -1)
                    
                   final_archivo = true; 
                
                System.out.println(byte_entrada);
                
                contador_byte ++;
            }
            
            archivo_lectura.close();
            
        }catch(IOException e){
        
            System.out.println("Error, No se encuentra el archivo");
        
    }
        System.out.println("La imagen tiene " + contador_byte + " bytes.");
        
        //System.out.println(datos_entrada[contador_byte]);
        
        crea_fichero(datos_entrada);
    }
    
    
    static void crea_fichero(int dato_nuevo_fichero[]){
        
        try{
            
            FileOutputStream fichero_nuevo = new FileOutputStream("I:\\Codo a Codo\\Recursos\\1prim_copia.jpg");
            
            for (int i = 0; i < dato_nuevo_fichero.length; i++) {
                
                fichero_nuevo.write(dato_nuevo_fichero[i]);
                
            }
            
            fichero_nuevo.close();
                    
        }catch(IOException ioe){
        
            System.out.println("Error al crear el archivo.");}
            
            
        }
    }
    

