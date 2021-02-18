package poo;

import javax.swing.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.Timer;

import java.awt.Toolkit;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj=new Reloj();
		
		mireloj.enMarcha(1000, true);
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		
	}

}

class Reloj{
		
	
	public void enMarcha(int intervalo, final boolean sonido){
		
		class DameLaHora2 implements ActionListener{
			
			public void actionPerformed(ActionEvent evento){
				
				Date ahora=new Date();
				
				System.out.println("Te muestro la hora cada 1 segundos " + ahora);
				
				if (sonido==true){
					
					Toolkit.getDefaultToolkit().beep();
					
				}
			}
		}
	
	ActionListener oyente=new DameLaHora2();
	
	Timer mitemporizador=new Timer(intervalo, oyente);
	
	mitemporizador.start();
	
}

	
	
}



