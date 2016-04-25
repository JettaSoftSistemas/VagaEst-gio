package fibonacci;

import javax.swing.*;

/*	
 * Esta classe executa o cálculo Fibonacci
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package fibonacci
 *  
*/

public class CriaFibonacci {

	private int valorFinal;

	/*
	 * @return valorFinal
	 * 					Retorna o Limite de Cálculo do Fibonacci 
	 */	
	public int getValorFinal() {
		return valorFinal;
	}
	
	/*
	 * @param valorFinal
	 * 					Carrega o Limite de Cálculo do Fibonacci 
	 */		
	public void setValorFinal(int valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	/*
	 * Construtor
	 */	
	public CriaFibonacci() {
		
		System.out.println("Início da criação do Objeto Fibonacci - Constructor");
		
	}

	/*
	 * Destructor
	 */	
	public void finalize() {
		
		System.out.println("Término do uso Objeto Fibonacci - Destructor");
		
	}		

	/**
	 * A Sequência de Fibonacci tem como primeiros termos os números 0 e 1 e, a seguir, 
	 *   cada termo subsequente é obtido pela soma dos dois termos predecessores.
	 * 
	 * @return Sequencia criada
	 * @see http://www.devmedia.com.br/sequencia-de-fibonacci-em-java/23620
	 * 
	 */	
	public String criaFibonacci() {
		if (valorFinal <= 0)  {
			JOptionPane.showMessageDialog(null, "Atenção inicialize a variável de execução corretamente !");
			return "";
		}		
		
		String retorno = "";
		
		long valorAtual = 0;
		long valorAtualTemp = 0;
		long valorAnterior = 0;
		long count = 0;
		try {

			/** 
			 * Bem na internet tem vários exemplos deste algoritmo para copiar/colar, mas optei por desenvolver o meu próprio. 
			 */				
			for (long index = 0; index < valorFinal; index++) {
				
				// Para facilitar inicializa a primeira sequência de Valor Atual e Anterior
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
			JOptionPane.showMessageDialog(null, "Exceção ao validar o método criaFibonacci: " + ex.getMessage());
			System.out.println("Exceção ao validar o método criaFibonacci: " + ex.getMessage());
			ex.printStackTrace();
			return "";
		}
		
		return retorno;		
	}		
	
}
