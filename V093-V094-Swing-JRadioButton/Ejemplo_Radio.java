package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ejemplo_Radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Radio mimarco = new Marco_Radio();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Radio extends JFrame{
	
	public Marco_Radio(){
		
		setVisible(true);
		
		setBounds(550,300,500,300);
		
		Lamina_Radio milamina = new Lamina_Radio();
		
		add(milamina);
	}
}

class Lamina_Radio extends JPanel{
	
	public Lamina_Radio(){
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
		
		add(texto, BorderLayout.CENTER);
		
		ButtonGroup migrupo1 = new ButtonGroup();
		
		boton1= new JRadioButton("Pequeño", false);
		
		boton2= new JRadioButton("Mediano", true);
		
		boton3= new JRadioButton("Grande", false);
		
		boton4= new JRadioButton("Muy grande", false);
		
		JPanel Lamina_radio = new JPanel();
		
		Evento_Radio mievento = new Evento_Radio();
		
		boton1.addActionListener(mievento);
		
		boton2.addActionListener(mievento);
		
		boton3.addActionListener(mievento);
		
		boton4.addActionListener(mievento);
		
		migrupo1.add(boton1);
		
		migrupo1.add(boton2);
		
		migrupo1.add(boton3);
		
		migrupo1.add(boton4);
		
		Lamina_radio.add(boton1);
		
		Lamina_radio.add(boton2);
		
		Lamina_radio.add(boton3);
		
		Lamina_radio.add(boton4);
		
		add(Lamina_radio, BorderLayout.SOUTH);
		
	}
	
	private class Evento_Radio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==boton1){
				
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
			}
			else if(e.getSource()==boton2){
				
				texto.setFont(new Font("Serif", Font.PLAIN, 12));
			}
			else if(e.getSource()==boton3){
				
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
			}
			else if(e.getSource()==boton4){
	
				texto.setFont(new Font("Serif", Font.PLAIN, 24));
}
		}
		
		
	}
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
}