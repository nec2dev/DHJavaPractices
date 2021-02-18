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
 * 
 */
public class Consulta_Preparada {
    
    public static void main(String[] args){
        
        //Para saber el puerto de la base de datos hacer este request
        //SHOW VARIABLES WHERE VARIABLE_NAME IN('hostname', 'port')
        try{
            
            //1.-Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");
            
            //2.-Crear objeto statement
            PreparedStatement miPreparedStatement = miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS"
                    + " WHERE SECCIÓN=? AND  PAÍSDEORIGEN=?");
            
            //3.-Establecer parámetrops de consulta
            miPreparedStatement.setString(1, "DEPORTES");
            
            miPreparedStatement.setString(2, "USA");
            
            //4.-Ejecutar y rrecorrer consulta
            ResultSet rs = miPreparedStatement.executeQuery();
            
                System.out.println("Ejecución primer consulta");
                System.out.println("");
                
            while(rs.next()){
               
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            
            rs.close();
            
            //4.-Reutilización de consulta
           
            miPreparedStatement.setString(1, "CERÁMICA");
            
            miPreparedStatement.setString(2, "CHINA");
            
            //4.-Ejecutar y rrecorrer consulta
            rs = miPreparedStatement.executeQuery();
                
            System.out.println("");
                System.out.println("Ejecución segunda consulta");
                System.out.println("");
            
            while(rs.next()){
                
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            
            rs.close();
             
        }catch(Exception e){
            
            System.out.println("No Conecta!!");
            
            e.printStackTrace();
            
        }
    }
    
}
