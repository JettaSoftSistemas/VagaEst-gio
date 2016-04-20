package Exercicios02;

import javax.swing.JOptionPane;

public class MainFibonacci {

	public static void main(String[] args) {
		Fibonacci n = new Fibonacci();

		n.sequenceFibonacci(Integer
				.parseInt(JOptionPane.showInputDialog("Digite a quantidade "
						+ "desejado para a sequencia Fibonacci: ")));
	}

}
