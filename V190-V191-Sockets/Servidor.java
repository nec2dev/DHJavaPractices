/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahuel E Correa
 * 
 */

public class Servidor {
    
public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
                
                Thread mihilo = new Thread(this);
                
                mihilo.start();
		
		}

    @Override
    public void run() {
        
            try {
                
                //System.out.println("estoy a la escucha");

                ServerSocket myserver = new ServerSocket(9999);
                
                String nick, ip, mensaje;
                
                ArrayList<String> listaIp = new ArrayList<String>();
                
                paqueteEnvio paquete_recibido;
                
                while(true){
                
                Socket misocket = myserver.accept();
                
                
                /*DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
                
                String mensaje_texto = flujo_entrada.readUTF();
                
                areatexto.append( mensaje_texto );
                
                misocket.close();*/
                
                ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
                
                paquete_recibido = (paqueteEnvio) paquete_datos.readObject();
                
                nick = paquete_recibido.getNick();
                
                ip = paquete_recibido.getIp();
                
                mensaje = paquete_recibido.getMensaje();
                
                if(!mensaje.equals(" online")){
                
                areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);
                
                Socket envia_destinatario = new Socket(ip, 9090);
                
                ObjectOutputStream paquete_reenvio = new ObjectOutputStream(envia_destinatario.getOutputStream());
                
                paquete_reenvio.writeObject(paquete_recibido);
                
                paquete_reenvio.close();
                
                envia_destinatario.close();
                
                misocket.close(); 
                
                    }else{
                       
                //Detecta usuarios online---------------------------
                
                InetAddress localizacion = misocket.getInetAddress();
                
                String IpRemota = localizacion.getHostAddress();
                
                System.out.println("Online " + IpRemota);
                
                listaIp.add(IpRemota);
                
                paquete_recibido.setIps(listaIp);
                
                    for(String z:listaIp){
                        
                        System.out.println("Array: " + z);
                        
                        Socket envia_destinatario = new Socket(z, 9090);
                
                ObjectOutputStream paquete_reenvio = new ObjectOutputStream(envia_destinatario.getOutputStream());
                
                paquete_reenvio.writeObject(paquete_recibido);
                
                paquete_reenvio.close();
                
                envia_destinatario.close();
                
                misocket.close();
                
                    }
                    
                //Fin de Detecta usuarios online----------------------
                }
                
                }
            
                        } catch (IOException ex) {
                            
                            ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            

    }
	private	JTextArea areatexto;
}
