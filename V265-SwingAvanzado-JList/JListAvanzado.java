/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlistavanzado;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Nahuel E Correa
 */
public class JListAvanzado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JFrame miMarco = new MarcodeLista();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        miMarco.setVisible(true);
    }
    
}

class MarcodeLista extends JFrame{
    
    public MarcodeLista(){
        
        setTitle("Prueba de Lista");
        
        setBounds(400, 300, 400, 300);
        
        String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
            "Agosto","Septiembre","Octubre","Noviembre","Deiciembre"   
        };
        
        listadeMeses=new JList<String>(meses);
        
        listadeMeses.setVisibleRowCount(4);
        
        JScrollPane laminadeDesplazamiento=new JScrollPane(listadeMeses);
        
        laminadeLista = new JPanel();
        
        laminadeLista.add(laminadeDesplazamiento);
        
        listadeMeses.addListSelectionListener(new ListSelectionListener(){
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.
                
                List<String> valores = listadeMeses.getSelectedValuesList();
                
                StringBuilder texto = new StringBuilder("Mes seleccionado: ");
                
                for(String elemnto: valores){
                    
                    String palabra = elemnto;
                    
                    texto.append(palabra);
                    
                    texto.append(" ");
                    
                }
                
                rotulo.setText(texto.toString());
            }
            
            
        });
        
        laminadeTexto=new JPanel();
        
        rotulo=new JLabel("Mes seleccionado: ");
        
        laminadeTexto.add(rotulo);
        
        add(laminadeLista, BorderLayout.NORTH);
        
        add(laminadeTexto, BorderLayout.SOUTH);
    }
    
    private JList<String> listadeMeses;
    
    private JPanel laminadeLista, laminadeTexto;
    
    private JLabel rotulo;
}
