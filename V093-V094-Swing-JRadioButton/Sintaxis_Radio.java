package graficos;

import javax.swing.*;

public class Sintaxis_Radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Radio_Sintaxis mimarco = new Marco_Radio_Sintaxis();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Radio_Sintaxis extends JFrame{
	
	public Marco_Radio_Sintaxis(){
		
		setVisible(true);
		
		setBounds(550,300,500,300);
		
		Lamina_Radio_Sintaxis milamina= new Lamina_Radio_Sintaxis();
		
		add(milamina);
	}
}

class Lamina_Radio_Sintaxis extends JPanel{
	
	public Lamina_Radio_Sintaxis(){
		
		ButtonGroup migrupo1 = new ButtonGroup();
		
		ButtonGroup migrupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Cyan", false);
		
		JRadioButton boton2 = new JRadioButton("Magenta", true);
		
		JRadioButton boton3 = new JRadioButton("Amarillo", false);
		
		JRadioButton boton4 = new JRadioButton("Masculino", false);
		
		JRadioButton boton5 = new JRadioButton("Femenino", false);
		
		migrupo1.add(boton1);
		
		migrupo1.add(boton2);
		
		migrupo1.add(boton3);
		
		migrupo2.add(boton4);
		
		migrupo2.add(boton5);
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
		add(boton5);
		
	}
	
}