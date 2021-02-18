/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Nahuel E Correa
 */
public class LeerImagen {
    
    public static void main (String[] args){
        
        MarcoImagen mimarco = new MarcoImagen();
        
        mimarco.setVisible(true);
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        }
    }
    class MarcoImagen extends JFrame{
	
	public MarcoImagen(){
		
		setTitle("Marco con Imagen");
		
		setBounds(75,30,1400,900);
		
		LaminaConImagen milamina=new LaminaConImagen();
		
		add(milamina);
		
	}
}

//Excepcion Comprobado Exception/IOException/ImageIO.read

//NullPointerException

class LaminaConImagen extends JPanel{
    
    public LaminaConImagen(){
        
        try{
		
		imagen = ImageIO.read( new File("src/graficos/bolita.png"));
                
		}
		
		catch(IOException e){
			
			System.out.println("La imagen no se encuentra");
		}
    
    }
	//Excepcion No Comprobado Exception/RuntimeException/
	public void paintComponent(Graphics g)throws NullPointerException{
		
		super.paintComponent(g);
                
                try{
                
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
                }catch(NullPointerException npe){
                    
                    g.drawString("No se ha podido cargar la imagen", 10, 10);
                }
                }
		
	
	
	private Image imagen;
}

