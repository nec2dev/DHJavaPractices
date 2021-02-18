/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtableplanets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class JTablePlanets {
    
    public static void main(String[] args){
        
        JFrame mimarco = new MarcoTabla();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
        
    }
    
}

class MarcoTabla extends JFrame{
    
    public MarcoTabla(){
        
        setTitle("los planetas");
        
        setBounds(300,300,400,200);
        
        JTable tablaPlanetas = new JTable(datosFila, nombresColumnas);
        
        add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
        
        JButton botonImprimir = new JButton("Imprimir tabla");
        
        botonImprimir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                
                try{
                    
                    tablaPlanetas.print();
                    
                }catch(Exception e1){
                    
                    e1.printStackTrace();
                }
            }   
            
        });
        
        JPanel laminaBoton = new JPanel();
        
        laminaBoton.add(botonImprimir);
        
        add(laminaBoton, BorderLayout.SOUTH);
       
    }
    
    private String [] nombresColumnas={"Nombre", "Radio", "Cant.lunas", "Gaseoso"};
    
    private Object [][] datosFila={
        
        {"Mercurio",2440.0, 0,false},
        {"Venus",6052.0, 0,"false"},
        {"Tierra",6378.0, 1,false},
        {"Marte",3397.0, 2,false},
        {"Júpiter",71492.0, 16,true},
        {"Saturno",60268.0, 18,true},
        {"Urano",25559.0, 17,true},
        {"Neptuno",24766.0, 8,true},
        {"Plutón",1137.0, 1,false}      
            
    };
}