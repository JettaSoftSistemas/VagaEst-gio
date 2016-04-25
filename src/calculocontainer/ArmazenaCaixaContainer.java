package calculocontainer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import calculocontainer.Caixa;
import calculocontainer.Container;

/*	
 * Esta classe define regras de negócio para Armazenar Caixas em Containers
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package calculocontainer
 *  
*/

public class ArmazenaCaixaContainer {
	
	/*
	 *  Propriedades do container apenas para fins de Cálculo
	 */
	private float larguraContainer = 2.48f;
	private float comprimentoContainer = 10.0f;
	private float alturaContainer = 3.28f;
	
	/*
	 * Rotina a parte que valida quantidade total de Caixas no Container, 
	 *   levando-se em consideração Comprimento, Largura e Altura
	 */
	private List<Caixa> objListaTotalCaixaContainer = new ArrayList<Caixa>();	
	/*
	 * Rotina a parte que valida uma lista o Container para cada modelo de Caixa, 
	 *   levando-se em consideração Comprimento, Largura e Altura
	 */
	private List<Container> objListaContainerTotalCaixas = new ArrayList<Container>();
	/*
	 * Rotina a parte que valida quantidade total de Caixas no Container
	 */
	private List<Caixa> objListaCaixaContainer = new ArrayList<Caixa>();	

	
	/*
	 * Valida diferentes combinações de armazenamento para Otimizar o espaço de armazenamento 
	 * COMBINAÇÃO 1 : CONTAINER (LARGURA) equivale a (LARGURA) da CAIXA
	 * COMBINAÇÃO 2 : CONTAINER (LARGURA) equivale a (COMPRIMENTO) da CAIXA
	 */	
	public boolean defineCaixaContainer() {

		/*
		 * Adiciona as caixas e seus atributos a Lista de Armazenamento, cada caixa terá seus atributos de armazenamento
		 */
		objListaCaixaContainer.add(new Caixa("Caixa1", 210, 0.253f, 0.608f, 0.518f));		
		objListaCaixaContainer.add(new Caixa("Caixa2", 200, 0.263f, 0.480f, 0.323f));				
		objListaCaixaContainer.add(new Caixa("Caixa3", 200, 0.203f, 0.403f, 0.413f));		
		objListaCaixaContainer.add(new Caixa("Caixa4", 200, 0.170f, 0.530f, 0.380f));
		objListaCaixaContainer.add(new Caixa("Caixa5", 140, 0.285f, 0.435f, 0.255f));
		
		/*
		 * Variáveis temporárias
		 */
		float valorTotalLarguraCaixa;
		float valorTotalComprimentoCaixa;
		float valorMargemErroLargura;
		float valorMargemErroComprimento;		
		
		try {
			
			/*
			 * Percorre a Lista de Caixas para realizar os cálculos de armazenamento levando-se em consideração a ALTURA / LARGURA E COMPRIMENTO do container
			 */
			for (Caixa caixa : objListaCaixaContainer) {
				
				caixa.defineQtdCaixas( (int) Math.floor( larguraContainer / caixa.getLargura() ), 
									   (int) Math.floor( larguraContainer / caixa.getComprimento() ));				
				/*
				 * Verifica se é melhor armazenar pela largura ou comprimento das Caixas 
				 */
				valorTotalLarguraCaixa = (caixa.getQuantidadeMaximaLargura() * caixa.getLargura());
				valorTotalComprimentoCaixa = (caixa.getQuantidadeMaximaComprimento() * caixa.getComprimento());
				
				/*
				 * Identifica as sobras de espaço
				 */
				valorMargemErroLargura = (larguraContainer - valorTotalLarguraCaixa);
				valorMargemErroComprimento = (larguraContainer - valorTotalComprimentoCaixa);
				
				/*
				 * Define qual modelo de armazenamento adotar
				 */
				if ((valorTotalLarguraCaixa <= larguraContainer) && 
					((valorMargemErroLargura < valorMargemErroComprimento) || (valorMargemErroComprimento < 0)) &&  
					(valorMargemErroLargura > 0)) {
					System.out.println("Melhor posicionar a Caixa: " + caixa.getDescricao() + " com a sua Largura posicionada a Largura do Container! ");
				}

				if ((valorTotalComprimentoCaixa <= larguraContainer) && 
					((valorMargemErroComprimento < valorMargemErroLargura) || (valorMargemErroLargura < 0)) && 
					(valorMargemErroComprimento > 0)) {
					System.out.println("Melhor posicionar a Caixa: " + caixa.getDescricao() + " com o seu Comprimento posicionado a Largura do Container! ");
				}				

			}
			
		
			System.out.println("\n");			
		}
		catch (Exception ex) {
			System.out.println("Exceção: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		
		return true;		
	}
	
	/*
	 * 	EXTRA REQUISITOS DO TESTE - Modelo Diferente de Armazenamento
	 *  
	 * > Valida diferentes combinações tridimensionais de armazenamento por Caixa. Alternando posição da caixa de acordo com as suas métricas LARGURA, ALTURA E COMPRIMENTO
	 *  
	 * > Por efeitos de comparação para armazenar inclui o atributo altura das caixas e container usando caixas empilhadas.
	 * 
	 * > Alterno o posionamento tridimensional das caixas para identificar qual posição permite acomodar a maior quantidade de uma determinada Caixa no Container.
	 * 
	 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, ALTURA, COMPRIMENTO) da CAIXA
	 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, COMPRIMENTO, ALTURA) da CAIXA
	 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, ALTURA, LARGURA) da CAIXA
	 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, LARGURA, ALTURA) da CAIXA
	 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, COMPRIMENTO, LARGURA) da CAIXA
	 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, LARGURA, COMPRIMENTO) da CAIXA		  
	 * 		  
	 */
	public boolean defineTotalMaximoCaixaContainer() {
		
		/*
		 * Adiciona as caixas e seus atributos a Lista de Armazenamento, cada caixa terá seus atributos de armazenamento
		 */
		objListaTotalCaixaContainer.add(new Caixa("Caixa1", 210, 0.253f, 0.608f, 0.518f));		
		objListaTotalCaixaContainer.add(new Caixa("Caixa2", 200, 0.263f, 0.480f, 0.323f));				
		objListaTotalCaixaContainer.add(new Caixa("Caixa3", 200, 0.203f, 0.403f, 0.413f));		
		objListaTotalCaixaContainer.add(new Caixa("Caixa4", 200, 0.170f, 0.530f, 0.380f));
		objListaTotalCaixaContainer.add(new Caixa("Caixa5", 140, 0.285f, 0.435f, 0.255f));

		try {

			/*
			 * Valida o total de caixas da combinação atual
			 */
			int totalCaixasCombinacao = 0;			
			
			/*
			 * Percorre a Lista de Caixas para realizar os cálculos de armazenamento levando-se em consideração a ALTURA / LARGURA E COMPRIMENTO do container
			 */
			for (Caixa caixa : objListaTotalCaixaContainer) {
				
				totalCaixasCombinacao = 0;
				
				/*
				 *  COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, ALTURA, COMPRIMENTO)				
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getLargura()), 
																		(int) Math.floor( alturaContainer / caixa.getAltura()),
																		(int) Math.floor( comprimentoContainer / caixa.getComprimento()));				
				caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_1);				

				/*
				 *  COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, COMPRIMENTO, ALTURA) 								
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getLargura()), 
																		(int) Math.floor( alturaContainer / caixa.getComprimento()),
																		(int) Math.floor( comprimentoContainer / caixa.getAltura()));		
				if (totalCaixasCombinacao > caixa.getQuantidadeMaxArmazenada()) 
					caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_2);
				
				/*
				 *  COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, ALTURA, LARGURA)								
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getComprimento()), 
																		(int) Math.floor( alturaContainer / caixa.getAltura()),
																		(int) Math.floor( comprimentoContainer / caixa.getLargura()));		
				if (totalCaixasCombinacao > caixa.getQuantidadeMaxArmazenada())
					caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_3);				

				/*
				 *  COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, LARGURA, ALTURA)								
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getComprimento()), 
																		(int) Math.floor( alturaContainer / caixa.getLargura()),
																		(int) Math.floor( comprimentoContainer / caixa.getAltura()));		
				if (totalCaixasCombinacao > caixa.getQuantidadeMaxArmazenada()) 
					caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_4);				

				/*
				 *  COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, COMPRIMENTO, LARGURA)
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getAltura()), 
																		(int) Math.floor( alturaContainer / caixa.getComprimento()),
																		(int) Math.floor( comprimentoContainer / caixa.getLargura()));
				if (totalCaixasCombinacao > caixa.getQuantidadeMaxArmazenada()) 
					caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_5);
				
				/*
				 *  COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, LARGURA, COMPRIMENTO) 								
				 */
				totalCaixasCombinacao = caixa.retornaCaixasContainer((int) Math.floor( larguraContainer / caixa.getAltura()), 
																		(int) Math.floor( alturaContainer / caixa.getLargura()),
																		(int) Math.floor( comprimentoContainer / caixa.getComprimento()));		
				if (totalCaixasCombinacao > caixa.getQuantidadeMaxArmazenada()) 
					caixa.setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.COMBINACAO_6);				
				
				/*
				 * Adiciona ao Container os dados das caixas armazenadas
				 */
				objListaContainerTotalCaixas.add( new Container("Container = " + caixa.getDescricao(), 
																larguraContainer, 
																comprimentoContainer, 
																alturaContainer, 
																Container.Status_Container.PREENCHIDO, 
																caixa) );
				System.out.println("A " + caixa.getDescricao() + " pode armazenar até um total de " + caixa.getQuantidadeMaxArmazenada() + " caixas no Container. Melhor modelo de armazenamento: " + caixa.getCombinacaoMaxima());
			}		
			
		}
		catch (Exception ex) {
			System.out.println("Exceção: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void imrimeDadosArmazenamentoMaximoCaixaContainer() {
		
		/*
		 * Percorre os Cotainers e especifica a posições das caixas
		 */
		for (Container container : objListaContainerTotalCaixas) {
			/*
			 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, ALTURA, COMPRIMENTO) da CAIXA
			 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, COMPRIMENTO, ALTURA) da CAIXA
			 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, ALTURA, LARGURA) da CAIXA
			 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, LARGURA, ALTURA) da CAIXA
			 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, COMPRIMENTO, LARGURA) da CAIXA
			 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, LARGURA, COMPRIMENTO) da CAIXA
			 */				
			
			System.out.println("\n");
			switch (container.getCaixasArmazenadas().getCombinacaoMaxima()) {
			case NAO_DEFINIDO : { 
									JOptionPane.showMessageDialog(null, "Posicionamento não definido !"); 
									break;
								}  
			case COMBINACAO_1 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" + 
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (LARGURA, ALTURA, COMPRIMENTO) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );									
									break; 
								} 
			case COMBINACAO_2 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" +
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (LARGURA, COMPRIMENTO, ALTURA) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );				
									break; 
								}
			case COMBINACAO_3 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" +
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (COMPRIMENTO, ALTURA, LARGURA) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );
									break; 
								}				
			case COMBINACAO_4 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" +
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (COMPRIMENTO, LARGURA, ALTURA) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );	
									break; 
								}
			case COMBINACAO_5 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" +
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (ALTURA, COMPRIMENTO, LARGURA) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );				 
									break; 
								}				
			case COMBINACAO_6 : { 
									System.out.println(	"Detalhes Armazenamento: " + "\n" +
											"Descrição: " + container.getCaixasArmazenadas().getDescricao() + "\n" +
											"Tot. Cx.: " + container.getCaixasArmazenadas().getQuantidadeTotalArmazenar() + "\n" +											
											"Tot. Máx. Cx. no Container: " + container.getCaixasArmazenadas().getQuantidadeMaxArmazenada() + "\n" +											
											"Tot. Cx. Altura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaAltura() + "\n" +
											"Tot. Cx. Largura Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaLargura() + "\n" +											
											"Tot. Cx. Comprimento Container: " + container.getCaixasArmazenadas().getQuantidadeMaximaComprimento() + "\n" +											
											"Combição de Armazenamento: " + container.getCaixasArmazenadas().getCombinacaoMaxima());
									System.out.println(	container.getDescricaoContainer() + " (ALTURA, LARGURA, COMPRIMENTO) da Caixa relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container " + "\n" );				 
									break; 
								}			
			}		
			
		}
		
	}

	public void finalize() {
		
		if (objListaTotalCaixaContainer != null) {
			objListaTotalCaixaContainer.clear();
			objListaTotalCaixaContainer = null;
		}

		if (objListaContainerTotalCaixas != null) {
			objListaContainerTotalCaixas.clear();
			objListaContainerTotalCaixas = null;
		}
		
	}
	
}
