import java.util.*;
public class Uso_Tallas {

	//enum Talla {CHICO, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla {
		
		CHICO("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		
		private Talla(String abreviatura){
			
			this.abreviatura=abreviatura;
			
			}
		
		public String dameAbreviatura(){//Getter
			
			return abreviatura;
		}
		
		private String abreviatura;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Escribe una talla: CHICO, MEDIANO, GRANDE, MUY_GRANDE");
		
		String entrada_datos=entrada.next().toUpperCase();
		
		Talla el_talle=Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("Talla=" + el_talle);
		
		System.out.println("Abreviatura=" + el_talle.dameAbreviatura());
	
	}

}
