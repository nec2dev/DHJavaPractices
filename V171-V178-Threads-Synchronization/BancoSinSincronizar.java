/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class BancoSinSincronizar {
    
    public static void main (String[] args){
        
        Banco b = new Banco();
        
        for (int i = 0; i < 100; i++) {
            
            EjecucionTransferencia r = new EjecucionTransferencia(b, i, 2000);
            
            Thread t = new Thread(r);
            
            t.start();
            
            /*try {
                t.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(BancoSinSincronizar.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
        }
        
    }
    
}

class Banco{
    
    public Banco(){
        
        cuentas = new double[100];
        
        
        for (int i = 0; i < cuentas.length; i++) {
            
            cuentas[i] = 2000;
            
        }
        
        saldoSuficiente = cierreBanco.newCondition();
    }
    
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad){
        
        cierreBanco.lock();
        
        try{
        
        while( cuentas[cuentaOrigen] < cantidad ){try {
            //Evalúa que el saldo no sea inferior al dinero de
            //la cuenta de origen, cambiamos el if por el while y comentamos el else
            
            saldoSuficiente.await();
            
            /*System.out.println("--------------CANTIDAD INSUFICIENTE: " + cuentaOrigen + "........SALDO: " + cuentas[cuentaOrigen] +
            ".........  $" + cantidad);
            
            return;
            
            }else{
            
            System.out.println("---------------CANTIDAD OK-------------" + cuentaOrigen);*/
            } catch (InterruptedException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(Thread.currentThread());
        
        cuentas[ cuentaOrigen ] -= cantidad; //dinero que sle de la cuenta de Origen
        
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        
        cuentas[cuentaDestino] += cantidad; 
        
        System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
        
        saldoSuficiente.signalAll();
        
        }finally{
            
            cierreBanco.unlock();
        }
    }
    
    public double getSaldoTotal(){
    
        double suma_cuentas = 0;
        
        for( double a: cuentas){
            
            suma_cuentas += a;
        }
        
        return suma_cuentas;
    
}
    
    private final double[] cuentas;
    
    private Lock cierreBanco = new ReentrantLock();
    
    private Condition saldoSuficiente;
    
}

class EjecucionTransferencia implements Runnable{
    
    public EjecucionTransferencia( Banco b, int de, double max){
        
        banco = b;
        
        deLaCuenta = de;
        
        cantidadMax = max;
        
    }
    
    @Override
    public void run(){
        
        while (true){
            
            try {
                int paraLaCuenta = (int)(100 * Math.random());
                
                double cantidad = cantidadMax * Math.random();
                
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecucionTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private Banco banco;
    
    private int deLaCuenta;
    
    private double cantidadMax;
}