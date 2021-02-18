package graficos;

import javax.swing.*;

import javax.swing.text.*;

import java.awt.*;

import java.awt.event.*;

public class Menu_Checkbox_Radio_Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Editor3 mimarco = new Marco_Editor3();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Editor3 extends JFrame{
	
	public Marco_Editor3(){
		
		setBounds(500,300,550,400);
		
		Lamina_Editor3 milamina = new Lamina_Editor3();
		
		add(milamina);
		
		setVisible(true);
		
	}
}

class Lamina_Editor3 extends JPanel{
	
	public Lamina_Editor3(){
	
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
		
		//configura_menu("Negrita", "Estilo", "",Font.BOLD,1);
		
		//configura_menu("Cursiva", "Estilo", "",Font.ITALIC,1);
		
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/graficos/negrita.gif"));
		
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/graficos/cursiva.gif"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		
		estilo.add(cursiva);
		
		//__________________________________
		
		/*configura_menu("12", "Tamaño", "",9,12);
		
		configura_menu("16", "Tamaño", "",9,16);
		
		configura_menu("18", "Tamaño", "",9,18);
		
		configura_menu("24", "Tamaño", "",9,24);*/
		
		ButtonGroup tamano_letra = new ButtonGroup();
		
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		
		JRadioButtonMenuItem diezseis = new JRadioButtonMenuItem("16");
		
		JRadioButtonMenuItem diezocho = new JRadioButtonMenuItem("18");
		
		JRadioButtonMenuItem veintecuatro = new JRadioButtonMenuItem("24");
		
		tamano_letra.add(doce);
		
		tamano_letra.add(diezseis);
		
		tamano_letra.add(diezocho);
	
		tamano_letra.add(veintecuatro);
		
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));
		
		diezseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));
		
		diezocho.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 18));
		
		veintecuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));
		
		tamano.add(doce);
		
		tamano.add(diezseis);
		
		tamano.add(diezocho);
		
		tamano.add(veintecuatro);
		
		//__________________________________
		
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
		
		/*} else if(menu=="Estilo"){
			
			estilo.add(elem_menu);
			
			if(estilos==Font.BOLD){
				
				elem_menu.addActionListener(new StyledEditorKit.BoldAction());
				
			} else if (estilos==Font.ITALIC){
				
				elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}*/
		
		} else if(menu=="Tamaño"){
			
			tamano.add(elem_menu);
			
			elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
		}
		
	}
	
	JTextPane miarea;
	
	JMenu fuente, estilo, tamano;
	
	Font letras;
}
