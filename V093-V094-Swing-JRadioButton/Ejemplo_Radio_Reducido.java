package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ejemplo_Radio_Reducido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Radio2 mimarco = new Marco_Radio2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Radio2 extends JFrame{
	
	public Marco_Radio2(){
		
		setVisible(true);
		
		setBounds(550,300,500,300);
		
		Lamina_Radio milamina = new Lamina_Radio();
		
		add(milamina);
	}
}

class Lamina_Radio2 extends JPanel{
	
	public Lamina_Radio2(){
		
		setLayout(new BorderLayout());
		
		texto = new JLabel(" En un lugar de la Mancha de cuyo nombre...");
		
		texto.setFont(new Font ("Serif", Font.PLAIN,12));
		
		add(texto, BorderLayout.CENTER);
		
		lamina_botones= new JPanel();
		
		migrupo = new ButtonGroup();
		
		colocarBotones("Pequeño", false, 10);
		
		colocarBotones("Mediano", true, 12);
		
		colocarBotones("Grande", false, 18);
		
		colocarBotones("Muy grande", false, 24);
		
		add(lamina_botones, BorderLayout.SOUTH);
	}
	
	public void colocarBotones(String nombre, boolean seleccionado, final int tamano){
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		
		migrupo.add(boton);
		
		lamina_botones.add(boton);
		
		ActionListener mievento = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				texto.setFont(new Font("Serif", Font.PLAIN, tamano));
			}
			
		};
			
		boton.addActionListener(mievento);	
		
	}
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
	
	private ButtonGroup migrupo;
	
	private JPanel lamina_botones;
}