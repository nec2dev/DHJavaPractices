/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel E Correa
 */
public class Fallos {
    
    public static void main (String[] args){
        
        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
        
        int[] miMatriz = new int[5];
        
        miMatriz[0] = 5;
        miMatriz[1] = 38;
        miMatriz[2] = -15;
        miMatriz[3] = 92;
        miMatriz[4] = 71;
        //miMatriz[5] = -81;
        
        for(int i=0; i<5; i++){
            
            System.out.println("Posición " + i + " = " + miMatriz[i]);
            
        }
        
        //Ejemplo pide datos personales
        
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
        
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
        
        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
        
        System.out.println("El programa terminó su ejecución");
    }
    
}
