package calculocontainer;

import javax.swing.JOptionPane;

import calculocontainer.ArmazenaCaixaContainer;

public class ExecutaArmazenamento {	

	public static void main(String[] args) {
		
		ArmazenaCaixaContainer objArmazena = new ArmazenaCaixaContainer(); 
		try {
			
			if ((! objArmazena.defineCaixaContainer()) || (! objArmazena.defineTotalMaximoCaixaContainer())) 
				JOptionPane.showMessageDialog(null, "Atenção não foi possível Armazenar as Caixas!" );			
			else {
				objArmazena.imrimeDadosArmazenamentoMaximoCaixaContainer();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exceção ao iniciar Armazenamento de Caixas: " + ex.getMessage() );
			System.out.println("Exceção ao iniciar Armazenamento de Caixas: " + ex.getMessage());
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
