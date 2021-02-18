package poo;

public class Furgoneta extends Coche {
	
	private int capacidad_carga;
	
	private int plazas_extra;
	
	public Furgoneta(int plazas_extra, int capacidad_carga) {
		
		super(); //lamar al constructo de la superclase para darle estado inicial.
		
		this.capacidad_carga=capacidad_carga;
		
		this.plazas_extra=plazas_extra;
		
		
	}
	
	public String dimeDatosFurgoneta(){
		
		return "La capacidad de carga es: " + capacidad_carga + ", y la cantidad de plazas son: "
				
				+ plazas_extra;
		
	}

}
