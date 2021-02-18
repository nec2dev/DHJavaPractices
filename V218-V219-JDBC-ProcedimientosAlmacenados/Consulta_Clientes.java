/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoalmacenado;

import java.sql.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Consulta_Clientes {
    
    public static void main(String[] args){
    
    try{
    
        Connection myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?&useSSL=false", "root","BrizuelaMySQL1999");

        CallableStatement misentencia = myConexion.prepareCall("{call MUESTRA_CLIENTES}");

        ResultSet rs = misentencia.executeQuery();

        while(rs.next()){

            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }

        rs.close();
    
    }catch(SQLException e){
    
    
}
    
}

}