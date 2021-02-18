/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciospracticos;
import javax.swing.*;

/**
 *
 * @author Nahuel E Correa
 */
public class Lamina_Botones extends JPanel{
    
    public Lamina_Botones(String titulo, String [] opciones){
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
    
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        grupo = new ButtonGroup();
        
        for (int i = 0; i < opciones.length; i++){
        
            JRadioButton bot = new JRadioButton(opciones[i]);
            
            bot.setActionCommand(opciones[i]);
            
            add(bot);
            
            grupo.add(bot);
            
            bot.setSelected(i == 0);
             
        }
    }
    
    public String getSeleccion(){
        
        ButtonModel miboton = grupo.getSelection();
        
        String s = miboton.getActionCommand();
        
        return s;
    }
    
    private ButtonGroup grupo;
}
