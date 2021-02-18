/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrospections;

import java.lang.reflect.*;
import java.util.Scanner;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class TestInstrospeccion {
    
    public static void main(String[] args){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("introduzca el nombre de la clase");
        
        String nombreClase;
        
        nombreClase = entrada.next();
        
        //Imprimir clase y superclase
        
        try{
            
            Class cl = Class.forName(nombreClase);
            
            Class superCl = cl.getSuperclass();
            
            System.out.println("Clase: " + nombreClase);
            
            if(superCl != null && superCl != Object.class){
                
                System.out.println(" extends " + superCl.getName());
                
            }
            
            System.out.println("");
            
            imprimirConstructores(cl);
            
            imprimirMetodos(cl);
            
            System.out.println("");
            
            imprimirCampos(cl);
            
        }catch(Exception e){
            
            e.printStackTrace();
            
            System.exit(0);
            
        }
        
    }
    
    //Imprime todos los parámetros
    public static void imprimirConstructores(Class cl){
        
        Constructor[] constructores = cl.getDeclaredConstructors();
        
        for(Constructor c: constructores){
            
            String nombre = c.getName();
            
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            
            System.out.print("  " + nombre + "(");
            
            //Imprimir parámetros
            
            Class[] tipoParams = c.getParameterTypes();
            
            for(int i=0; i<tipoParams.length; i++){
                
                if(i>0) System.out.print(",  ");
                
                System.out.print(tipoParams[i].getName());
                
            }
            
            System.out.println(");");
        }
    }
    
    //Imprime todos los metodos de clase
    public static void imprimirMetodos(Class cl){
        
        Method[] metodos = cl.getDeclaredMethods();
        
        for(Method m: metodos){
            
            Class tipodevuelto = m.getReturnType();
            
            String nombre = m.getName();
            
            //Imprime modificadores, tipo y nombre
            
            System.out.print("  " + Modifier.toString(m.getModifiers()));
            
            System.out.print("  " + tipodevuelto.getName() + " " + nombre + "(");
            
            //Imprime tipo deparámetros
            
            Class[] tipoParam = m.getParameterTypes();
            
            for(int i=0; i<tipoParam.length; i++){
                
                if(i>0) System.out.print(", ");
                
                System.out.print(tipoParam[i].getName());
            }
            
            System.out.println(");");
        }
    }
    
    //Imprime los campos de la clase
            
    public static void imprimirCampos(Class cl){
        
        Field[] campos = cl.getDeclaredFields();
        
        for(Field f: campos){
            
            Class tipoCampo = f.getType();
            
            String nombre = f.getName();
            
            System.out.print("  " + Modifier.toString(f.getModifiers()));
            
            System.out.println("  " + tipoCampo.getName() + " " + nombre + ";");
        }
    }
    
}
