/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.io.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */

public class Uso_ArrayList {
    
    public static void main(String[] args){
        
        ArrayList2 archivos = new ArrayList2(4);
        
        archivos.add("Juan");
        archivos.add("María");
        archivos.add("Ana");
        archivos.add("Paula");
        archivos.add(new File("gestion_pedidos.accdb"));
        
        String nombrePersona = (String)archivos.get(4);//Casting cada vez que vamos a instanciar 
        
        /*archivos.add(new File("gestion_pedidos.accdb"));
        
        File nombrePersona = (File)archivos.get(0);*/
        
                System.out.println(nombrePersona);
    }
    
}
