import java.util.*;
public class Adivina_Numero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Refundicion convertir un double en int
		
		int aleatorio=(int)(Math.random()*100);

		//System.out.println(aleatorio);
		
		//Si aleatorio es 0 la condición de que numero es distinto a aleatorio es falsa
		//No se ejecuta while, para solucionar esto usamos el Do while
		
		Scanner entrada=new Scanner(System.in);
		
		int numero=0;
		
		int intentos=0;
		
		while(numero!=aleatorio) {
			
			intentos++;
			
			System.out.println("Introduce un número, por favor ");
			
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				
				System.out.println("Es más bajo ");
			}
		
		
		else if(aleatorio>numero) {
			
			System.out.println("Es más alto ");
		
			}
		}
	
		System.out.println("Correcto!, lo has conseguido en " + intentos + " intentos.");
	
	}

}
