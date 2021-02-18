/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel E Correa
 * 
 * 
 */
public class AreaPeso {
    
    public static void main(String [] args){
        
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Elije una opción: \n1: Cuadrado \n2: Rectángulo"
                + "\n3: Triángulo \n4: Círculo"  );
       
        try{
           
        figura = entrada.nextInt();
        
    }catch(InputMismatchException ime){
    
            System.out.println("Ha ocurrido un error");
    
}finally{
           
             entrada.close();
             
        }
        
        switch(figura){
            
            case 1: 
                
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el lado: " ));
                
                double areacuadrado = Math.pow(lado,2);
                
                System.out.println("El área del Cuadrado es de: " + areacuadrado);
                
                break;
                
            case 2: 
                
                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la base: " ));
                
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura: " ));
                
                System.out.println("El área del Rectángulo es de: " + base*altura);
                
                break;
                
            case 3:
                
                int basetr = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la base: " ));
                
                int alturatr = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura: " ));
                
                System.out.println("El área del Triángulo es de: " + basetr*alturatr);
                
                break;
                
            case 5:
                
                double radio =  Double.parseDouble(JOptionPane.showInputDialog("Introduzca el radio: " ));
                
                double areacirculo = Math.PI*(Math.pow(radio, 2));
                
                System.out.println("El área del Círculo es de: " + areacirculo);
                
                break;
                
            default:
                
                System.out.println("La opción no es correcta");
        }
        
            float altura = Float.parseFloat(JOptionPane.showInputDialog("Introduzca su altura en centímetros: " ));
            
            System.out.println("Si eres hombre tu peso ideal es " + (altura - 110) + " Kg.");
            
            System.out.println("Si eres mujer tu peso ideal es " + (altura - 120) + " Kg.");
    }
    static int figura;
    
}
