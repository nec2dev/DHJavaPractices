/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

/**
 *
 * @author Nahuel E Correa
 */
public class Libro {
    
    public Libro(String titulo, String autor, int ISBN){
        
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }
    
    public String getDatos(){
        
        return "El título es: " + titulo + ", El autor Es: " 
                + autor + ", El ISBN es: " + ISBN;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ISBN;
        return hash;
    }

    /*@Override
    public boolean equals(Object obj){
    if( obj instanceof Libro){
    Libro otro = (Libro) obj;
    if( this.ISBN == otro.ISBN){
    return true;
    }else{
    return false;            
    }
    }else{
    return false;
    }
    }*/
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        return true;
    }

    
    private String titulo;
    private String autor;
    private int ISBN;
    
}
class ISBN{
    
    public ISBN(){
        
        
    }
}
