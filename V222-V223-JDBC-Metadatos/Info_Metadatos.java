/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Info_Metadatos {
    
    public static void main(String[] args){
        
        //mostrarInfoBBDD();
        
        mostrarInfoTablas();
    }
    
    static void mostrarInfoBBDD(){
        
        Connection myConexion = null;
        
        try{
            
            myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?&useSSL=false", "root","BrizuelaMySQL1999");
            
            //Obtener metadatos
            DatabaseMetaData datosBBDD = myConexion.getMetaData();
            
            System.out.println("gestor de Base de Datos: " + datosBBDD.getDatabaseProductName());
            
            System.out.println("Version del Gestor: " + datosBBDD.getDatabaseProductVersion());
            
            System.out.println("Nombre del Driver: " + datosBBDD.getDriverName());
            
            System.out.println("Versión del Driver: " + datosBBDD.getDriverVersion());
            
        }catch(Exception e){
            
            e.printStackTrace();
              
        }finally{
            
            try {
                myConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Info_Metadatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    static void mostrarInfoTablas(){
        
        Connection myConexion = null;
        
        ResultSet myResultset = null;
        
        try{
            
            myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql?&useSSL=false", "root","BrizuelaMySQL1999");
            
            //Obtener metadatos
            DatabaseMetaData datosBBDD = myConexion.getMetaData();
            
            //Lista de tablas
            System.out.println("Lista de tablas: " );
            
            myResultset = datosBBDD.getTables(null, null, null, null);
            
            while(myResultset.next()){
                
                System.out.println(myResultset.getString("TABLE_NAME"));
            }
            
            //Lista de Columnas de Productos
            System.out.println("");
            
            System.out.println("Campos de productos: ");
            
            myResultset = datosBBDD.getColumns(null, null, "productos", null);
        
            while(myResultset.next()){
                
                System.out.println(myResultset.getString("COLUMN_NAME"));
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
              
        }finally{
            
            try {
                myConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Info_Metadatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}