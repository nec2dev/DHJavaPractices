package graficos;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class trabajando_Fuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConFuentes mimarco= new MarcoConFuentes();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}

class MarcoConFuentes extends JFrame{
	
	public MarcoConFuentes(){
		
		setTitle("Marco con Fuentes");
		
		setSize(400,400);
		
		LaminaConFuentes milamina=new LaminaConFuentes();
		
		add(milamina);
		
		milamina.setBackground(new Color(255,255,255));
		
	}
}

class LaminaConFuentes extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
			
		Graphics2D g2=(Graphics2D) g;
		
		Font mifuente=new Font("Impact", Font.BOLD, 100);
		
		g2.setFont(mifuente);
		
		g2.setColor(Color.CYAN);
		
		g2.drawString("Nahuel", 30, 100);
		
		g2.setFont(new Font("Arial Bold", Font.ITALIC, 14));
		
		g2.setColor(new Color(15,15,255));
		
		g2.drawString("programmer", 155, 120);
	}
}