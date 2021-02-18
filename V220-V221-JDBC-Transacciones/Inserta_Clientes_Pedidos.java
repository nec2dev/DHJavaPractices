/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacciones;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Inserta_Clientes_Pedidos {
    
    public static void main(String[] args){
        
        Connection myConexion = null;
        
        try{
            
            //1.-Crear conexión
            myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?&useSSL=false", "root","BrizuelaMySQL1999");
            
            myConexion.setAutoCommit(false);//Trata a las instrucciones como bloque
            
            //2.-Crear objeto statement
            Statement myStatement = myConexion.createStatement();
            
            String consulta1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'CANADA 1618')";
            
            //3a.Ejecutar Query
            myStatement.executeUpdate(consulta1);
            
            String consulta2 = "INSERT INTO PEDIDOS (NÚMERODEPEDIDOo, CÓDIGOCLIENTE, FECHADEPEDIDO) VALUES ('92', 'CT84', '11/03/2008')";
            
            //3b.Ejecutar Query
            myStatement.executeUpdate(consulta2);
            
            myConexion.commit();//Si todas las consultas estan bien, da el oK
            
            System.out.println("Datos insertados correctamente");
            
            
	}catch(SQLException e){
            
            System.out.println("error en la insercion de datos");
            
            try {
                myConexion.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Inserta_Clientes_Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    
}
