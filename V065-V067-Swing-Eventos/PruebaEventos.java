package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PruebaEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBotones mimarco= new MarcoBotones();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class MarcoBotones extends JFrame{
	
	public MarcoBotones(){
		
		setTitle("Botones y Eventos");
		
		setBounds(700,300,500,300);
		
		LaminaBotones milamina=new LaminaBotones();
		
		add(milamina);
		
	}
}

class LaminaBotones extends JPanel {
	
	JButton botonCyan=new JButton("Cyan");
	
	JButton botonMagenta=new JButton("Magenta");
	
	JButton botonAmarillo=new JButton("Amarillo");
	
	public LaminaBotones(){
		
		add(botonCyan);
		
		add(botonMagenta);
		
		add(botonAmarillo);
		
		ColorFondo Cyan=new ColorFondo(Color.CYAN);
		
		ColorFondo Magenta=new ColorFondo(Color.MAGENTA);
		
		ColorFondo Amarillo=new ColorFondo(Color.YELLOW);
		
		botonCyan.addActionListener(Cyan);
		
		botonMagenta.addActionListener(Magenta);
		
		botonAmarillo.addActionListener(Amarillo);
	}
	
	private class ColorFondo implements ActionListener{
		
		public ColorFondo(Color c){
			
			colorDeFondo=c;
			
		}
		
		public void actionPerformed(ActionEvent e){
			
		setBackground(colorDeFondo);	
		
		
		}
		
		private Color colorDeFondo;
	}
	
}




