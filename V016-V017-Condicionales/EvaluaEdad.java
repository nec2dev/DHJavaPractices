import java.util.*;
public class EvaluaEdad {

	private static Scanner entrada;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		entrada = new Scanner(System.in);
		
		System.out.println("Introduce tu edad, por favor: ");
		
		int edad=entrada.nextInt();
		
		if(edad>=21){
			
			System.out.println("Eres mayor de edad.");
			
			}
		    else{
		    	System.out.println("Eres menor de edad.");
		    }
	}

}
