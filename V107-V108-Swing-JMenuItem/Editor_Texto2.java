package graficos;

import javax.swing.*;

import javax.swing.text.*;

import java.awt.*;

import java.awt.event.*;

public class Editor_Texto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Editor2 mimarco = new Marco_Editor2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Editor2 extends JFrame{
	
	public Marco_Editor2(){
		
		setBounds(500,300,550,400);
		
		Lamina_Editor2 milamina = new Lamina_Editor2();
		
		add(milamina);
		
		setVisible(true);
		
	}
}

class Lamina_Editor2 extends JPanel{
	
	public Lamina_Editor2(){
	
		setLayout(new BorderLayout());
		
		JPanel Lamina_Menu = new JPanel();
		
		JMenuBar mibarra = new JMenuBar();
		
		//__________________________________
		
		fuente = new JMenu("Fuente");
		
		estilo = new JMenu("Estilo");
		
		tamano = new JMenu("Tamaño");
		
		configura_menu("Arial", "Fuente", "Arial",9,10);
		
		configura_menu("Courier", "Fuente", "Courier",9,10);
		
		configura_menu("Verdana", "Fuente", "Verdana",9,10);
		
		//__________________________________
		
		configura_menu("Negrita", "Estilo", "",Font.BOLD,1);
		
		configura_menu("Cursiva", "Estilo", "",Font.ITALIC,1);
		
		//__________________________________
		
		configura_menu("12", "Tamaño", "",9,12);
		
		configura_menu("16", "Tamaño", "",9,16);
		
		configura_menu("18", "Tamaño", "",9,18);
		
		configura_menu("24", "Tamaño", "",9,24);
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamano);
		
		Lamina_Menu.add(mibarra);
		
		add(Lamina_Menu, BorderLayout.NORTH);
		
		/*JTextPane*/miarea = new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
		
		JMenuItem elem_menu = new JMenuItem(rotulo);
		
		if (menu=="Fuente"){
			
			fuente.add(elem_menu);
			
			if (tipo_letra=="Arial"){
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
			
			}else if (tipo_letra=="Courier"){
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
			
			}else if (tipo_letra=="Verdana"){
				
				elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "verdana"));
			}
		
		} else if(menu=="Estilo"){
			
			estilo.add(elem_menu);
			
			if(estilos==Font.BOLD){
				
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
				
			} else if (estilos==Font.ITALIC){
				
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		
		} else if(menu=="Tamaño"){
			
			tamano.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}
		
	}
	
	JTextPane miarea;
	
	JMenu fuente, estilo, tamano;
	
	Font letras;
}