/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usoempleado;

import java.util.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */

public class Uso_Empleado {
    
        public static void main (String[] args){
            
            /*Empleado listadeEmpleados[] = new Empleado[4];
            
            listadeEmpleados[0] = new Empleado("Brisa", 45, 2500);
            
            listadeEmpleados[1] = new Empleado("Greta", 31, 5500);
            
            listadeEmpleados[2] = new Empleado("Mayra", 22, 7500);
            
            listadeEmpleados[3] = new Empleado("Debora", 22, 7500);*/
            
            ArrayList <Empleado> listadeEmpleados = new ArrayList<Empleado>();
            
            /*listadeEmpleados.ensureCapacity(11);*/ /*el arrayList al tener una capacidad
            inicial de 10 elemntos, prepara la memoria para almacenar estos diez elemntos,
            pero si agregamos otro elemento el ArrayList crea una copia de esas diez posiciones
            y la duplica, esto implica un uso de memoria para 20 elementos pero alberga 11.
            Para que no haya desperdicio de memoria le podemos indicar la cantidad final de elemntos
            que va a tener este ArrayList......Evitamos el proceso de copia de elemntos*/
            
            listadeEmpleados.add(new Empleado("Brisa", 45, 2500));
            
            listadeEmpleados.add(new Empleado("Greta", 31, 5500));
            
            listadeEmpleados.add(new Empleado("Mayra", 22, 7500));
            
            listadeEmpleados.add(new Empleado("Debora", 22, 7500));
            
            listadeEmpleados.add(new Empleado("María", 45, 9500));
            
            listadeEmpleados.add(new Empleado("BrisaO", 45, 2500));
            
            listadeEmpleados.add(new Empleado("GretaO", 31, 5500));
            
            listadeEmpleados.add(new Empleado("MayraO", 22, 7500));
            
            listadeEmpleados.add(new Empleado("DeboraO", 22, 7500));
            
            listadeEmpleados.add(new Empleado("MarñíaO", 45, 9500));
            
            listadeEmpleados.add(new Empleado("Octavio", 33, 9500));
            
            listadeEmpleados.add(new Empleado("Susy", 15, 9100));
            
            listadeEmpleados.add(new Empleado("Sergio", 21, 9300));
            
            //listadeEmpleados.trimToSize();
            //corta el espacio de memoria
            
            //listadeEmpleados.add(new Empleado("Diego", 21, 9300));
            
            listadeEmpleados.set(1, new Empleado("Diego", 21, 9300));
            
            System.out.println("el arrayList tiene " + listadeEmpleados.size() + " elementos.");
            
            /*for (Empleado e: listadeEmpleados){
                
                System.out.println(e.dameDatos());
                
                
                System.out.println(listadeEmpleados.get(4).dameDatos());
            }*/
            
            Iterator<Empleado> miIterator = listadeEmpleados.iterator();
            
            while(miIterator.hasNext()){
                
                System.out.println(miIterator.next().dameDatos());
            }
            
            /*for (int i = 0; i < listadeEmpleados.size(); i++) {
                
                Empleado e = listadeEmpleados.get(i);
                
                System.out.println(e.dameDatos());
                
            }*/
            
            
            /*Empleado arraydeEmpleados[] = new Empleado[listadeEmpleados.size()];
            
            listadeEmpleados.toArray(arraydeEmpleados);
            
            for (int i = 0; i < arraydeEmpleados.length; i++) {
                
                System.out.println(arraydeEmpleados[i].dameDatos());
                
            }*/
        }
    
}


    
    
