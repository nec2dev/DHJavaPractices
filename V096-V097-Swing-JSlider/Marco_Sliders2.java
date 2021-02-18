package graficos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

import java.awt.event.*;

public class Marco_Sliders2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Marco_Slider2 mimarco = new  Marco_Slider2();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco_Slider2 extends JFrame{
	
	public Marco_Slider2(){
		
		setVisible(true);
		
		setBounds(550,400,550,300);
		
		Lamina_Slider2 milamina = new Lamina_Slider2();
		
		add(milamina);
	}
}

class Lamina_Slider2 extends JPanel{
	
	public Lamina_Slider2(){
		
		setLayout(new BorderLayout());
		
		rotulo = new JLabel(" En un lugar de la Mancha de cuyo nombre...");
		
		add(rotulo, BorderLayout.CENTER);
		
		control = new JSlider(8, 50, 12);
		
		control.setMajorTickSpacing(20);
		
		control.setMinorTickSpacing(5);
		
		control.setPaintTicks(true);
		
		control.setPaintLabels(true);
		
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		
		//control.setSnapToTicks(true);hace que la flecha se sitúe en un punto exacto
		
		control.addChangeListener(new EventoSlider());
		
		JPanel laminaSlider = new JPanel();
		
		laminaSlider.add(control);
		
		add(laminaSlider, BorderLayout.NORTH);
		
	}
	
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			
			//contador++;
			
			///System.out.println("Estas manipulando el deslizante: " + control.getValue());
			
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
		}
		
		
	}
	
	private JLabel rotulo;
	
	private JSlider control;
	
	private static int contador;
}