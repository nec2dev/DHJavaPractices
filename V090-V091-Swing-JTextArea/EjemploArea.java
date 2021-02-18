package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class EjemploArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoArea mimarco= new MarcoArea();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoArea extends JFrame{
	
	public MarcoArea(){
		
		setBounds(500,300,500,350);
		
		LaminaArea milamina= new LaminaArea();
		
		add(milamina);
		
		setVisible(true);
	}
}

class LaminaArea extends JPanel{
	
	public LaminaArea(){
		
		miarea = new JTextArea(8,20);
		
		JScrollPane laminabarra= new JScrollPane(miarea);
		
		miarea.setLineWrap(true);
		
		JButton miboton = new JButton("Dale");
		
		miboton.addActionListener(new GestionaArea());
		
		add(laminabarra);
		
		add(miboton);
	}
	
	private class GestionaArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			System.out.println(miarea.getText());
		}
		
		
	}
	private JTextArea miarea;
}