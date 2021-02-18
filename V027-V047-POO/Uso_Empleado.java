package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Empleado empleado1=new Empleado("Pablo Gonal" , 85000, 1990, 12, 17);
		
		Empleado empleado2=new Empleado("Ana López" , 95000, 1995, 06, 02);
		
		Empleado empleado3=new Empleado("Mariana Martínez" , 105000, 2002, 03, 15);
		
		empleado1.subeSueldo(5);
		
		empleado2.subeSueldo(5);
		
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo()
						+ " Fecha de Alta: " + empleado1.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo()
		+ " Fecha de Alta: " + empleado2.dameFechaContrato());
		
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo()
		+ " Fecha de Alta: " + empleado3.dameFechaContrato());*/
		
		Jefatura jefe_RRHH=new Jefatura("Nahuel", 55000, 2006, 9, 25);
		
		jefe_RRHH.esteblece_incentivo(2570);
		
		
		Empleado[] misEmpleados =new Empleado[6];
		
		misEmpleados[0]= new Empleado("Pablo Gonal", 85000, 1990, 12, 17);
		
		misEmpleados[1]= new Empleado("Ana López", 95000, 1995, 06, 02);
		
		misEmpleados[2]= new Empleado("Mariana Martínez", 105000, 2002, 03, 15);
		
		misEmpleados[3]= new Empleado("Antonio Fernández");
		
		misEmpleados[4]=jefe_RRHH; //polimorfismo en accion. Principio de sustitución
		
		misEmpleados[5]= new Jefatura("Mayra", 95000, 2009,11, 9);
		
		Jefatura Jefa_Finanzas=(Jefatura) misEmpleados[5];
		
		Jefa_Finanzas.esteblece_incentivo(55000);
		
		System.out.println (Jefa_Finanzas.tomar_decisiones("Dar más días de vacaciones a los empleados"));
		
		System.out.println("El jefe " + Jefa_Finanzas.dameNombre() + 
				" Tiene un bono de: " + Jefa_Finanzas.establece_bonus(500));
		
		System.out.println("El empleado  " +  misEmpleados[3].dameNombre() + 
				" Tiene un bono de: " + misEmpleados[3].establece_bonus(200));
		
		
		/*for(int i=0;i<3;i++){
			
			misEmpleados[i].subeSueldo(5);
		}*/
		
		for(Empleado e: misEmpleados){
			
			e.subeSueldo(5);
		}
		
		/*for(int i=0;i<3;i++){
			
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + " Sueldo: " + misEmpleados[i].dameSueldo()
			+ " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}*/
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados){
			System.out.println("Nombre: " + e.dameNombre() + /*"ID es: " + e. +*/ " Sueldo: " + e.dameSueldo()
					+ " Fecha de Alta: " + e.dameFechaContrato());
				}
		}
		
		
	}


class Empleado implements Comparable, Trabajadores {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia ){
		
		nombre=nom;
		
		sueldo=sue;
		
		GregorianCalendar calendario= new GregorianCalendar(agno, mes-1,dia);
		
		altaContrato=calendario.getTime();
		
		++IdSiguiente;
		
		Id=IdSiguiente;
		
		
	}
	
	public double establece_bonus(double gratificacion){
		
		return Trabajadores.bonus_base+gratificacion;
	}
	
	public Empleado(String nom){
		
		this(nom, 30000, 2000,01,01);
		
	}
	
	
	public String dameNombre(){ //Metodo Getter
		
		return nombre + " Id: " + Id;
	}
	
	public double dameSueldo(){ //Metodo Getter
		
		return sueldo;
	}
	
	public Date dameFechaContrato(){ //Metodo Getter
		
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje){
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	public int compareTo(Object miObjeto){
		
		Empleado otroEmpleado=(Empleado) miObjeto;
		
		if(this.Id<otroEmpleado.Id){
			
			return 1;
		}
		
if(this.Id>otroEmpleado.Id){
			
			return -1;}

return 0;

			
			
	}
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
	
	
}

class Jefatura extends Empleado implements Jefes {
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia){
		
		super(nom, sue, agno, mes, dia);
		
	}
	
	public String tomar_decisiones(String decision){
		
		return "Un miembro de la dirección ha tomado la decisión de " + decision;
	}
	
	public double establece_bonus(double gratificacion){
		
		double prima=2000;
		
		return Trabajadores.bonus_base+ gratificacion + prima;
	}
	public void esteblece_incentivo(double b){
		
		incentivo=b;
		
	}
		
		public double dameSueldo(){
			
			double sueldoJefe=super.dameSueldo();
			
			return sueldoJefe + incentivo;
			
			
		
	}
	
	private double incentivo; 
	
	
}


