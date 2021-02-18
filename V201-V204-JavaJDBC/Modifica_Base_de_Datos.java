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
public class Modifica_Base_de_Datos {
    
    public static void main(String[] args){
        
        //Para saber el puerto de la base de datos hacer este request
        //SHOW VARIABLES WHERE VARIABLE_NAME IN('hostname', 'port')
        try{
            
            //1.-Crear conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");
            
            //2.Crear objeto statement
            Statement miStatement = miConexion.createStatement();
            
            //String instruccionSql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77', 'PANTALÓN', 25.35)";
            //String instruccionSql = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
            String instruccionSql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(instruccionSql);
            
            //System.out.println("datos insertados correctamente");
            //System.out.println("datos modificados correctamente");
            System.out.println("datos borrados correctamente");
             
        }catch(Exception e){
            
            System.out.println("No Conecta!!");
            
            e.printStackTrace();
            
        }
    }
}
