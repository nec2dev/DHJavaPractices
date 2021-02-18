/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectaBBDD;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Aplicacion_Consulta {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
               
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
                botonConsulta.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        ejecutaConsulta();
                    
                    }
                });
                        
		add(botonConsulta, BorderLayout.SOUTH);
                
                
                
                //--------------CONEXION CON BBDD------------------//
                
                try{
            
            //1.-Crear conexión
            myConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?&useSSL=false", "root","BrizuelaMySQL1999");
	
            //2.-Crear objeto statement
            Statement myStatement = myConexion.createStatement();
            
            String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
            
            //3.Ejecutar Query
            ResultSet myResultset = myStatement.executeQuery(consulta);
            
            while(myResultset.next()){
                
                secciones.addItem(myResultset.getString(1));
            }
            
            myResultset.close();
            
                //--------------CARGA JCOMBOBOX PAISES-----------------//
                
            consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
            
            //3.Ejecutar Query
            myResultset = myStatement.executeQuery(consulta);
            
            while(myResultset.next()){
                
                paises.addItem(myResultset.getString(1));
            }
            
            myResultset.close();
            
	}catch(SQLException e){
            
        }	
		
        }
        
        private void ejecutaConsulta(){
            
            ResultSet myResultset = null;
            
            try{
                
                resultado.setText("");
                
                String seccion=(String)secciones.getSelectedItem();
                
                String pais=(String)paises.getSelectedItem();
                
                if(!seccion.equals("Todos") && pais.equals("Todos")){
                
                enviaConsultaseccion = myConexion.prepareStatement(consultaSeccion);
                
                enviaConsultaseccion.setString(1, seccion);
                
                myResultset = enviaConsultaseccion.executeQuery();
                
                    }else if(seccion.equals("Todos") && !pais.equals("Todos")){
                
                        enviaConsultapais = myConexion.prepareStatement(consultaPais);
                
                        enviaConsultapais.setString(1, pais);
                
                        myResultset = enviaConsultapais.executeQuery();
                        
                        }else if(!seccion.equals("Todos") && !pais.equals("Todos")){
                        
                            enviaConsultatodos = myConexion.prepareStatement(consultaTodos);

                            enviaConsultatodos.setString(1, seccion);
                            
                            enviaConsultatodos.setString(2, pais);

                            myResultset = enviaConsultatodos.executeQuery();
                        
                        
                    }
                
                while(myResultset.next()){
                    
                    resultado.append(myResultset.getString(1));
                    
                    resultado.append(", ");
                    
                    resultado.append(myResultset.getString(2));
                    
                    resultado.append(", ");
                    
                    resultado.append(myResultset.getString(3));
                    
                    resultado.append(", ");
                    
                    resultado.append(myResultset.getString(4));
                    
                    resultado.append("\n");
                    
                }
                        
            }catch(SQLException e){
                
            }
            
            
        }
	
        private Connection myConexion;
        
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;
        
        private PreparedStatement enviaConsultaseccion;
        
        private PreparedStatement enviaConsultapais;
        
        private PreparedStatement enviaConsultatodos;
        
        private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	
        private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
        
        private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
}
