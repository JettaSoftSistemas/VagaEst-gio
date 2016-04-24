package Exercicio04;

import java.text.DecimalFormat;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class Truck {
	private int qnt;
	private float largura;
	private float comprimento;
	private float altura;
	private Caixas caixas;
	private int[] conjuntoLargura;
	private int[] conjuntoComprimento;

	public Truck() {
		this.largura = 2.48f;
		this.comprimento = 10;
		this.altura = 3.28f;
		this.qnt = 1;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		qnt = qnt;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		comprimento = comprimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		altura = altura;
	}

	public Caixas getCaixas() {
		return caixas;
	}

	public void setCaixas(Caixas caixas) {
		this.caixas = caixas;
	}

	public int[] getConjuntoLargura() {
		return conjuntoLargura;
	}

	public void setConjuntoLargura(int[] conjuntoLargura) {
		this.conjuntoLargura = conjuntoLargura;
	}

	public int[] getConjuntoComprimento() {
		return conjuntoComprimento;
	}

	public void setConjuntoComprimento(int[] conjuntoComprimento) {
		this.conjuntoComprimento = conjuntoComprimento;
	}

	public int caixaQuantidadeMaxLargura(float f) {
		Float value = largura / f;
		Integer i = Integer.valueOf(value.intValue());
		return i;
	}

	public int caixaQuantidadeMaxComprimento(float f) {
		Float v = new Float(largura / f);
		Integer i = new Integer(v.intValue());
		return i;
	}

	public void imprimirDados(int i) {
		System.out.println("Quantidade de Caixas: " + i);
	}

	public int[] conjuntoLargura(Caixas caixa) {
		this.conjuntoLargura = new int[caixaQuantidadeMaxLargura(caixa.getLargura())];
		System.out.print("Conjunto Largura: ");
		for (int i = 0; i < conjuntoLargura.length; i++) {
			conjuntoLargura[i] = i + 1;
			System.out.print(conjuntoLargura[i] + " ");
		}
		System.out.println("");
		return conjuntoComprimento;
	}

	public int[] conjuntoComprimento(Caixas caixa) {
		this.conjuntoComprimento = new int[caixaQuantidadeMaxComprimento(caixa.getComprimento())];
		System.out.print("Conjunto Comprimento: ");
		for (int i = 0; i < conjuntoComprimento.length; i++) {
			conjuntoComprimento[i] = i + 1;
			System.out.print(conjuntoComprimento[i] + " ");
		}
		return conjuntoComprimento;
	}

	public float grupoLargura(Caixas caixa) {
		float l = largura;
		float[] a = new float[caixaQuantidadeMaxLargura(caixa.getLargura())];
		DecimalFormat df = new DecimalFormat("0.000");

		for (int i = 0; i < a.length; i++) {
			l = l - caixa.getLargura();
		}
		System.out.println("Sobre da Largura do Conteiner: " + df.format(l));

		return l;
	}

	public float grupoComprimento(Caixas caixa) {
		float l = largura;
		float[] a = new float[caixaQuantidadeMaxComprimento(caixa.getComprimento())];
		DecimalFormat df = new DecimalFormat("0.000");
		for (int i = 0; i < a.length; i++) {
			l = l - caixa.getComprimento();
		}
		System.out.println("Sobra da Largura do Conteiner: " + df.format(l));
		return l;
	}

	public void melhorCombinacao(Caixas caixa) {
		float b = grupoComprimento(caixa);
		float a = grupoLargura(caixa);
		DecimalFormat df = new DecimalFormat("0.000");
		if (a < b) {
			System.out.println("Melhor Combinacao: " + df.format(a));
		} else {
			System.out.println("Melhor Combinacao: " + df.format(b));
		}
		System.out.println(" ");
	}

}
