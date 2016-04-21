package Exercicio03;

import javax.swing.JOptionPane;

public class CaixaEletronicoMain {
	public static void main(String[] args) {
		CaixaEletronico n = new CaixaEletronico();
		
		n.deposito(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado: R$")));
		n.saque(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado: R$")));
		n.imprimirDados();
	}
}
