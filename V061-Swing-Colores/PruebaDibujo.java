package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MarcoConColor mimarco=new MarcoConColor();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConColor extends JFrame{
	
	public MarcoConColor(){
		
		setTitle("Prueba de Color");
		
		setSize(400,400);
		
		LaminaColor milamina=new LaminaColor();
		
		add(milamina);
		
		milamina.setBackground(new Color(255,255,255));
		
	}
}

class LaminaColor extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);
		
		//g.drawLine(50, 50, 300, 200);
		
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.setPaint(Color.BLACK);
		
		g2.draw(rectangulo);//Pinta el contorno
		
		g2.setPaint(Color.MAGENTA.brighter());
		
		g2.fill(rectangulo);
		
		Ellipse2D elipse=new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.setPaint(Color.BLACK);
		
		g2.draw(elipse);
		
		g2.setPaint(Color.CYAN.brighter().brighter());
		
		g2.fill(elipse);
		
		//g2.draw(new Line2D.Double(60,60,300,250));
		
		double CentroenX=rectangulo.getCenterX();
		
		double CentroenY=rectangulo.getCenterY();
		
		double radio=150;
		
		Ellipse2D circulo=new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio, CentroenY+radio);
		
		//g2.draw(circulo);
		
	}
}