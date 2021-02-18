package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class Layouts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Layout mimarco= new Marco_Layout();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class Marco_Layout extends JFrame{
	
	public Marco_Layout(){
		
		setTitle("Prueba Acciones");
		
		setBounds (600,150,600,300);
		
		Panel_Layout milamina=new Panel_Layout();
		
		//FlowLayout disposicion= (new FlowLayout(FlowLayout.CENTER, 75,100));
		
		//milamina.setLayout(disposicion);
		
		Panel_Layout2 milamina2= new Panel_Layout2();
		
		add(milamina, BorderLayout.NORTH);
		
		add (milamina2, BorderLayout.SOUTH);
	}
}

class Panel_Layout extends JPanel{
	
	public Panel_Layout(){
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JButton("Cyan"));
		
		add(new JButton("Magenta"));
		
		
	}
}

class Panel_Layout2 extends JPanel{
	
	public Panel_Layout2(){
		
		setLayout(new BorderLayout());
		
		add(new JButton("Amarillo"), BorderLayout.WEST);
		
		add(new JButton("Violeta"), BorderLayout.EAST);
		
		add(new JButton("Verde"), BorderLayout.CENTER);
		
		
	}
}