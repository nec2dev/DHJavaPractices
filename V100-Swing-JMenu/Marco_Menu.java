package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Marco_Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuFrame mimarco = new MenuFrame();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MenuFrame extends JFrame{
	
	public MenuFrame(){
		
		setVisible(true);
		
		setBounds(550,300,500,300);
		
		MenuLamina milamina = new MenuLamina();
		
		add(milamina);
	}
}

class MenuLamina extends JPanel{
	
	public MenuLamina(){
		
		JMenuBar mibarra = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		
		JMenu edicion = new JMenu("Edición");
		
		JMenu herramientas = new JMenu("Herramientas");
		
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem guardar = new JMenuItem("Guardar");
		
		JMenuItem guardar_como = new JMenuItem("Guardar como...");
		
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("bin/graficos/cortar.gif"));
		
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("bin/graficos/copiar.gif"));
		
		//copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("bin/graficos/pegar.gif"));
		
		JMenuItem generales = new JMenuItem("Generales");
		
		JMenuItem parciales = new JMenuItem("Parciales");
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		opciones.add(opcion1);
		
		opciones.add(opcion2);
		
		archivo.add(guardar);
		
		archivo.add(guardar_como);
		
		edicion.add(cortar);
		
		edicion.add(copiar);
		
		edicion.add(pegar);
		
		edicion.addSeparator();
		
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		herramientas.add(parciales);
		
		mibarra.add(archivo);
	
		mibarra.add(edicion);
	
		mibarra.add(herramientas);
	
		add(mibarra);
		
	}
}