package poo;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;

import java.util.*;

import javax.swing.Timer;

public class Prueba_Temporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DameLaHora oyente=new DameLaHora();
		
		//ActionListener oyente=new DameLaHora();
		
		Timer mitemporizador=new Timer(5000, oyente);
		
		mitemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		System.exit(0);
		
		
	}

}

	class DameLaHora implements ActionListener{
	
		
	public void actionPerformed(ActionEvent e){
		
		Date ahora=new Date();
		
		System.out.println("te pongo la hora cada 5 segundos: " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
		
	}
}
