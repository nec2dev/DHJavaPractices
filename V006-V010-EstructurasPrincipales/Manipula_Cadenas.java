
public class Manipula_Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombre="Nahuel";
		
		System.out.println( " Mi nombre es " + nombre);
		
		System.out.println( " Mi nombre tiene " + nombre.length() + " letras.");
		
		System.out.println( " La primer letra de " + nombre + " es la letra " + nombre.charAt(0));
		
		int ultima_letra;
		
		ultima_letra=nombre.length();
		
		System.out.println( " La última letra de " + nombre + " es la letra " + nombre.charAt(ultima_letra-1) );
	}

}
