/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectaBBDD;

import java.sql.*;

/**
 *
 * @author Nahuel E Correa
 */
public class Conecta_Pruebas {
    
    public static void main(String[] args){
        
        //Para saber el puerto de la base de datos hacer este request
        //SHOW VARIABLES WHERE VARIABLE_NAME IN('hostname', 'port')
        try{
            
            //1.-Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root","BrizuelaMySQL1999");
            
            //2.Crear objeto statement
            Statement miStatement = miConexion.createStatement();
            
            //3.Ejecutar Query
            ResultSet miResultset = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
            
            //4.-Recorrer el resultset
            while(miResultset.next()){
            
            System.out.println(miResultset.getString("NOMBREARTÍCULO") + " " 
                    + miResultset.getString("CÓDIGOARTÍCULO") + " " +
                    miResultset.getString("PRECIO"));
            
            /*System.out.println(miResultset.getString(3) + " " 
                    + miResultset.getString(1) + " " +
                    miResultset.getString(4));*/
            
        }
            
        }catch(Exception e){
            
            System.out.println("No Conecta!!");
            
            e.printStackTrace();
            
        }
        
    }
    
}
