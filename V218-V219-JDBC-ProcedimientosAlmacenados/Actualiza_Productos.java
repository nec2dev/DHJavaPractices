/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesoalmacenado;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Actualiza_Productos {
    
    public static void main(String[] args){
        
        int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("introduzca precio: "));
        
        String nArticulo = JOptionPane.showInputDialog("introduzca artículo: ");
        
        try{
    
        Connection myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");

        CallableStatement misentencia = myConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");

        misentencia.setInt(1, nPrecio);
        
        misentencia.setString(2, nArticulo);

        misentencia.execute();
        
            System.out.println("Actualizado correctamente.");
    
    }catch(SQLException e){
    
    
}
    }
    
}
