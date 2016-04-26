package Exercicio04;

public class Caixas {
	private int qnt;
	private float largura;
	private float comprimento;
	private float altura;

	
	

	public Caixas(int qnt, float largura, float comprimento, float altura) {
		this.qnt = qnt;
		this.largura = largura;
		this.comprimento = comprimento;
		this.altura = altura;
		
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	



}
