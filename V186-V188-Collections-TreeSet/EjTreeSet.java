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
public class EjTreeSet {
    
    public static void main (String[] args){
        
        /*TreeSet<String> ordenaPersonas = new TreeSet<String>();
        
        ordenaPersonas.add("Sandra");
        
        ordenaPersonas.add("Celeste");
        
        ordenaPersonas.add("Fobos");
        
        ordenaPersonas.add("Deimos");
        
        ordenaPersonas.add("Zulma");
        
        ordenaPersonas.add("Abelardo");
        
        for (String ordenaPersona : ordenaPersonas) {
            
            System.out.println(ordenaPersona);
            
        }*/
        
        Articulo primero = new Articulo(1, "Primer artículo");
        
        Articulo segundo = new Articulo(2, "Segundo artículo");
        
        //Articulo segundo = new Articulo(200, "Segundo artículo");
        
        Articulo tercer = new Articulo(3, "Tercer artículo");
        
        Articulo cuarto = new Articulo(4, "Cuarto artículo");
        
        Articulo quinto = new Articulo(5, "Quinto artículo");
        
        Articulo sexto = new Articulo(6, "Sexto artículo");
        
        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        
        ordenaArticulos.add(quinto);
        
        ordenaArticulos.add(segundo);
        
        ordenaArticulos.add(cuarto);
        
        ordenaArticulos.add(tercer);
        
        ordenaArticulos.add(sexto);
        
        ordenaArticulos.add(primero);
        
        for (Articulo ordenaArticulo : ordenaArticulos) {
            
            System.out.println(ordenaArticulo.getDescripcion());
              
        }
        
        System.out.println("");
        
        Articulo comparador_articulo = new Articulo();
        
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparador_articulo);
    
        ordenaArticulos2.add(primero);
        
        ordenaArticulos2.add(segundo);
        
        ordenaArticulos2.add(tercer);
        
        ordenaArticulos2.add(cuarto);
        
        ordenaArticulos2.add(quinto);
        
        ordenaArticulos2.add(sexto);
        
        for (Articulo articulo : ordenaArticulos2) {
            
            System.out.println(articulo.getDescripcion());
            
        }
        
    }
    
    
}

class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
    
    public Articulo(){
        
        
    }
    
    public Articulo(int num, String desc){
        
        numero_articulo = num;
        
        descripcion = desc;
    }

    @Override
    public int compareTo(Articulo o) {
        
    return numero_articulo - o.numero_articulo;

    }

    public String getDescripcion() {
        return descripcion;
    }
    
    private int numero_articulo;
    
    private String descripcion;

    @Override
    public int compare(Articulo arg0, Articulo arg1) {
        
        String descripcionA = arg0.getDescripcion();
        
        String descripcionB = arg1.getDescripcion();
        
        return descripcionA.compareTo(descripcionB);
        }
    
    }

