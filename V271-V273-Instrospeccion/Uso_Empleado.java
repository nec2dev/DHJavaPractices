/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrospections;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Uso_Empleado {
    
    public static void main(String[] args){
        
            Persona Antonia = new Persona("Antonia");
            
            System.out.println(Antonia.getNombre());
            
            Empleado Ana = new Empleado("Ana", 35000);
            
            System.out.println(Ana.getNombre());
            
            System.out.println(Ana.getSalario());
            
            //System.out.println(Antonia.getClass());
            
            //Class c11 = Antonia.getClass();
            
            //System.out.println(c11.getName());
            
            String nombreClase = "instrospections.Persona";
            
            Class c11;
            
            try {
                
             c11 = Class.forName(nombreClase);
            
                System.out.println(c11.getName());
            
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Uso_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
            nombreClase = "instrospections.Empleado";
            
            try {
                
             c11 = Class.forName(nombreClase);
            
                System.out.println(c11.getName());
            
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Uso_Empleado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
    }
    
}

class Persona{
    
    public Persona(String nombre){
        
        this.nombre = nombre;
        
    }
    
    public String getNombre(){
        
        return nombre;
    }
    
    private String nombre;
}

class Empleado extends Persona{
    
    public Empleado(String nombre, double salario){

    super(nombre);
    
    this.salario = salario;

    }
    
    public void SetIncentivo(double incentivo){
        
        salario = salario+incentivo;
        
    }
    
    public String getSalario(){
        
        return "el salario final es: " + salario;
    }
    
    private double salario;

}
