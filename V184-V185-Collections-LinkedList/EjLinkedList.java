/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;
import java.util.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class EjLinkedList {
    
    public static void main (String[] args){
        
        LinkedList<String> personas = new LinkedList<String>();
        
        personas.add("Manuel");
        
        personas.add("Sandra");
        
        personas.add("Ana");
        
        personas.add("laura");
        
        personas.add(0,"Nahuel");
        
        System.out.println(personas.size());
        
        ListIterator<String> it = personas.listIterator();
        
        it.next();
        
        it.add("Ezequiel");
        
        it.add("Correa");
        
        
        
        for (String persona : personas) {
            
            System.out.println(persona);
            
        }
                   
    }
    
}