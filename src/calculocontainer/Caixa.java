package calculocontainer;

/*	
 * Esta classe define regras de negócio para Caixas
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package calculocontainer
 *  
*/

public class Caixa {

	/*
	 * Atributos da Caixa
	 */
	private String descricao;
	private float largura;
	private float comprimento;
	private float altura;
	/*
	 * Controle de Quantidades
	 * Quantidade Total de Caixas a Armazenar
	 */
	private int quantidadeTotalArmazenar;
	
	/*
	 * Quantidade Total do tipo de caixa que cabe no Container
	 */
	private int quantidadeMaxArmazenada;
	private int quantidadeMaximaAltura;
	private int quantidadeMaximaLargura;	
	private int quantidadeMaximaComprimento;	
	/*
	 *  EXTRA REQUISITOS DO TESTE
	 * Valida diferentes combinações de armazenamento para Otimizar o espaço de armazenamento 
	 * COMBINAÇÃO 1 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, ALTURA, COMPRIMENTO) da CAIXA
	 * COMBINAÇÃO 2 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (LARGURA, COMPRIMENTO, ALTURA) da CAIXA
	 * COMBINAÇÃO 3 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, ALTURA, LARGURA) da CAIXA
	 * COMBINAÇÃO 4 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (COMPRIMENTO, LARGURA, ALTURA) da CAIXA
	 * COMBINAÇÃO 5 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, COMPRIMENTO, LARGURA) da CAIXA
	 * COMBINAÇÃO 6 : CONTAINER (LARGURA, ALTURA, COMPRIMENTO) equivale a (ALTURA, LARGURA, COMPRIMENTO) da CAIXA		 	  
	 */
	public static enum Combinacao_Max_Armazenamento { NAO_DEFINIDO, COMBINACAO_1, COMBINACAO_2, COMBINACAO_3, COMBINACAO_4, COMBINACAO_5, COMBINACAO_6 }
	private Combinacao_Max_Armazenamento combinacaoMaxima;
	
	public int getQuantidadeMaximaAltura() {
		return this.quantidadeMaximaAltura;
	}
	public void setQuantidadeMaximaAltura(int quantidadeMaximaAltura) {
		this.quantidadeMaximaAltura = quantidadeMaximaAltura;
	}
	public int getQuantidadeMaximaLargura() {
		return this.quantidadeMaximaLargura;
	}
	public void setQuantidadeMaximaLargura(int quantidadeMaximaLargura) {
		this.quantidadeMaximaLargura = quantidadeMaximaLargura;
	}
	public int getQuantidadeMaximaComprimento() {
		return this.quantidadeMaximaComprimento;
	}
	public void setQuantidadeMaximaComprimento(int quantidadeMaximaComprimento) {
		this.quantidadeMaximaComprimento = quantidadeMaximaComprimento;
	}
	public Combinacao_Max_Armazenamento getCombinacaoMaxima() {
		return this.combinacaoMaxima;
	}
	public void setCombinacaoMaxima(Combinacao_Max_Armazenamento combinacaoMaxima) {
		this.combinacaoMaxima = combinacaoMaxima;
	}	
	public String getDescricao() {
		return this.descricao;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getLargura() {
		return this.largura;
	}
	private void setLargura(float largura) {
		this.largura = largura;
	}
	public float getComprimento() {
		return this.comprimento;
	}
	private void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public float getAltura() {
		return this.altura;
	}
	private void setAltura(float altura) {
		this.altura = altura;
	}	
	public int getQuantidadeTotalArmazenar() {
		return this.quantidadeTotalArmazenar;
	}
	private void setQuantidadeTotal(int quantidadeTotal) {
		this.quantidadeTotalArmazenar = quantidadeTotal;
	}	
	public int getQuantidadeMaxArmazenada() {
		return this.quantidadeMaxArmazenada;
	}
	public void setQuantidadeMaxArmazenada(int quantidadeArmazenada) {
		this.quantidadeMaxArmazenada = quantidadeArmazenada;
	}
	
	public Caixa(String descricao, int quantidadeTotaCaixas, float largura, float comprimento, float altura) {
		
		setDescricao(descricao);
		setLargura(largura);
		setComprimento(comprimento);
		setAltura(altura);
		setQuantidadeTotal(quantidadeTotaCaixas);
		setCombinacaoMaxima(Caixa.Combinacao_Max_Armazenamento.NAO_DEFINIDO);
		
	}
	
	public void finalize() {
		
		System.out.println("Desctructor Caixas");
		
	}

	/*
	 * Para fins de Log define a quantidade de caixas armazenadas na LARGURA / ALTURA / COMPRIMENTO no Container				
	 */
	public int retornaCaixasContainer(int totalCaixasLargura, int totalCaixasAltura, int totalCaixasComprimento) {

		setQuantidadeMaximaLargura(totalCaixasLargura);
		setQuantidadeMaximaAltura(totalCaixasAltura);
		setQuantidadeMaximaComprimento(totalCaixasComprimento);
		setQuantidadeMaxArmazenada(((totalCaixasComprimento * totalCaixasLargura) * totalCaixasAltura));
		
		return getQuantidadeMaxArmazenada();
		
	}
	
	/*
	 * Para fins de Log define a quantidade de caixas armazenadas na LARGURA / COMPRIMENTO no Container
	 */
	public void defineQtdCaixas(int totalCaixasLargura, int totalCaixasComprimento) {
		
		setQuantidadeMaximaLargura(totalCaixasLargura);
		setQuantidadeMaximaComprimento(totalCaixasComprimento);
		
	}	
	
}
