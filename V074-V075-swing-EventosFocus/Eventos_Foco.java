package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Eventos_Foco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Foco mimarco= new Marco_Foco();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		}

}
class Marco_Foco extends JFrame{
	
	public Marco_Foco(){
		
		setVisible(true);
		
		setBounds(300,300,600,450);
		
		add(new Lamina_Foco());
	}
}

class Lamina_Foco extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		setLayout(null);
		
		cuadro1= new JTextField();
		
		cuadro2= new JTextField();
		
		cuadro1.setBounds(120,10,150,20);
		
		cuadro2.setBounds(120,50,150,20);
		
		add(cuadro1);
		
		add(cuadro2);
		
		LanzaFocos elFoco=new LanzaFocos();
		
		cuadro1.addFocusListener(elFoco);
	}
	
	private class LanzaFocos implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
			String email=cuadro1.getText();
			
			boolean comprobacion=false;
			
			for (int i=0; i<email.length(); i++){
				
				if(email.charAt(i)=='@'){
					
					comprobacion=true;
				}
			}
			
			if(comprobacion){
				
				System.out.println("Correcto");
			
			
			}else{
				
				System.out.println("Incorrecto");
			}
		}
		
		/*No funciona para comprobar mails con 2 puntos
		/despues de la arroba, por ej mail@mail.com.ar*/
	}
	
	JTextField cuadro1;
	
	JTextField cuadro2;
}

