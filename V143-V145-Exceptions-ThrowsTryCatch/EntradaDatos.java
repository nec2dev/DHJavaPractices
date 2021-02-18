/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;
import java.util.*;

/**
 *
 * @author Nahuel E Correa
 */
public class EntradaDatos {
    
    public static void main(String[] args){
        
        System.out.println("¿Qué desa hacer?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");
        
        Scanner entrada = new Scanner (System.in);
        
        int decision = entrada.nextInt();
        
        if(decision == 1){
            
            try{
            
            pedirDatos();
            
            
        }catch(InputMismatchException ime){
            
                System.out.println("Qué demonio haz introducido en edad?!");
        }
        }else{
            
            System.out.println("Adiós!");
            
            System.exit(0);
        }
           
        entrada.close();
    }
    
    static void pedirDatos() throws InputMismatchException{
        
        try{
        
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Introduce tu nombre, por favor");
        
        String nombreUsuario = entrada.nextLine();
        
        System.out.println("Introduce tu edad, por favor");
        
        int edadUsuario = entrada.nextInt();
        
        System.out.println("Hola " + nombreUsuario + ", tienes " + edadUsuario + " años."
                + " Y el año que viene tendrás " + (edadUsuario+1) + " años.");
        
        entrada.close();
        }catch(InputMismatchException ime/*o puede ir Exception e*/){
            
            System.out.println("Qué demonio haz introducido en edad?!");
        }
        System.out.println("El programa terminó su ejecución");
        
        
    }
}
