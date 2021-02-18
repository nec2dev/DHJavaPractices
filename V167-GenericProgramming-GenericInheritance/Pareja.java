/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

/**
 *
 * @author Nahuel E Correa
 * 
 */

public class Pareja <T>{
    
    public Pareja(){
        
        primero = null;
    }
    
    public void setPrimero(T nuevoValor){
        
        primero = nuevoValor;
    }
    
    public T getPrimero(){
        
        return primero;
    }
    
    private T primero;
    
    
    
}
