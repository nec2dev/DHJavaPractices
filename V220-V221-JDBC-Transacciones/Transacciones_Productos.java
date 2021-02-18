/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Transacciones_Productos {
    
    public static void main(String[] args){
        
    Connection myConexion = null;
        
        try{
            
            //1.-Crear conexión
            myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");
            
            myConexion.setAutoCommit(false);//Trata a las instrucciones como bloque
            
            //2.-Crear objeto statement
            Statement myStatement = myConexion.createStatement();
            
            String consulta1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'";
            
            String consulta2 = "DELETE FROM PRODUCTOS WHERE PRECIO>300";
            
            String consulta3 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";
            
            boolean ejecutar = ejecutarTransaccion();
            
            if(ejecutar){
                
                myStatement.executeUpdate(consulta1);
                
                myStatement.executeUpdate(consulta2);
                
                myStatement.executeUpdate(consulta3);
                
                myConexion.commit();
                
                System.out.println("Se ejecutó la transacción correctamente");
                
            }else{
                
                System.out.println("No se realizó ningun cambio en la BBDD");
            }
            
            
	}catch(SQLException e){
            
        try {
            myConexion.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Transacciones_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
            e.printStackTrace();
            System.out.println("Ooops, Algo salió mal");
            
        }
        
        
    }
    
    static boolean ejecutarTransaccion(){
        
        String ejecucion = JOptionPane.showInputDialog("Ejecutamos transacción?");
        
        if(ejecucion.equals("Si")) return true;
        
        else return false;
        
        
    }
    
}

