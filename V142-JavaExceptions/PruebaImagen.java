package graficos;

import java.awt.*;

import javax.swing.*;

import javax.imageio.*;

import java.io.*;

public class PruebaImagen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoImagen mimarco= new MarcoImagen();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class MarcoImagen extends JFrame{
	
	public MarcoImagen(){
		
		setTitle("Marco con Imagen");
		
		setBounds(75,30,1400,900);
		
		LaminaImagen milamina=new LaminaImagen();
		
		add(milamina);
		
	}
}

class LaminaImagen extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		File miimagen=new File("src/graficos/bolita.png");
		
		try{
		
			imagen=ImageIO.read(miimagen);
		}
		
		catch(IOException e){
			
			System.out.println("La imagen no se encuentra");
		}
		
		int anchuraImagen=imagen.getWidth(this);
		
		int alturaImagen=imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		for (int i=0; i<1400; i++){
			
			for (int j=0; j<900; j++){
				
				if(i+j>0){
					
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				
				}
			}
				
		}
		
		
		
	}
	
	private Image imagen;
}