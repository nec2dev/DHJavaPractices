/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_genericos;

import java.util.*;

import usoempleado.Empleado;

/**
 *
 * @author Nahuel E Correa
 *
 */

public class MetodosGenericos {
    
    public static void main(String[] args){
        
        String nombres[] = {"José", "María", "Giuseppe"};
        
        System.out.println(MisMatrices.getMenor(nombres));
        
        GregorianCalendar fechas[] = {new  GregorianCalendar(2005,07,12),
            new  GregorianCalendar(2008,05,31),new  GregorianCalendar(2018,04,01),
        };
        
        System.out.println(MisMatrices.getMenor(fechas));
        
        /*Empleado paco = new Empleado("Pablo", 45, 2500);
        Empleado ana = new Empleado("Ana", 45, 2500);
        Empleado maria = new Empleado("María", 45, 2500);
        
        Empleado misEmpleados[] = {paco,ana,maria};
        
        System.out.println(MisMatrices.getMenor(misEmpleados));*/
        
        /*String elementos = MisMatrices.getElementos(nombres);
        
        System.out.println(elementos);
        
        Empleado listadeEmpleados[] = {new Empleado("Ana", 45, 2500),
        new Empleado("José", 45, 2500), new Empleado("María", 45, 2500),
        new Empleado("Pablo", 45, 2500), new Empleado("Analía", 45, 2500)};
        
        System.out.println(MisMatrices.getElementos(listadeEmpleados));*/
    }
}

/*class MisMatrices{
    
    public static <T> String getElementos(T[]a){
        
        return "El array tiene: " + a.length + " elementos.";*/

class MisMatrices {
    
    public static <T extends Comparable> T getMenor(T[]a){//No implements
        
        if (a == null || a.length == 0){
            
            return null;
        }
        
        T elementoMenor = a[0];
        
        for (int i = 0; i < a.length; i++) {
            
            if (elementoMenor.compareTo(a[i])>0){
                
                elementoMenor = a[i];
            }
            
        }
        
        return elementoMenor;
    }
}