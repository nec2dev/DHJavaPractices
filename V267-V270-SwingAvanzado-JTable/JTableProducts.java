/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtableproducts;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class JTableProducts {
    
    public static void main(String[] args){
        
        JFrame mimarco = new MarcoProductos();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
        
    }
    
}

class MarcoProductos extends JFrame{
    
    public MarcoProductos(){
        
        setTitle("Productos");
        
        setBounds(500,300,800,400);
        
        JPanel superior = new JPanel();
        
        nombredeTablas = new JComboBox();
        
        try{
            
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "BrizuelaMySQL1999");
            
            datosBBDD = miconexion.getMetaData();
            
            rs=datosBBDD.getTables(null, null, null, null);
            
            while(rs.next()){
                
                nombredeTablas.addItem(rs.getString("TABLE_NAME"));
                
            }
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
        
        nombredeTablas.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                
                String tablaSeleccionada = (String)  nombredeTablas.getSelectedItem();
                
                String consulta = "SELECT * FROM " + tablaSeleccionada;
                
                try{
                
                sentencia = miconexion.createStatement();
                
                rs=sentencia.executeQuery(consulta);
                
                /*while(rs.next()){
                    
                    System.out.println(rs.getString("NOMBREARTÍCULO") + " " 
                    + rs.getString("CÓDIGOARTÍCULO"));
                }*/
                
                modelo = new ResultSetModeloTabla(rs);
                
                JTable tabla = new JTable(modelo);
                
                add(new JScrollPane(tabla), BorderLayout.CENTER);
                
                validate();
                
                }catch(Exception e1){
                    
                    e1.printStackTrace();
                }
            }
        });
        
        superior.add(nombredeTablas);
        
        add(superior, BorderLayout.NORTH);
        
    }
    
    private JComboBox nombredeTablas;
    
    private DatabaseMetaData datosBBDD;
    
    private ResultSet rs;
    
    private Connection miconexion;
    
    private Statement sentencia;
    
    private ResultSetModeloTabla modelo;
    
}

class ResultSetModeloTabla extends AbstractTableModel{
    
    public ResultSetModeloTabla(ResultSet unResultSet){
        
        try {
            rsRegistros = unResultSet;
            
            rsmd=rsRegistros.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public int getRowCount() {
        try {
            //throw new UnsupportedOperationException("Not supported yet.");
            //To change body of generated methods, choose Tools | Templates.
            
            rsRegistros.last();
            
            return rsRegistros.getRow();
        } catch (SQLException ex1) {
            //Logger.getLogger(ResultSetModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
            
            ex1.printStackTrace();
            
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            //throw new UnsupportedOperationException("Not supported yet.");
            //To change body of generated methods, choose Tools | Templates.

            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            //Logger.getLogger(ResultSetModeloTabla.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
            
            return 0;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        try{
        
        rsRegistros.absolute(arg0 + 1);
        
        return rsRegistros.getObject(arg1 + 1);
        
    }catch(Exception e){
        
        e.printStackTrace();
        
        return 0;
    }
        
   }
    
    public String getColumnName(int c){
        
        try{
            
            return rsmd.getColumnName(c + 1);
            
        }catch(Exception e){
            
            e.printStackTrace();
            
            return null;
        }
    }

    private ResultSet rsRegistros;
    
    private ResultSetMetaData rsmd;
}
