import java.util.*;
public class Entrada_ejemplo1 {

	private static Scanner entrada;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		entrada = new Scanner(System.in);
				
				System.out.println(" Introduce tu nombre: ");
				
				String nombre_usuario=entrada.nextLine();
				
				System.out.println( " Introduce tu edad,; por favor: ");
				
				int edad=entrada.nextInt();
				
				System.out.println( "Hola " + nombre_usuario + ".El año que viene tendrás " + (edad+1) + " años.");

				

	}

}
