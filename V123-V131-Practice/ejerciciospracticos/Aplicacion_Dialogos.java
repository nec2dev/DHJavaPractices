/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciospracticos;

import javax.swing.JFrame;

/**
 *
 * @author Nahuel E Correa
 */
public class Aplicacion_Dialogos {
    
        public static void main (String[] args){
            
            Marco_Dialogos miMarco = new Marco_Dialogos();
            
            miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            miMarco.setVisible(true);
        }
    
}
