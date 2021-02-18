/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usothreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class SincronizandoHilos {
    
    public static void main(String[] args){
        
        HilosVarios hilo1 = new HilosVarios();
        
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        
        hilo2.start();
        
        hilo1.start();
        
        /*try {
            hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SincronizandoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        hilo2.start();
        
        try {
            hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SincronizandoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        System.out.println("terminadas las tareas");
        
    }
    
}

class HilosVarios extends Thread{
    
    public void run(){
        
        for (int i = 0; i < 15; i++) {
            
            System.out.println("Ejecutando" + getName());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}
class HilosVarios2 extends Thread{
    
    public HilosVarios2(Thread hilo){
        
        this.hilo = hilo;
        
    }
    
    public void run(){
        
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 15; i++) {
            
            System.out.println("Ejecutando" + getName());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    private Thread hilo;
}