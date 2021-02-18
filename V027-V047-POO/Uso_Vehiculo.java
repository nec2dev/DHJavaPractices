package poo;
/*import javax.swing.*;*/
public class Uso_Vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Coche mi_coche=new Coche();
		mi_coche.establece_color(JOptionPane.showInputDialog("Introduce un color:"));
		
		System.out.println(mi_coche.dime_color());
		
		System.out.println(mi_coche.dime_datos_generales());
		
		mi_coche.configura_asientos(JOptionPane.showInputDialog("Tiene sientos de cuero?:")); //"si" distingue mayúsculas y minúsculas
		
		System.out.println(mi_coche.dime_asientos());
		
		mi_coche.configura_climatizador(JOptionPane.showInputDialog("Tiene aire acondicionado?:"));
		System.out.println(mi_coche.dime_aire());
		
		System.out.println(mi_coche.dime_peso_coche());
		
		System.out.println("El precio final del coche es: " + mi_coche.precio_coche());
	

	}*/
		Coche micoche1=new Coche();
		
		micoche1.establece_color("Rojo");
		
		Furgoneta mifurgoneta1= new Furgoneta(7, 580);
		
		mifurgoneta1.establece_color("Azul");
		
		mifurgoneta1.configura_asientos("si");
		
		mifurgoneta1.configura_climatizador("si");
		
		System.out.println(micoche1.dime_datos_generales() +  micoche1.dime_color());
		
		System.out.println(mifurgoneta1.dime_datos_generales() + mifurgoneta1.dimeDatosFurgoneta());
		
		
	}	
}
