package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Editor_Texto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Marco_Editor mimarco = new Marco_Editor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class Marco_Editor extends JFrame{
	
	public Marco_Editor(){
		
		setBounds(500,300,550,400);
		
		Lamina_Editor milamina = new Lamina_Editor();
		
		add(milamina);
		
		setVisible(true);
		
	}
}

class Lamina_Editor extends JPanel{
	
	public Lamina_Editor(){
	
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
		
		
		/*JMenuItem arial = new JMenuItem("Arial");
		
			arial.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				miarea.setFont(new Font("Arial", Font.PLAIN, 12));
			}
		});
		
		JMenuItem courier = new JMenuItem("Courier");
		
		//Gestiona_Menus tipo_letra = new Gestiona_Menus();
		
		courier.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				miarea.setFont(new Font("Courier", Font.PLAIN, 12));
			}
		});
		
		JMenuItem verdana = new JMenuItem("Verdana");
		
		verdana.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				miarea.setFont(new Font("Verdana", Font.PLAIN, 12));
			}
		});
		
		
		fuente.add(arial);
		
		fuente.add(courier);
		
		fuente.add(verdana);
		
		//__________________________________
		
		JMenuItem negrita = new JMenuItem("Negrita");
		
		JMenuItem cursiva = new JMenuItem("Cursiva");
		
		estilo.add(negrita);
		
		estilo.add(cursiva);
		
		//__________________________________
		
		JMenuItem tam_12 = new JMenuItem("12");
		
		JMenuItem tam_16 = new JMenuItem("16");
		
		JMenuItem tam_18 = new JMenuItem("18");
		
		JMenuItem tam_24 = new JMenuItem("24");
		
		tamano.add(tam_12);
		
		tamano.add(tam_16);
		
		tamano.add(tam_18);
		
		tamano.add(tam_24);*/
		
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
		
		} else if(menu=="Estilo"){
			
			estilo.add(elem_menu);
		
		} else if(menu=="Tamaño"){
			
			tamano.add(elem_menu);
		}
		
		elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
	}
	
	private class Gestiona_Eventos implements ActionListener{
		
		String tipo_texto, menu;
		
		int  estilo_letra, tamano_letra;
		
		Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra){
			
			tipo_texto = texto2;
			
			estilo_letra = estilo2;
			
			tamano_letra = tam_letra;
			
			menu = elemento;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			letras = miarea.getFont();
			
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana"){
				
				estilo_letra = letras.getStyle();
				
				tamano_letra = letras.getSize();
				
			} else if (menu=="Cursiva" || menu=="Negrita"){
				
				if (letras.getStyle()==1 || letras.getStyle()==2){
					
					estilo_letra=3;
				}
				tipo_texto = letras.getFontName();
				
				tamano_letra = letras.getSize();
			} else if (menu=="12" || menu=="16" || menu=="18" || menu=="24"){
				
				estilo_letra = letras.getStyle();
				
				tipo_texto = letras.getFontName();
			}
			
			miarea.setFont(new Font(tipo_texto, estilo_letra, tamano_letra));
			
			System.out.println("Tipo " + tipo_texto + " Estilo " + estilo_letra + " Tamaño " + tamano_letra);
		}
		
	}
	
	JTextPane miarea;
	
	JMenu fuente, estilo, tamano;
	
	Font letras;
}