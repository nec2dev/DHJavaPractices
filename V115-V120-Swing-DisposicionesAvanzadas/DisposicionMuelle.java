package graficos;

import java.awt.*;

	public class DisposicionMuelle{

		public static void main(String[] args) {
			//TODO

			MarcoCaja mimarco = new MarcoCaja();

			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			mimarco.setVisible(true);
			
		}
	}

	class MarcoMuelle extends JFrame{

		public MarcoMuelle(){

			setBounds(300, 400, 1000, 350);

			laminaMuelle milamina = new laminaMuelle();

			add(milamina);

			setVisible(true);

		}
	}

	class laminaMuelle extends JPanel{

		public laminaMuelle(){

			JButton boton1 = new JButton("Boton 1");

			JButton boton2 = new JButton("Boton 2");

			JButton boton3 = new JButton("Boton 3");

			Springlayout milayout = new Springlayout();

			setLayout(milayout);

			add(boton1);

			add(boton2);

			add(boton3);

			Spring mimuelle = Spring.constant(0, 10, 100);

			Spring muelleRigido = Spring.constant(10);

			milayout.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);

			milayout.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);

			milayout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);

			milayout.putConstraint(SpringLayout.EAST, boton3, mimuelle, SpringLayout.EAST, boton3);

		}
	}