/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.util.*;

import java.io.*;


/**
 *
 * @author Mayra
 * 
 */
public class Serializacion {
    
    public static void main (String[] args){
        
        Administrador jefe = new Administrador ("Nahuel", 80000, 2005, 12, 15);
        
        jefe.setIncentivo(5000);
        
        Empleado[] persona1 = new Empleado[3];
        
        persona1[0] = jefe;
        
        persona1[1] = new Empleado ("Mayra", 25000, 2009, 10, 1);
        
        persona1[2] = new Empleado ("Brisa", 10000, 2012, 9, 15);
    }
    
}
