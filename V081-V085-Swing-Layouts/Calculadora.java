package graficos;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCalculadora mimarco=new MarcoCalculadora();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		mimarco.setVisible(true);
	}

}

class MarcoCalculadora extends JFrame{
	
	public MarcoCalculadora(){
		
		setTitle("Calculadora");
		
		setBounds(500,300,450,550);
		
		LaminaCalculadora milamina= new LaminaCalculadora();
		
		add(milamina);
		
		//pack();
		
	}
}

class LaminaCalculadora extends JPanel{
	
	public LaminaCalculadora(){
		
		principio=true;
		
		setLayout(new BorderLayout());
		
		pantalla= new JButton("0");
		
		pantalla.setEnabled(false);
		
		add(pantalla, BorderLayout.NORTH);
		
		milamina2 = new JPanel();
		
		milamina2.setLayout(new GridLayout(7,5));
		
		ActionListener insertar= new InsertaNumero();
		
		ActionListener orden= new AccionOrden();
		
		PonerBoton("MC",orden);
		PonerBoton("MR",orden);
		PonerBoton("M+",orden);
		PonerBoton("M-",orden);
		PonerBoton("MS",orden);
		
		PonerBoton("%",orden);
		PonerBoton("raiz",orden);
		PonerBoton("x2",orden);
		PonerBoton("1/x",orden);
		PonerBoton("N",orden);
		
		PonerBoton("CE",orden);
		PonerBoton("C",orden);
		PonerBoton("Borrar",orden);
		PonerBoton("/",orden);
		PonerBoton("A",orden);
		
		PonerBoton("7",insertar);
		PonerBoton("8",insertar);
		PonerBoton("9",insertar);
		PonerBoton("*",orden);
		PonerBoton("H",orden);
		
		PonerBoton("4",insertar);
		PonerBoton("5",insertar);
		PonerBoton("6",insertar);
		PonerBoton("-",orden);
		PonerBoton("U",orden);
		
		PonerBoton("1",insertar);
		PonerBoton("2",insertar);
		PonerBoton("3",insertar);
		PonerBoton("+",orden);
		PonerBoton("E",orden);
		
		PonerBoton("+-",orden);
		PonerBoton("0",insertar);
		PonerBoton(".",insertar);
		PonerBoton("=",orden);
		PonerBoton("L",orden);
		
		add(milamina2, BorderLayout.CENTER);
		
		ultimaOperacion="=";
	}
	
	private void PonerBoton(String rotulo, ActionListener oyente){
		
		JButton boton=new JButton(rotulo);
		
		boton.addActionListener(oyente);
		
		milamina2.add(boton);
		
	}
	
	private class InsertaNumero implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String entrada=e.getActionCommand();
		
			if (principio){
				
				pantalla.setText("");
				
				principio= false;
				
			}
			
			pantalla.setText(pantalla.getText()+entrada);
			
		}
		
		
	}
	
	private class AccionOrden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String operacion=e.getActionCommand();
			
			calcular(Double.parseDouble(pantalla.getText()));
			
			ultimaOperacion=operacion;
			
			principio=true;
		}
		
		public void calcular(double x){
			
			if(ultimaOperacion.equals("+")){
				
				resultado+=x;
				
			}
			
			else if(ultimaOperacion.equals("=")){
				
				resultado=x;
			}
			
			else if(ultimaOperacion.equals("-")){
				
				resultado-=x;
			}
			else if(ultimaOperacion.equals("*")){
				
				resultado*=x;
			}	
				
			else if(ultimaOperacion.equals("/")){
				
				resultado/=x;
			}	
			
			else if(ultimaOperacion.equals("+")){
				
				resultado=x;
			}
			
			pantalla.setText(""+ resultado);
		}
		
	}
	
	private JPanel milamina2;
	
	private JButton pantalla;
	
	private boolean principio;
	
	private double resultado;
	
	private String ultimaOperacion;
}