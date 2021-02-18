/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author Nahuel E Correa}
 * 
 */

public class ArrayList2 {
    
    public ArrayList2(int z){
        
        datosElementos = new Object[z];
    }
    
    public Object get (int i){
        
        return datosElementos[i];
    }
    
    public void add(Object o){
        
        datosElementos[i] = o;
        
        i++;
    }
    
    private Object[] datosElementos;
    
    private int i = 0;
}
