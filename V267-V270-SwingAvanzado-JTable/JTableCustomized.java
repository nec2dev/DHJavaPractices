/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtablecustomized;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class JTableCustomized {
    
    public static void main(String[] args){
        
        JFrame mimarco = new MarcoTablaPersonalizada();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
        
    }
    
}

class MarcoTablaPersonalizada extends JFrame{
    
    
    public MarcoTablaPersonalizada(){
        
        setTitle("Tabla personalizada");
        
        setBounds(300,300,400,200);
        
        TableModel mimodelo = new ModelotablaPersonalizada();
        
        JTable mitabla = new JTable(mimodelo);
        
        add(new JScrollPane(mitabla));
    }
    
}

class ModelotablaPersonalizada extends AbstractTableModel{

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        return 5;
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.}}
        
        int z = rowIndex+1;
        
        int y = columnIndex+2;
        
        return " " + z + " " + y;
    }
    
    public String getColumnName(int c){
        
        return "Columna " + c;
        
    }
}
