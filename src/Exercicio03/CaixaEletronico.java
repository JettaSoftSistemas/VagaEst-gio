package Exercicio03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CaixaEletronico {
	private double saldo;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {

		this.saldo = saldo;

	}

	// Metodo saque
	public void saque(double saque) {
		if (saque > 0 || saque < saldo) {
			saldo = saldo - saque;
		}
	}

	// Metodo deposito
	public void deposito(double deposito) {
		if (deposito > 0) {
			saldo = saldo + deposito;
		} else {
			System.out.println("Valor Invalido");
		}
	}

	// Extrato
	public void imprimirDados() {
		try {

			// Criacao e o caminho em que o diretorio sera criado.
			File diretorio = new File("Caixa");
			// Criacao e nome do arquivo que sera criado.
			File arquivo = new File("CaixaEletronico.txt");

			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			// Metodo para escrever no arquivo criado
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("Saldo: " +saldo + " R$");

			// Onde sera incluido todos os metodos que quero que apareca no
			// arquivo texto.
			bw.close();
			fw.close();
			// Leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

		} catch (Exception e) {
		}
		System.out.println("Saldo: " + saldo + " R$");

	}

}
