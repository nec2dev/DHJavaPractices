/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

/**
 *
 * @author Nahuel E Correa
 */
public class Uso_Pareja {
    
    public static void main (String[] args){
        
        Pareja<String> una = new Pareja<String>();
        
        una.setPrimero("Campeón!");
        
        System.out.println(una.getPrimero());
        
        Persona persona1 = new Persona("Ana");
        
        Pareja<Persona> otra = new Pareja<Persona>();
        
        otra.setPrimero(persona1);
        
        System.out.println(otra.getPrimero());
        
    }
    
}

class Persona{
    
    public Persona(String nombre){
        
        this.nombre = nombre;
        
    }
    
    @Override
    public String toString(){
    
    return nombre;
}
    
    private String nombre;
}
