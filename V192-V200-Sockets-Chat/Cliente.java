/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nahuel E Correa
 * 
 */


public class Cliente {
    
public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
                
                addWindowListener(new EnvioOnline());
                
		}	
	
}

//Envío de sesión online-----------------------------

class EnvioOnline extends WindowAdapter{
    
    public void windowOpened(WindowEvent e){
        
        try{
            
            Socket misocket = new Socket("192.168.0.194", 9999);
            
            paqueteEnvio datos = new paqueteEnvio();
            
            datos.setMensaje(" online");
            
            ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
            
            paquete_datos.writeObject(datos);
            
            misocket.close();
            
        }catch(Exception e2){
            
        }
    }
}

//Fin de envío de sesión online----------------------

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
            
                String nick_usuario = JOptionPane.showInputDialog("Nick: ");
            
                JLabel n_nick = new JLabel("Nick: ");
                
                add(n_nick);
            
                nick = new JLabel();
                
                nick.setText(nick_usuario);
                
                add(nick);
                
		JLabel texto=new JLabel("Online:");
		
		add(texto);
                
                ip = new JComboBox();
                
                /*ip.addItem("Usuario 1");
                
                ip.addItem("Usuario 2");
                
                ip.addItem("Usuario 3");
                
                ip.addItem("Usuario 4");*/
                
                //ip.addItem("192.168.0.197");
                
                //ip.addItem("192.168.0.198");
                
                add(ip); 
                
                campochat = new JTextArea(12,20);
                
                add(campochat);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
                
                EnviaTexto mievento = new EnviaTexto();
                
                miboton.addActionListener(mievento);
		
		add(miboton);	
                
                Thread mihilo = new Thread(this);
                
                mihilo.start();
		
	}

    @Override
    public void run() {
        
        try{
            
            ServerSocket servidor_cliente = new ServerSocket(9090);
            
            Socket cliente;
            
            paqueteEnvio paquete_recibido;
            
            while(true){
                
                cliente = servidor_cliente.accept();
                
                ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
                
                paquete_recibido = (paqueteEnvio) flujo_entrada.readObject();
                
                if(!paquete_recibido.getMensaje().equals(" online")){
                    
                    campochat.append("\n" + paquete_recibido.getNick() + ": " + paquete_recibido.getMensaje());
                    
                }else{
                    
                    /*campochat.append("\n" + paquete_recibido.getIps());*/
                    
                    ArrayList<String> IpsMenu = new ArrayList<String>();
                    
                    IpsMenu = paquete_recibido.getIps();
                    
                    ip.removeAllItems();
                    
                    for (String z:IpsMenu) {
                        
                        ip.addItem(z);
                        
                    }
                    
                }
                   
            }
            
            
        }catch(Exception e){
            
            
        }
    }
	
	private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            campochat.append("\n" + campo1.getText());
            
            try {
                
                Socket misocket = new Socket("192.168.1.33", 9999);
                
                /*DataOutputStream flujo_salida = new DataOutputStream(mysocket.getOutputStream());
                
                flujo_salida.writeUTF(campo1.getText());
                
                flujo_salida.close();*/
                
                paqueteEnvio datos = new paqueteEnvio();
                
                datos.setNick(nick.getText());
                
                //datos.setIp((String)ip.getSelectedItem());Castié a String y parece que va bien
                
                datos.setIp(ip.getSelectedItem().toString());
                
                datos.setIp((String)ip.getSelectedItem());
                
                datos.setMensaje(campo1.getText());
                
                ObjectOutputStream paquetes_datos = new ObjectOutputStream(misocket.getOutputStream());
                
                paquetes_datos.writeObject(datos);
                
                misocket.close();
                
            } catch (UnknownHostException e1){
                
                e1.printStackTrace();
                
            } catch (IOException e1) {
                Logger.getLogger(LaminaMarcoCliente.class.getName()).log(Level.SEVERE, null, e1);
                
                System.out.println(e1.getMessage());
            }
                
           
                
            }
        }
 	
	private JTextField campo1;
        
        private JComboBox ip;
        
        private JLabel nick;
        
        private JTextArea campochat;
	
	private JButton miboton;
	
}

class paqueteEnvio implements Serializable{
    
    private String nick, ip, mensaje;
    
    private ArrayList<String> Ips;

    public ArrayList<String> getIps() {
        return Ips;
    }

    public void setIps(ArrayList<String> Ips) {
        this.Ips = Ips;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
