package graficos;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Barra_Herramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Marco_Barra mimarco=new Marco_Barra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame{
	
	public Marco_Barra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuración de acciones
		
		AccionColor accionCyan= new AccionColor("Cyan", new ImageIcon("src/graficos/icocyan.png"), Color.CYAN);
	
		AccionColor accionMagenta= new AccionColor("Magenta", new ImageIcon("src/graficos/icomagenta.png"), Color.MAGENTA);
	
		AccionColor accionAmarillo= new AccionColor("Amarillo", new ImageIcon("src/graficos/icoamarillo.png"), Color.YELLOW);
		
		Action accionSalir = AbstractAction("Salir", new ImageIcon("src/graficos/salir.png")){

			@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

				System.exit(0);

			}

		};

		JMenu menu = new JMenu("Color");

		menu.add(accionCyan);
		
		menu.add(accionMagenta);

		menu.add(accionYellow);

		JMenuBar barraMenu = new JMenuBar();

		barraMenu.add(menu);

		setJMenuBar(barraMenu);

		//Construccion de la barra de herramientas

		JToolBar barra = new JToolBar();

		barra.add(accionCyan);

		barra.add(accionMagenta);

		barra.add(accionYellow);

		barra.addSeparator();

		barra.add(accionSalir);

		add(barra, BorderLayout.NORTH);
		
	}
		
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c){
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}

	private JPanel lamina;
}



