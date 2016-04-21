package calculoContainer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import calculoContainer.Caixa;
import calculoContainer.Container;

public class ArmazenaCaixaContainer {	
	
	private List<Caixa> objListaCaixa = new ArrayList<Caixa>();	
	private List<Container> objListaContainer = new ArrayList<Container>();
	
	public List<Caixa> getObjListaCaixa() {
		return objListaCaixa;
	}
	public void setObjListaCaixa(List<Caixa> objListaCaixa) {
		this.objListaCaixa = objListaCaixa;
	}	
	public List<Container> getObjListaContainer() {
		return objListaContainer;
	}
	public void setObjListaContainer(List<Container> objListaContainer) {
		this.objListaContainer = objListaContainer;
	}	
	
	public boolean executaArmazenagem() {
		
		//Adiciona as caixas e seus atributos a Lista de Armazenamento, cada caixa terá seus atributos de armazenamento
		objListaCaixa.add(new Caixa("Caixa1", 210, 0.253f, 0.608f, 0.518f));		
		objListaCaixa.add(new Caixa("Caixa2", 200, 0.263f, 0.480f, 0.323f));				
		objListaCaixa.add(new Caixa("Caixa3", 200, 0.203f, 0.403f, 0.413f));		
		objListaCaixa.add(new Caixa("Caixa4", 200, 0.170f, 0.530f, 0.380f));
		objListaCaixa.add(new Caixa("Caixa5", 140, 0.285f, 0.435f, 0.255f));

		/*
		 * Valida diferentes combinações tridimensionais de armazenamento. Por efeitos de comparação inclui o atributo altura das caixas no container, como se as caixas possam ser empilhadas.
		 * Alterno o posionamento tridimensional das caixas para identificar qual posição permite acomodar mais quantidades no Container. 
		 * 		  
		 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, ALTURA, COMPRIMENTO)
		 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, COMPRIMENTO, ALTURA)
		 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, ALTURA, LARGURA)
		 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, LARGURA, ALTURA)
		 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, COMPRIMENTO, LARGURA)
		 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, LARGURA, COMPRIMENTO)		  
		 * 		  
		 */
		try {

			//Propriedades temporárias do container apenas para fisns de Cálculo
			float larguraContainer = 2.48f;
			float comprimentoContainer = 10.0f;
			float alturaContainer = 3.28f;			
			
			//Percorre a Lista de Caixas para realizar os cálculos de armazenamento levando-se em consideração a ALTURA / LARGURA E COMPRIMENTO do container
			for (Caixa caixa : objListaCaixa) {
				
				//Valida o total de caixas da combinação atual
				int totalCaixasCombinacao = 0;
				
				// COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, ALTURA, COMPRIMENTO)				
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getLargura() ), 
																  Math.round( alturaContainer / caixa.getAltura() ),
																  Math.round( comprimentoContainer / caixa.getComprimento() ));				
				caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
				caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_1);				

				// COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, COMPRIMENTO, ALTURA) 								
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getLargura() ), 
						  										  Math.round( alturaContainer / caixa.getComprimento() ),
						  										  Math.round( comprimentoContainer / caixa.getAltura() ));		
				if (totalCaixasCombinacao > caixa.getQuantidadeArmazenada()) { 
					caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
					caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_2);
				}

				// COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, ALTURA, LARGURA)								
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getComprimento() ), 
																  Math.round( alturaContainer / caixa.getAltura() ),
														          Math.round( comprimentoContainer / caixa.getLargura() ));		
				if (totalCaixasCombinacao > caixa.getQuantidadeArmazenada()) { 
					caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
					caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_3);
				}

				// COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, LARGURA, ALTURA)								
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getComprimento() ), 
																  Math.round( alturaContainer / caixa.getLargura()  ),
															      Math.round( comprimentoContainer / caixa.getAltura() ));		
				if (totalCaixasCombinacao > caixa.getQuantidadeArmazenada()) { 
					caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
					caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_4);
				}

				// COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, COMPRIMENTO, LARGURA)
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getAltura() ), 
					      										  Math.round( alturaContainer / caixa.getComprimento() ),
					      										  Math.round( comprimentoContainer / caixa.getLargura() ));
				if (totalCaixasCombinacao > caixa.getQuantidadeArmazenada()) { 
					caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
					caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_5);
				}				
				
				// COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, LARGURA, COMPRIMENTO) 								
				totalCaixasCombinacao = caixa.retornaTotalCaixas( Math.round( larguraContainer / caixa.getAltura() ), 
						  										  Math.round( alturaContainer / caixa.getLargura() ),
						                                          Math.round( comprimentoContainer / caixa.getComprimento() ));		
				if (totalCaixasCombinacao > caixa.getQuantidadeArmazenada()) { 
					caixa.setQuantidadeArmazenada(totalCaixasCombinacao);
					caixa.setCombinacao(Caixa.Combinacao_Armazenamento.COMBINACAO_6);
				}
				
				//Adiciona ao Container os dados das caixas armazenadas
				objListaContainer.add( new Container("Container = " + caixa.getDescricao(), 2.48f, 10.0f, 3.28f, Container.Status_Container.PREENCHIDO, caixa) );
			}		
			
		}
		catch (Exception ex) {
			System.out.println("Exceção: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void defineCoordenadas() {
		
		//Percorre os Cotainers e especifica a posiçãos das caixas
		for (Container container : objListaContainer) {
			/*
			 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, ALTURA, COMPRIMENTO)
			 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, COMPRIMENTO, ALTURA)
			 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, ALTURA, LARGURA)
			 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, LARGURA, ALTURA)
			 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, COMPRIMENTO, LARGURA)
			 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, LARGURA, COMPRIMENTO)
			 */				
			
			switch (container.getCaixasArmazenadas().getCombinacao()) {
				case NAO_DEFINIDO : { JOptionPane.showMessageDialog(null, "Posicionamento não definido !"); break;}  
				case COMBINACAO_1 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (LARGURA, ALTURA, COMPRIMENTO) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; } 
				case COMBINACAO_2 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (LARGURA, COMPRIMENTO, ALTURA) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; }
				case COMBINACAO_3 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (COMPRIMENTO, ALTURA, LARGURA) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; }				
				case COMBINACAO_4 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (COMPRIMENTO, LARGURA, ALTURA) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; }
				case COMBINACAO_5 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (ALTURA, COMPRIMENTO, LARGURA) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; }				
				case COMBINACAO_6 : { JOptionPane.showMessageDialog(null, container.getDescricaoContainer() + " (ALTURA, LARGURA, COMPRIMENTO) da Caixa posicionada relativa à (LARGURA, ALTURA, COMPRIMENTO) do Container "); break; }			
			}		
			
		}
		
	}

	public void finalize() {
		
		if (objListaCaixa != null) {
			objListaCaixa.clear();
			objListaCaixa = null;
		}

		if (objListaContainer != null) {
			objListaContainer.clear();
			objListaContainer = null;
		}
		
	}
	
}
