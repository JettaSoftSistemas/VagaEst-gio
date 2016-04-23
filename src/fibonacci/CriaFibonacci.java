package fibonacci;

import javax.swing.*;

public class CriaFibonacci {

	private int valorFinal;

	public int getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(int valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	public CriaFibonacci() {
		System.out.println("In�cio da cria��o do Objeto Fibonacci - Constructor");	
	}
	
	public void finalize() {
		System.out.println("T�rmino do uso Objeto Fibonacci - Destructor");
	}		

	/**
	 * @deprecated: A Sequ�ncia de Fibonacci tem como primeiros termos os n�meros 0 e 1 e, a seguir, cada termo subsequente � obtido pela soma dos dois termos predecessores.
	 * 
	 * @return Sequencia criada
	 */	
	public String criaFibonacci() {
		if (valorFinal <= 0)  {
			JOptionPane.showMessageDialog(null, "Aten��o inicialize a vari�vel de execu��o corretamente !");
			return "";
		}		
		
		String retorno = "";
		
		long valorAtual = 0;
		long valorAtualTemp = 0;
		long valorAnterior = 0;
		long count = 0;
		try {

			/** 
			 * " Bem na internet tem v�rios exemplos desde algoritmo para copiar/colar, mas optei por desenvolver o meu pr�prio. "
			 * 
			 * 
			 * AQUI TEM V�RIOS EXEMPLOS
			 * http://www.devmedia.com.br/sequencia-de-fibonacci-em-java/23620 
			 */				
			for (long index = 0; index < valorFinal; index++) {
				
				// Para facilitar inicializa a primeira sequ�ncia de Valor Atual e Anterior
				if (index < 2) {
					if (index %2 == 0)
						valorAnterior = index; 
					else
						valorAtual = index;

					if (index == 0)
						retorno = retorno + (valorAnterior + valorAtual);
					else
						retorno = retorno + ", " + (valorAnterior + valorAtual);					
				}
				else
				{
					// Agora com a sequencia inicial pronta apenas soma o Valor Atual e Anterior
					retorno = retorno + ", " + (valorAnterior + valorAtual);
					
					valorAtualTemp = valorAtual; 
					valorAtual = (valorAnterior + valorAtual);					
					valorAnterior = valorAtualTemp;					
				}
				
				// Quebra de linha
				if (count == 20) {
					retorno = retorno + "\n";
					count = 0;
				}
				else
					++count;
			}
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exce��o ao validar o m�todo criaFibonacci: " + ex.getMessage());
			System.out.println("Exce��o ao validar o m�todo criaFibonacci: " + ex.getMessage());
			ex.printStackTrace();
			return "";
		}
		
		return retorno;		
	}		
	
}
