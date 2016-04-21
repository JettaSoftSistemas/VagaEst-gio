package fibonacci;

import javax.swing.JOptionPane;
import fibonacci.CriaFibonacci;
import rotinasIo.CriaSalvaArquivo;

public class ExecutaFibonacci {

	public static void main(String[] args) {		
		
		CriaFibonacci objFibonacci = new CriaFibonacci();
		CriaSalvaArquivo objArquivo = new CriaSalvaArquivo();
		try {
			
			Integer valorFinal = new Integer(JOptionPane.showInputDialog("Digite o valor final da Sequência Fibonacci!"));						
			
			objFibonacci.setValorFinal(valorFinal);			
			
			objArquivo.setNomeArquivo("Fibonacci.txt");			
			
			objArquivo.setValorArquivo(objFibonacci.criaFibonacci());
			
			if (objArquivo.getValorArquivo() != "")
				objArquivo.salvaArquivo();
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exceção ao inserir o Valor Final: " + ex.getMessage());
			System.out.println("Exceção ao inserir o Valor Final: " + ex.getMessage());			
			ex.printStackTrace();
		}
		finally {
			if (objFibonacci != null)
				objFibonacci = null;
			
			if (objArquivo != null)
				objArquivo = null;			
		}		
		
		System.gc();
		System.exit(0);

	}

}
