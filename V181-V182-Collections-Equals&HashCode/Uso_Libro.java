/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Uso_Libro {
    
    public static void main(String[] args){
        
        Libro libro1 = new Libro("la guerra de los gimnasios", "César Aira", 2357457);
        
        Libro libro2 = new Libro("la guerra de los gimnasios II", "César Aira", 2357432);
        
        //libro1 = libro2;
        
        //El hashcode es la referencia a la ubicacion de la memoria heap de un bjeto
        
        if(libro1.equals(libro2)){
            
            System.out.println("es el mismo libro");
            
            System.out.println(libro1.hashCode());
            
            System.out.println(libro2.hashCode());
            
        }else{
            
            System.out.println("No es el mismo libro");
            
            System.out.println(libro1.hashCode());
            
            System.out.println(libro2.hashCode());
        }
    }
    
}
