package Exercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MainFibonacci {

	public static void main(String[] args) {
		Fibonacci n = new Fibonacci();
		n.sequenceFibonacci(Integer.parseInt(
				JOptionPane.showInputDialog("Digite a quantidade desejado para a sequencia Fibonacci: ")));

	}

}
