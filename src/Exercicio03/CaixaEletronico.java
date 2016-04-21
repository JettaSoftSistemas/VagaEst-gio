package Exercicio03;

public class CaixaEletronico {
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {

		this.saldo = saldo;

	}
	//Metodo saque
	public void saque(double saque) {
		if (saque > 0 || saque < saldo) {
			saldo = saldo - saque;
		}
	}
	//Metodo deposito
	public void deposito(double deposito) {
		if (deposito > 0) {
			saldo = saldo + deposito;
		} else {
			System.out.println("Valor Invalido");
		}
	}
	//Extrato
	public void imprimirDados() {
		System.out.println("Saldo: " +saldo + " R$");
	
	}

}
