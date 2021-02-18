package graficos;

import java.awt.*;

	public class DisposicionLibre{

		public static void main(String[] args) {
			//TODO

			MarcoCaja mimarco = new MarcoCaja();

			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			mimarco.setVisible(true);
			
		}
	}

	class MarcoLibre extends JFrame{

		public MarcoLibre(){

			setBounds(450, 350, 600, 400);

			laminaLibre milamina = new laminaLibre();

			add(milamina);

			setVisible(true);

		}
	}

	class laminaLibre extends JPanel{

		public laminaLibre(){

			setLayout(null);//Disposicion libre

			/*JButton boton1 = new JButton("Boton 1");

			JButton boton2 = new JButton("Boton 2");

			boton1.setBounds(500, 300, 120, 25);

			boton2.setBounds(200, 100, 120, 25);

			add(boton1);

			add(boton2);*/

			JLabel nombre = JLabel("Nombre:");

			JLabel apellido = JLabel("Apellido:");

			JTextField c_nombre = new JTextField(10);

			JTextField c_apellido = new JTextField(10);

			nombre.setBounds(20, 20, 80, 10);

			c_nombre.setBounds(100, 17, 100, 20);

			apellido.setBounds(20, 60, 80, 15);

			c_apellido.setBounds(100, 55, 100, 20);

			add(nombre);

			add(apellido);

			add(c_nombre);

			add(c_apellido);

		}

	}	
