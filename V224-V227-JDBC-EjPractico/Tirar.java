/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionfinal;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nahuel E Correa
 * 
 */
public class Tirar {
    
    public static void main(String[] args){
        
        Marco mimarco = new Marco();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFileChooser chooser = new JFileChooser();
    
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        
                "Archivos de texto", "txt");
    
        chooser.setFileFilter(filter);
    
        int returnVal = chooser.showOpenDialog(mimarco);
    
        if(returnVal == JFileChooser.APPROVE_OPTION) {
       
            System.out.println("You chose to open this file: " +
            
                    chooser.getSelectedFile().getAbsolutePath());
    }
        
    }
}

class Marco extends JFrame{
    
    public Marco(){
        
        setBounds(300, 300, 300, 300);
        
        setVisible(true);
    }
}
