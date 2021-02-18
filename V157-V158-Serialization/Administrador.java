/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Nahuel E Correa
 */
public class Administrador {
    
    public Administrador(String nom, double sue, int agno, int mes, int dia){
		
		nombre=nom;
		
		sueldo=sue;
		
		GregorianCalendar calendario= new GregorianCalendar(agno, mes-1,dia);
		
		altaContrato=calendario.getTime();
		
		
        
        
    }
    
    private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
    
}

        