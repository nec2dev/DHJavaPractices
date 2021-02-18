package graficos;

import javax.swing.*;

import java.awt.event.*;

public class Eventos_mouse_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoMouse3 mimarco= new MarcoMouse3();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

}

class MarcoMouse3 extends JFrame{
	
	public MarcoMouse3(){
		
		setVisible(true);
		
		setBounds(700,300,600,450);
		
		EventoDeMouse3 mievento= new EventoDeMouse3();
		
		addMouseMotionListener( mievento);
		
	}
}

class EventoDeMouse3 implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Estás arrastrando el mouse");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Estás moviendo el mouse");
	}
	
}