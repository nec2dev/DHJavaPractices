package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoAccion marco=new MarcoAccion();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoAccion extends JFrame{
	
	public MarcoAccion(){
	
	setTitle("Prueba Acciones");
	
	setBounds(600,350,600,300);
	
	PanelAccion lamina=new PanelAccion();
	
	add(lamina);
	
	}
}

class PanelAccion extends JPanel{
	
	
public PanelAccion(){
	
	AccionColor accionCyan= new AccionColor("Cyan", new ImageIcon("src/graficos/icocyan.png"), Color.CYAN);
	
	AccionColor accionMagenta= new AccionColor("Magenta", new ImageIcon("src/graficos/icomagenta.png"), Color.MAGENTA);
	
	AccionColor accionAmarillo= new AccionColor("Amarillo", new ImageIcon("src/graficos/icoamarillo.png"), Color.YELLOW);
	
	/*JButton botonCyan= new JButton(AccionCyan);
	
	add(botonCyan);*/
	
	add(new JButton(accionCyan));
	
	add(new JButton(accionMagenta));
	
	add(new JButton(accionAmarillo));
	
	/*JButton  botonCyan=new JButton("Cyan");
	
	JButton  botonMagenta=new JButton("Magenta");
	
	JButton  botonAmarillo=new JButton("Amarillo");
	
	add(botonCyan);
	
	add(botonMagenta);
	
	add(botonAmarillo);*/
	
	
	InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	
	//KeyStroke teclaCyan= KeyStroke.getKeyStroke("Ctrl C");
	
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl C"), "fondoCyan");
	
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl M"), "fondoMagenta");
	
	mapaEntrada.put(KeyStroke.getKeyStroke("ctrl Y"), "fondoAmarillo");
	
	ActionMap mapaAccion= getActionMap();
	
	mapaAccion.put("fondoCyan", accionCyan);
	
	mapaAccion.put("fondoMagenta", accionMagenta);
	
	mapaAccion.put("fondoAmarillo", accionAmarillo);
	
	
	}

private class AccionColor extends AbstractAction{

	public AccionColor(String nombre, Icon icono, Color color_boton){
	
	putValue(Action.NAME, nombre);
	
	putValue(Action.SMALL_ICON, icono);
	
	putValue(Action.SHORT_DESCRIPTION, "Pone la lámina de color " + nombre);
	
	putValue("color_de_fondo", color_boton);
	
	
}
	public void actionPerformed(ActionEvent e) {
		
		Color c=(Color)getValue("color_de_fondo");
		
		setBackground(c);
		
		System.out.println("Nombre: " + getValue(Action.NAME) + ". Descripción: " + getValue(Action.SHORT_DESCRIPTION));
	}	
	
	
}
}

