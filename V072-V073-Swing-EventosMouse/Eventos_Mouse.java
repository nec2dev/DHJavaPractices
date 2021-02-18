package graficos;

import javax.swing.*;

import java.awt.event.*;

public class Eventos_Mouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoMouse mimarco= new MarcoMouse();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EventoDeMouse evento= new EventoDeMouse();
	}
	

}

class MarcoMouse extends JFrame{
	
	public MarcoMouse(){
		
		setVisible(true);
		
		setBounds(700,300,600,450);
		
		EventoDeMouse evento= new EventoDeMouse();
		
		addMouseListener(evento);
		
	}
}


class EventoDeMouse implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Has hecho click");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de salir");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Acabas de levantar");
	}
	
	
}