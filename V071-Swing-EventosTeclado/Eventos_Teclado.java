package graficos;

import javax.swing.*;

import java.awt.event.*;

public class Eventos_Teclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConTeclas mimarco= new MarcoConTeclas();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConTeclas extends JFrame{
	
	public MarcoConTeclas(){
		
		setVisible(true);
		
		setBounds(700,300,600,450);
		
		EventoDeTeclado tecla= new EventoDeTeclado();
		
		addKeyListener(tecla);
		
	}
}

class EventoDeTeclado implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//int codigo=e.getKeyCode();
		
		//System.out.println(codigo);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		char letra=e.getKeyChar();
		
		System.out.println(letra);
	}
	
	
}