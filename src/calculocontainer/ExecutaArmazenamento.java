package calculocontainer;

import javax.swing.JOptionPane;

import calculocontainer.ArmazenaCaixaContainer;

public class ExecutaArmazenamento {	

	public static void main(String[] args) {
		
		ArmazenaCaixaContainer objArmazena = new ArmazenaCaixaContainer(); 
		try {
			
			if ((! objArmazena.defineCaixaContainer()) || (! objArmazena.defineTotalMaximoCaixaContainer())) 
				JOptionPane.showMessageDialog(null, "Aten��o n�o foi poss�vel Armazenar as Caixas!" );			
			else {
				objArmazena.imrimeDadosArmazenamentoMaximoCaixaContainer();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exce��o ao iniciar Armazenamento de Caixas: " + ex.getMessage() );
			System.out.println("Exce��o ao iniciar Armazenamento de Caixas: " + ex.getMessage());
			ex.printStackTrace();			
		}
		finally {
			if (objArmazena != null)
				objArmazena = null;
		}	
		
		System.gc();
		System.exit(0);
		
	}

}
