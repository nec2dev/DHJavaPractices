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
public class EjMaps {
    
    public static void main(String[] args){
        
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
        
        personal.put("145", new Empleado("Nahuel"));
        
        personal.put("146", new Empleado("Ezequiel"));
        
        personal.put("147", new Empleado("Fux"));
        
        personal.put("148", new Empleado("nec2"));
        
        System.out.println(personal);
        
        personal.remove("148");
        
        System.out.println("");
        
        System.out.println(personal);
        
        System.out.println("");
        
        personal.put("147", new Empleado("Fuxine"));
        
        System.out.println(personal);
        
        System.out.println("");
        
        //System.out.println(personal.entrySet());
        
        for (Map.Entry<String, Empleado>  entrada : personal.entrySet()) {
            
            String clave = entrada.getKey();
            
            Empleado valor = entrada.getValue();
            
            System.out.println("Clave = " + clave + ", valor = " + valor);
            
        }
    }
}

class Empleado{
    
    public Empleado(String nombre){
        
        this.nombre = nombre;
        
        sueldo = 2000;
        
    }
    
    public String toString(){
        
        return "[Nombre = " + nombre + ", sueldo = " + sueldo + "].";
    }
    
    private String nombre;
    
    private double sueldo;
}
