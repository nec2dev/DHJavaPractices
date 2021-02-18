import java.util.*;
import javax.swing.*;
public class Areas {

	private static Scanner entrada;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		entrada = new Scanner(System.in);
		
		System.out.println("Elige una opción: \n1: Cuadrado \n2: rectángulo \n3: triángulo \n4: Círculo");
		
		int figura=entrada.nextInt();
		
		switch(figura) {
		
		case 1: 
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado: "));
			
			System.out.println("El área del cuadrado es " + Math.pow(lado,2));
			
			break;
			
		
		case 2:
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
			
			System.out.println("El área del rectángulo es " + base*altura);
			
			break;
			
		
		case 3:
			base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
			altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
			
			System.out.println("El área del triángulo es " + base*altura/2);
			
			break;
			
			
		case 4:
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
			
			System.out.println("El área del círculo es ");
			
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			
			break;
			
		default:
			System.out.println(" La opción no es correcta");
		}
		
		
	}

}
