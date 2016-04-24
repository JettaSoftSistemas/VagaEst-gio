package Exercicio04;

public class Main {

	public static void main(String[] args) {
		Truck conteiner = new Truck();
		Caixas caixa1 = new Caixas(210, 0.253f, 0.608f, 0.518f);
		Caixas caixa2 = new Caixas(200, 0.263f, 0.480f, 0.323f);
		Caixas caixa3 = new Caixas(200, 0.203f, 0.403f, 0.413f);
		Caixas caixa4 = new Caixas(200, 0.170f, 0.530f, 0.380f);
		Caixas caixa5 = new Caixas(140, 0.285f, 0.435f, 0.255f);

		//conteiner.caixaQuantidadeMaxComprimento(caixa1.getComprimento());
		//conteiner.conjuntoComprimento(caixa1);
		//conteiner.caixaQuantidadeMaxComprimento(caixa2.getComprimento());
		//conteiner.caixaQuantidadeMaxComprimento(caixa3.getComprimento());
		//conteiner.caixaQuantidadeMaxComprimento(caixa4.getComprimento());
		//conteiner.caixaQuantidadeMaxComprimento(caixa5.getComprimento());
		
		
		//conteiner.caixaQuantidadeMaxLargura(caixa1.getLargura());
		//conteiner.caixaQuantidadeMaxLargura(caixa2.getLargura());
		//conteiner.caixaQuantidadeMaxLargura(caixa3.getLargura());
		//conteiner.caixaQuantidadeMaxLargura(caixa4.getLargura());
		//conteiner.caixaQuantidadeMaxLargura(caixa5.getLargura());
		System.out.println(">>>>>>>Caixa 1<<<<<<<<");
		conteiner.melhorCombinacao(caixa1);
		System.out.println(">>>>>>>Caixa 2<<<<<<<<");
		conteiner.melhorCombinacao(caixa2);
		System.out.println(">>>>>>>Caixa 3<<<<<<<<");
		conteiner.melhorCombinacao(caixa3);
		System.out.println(">>>>>>>Caixa 4<<<<<<<<");
		conteiner.melhorCombinacao(caixa4);
		System.out.println(">>>>>>>Caixa 5<<<<<<<<");
		conteiner.melhorCombinacao(caixa5);
		

	}
}
