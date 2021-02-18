/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        JFrame marco = new MarcoRebote();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        marco.setVisible(true);
    }
    
}

class PelotaHilos implements Runnable{
    
    public PelotaHilos(Pelota unaPelota, Component unComponente){
        
        pelota = unaPelota;
        
        componente = unComponente;
        
    }
    
    public void run(){
        
        System.out.println("estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        
        //for (int i=1; i<=3000; i++){
        
        //while(!Thread.interrupted()){
        
        while(!Thread.currentThread().isInterrupted()){
        
        pelota.mueve_pelota(componente.getBounds());
        
        componente.paint(componente.getGraphics());
        
        /*try{
            
            Thread.sleep(4);
            
        } catch ( InterruptedException e){
            
            e.printStackTrace();
    
        }*/
    }
    
    System.out.println("estado del hilo al terminan: " + Thread.currentThread().isInterrupted());
        
    }
    
    private Pelota pelota;
    
    private Component componente;
}

//Movimiento de la Pelota

class Pelota{
    
    //Mueve la pelota inviriendo la posición si choca con Letras
    
    public void mueve_pelota(Rectangle2D limites){
        
        x += dx;
        y += dy;
        
            if(x<limites.getMinX()){
                
                x=limites.getMinX();}else{
            
            dx=-dx;
            
            }
    
            if(x + TAMX>=limites.getMaxX()){
                
                x=limites.getMaxX()- TAMX;}else{
                
                dx=-dx;
            }
            
            if(y<limites.getMinY()){
                
                y=limites.getMinY();}else{
            
            dy=-dy;
            
            }
    
            if( y + TAMY >= limites.getMaxY()){
                
                y = limites.getMaxY() - TAMY;}else{
                
                dy = -dy;
            }
        }

        //Forma de la pelota en su posicion inicial

public Ellipse2D getShape(){

    return new Ellipse2D.Double(x,y,TAMX,TAMY);

}

private static final int TAMX = 15;

private static final int TAMY = 15;

private double x = 0;

private double y = 0;

private double dx = 1;

private double dy = 1;

}    

//Lamina que dibuja la pelotas

class LaminaPelota extends JPanel{
    
    //Añadimos la pelota a la lámina
    
public void add(Pelota b){
    
    pelotas.add(b);
    
}

public void paintComponent (Graphics g){
    
super.paintComponent(g);

Graphics2D g2 = (Graphics2D)g;

for(Pelota b: pelotas){
    
    g2.fill(b.getShape());
    
    }
}

private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

}

//Marco con láminas y botones

class MarcoRebote extends JFrame{
    
    public MarcoRebote(){
    
        setBounds(600, 300, 400, 350);

        setTitle ("Rebotes");

        lamina = new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();
        
        ponerBoton(laminaBotones, "Dale!", new ActionListener(){

        public void actionPerformed(ActionEvent evento){
        
        comienza_el_juego();
            
        }
    });

    ponerBoton( laminaBotones, "Salir", new ActionListener(){
    
    public void actionPerformed(ActionEvent evento){
        
        System.exit(0);
    
        }

    });
    
    ponerBoton( laminaBotones, "Detener", new ActionListener(){
    
    public void actionPerformed(ActionEvent evento){
        
        detener();
    
        }

    });

    add( laminaBotones, BorderLayout.SOUTH);
    
    }
    
//Ponemos botones 
    
public void ponerBoton( Container c, String titulo, ActionListener oyente){

    JButton boton = new JButton(titulo);
    
    c.add(boton);

    boton.addActionListener(oyente);
    
}

//Añade pelota y la hace rebotal 1000 veces

public void comienza_el_juego(){
    
    Pelota pelota = new Pelota();
    
    lamina.add(pelota); 
    
    Runnable r = new PelotaHilos( pelota, lamina);
    
    //Thread t = new Thread(r);
    
    t = new Thread(r);
    
    t.start();
    
}

public void detener(){
    
    //t.stop(); Método obsoleto
    
    t.interrupt();
    
}

Thread t;

private LaminaPelota lamina;

}

