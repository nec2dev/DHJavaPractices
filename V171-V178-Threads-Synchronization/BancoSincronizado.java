/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class BancoSincronizado {
    
    public static void main (String[] args){
        
        Banco2 b2 = new Banco2();
        
        for (int i = 0; i < 100; i++) {
            
            EjecucionTransferencia2 r = new EjecucionTransferencia2(b2, i, 2000);
            
            Thread h = new Thread(r);
            
            h.start();  
        } 
    }  
}

class Banco2{
    
    public Banco2(){
        
        cuentas = new double[100];
        
        
        for (int i = 0; i < cuentas.length; i++) {
            
            cuentas[i] = 2000;
            
        }
        
    }
    
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
        
        while( cuentas[cuentaOrigen] < cantidad ){
            
            wait();
            
        }
        
        System.out.println(Thread.currentThread());
        
        cuentas[ cuentaOrigen ] -= cantidad; //dinero que sle de la cuenta de Origen
        
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        
        cuentas[cuentaDestino] += cantidad; 
        
        System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
        
        notifyAll();
        
        }
    
    
    public double getSaldoTotal(){
    
        double suma_cuentas = 0;
        
        for( double a: cuentas){
            
            suma_cuentas += a;
        }
        
        return suma_cuentas;
    
}
    
    private final double[] cuentas;
    
}

class EjecucionTransferencia2 implements Runnable{
    
    public EjecucionTransferencia2( Banco2 b2, int de, double max){
        
        banco2 = b2;
        
        deLaCuenta = de;
        
        cantidadMax = max;
        
    }
    
    @Override
    public void run(){
        
        while (true){
            
            try {
                int paraLaCuenta = (int)(100 * Math.random());
                
                double cantidad = cantidadMax * Math.random();
                
                banco2.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private Banco2 banco2;
    
    private int deLaCuenta;
    
    private double cantidadMax;
}