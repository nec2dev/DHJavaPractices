package graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoPassword mimarco= new MarcoPassword();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoPassword extends JFrame{
	
	public MarcoPassword(){
		
		setBounds(400,300,550,400);
		
		LaminaPassword milamina= new LaminaPassword();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaPassword extends JPanel{
	
	public LaminaPassword(){
		
		setLayout(new BorderLayout());
		
		JPanel lamina_superior= new JPanel();
		
		lamina_superior.setLayout(new GridLayout(2,2));
		
		add(lamina_superior, BorderLayout.NORTH);
		
		JLabel eiqueta1 = new JLabel("Usuario");
		
		JLabel eiqueta2 = new JLabel("Password");
		
		JTextField c_usuario = new JTextField(15);
		
		Comprueba_Pass mievento= new Comprueba_Pass();
		
		c_contra= new JPasswordField(15);
		
		c_contra.getDocument().addDocumentListener(mievento);
		
		lamina_superior.add(eiqueta1);
		
		lamina_superior.add(c_usuario);
		
		lamina_superior.add(eiqueta2);
		
		lamina_superior.add(c_contra);
		
		JButton enviar= new JButton("Enviar");
		
		add(enviar, BorderLayout.SOUTH);
		
	}
	
	private class Comprueba_Pass implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
			char[] contrasena;
			
			contrasena=c_contra.getPassword();
			
			if(contrasena.length<8 || contrasena.length>12){
				
				c_contra.setBackground(Color.red);
			
			}else{
				
				c_contra.setBackground(Color.white);
			}
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
char[] contrasena;
			
			contrasena=c_contra.getPassword();
			
			if(contrasena.length<8 || contrasena.length>12){
				
				c_contra.setBackground(Color.red);
			
			}else{
				
				c_contra.setBackground(Color.white);
			}
		}
		
	}
	
	JPasswordField  c_contra;
}