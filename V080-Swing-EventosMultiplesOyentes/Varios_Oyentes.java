package graficos;

import java.awt.event.*;

import javax.swing.*;

public class Varios_Oyentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Marco_Principal mimarco= new Marco_Principal();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
		
		
	}

}

class Marco_Principal extends JFrame{
	
	public Marco_Principal(){
		
		setTitle("Prueba varios");
		
		setBounds(1300,100,300,200);
		
		Lamina_Principal milamina=new Lamina_Principal();
		
		add(milamina);
	}
}

class Lamina_Principal extends JPanel{
	
	public Lamina_Principal(){
		
		JButton boton_nuevo= new JButton("Nuevo");
		
		add(boton_nuevo);
		
		boton_cerrar= new JButton("Cerrar Todo");
		
		add(boton_cerrar);
		
		Oyente_Nuevo mioyente= new Oyente_Nuevo();
		
		boton_nuevo.addActionListener(mioyente);
	}
	
	private class Oyente_Nuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Marco_Emergente marco=new Marco_Emergente(boton_cerrar);
			
			marco.setVisible(true);
		}
		
		
	}
	
	JButton boton_cerrar;
}

	class Marco_Emergente extends JFrame{
		
		
		public Marco_Emergente(JButton boton_de_principal){
			
			contador++;
			
			setTitle("Ventana " + contador);
			
			setBounds(40*contador, 40*contador, 300,200);
			
			Cierra_Todos oyentecerrar= new Cierra_Todos();
			
			boton_de_principal.addActionListener(oyentecerrar);
			
			}
		
		private class Cierra_Todos implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dispose();
			}
			
			
		}
		
		private static int contador=0;
	}