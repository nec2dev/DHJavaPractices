package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Marco_Sliders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Marco_Slider mimarco = new  Marco_Slider();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco_Slider extends JFrame{
	
	public Marco_Slider(){
		
		setVisible(true);
		
		setBounds(550,400,550,300);
		
		Lamina_Slider milamina = new Lamina_Slider();
		
		add(milamina);
	}
}

class Lamina_Slider extends JPanel{
	
	public Lamina_Slider(){
		
		JSlider control = new JSlider(SwingConstants.HORIZONTAL, 0,100,50);
		
		control.setMajorTickSpacing(10);
		
		control.setMinorTickSpacing(5);
		
		control.setPaintTicks(true);
		
		control.setPaintLabels(true);
		
		control.setFont(new Font("Serif", Font.ITALIC, 9));
		
		control.setSnapToTicks(true);//hace que la flecha se sitúe en un punto exacto
		
		add(control);
		
	}
}