import javax.swing.*;
public class AccesoAplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String clave="Nahuel";
		
		String pass="";
		
		while (clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce la contrase�a, por favor");
			
			if (clave.equals(pass)==false) {
				
				System.out.println("Contrase�a incorrecta");
			}
			
		
		}

		System.out.println("Contrase�a correcta");
	}

}
