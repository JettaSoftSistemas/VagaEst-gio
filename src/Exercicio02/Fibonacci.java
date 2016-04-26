package Exercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Fibonacci {
	private int n1;
	private int n2;

	// Contrutor inicializando os valores das variaveis.
	public Fibonacci() {
		this.n1 = 0;
		this.n2 = 1;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	// Executando a sequencia Fibonacci com a quantidade escolhida pelo usuario.

	public void sequenceFibonacci(int v) {
		try {

			// Criacao e o caminho em que o diretorio sera criado.
			File diretorio = new File("Fibonacci");
			// Criacao e nome do arquivo que sera criado.
			File arquivo = new File("Fibonacci.txt");

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			// Metodo para escrever no arquivo criado
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			for (int i = 0; i < v; i++) {
				bw.write(n2+" ");
				System.out.print(" " + n2);
				n2 = n1 + n2;
				n1 = n2 - n1;
			}
			// Onde sera incluido todos os metodos que quero que apareca no
			// arquivo texto.
			bw.close();
			fw.close();
			// Leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

		} catch (Exception e) {
		}
		
	}
}
