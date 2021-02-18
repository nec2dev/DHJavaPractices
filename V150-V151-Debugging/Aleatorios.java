/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejdebugging;

import javax.swing.*;

/**
 *
 * @author Nahuel E Correa
 * 
 * Tuvimos que depurar para que de numeros aleatorios
 * .random daba solo ceros 000
 * 
 * Poner un brakpoint en la línea problematica
 * e ir avanzando con step over
 * en Output esta la consola del debug
 * 
 */
public class Aleatorios {
    
    public static void main(String[] args)  {
        
        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz: "));
        
        int num_aleatorio[] = new int[elementos];
        
        for(int i=0; i<num_aleatorio.length; i++){
            

            num_aleatorio[i] =(int) (Math.random()*100);
            
        }
        for( int elem: num_aleatorio){
        
            System.out.println(elem);
    }
    }
    
}
