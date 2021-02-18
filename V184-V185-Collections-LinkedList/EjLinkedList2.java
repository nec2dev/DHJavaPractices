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
public class EjLinkedList2 {
    
    public static void main(String[] args){
        
        LinkedList<String> paises = new LinkedList<String>();
        
        paises.add("España");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Perú");
        paises.add("Argentina");
        paises.add("Uruguay");
        
        LinkedList<String> capitales = new LinkedList<String>();
        
        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("D.F.");
        capitales.add("Lima");
        capitales.add("Buenos Aires");
        capitales.add("Montevideo");
        
        //System.out.println(paises);
        //System.out.println(capitales);
        
        ListIterator<String> iteradorA = paises.listIterator();
        ListIterator<String> iteradorB = capitales.listIterator();
        
        while(iteradorB.hasNext()){
            
            if(iteradorA.hasNext()){
                
                iteradorA.next();
            }
            
        iteradorA.add(iteradorB.next());
        
        }
        
        System.out.println(paises);
        
        iteradorB = capitales.listIterator();
        
        while(iteradorB.hasNext()){
            
            iteradorB.next();
            
            if(iteradorB.hasNext()){
                
                iteradorB.next();
                
                iteradorB.remove();
            }
        }
        
        System.out.println(capitales);
        
        paises.removeAll(capitales);
        
        System.out.println(paises);
    }
    
    
    
}
