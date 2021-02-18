/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletree;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 *
 * @author Nahuel E Correa
 * 
 */
public class SimpleTree {
    
    public static void main(String[] args){
        
        JFrame miMarco = new MarcoTree();
        
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        miMarco.setVisible(true);
        
        
    } 
    
}

class MarcoTree extends JFrame{
    
    public MarcoTree(){
        
        setTitle("Arbol simple");
        
        setBounds(350,300,600,200);
        
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
        
        DefaultMutableTreeNode pais = new DefaultMutableTreeNode("Argentina");
        
        raiz.add(pais);
        
        DefaultMutableTreeNode provincia = new DefaultMutableTreeNode("Buenos Aires");
        
        pais.add(provincia);
        
        DefaultMutableTreeNode caba = new DefaultMutableTreeNode("Ciudad autónoma de Buenos Aires");
        
        provincia.add(caba);
        
            DefaultMutableTreeNode laplata = new DefaultMutableTreeNode("Ciudad de La Plata");
        
        provincia.add(laplata);
        
        provincia = new DefaultMutableTreeNode("Mendoza");
        
        pais.add(provincia);
        
        DefaultMutableTreeNode potrerillos = new DefaultMutableTreeNode("Potrerillos");
        
        provincia.add(potrerillos);
        
        pais = new DefaultMutableTreeNode("Alemania");
        
        raiz.add(pais);
        
        provincia = new DefaultMutableTreeNode("Baviera");
        
        pais.add(provincia);
        
        DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");
        
        provincia.add(munich);
        
        JTree arbol = new JTree(raiz);
        
        //LaminaTree milamina = new LaminaTree(arbol);
        
        //add(milamina);
        
        Container laminaContenido = getContentPane();
        
        laminaContenido.add(new JScrollPane(arbol));
        
    }
}

class LaminaTree extends JPanel{

    public LaminaTree(JTree miarbol){

    setLayout(new BorderLayout());
    
    add(miarbol, BorderLayout.NORTH);

}


}