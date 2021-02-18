import java.util.Scanner;
public class Adivina_Numero_DoWhile {

	private static Scanner entrada;

	public static void main(String[] args) {
		
		int aleatorio=(int)(Math.random()*100);
		
		entrada = new Scanner(System.in);
		
		int numero=0;
		
		int intentos=0;
		
		do {
			
			intentos++;
			
			System.out.println("Introduce un número, por favor ");
			
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				
				System.out.println("Es más bajo ");
			}
		
		
		else if(aleatorio>numero) {
			
			System.out.println("Es más alto ");
		
			}
		} while(numero!=aleatorio);
	
		System.out.println("Correcto!, lo has conseguido en " + intentos + " intentos.");
	
	}

}