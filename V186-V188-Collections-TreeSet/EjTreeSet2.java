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
public class EjTreeSet2 {
    
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
        
        Articulo2 primero = new Articulo2(1, "Primer artículo");
        
        Articulo2 segundo = new Articulo2(2, "Segundo artículo");
        
        Articulo2 tercer = new Articulo2(3, "Tercer artículo");
        
        Articulo2 cuarto = new Articulo2(4, "Cuarto artículo");
        
        Articulo2 quinto = new Articulo2(5, "Quinto artículo");
        
        Articulo2 sexto = new Articulo2(6, "Sexto artículo");
        
        TreeSet<Articulo2> ordenaArticulos2 = new TreeSet<Articulo2>();
        
        ordenaArticulos2.add(quinto);
        
        ordenaArticulos2.add(segundo);
        
        ordenaArticulos2.add(cuarto);
        
        ordenaArticulos2.add(tercer);
        
        ordenaArticulos2.add(sexto);
        
        ordenaArticulos2.add(primero);
        
        for (Articulo2 ordenaArticulo3 : ordenaArticulos2) {
            
            System.out.println(ordenaArticulo3.getDescripcion());
              
        }
        
        System.out.println("");
        
        //Articulo comparador_articulo = new Articulo();
        
        //TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparador_articulo);
        
        //ComparadorArticulos2 compara_articulos = new ComparadorArticulos2();
        
        TreeSet<Articulo2> compara_articulos2 = new TreeSet<Articulo2>(new Comparator<Articulo2>(){
           

    @Override
    public int compare(Articulo2 o1, Articulo2 o2) {
        
        String desc1 = o1.getDescripcion();
        
        String desc2 = o2.getDescripcion();
        
        return desc1.compareTo(desc2);
        
    }});
    
        ordenaArticulos2.add(primero);
        
        ordenaArticulos2.add(segundo);
        
        ordenaArticulos2.add(tercer);
        
        ordenaArticulos2.add(cuarto);
        
        ordenaArticulos2.add(quinto);
        
        ordenaArticulos2.add(sexto);
        
        for (Articulo2 articulo2 : ordenaArticulos2) {
            
            System.out.println(articulo2.getDescripcion());
            
        }
        
    }
    
    
}

class Articulo2 implements Comparable<Articulo2>{
    
    public Articulo2(int num, String desc){
        
        numero_articulo2 = num;
        
        descripcion = desc;
    }

    
    public int compareTo(Articulo2 o) {
        
    return numero_articulo2 - o.numero_articulo2;

    }

    public String getDescripcion() {
        return descripcion;
    }
    
    private int numero_articulo2;
    
    private String descripcion;

  
    
    
}
