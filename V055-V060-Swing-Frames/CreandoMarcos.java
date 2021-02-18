package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miMarco marco1=new miMarco();//Instanciar miMarco
		
		marco1.setVisible(true);//Hacer visible el frame
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//cuando se cierra el frame deja de trabajar el programa
		
		
	}

}

class miMarco extends JFrame{
	
	public miMarco(){//Constructor
		
		//setSize(500,300);
		
		//setLocation(500,300);
		
		setBounds(500,300,550,250);
		
		//setResizable(false);
		
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		
		//setExtendedState(6);
		
		setTitle("Mi ventana");
		
		
	}
}
