package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Marco_Spinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoSpinner mimarco = new MarcoSpinner();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoSpinner extends JFrame{
	
	public MarcoSpinner(){
		
		setVisible(true);
		
		setBounds(550,300,500,300);
		
		add(new LaminaSpinner());
	}
}
class LaminaSpinner extends JPanel{
	
	public LaminaSpinner(){
		
		//String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			
			/*{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre"};*/
		
		JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1){
		
			public Object getNextValue(){
				
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue(){
				
				return super.getNextValue();
			}
			
		}/*new SpinnerListModel(lista)
		
		*clase anónima
		*/
		);
		
		Dimension d= new Dimension(200, 20);
		
		control.setPreferredSize(d);
		
		add(control);
		
		
		
	}
	
	/*private class MiModeloJSpinner extends SpinnerNumberModel{
		
		public MiModeloJSpinner(){//Invierte las flechas de incremento y decremento
			
			super(5,0,10,1);
		}
		
		public Object getNextValue(){
			
			return super.getPreviousValue();
		}
		
		public Object getPreviousValue(){
			
			return super.getNextValue();
		}
	}*/
}