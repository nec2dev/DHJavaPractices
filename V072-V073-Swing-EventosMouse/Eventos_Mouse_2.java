package graficos;

import javax.swing.*;

import java.awt.event.*;

public class Eventos_Mouse_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoMouse2 mimarco= new MarcoMouse2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

}

class MarcoMouse2 extends JFrame{
	
	public MarcoMouse2(){
		
		setVisible(true);
		
		setBounds(700,300,600,450);
		
		EventoDeMouse2 mievento= new EventoDeMouse2();
		
		addMouseListener(mievento);
		
	}
}

class EventoDeMouse2 extends MouseAdapter{
	
	//public void mouseClicked(MouseEvent e){
		
		//System.out.println("Coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());
		
		//System.out.println(e.getClickCount());
		
	public void mousePressed(MouseEvent e){	
	
	//System.out.println(e.getModifiersEx());
		
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
			
			System.out.println("Has clickeado el botón izquierdo");
		
		}else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
			
			System.out.println("Has clickeado la rueda del mouse");
		
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
			
			System.out.println("Has clickeado el botón derecho");
		}
	}
}


/*class EventoDeMouse implements MouseListener{

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
	
	
}*/