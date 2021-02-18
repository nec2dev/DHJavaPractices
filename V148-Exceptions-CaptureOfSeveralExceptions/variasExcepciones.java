/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;
import javax.swing.*;

/**
 *
 * @author Nahuel E Correa
 * 
 * 
 */
public class variasExcepciones {
    
    public static void main(String[] arg){
        
        try{
        
            division();
    
        }catch(ArithmeticException ae ){
            
            System.out.println("No se permite la división por 0");
        
        }catch(NumberFormatException nfe ){
            
            System.out.println("No has introducido un número entero");
            
            //System.out.println(nfe.getMessage());
            
            System.out.println("Se ha generado un error de este tipo: " + nfe.getClass().getName());
        }
    }
    
    static void division(){
        
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el dividendo: "));
    
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el divisor: "));
        
        System.out.println("El resultado es: " + num1/num2);

        
    } 
}
