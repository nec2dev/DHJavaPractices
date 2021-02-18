/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usoempleado;

/**
 *
 * @author Nahuel E Correa
 * 
 */

public class Empleado {
    
public Empleado(String nombre, int edad, double sueldo){
        
        this.nombre = nombre;
        
        this. edad = edad;
    
        this.sueldo = sueldo;
    }

public String dameDatos(){

    return "El empleado de nombre " + nombre + ", tiene " + edad + " años. Y tiene un sueldo de $ " + sueldo;

}

private String nombre;

private int edad;

private double sueldo;

}
