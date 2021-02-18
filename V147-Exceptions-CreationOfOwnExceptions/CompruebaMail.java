/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejexcepciones;

//import java.io.EOFException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel E Correa
 * 
 * Exepciones
 * 
 * 
 */
public class CompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mail=JOptionPane.showInputDialog("Introduce mail");
                
                //examinaMail(mail);
               
                try{
                
                    examinaMail(mail);
                
                }catch(Exception e){
                    
                    System.out.println("La direccion de mail no es correcta.");
                    
                    e.printStackTrace();//No solo imprime el mensaje de catch sino,
                                        //da pista a otro programador de la excepcion propia creada
                }
        }
        
        static void examinaMail(String mail)throws Longitud_mail_erronea{
            
                int arroba=0;
		
		boolean punto=false;
                
                if(mail.length()<=3){
                    
                    //ArrayIndexOutOfBoundsException aiobe = new ArrayIndexOutOfBoundsException();
                    
                    //throw aiobe;
                    
                    //throw new EOFException();
                    
                    throw new Longitud_mail_erronea("El mail es muuy corto");
                
                }else{
		
		for (int i=0; i<mail.length(); i++){
			
			if(mail.charAt(i)=='@'){
				
				arroba++;
				
			}
			
			if(mail.charAt(i)=='.'){
				
				punto=true;
			}
		}
		
		if(arroba==1){
			
			System.out.println("Es correcto");
		}
		
		else {
			
			System.out.println("No es correcto");
		}
	}

}}

 class Longitud_mail_erronea extends Exception{
     
     public Longitud_mail_erronea(){}
         
     public Longitud_mail_erronea(String msj_error){
         
         super(msj_error);
     }
 }   

