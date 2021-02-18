/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciospracticos;

import javax.swing.*;
import java.awt.*;//Para el GridLayout
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Date;

/**
 *
 * @author Nahuel E Correa
 * 
 * 17/10/2017
 * 
 * 
 */
public class Marco_Dialogos extends JFrame {

    public Marco_Dialogos() {

        setTitle("Prueba de diálogos");

        setBounds(500, 300, 600, 450);

        JPanel miLaminaCuadricula = new JPanel();

        miLaminaCuadricula.setLayout(new GridLayout(2, 3));

        String primero[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};

        lamina_tipo = new Lamina_Botones("Tipo", primero);

        miLaminaCuadricula.add(lamina_tipo);

        add(miLaminaCuadricula);

        String segundo[] = {"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};

        lamina_tipo_mensajes = new Lamina_Botones("Tipo de Mensaje", segundo);

        miLaminaCuadricula.add(lamina_tipo_mensajes);

        add(miLaminaCuadricula);

        lamina_mensaje = new Lamina_Botones("Mensaje", new String[]{
            "Cadenas", "Icono", "Componente", "Otros", "Object[]"});

        miLaminaCuadricula.add(lamina_mensaje);

        add(miLaminaCuadricula);

        lamina_confirmar = new Lamina_Botones("Confirmar", new String[]{
            "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"});

        miLaminaCuadricula.add(lamina_confirmar);

        add(miLaminaCuadricula);

        lamina_opcion = new Lamina_Botones("Opción", new String[]{
            "String[]", "Icon[]", "Object[]"});

        miLaminaCuadricula.add(lamina_opcion);

        add(miLaminaCuadricula);

        lamina_entrada = new Lamina_Botones("Entrada", new String[]{
            "Campo de texto", "Combo"});

        miLaminaCuadricula.add(lamina_entrada);

        add(miLaminaCuadricula);

        setLayout(new BorderLayout());

        //Construimos la lámina iferior
        JPanel lamina_mostrar = new JPanel();

        JButton boton_mostrar = new JButton("Mostrar");

        boton_mostrar.addActionListener(new AccionMostrar());

        lamina_mostrar.add(boton_mostrar);

        add(lamina_mostrar, BorderLayout.SOUTH);

        add(miLaminaCuadricula, BorderLayout.CENTER);

    }

    //------------------Proporciona el Mensaje-------------------//
    public Object getMensaje() {

        String s = lamina_mensaje.getSeleccion();

        if (s.equals("Cadena")) {

            return cadenaMensaje;

        } else if (s.equals("Icono")) {

            return iconoMensaje;

        } else if (s.equals("Componente")) {

            return componenteMensaje;

        } else if (s.equals("Otros")) {

            return objetoMensaje;

        } else if (s.equals("Object[]")) {

            return new Object[]{
                cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje
            };
        } else {

            return null;
        }
    }

    //------devuelve tipo de Icono y cantidad de Botones------------//
    public int getTipo(Lamina_Botones lamina) {

        String s = lamina.getSeleccion();

        if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {

            return 0;

        } else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {

            return 1;

        } else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {

            return 2;

        } else if (s.equals("QUESTION_MESSAGE")) {

            return 3;

        } else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {

            return -1;

        } else {

            return 0;
        }
    }
    //------------da opciones a la lámina Opción-----------------//

    public Object[] getopciones(Lamina_Botones lamina) {

        String s = lamina.getSeleccion();

        if (s.equals("String[]")) {

            return new String[]{"Amarillo", "Cyan", "Magenta"};

        } else if (s.equals("Icon[]")) {

            return new Object[]{new ImageIcon("src/icoamarillo.png"), new ImageIcon("src/icocyan.png"), new ImageIcon("src/icomagenta.png")

            };
        } else if (s.equals("Object[]")) {

            return new Object[]{
                cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje
            };
        } else {

            return null;
        }
    }

    //------Clase interna que gestiona los eventos---------------//
    private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //System.out.println(lamina_tipo.getSeleccion() + " " + lamina_tipo_mensajes.getSeleccion());
            
            if (lamina_tipo.getSeleccion().equals("Mensaje")) {

                JOptionPane.showMessageDialog(Marco_Dialogos.this, getMensaje(), "Título", getTipo(lamina_tipo_mensajes));

            } else if (lamina_tipo.getSeleccion().equals("Confirmar")) {

                JOptionPane.showConfirmDialog(Marco_Dialogos.this, getMensaje(), "Título", getTipo(lamina_confirmar), getTipo(lamina_tipo_mensajes));

            } else if (lamina_tipo.getSeleccion().equals("Entrada")) {
                
                if(lamina_entrada.getSeleccion().equals("Campo de Texto")){

                JOptionPane.showInputDialog(Marco_Dialogos.this, getMensaje(), "Título", getTipo(lamina_tipo_mensajes));

            }else{
                
                JOptionPane.showInputDialog(Marco_Dialogos.this, getMensaje(), "Título", getTipo(lamina_tipo_mensajes), null, new String[]{"Amarillo", "Cyan", "Magenta"}, "Amarillo");
            }
                
            } else if (lamina_tipo.getSeleccion().equals("Opción")) {

                JOptionPane.showOptionDialog(Marco_Dialogos.this, getMensaje(), "Título", 0, getTipo(lamina_tipo_mensajes), null, getopciones(lamina_opcion), null);
            }
        }
    }

    private Lamina_Botones lamina_tipo, lamina_tipo_mensajes, lamina_mensaje, lamina_confirmar, lamina_opcion, lamina_entrada;

    private String cadenaMensaje = "Mensaje";

    private Icon iconoMensaje = new ImageIcon("src/ico.png");

    private Object objetoMensaje = new Date();

    private Component componenteMensaje = new Lamina_Ejemplo();
}

class Lamina_Ejemplo extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());

        g2.setPaint(Color.CYAN);

        g2.fill(rectangulo);
    }
}
