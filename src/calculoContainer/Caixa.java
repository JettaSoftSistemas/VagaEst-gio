package calculoContainer;

public class Caixa {

	//Atributos da Caixa
	private String descricao;
	private float largura;
	private float comprimento;
	private float altura;
	
	//Controle de Quantidades 
	private int quantidadeTotal;
	private int quantidadeArmazenada;
	private int quantidadeTotalAltura;
	private int quantidadeTotalLargura;	
	private int quantidadeTotalComprimento;	
	
	/*
	 * Valida diferentes combinações de armazenamento para Otimizar o espaço de armazenamento 
	 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, ALTURA, COMPRIMENTO)
	 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (LARGURA, COMPRIMENTO, ALTURA)
	 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, ALTURA, LARGURA)
	 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (COMPRIMENTO, LARGURA, ALTURA)
	 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, COMPRIMENTO, LARGURA)
	 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) - CAIXA (ALTURA, LARGURA, COMPRIMENTO)		 	  
	 */
	public enum Combinacao_Armazenamento { NAO_DEFINIDO, COMBINACAO_1, COMBINACAO_2, COMBINACAO_3, COMBINACAO_4, COMBINACAO_5, COMBINACAO_6 }
	private Combinacao_Armazenamento combinacao;
	
	public int getQuantidadeTotalAltura() {
		return quantidadeTotalAltura;
	}
	public void setQuantidadeTotalAltura(int quantidadeTotalAltura) {
		this.quantidadeTotalAltura = quantidadeTotalAltura;
	}
	public int getQuantidadeTotalLargura() {
		return quantidadeTotalLargura;
	}
	public void setQuantidadeTotalLargura(int quantidadeTotalLargura) {
		this.quantidadeTotalLargura = quantidadeTotalLargura;
	}
	public int getQuantidadeTotalComprimento() {
		return quantidadeTotalComprimento;
	}
	public void setQuantidadeTotalComprimento(int quantidadeTotalComprimento) {
		this.quantidadeTotalComprimento = quantidadeTotalComprimento;
	}
	public Combinacao_Armazenamento getCombinacao() {
		return combinacao;
	}
	public void setCombinacao(Combinacao_Armazenamento combinacao) {
		this.combinacao = combinacao;
	}	
	public String getDescricao() {
		return descricao;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getLargura() {
		return largura;
	}
	private void setLargura(float largura) {
		this.largura = largura;
	}
	public float getComprimento() {
		return comprimento;
	}
	private void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public float getAltura() {
		return altura;
	}
	private void setAltura(float altura) {
		this.altura = altura;
	}	
	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}
	private void setQuantidadeTotal(int quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}	
	public int getQuantidadeArmazenada() {
		return quantidadeArmazenada;
	}
	public void setQuantidadeArmazenada(int quantidadeArmazenada) {
		this.quantidadeArmazenada = quantidadeArmazenada;
	}
	
	public Caixa(String descricao, int quantidadeTotaCaixas, float largura, float comprimento, float altura) {
		
		setDescricao(descricao);
		setLargura(largura);
		setComprimento(comprimento);
		setAltura(altura);
		setQuantidadeTotal(quantidadeTotaCaixas);
		setCombinacao(Caixa.Combinacao_Armazenamento.NAO_DEFINIDO);
		
	}
	
	public void finalize() {
		
		System.out.println("Desctructor Caixas");
		
	}

	public int retornaTotalCaixas(int totalCaixasLargura, int totalCaixasAltura, int totalCaixasComprimento) {
		
		//Para fins de Coordenadas define a quantidade de caixas por ALTURA/LARGURA/COMPRIMENTO				
		setQuantidadeTotalLargura( totalCaixasLargura );
		setQuantidadeTotalAltura( totalCaixasAltura);
		setQuantidadeTotalComprimento( Math.round( totalCaixasComprimento ));
		
		return Math.round( (( totalCaixasLargura * totalCaixasAltura ) * totalCaixasComprimento) );
		
	}	
	
}
