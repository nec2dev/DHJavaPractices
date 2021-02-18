package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Prueba_Combo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCombo mimarco = new MarcoCombo();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoCombo extends JFrame{
	
	public MarcoCombo(){
		
		setVisible(true);
		
		setBounds(650,400,600,400);
		
		LaminaCombo milamina = new LaminaCombo();
		
		add(milamina);
		
	}
}

class LaminaCombo extends JPanel{
	
	public LaminaCombo(){
		
		setLayout(new BorderLayout());
		
		texto = new JLabel(" En un lugar de la mancha de cuyo nombre...");
		
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		
		add(texto, BorderLayout.CENTER);
		
		JPanel lamina_norte = new JPanel();
		
		micombo = new JComboBox();
		
		micombo.setEditable(true);
		
		micombo.addItem("Serif");
		
		micombo.addItem("SansSerif");
		
		micombo.addItem("Monospaced");
		
		micombo.addItem("Dialog");
		
		Evento_combo mievento = new Evento_combo();
		
		micombo.addActionListener(mievento);
		
		lamina_norte.add(micombo);
		
		add(lamina_norte, BorderLayout.NORTH);
		
	}
	
	private class Evento_combo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN, 18));
		}
		
		
	}
	
	private JLabel texto;
	
	private JComboBox micombo;
}