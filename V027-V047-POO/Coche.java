package poo;

public class Coche {
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso;
	
	private String color;
	
	private int peso_total;
	
	private boolean asientos_cuero,aire_acondicionado;
	
	
public Coche(){
	
	ruedas=4;
	largo=2000;
	ancho=1500;
	motor=1600;
	peso=500;
	
	
}
	
public String dime_datos_generales(){ //Método Getter 
	
	return "La plataforma del vehículo tiene " + ruedas + " ruedas" + ". Mide "
	
	+ largo/1000 + " metros de largo con un ancho de " + ancho + " mm. y un peso de " 
	
	+ peso + " Kg.";
	
}

public void establece_color(String color_coche){ //Método Setter
	
	color=color_coche;
	
	
}

public String dime_color(){
	
	return "El color del coche es: " + color;
	
}
	
	public void configura_asientos(String asientos_cuero){
		
		if (asientos_cuero.equalsIgnoreCase("si")){
			
			this.asientos_cuero=true;
		}else{
			this.asientos_cuero=false;
		}
	}

	public String dime_asientos(){
		
		if(asientos_cuero==true){
			
			return "El coche tiene asientos de cuero.";
		}else{
			return "El coche tiene asientos de serie.";
		}
	}
	public void configura_climatizador(String aire_acondicionado){
		if(aire_acondicionado.equalsIgnoreCase("si")){
			
			this.aire_acondicionado=true;
		}else{
			this.aire_acondicionado=false;
		}
	}
	public String dime_aire(){
		
		if(aire_acondicionado==true){//Método Getter
			
			return "El coche incorpora aire aondicionado.";
		}else{
			return "El coche no incorpora aire aondicionado.";
		}
	}
	
	public String dime_peso_coche(){
		
		int peso=500;
		
		peso_total=peso_total+peso;
		
		if(asientos_cuero==true){
			
		peso_total=peso_total+50;
			
		}
		if(aire_acondicionado==true){
			peso_total=peso_total+20;
			
		}
		
		return "El peso del coche es:" + peso_total;
	}
	
	public int precio_coche(){
		
		int precio_final=10000;
		
		if(asientos_cuero==true){
			
			precio_final+=2000;
		}
		
		if(aire_acondicionado==true){
			
			precio_final+=1500;
		}
		
		return precio_final;
				
	}
	
}


