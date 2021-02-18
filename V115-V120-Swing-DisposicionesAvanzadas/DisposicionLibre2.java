package graficos;

import java.awt.*;

	public class DisposicionLibre2{

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

			setLayout(new EnColumnas);//Disposicion libre

			/*JButton boton1 = new JButton("Boton 1");

			JButton boton2 = new JButton("Boton 2");

			boton1.setBounds(500, 300, 120, 25);

			boton2.setBounds(200, 100, 120, 25);

			add(boton1);

			add(boton2);*/

			JLabel nombre = JLabel("Nombre:");

			JLabel apellido = JLabel("Apellido:");

			JLabel edad = JLabel("Edad:");

			JTextField c_nombre = new JTextField(10);

			JTextField c_apellido = new JTextField(10);

			JTextField c_edad = new JTextField();

			/*nombre.setBounds(20, 20, 80, 10);

			c_nombre.setBounds(100, 17, 100, 20);

			apellido.setBounds(20, 60, 80, 15);

			c_apellido.setBounds(100, 55, 100, 20);*/

			add(nombre);

			add(c_nombre);

			add(apellido);

			add(c_apellido);

			add(edad);

			add(c_edad);

		}

	}

	//Hay que agregar los métodos sin implementar	

	class EnColumnas implements LayoutManager{

		public void layoutContainer(Container micontenedor){

			int contador = 0;

			int n = micontenedor.getComponentCount();

			for(int i=0; i<n; i++){

				contador++;

				Component c = micontenedor.getComponent(i);

				c.setBounds(x, y, 100, 20);

				x+= 100;

				if(contador%2 == 0){

					x = 20;

					y = 40;

				}

			}

		}

		private int x = 20;
		private int y = 20;
	}
