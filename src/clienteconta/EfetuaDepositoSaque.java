package clienteconta;

import javax.swing.JOptionPane;

import clienteconta.Agencia;
import clienteconta.Cliente;
import clienteconta.Conta;
import rotinasio.CriaSalvaArquivo;

public class EfetuaDepositoSaque {
	
	public void salvaAquivo(String nomeArquivo, String textoArquivo) {
		
		CriaSalvaArquivo objArquivo = new CriaSalvaArquivo();		
		try {
			
			objArquivo.setNomeArquivo(nomeArquivo);
			objArquivo.setValorArquivo(textoArquivo);
			objArquivo.salvaArquivo();
			
		}
		finally {
			if (objArquivo != null)
				objArquivo = null;				
		}
		
	}

	public static void main(String[] args) {

		EfetuaDepositoSaque objArquivo = new EfetuaDepositoSaque();
		Agencia objAgencia = new Agencia("001122C", 55);
		Cliente objCliente = new Cliente("Julio Cesar", "007.359.855-55");

		// Inicializa conta com R$ 1000
		Conta objConta = new Conta(1000, "35899-5", objCliente, objAgencia);		
		try {
			
			// Realiza saque maior que Saldo
			double vlTransacao = 5000;			
			if (! objConta.saque(vlTransacao)) 
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o Saque de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo());
			
			//Log do Saque maior que Saldo			
			objArquivo.salvaAquivo("Saque_Invalido.txt", "============= " + "N�o foi poss�vel realizar o Saque de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo() + " =============");
			
			// Realiza Dep�sito Negativo
			vlTransacao = -2500;
			if (! objConta.deposito(vlTransacao)) {
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o Dep�sito de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo());
			}
			
			//Log do Dep�sito Negativo
			objArquivo.salvaAquivo("Deposito_Invalido.txt", "============= " + "N�o foi poss�vel realizar o Dep�sito de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo() + " =============");			
			
			// Realiza Dep�sito Positivo
			vlTransacao = 2500;
			if (! objConta.deposito(vlTransacao)) {
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o Dep�sito de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo());
				
				//Log do Dep�sito Positivo
				objArquivo.salvaAquivo("Deposito_Positivo.txt", "============= " + "N�o foi poss�vel realizar o Dep�sito de " + vlTransacao + ". Saldo Atual: " + objConta.getSaldo() + " =============");				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Dep�sito de " + vlTransacao + " realizado. Saldo Atual: " + objConta.getSaldo());
				
				//Log do Dep�sito Positivo
				objArquivo.salvaAquivo("Deposito_Positivo.txt", "============= " + "Dep�sito de " + vlTransacao + " realizado. Saldo Atual: " + objConta.getSaldo() + " =============");				
			}
			
			// Realiza um Saque menor que o saldo
			vlTransacao = 1500;			
			if (objConta.saque(vlTransacao)) 
				JOptionPane.showMessageDialog(null, "Saque de " + vlTransacao + " realizado. Saldo Atual: " + objConta.getSaldo());
			
			//Log do Saque menor que o saldo
			objArquivo.salvaAquivo("Saque_Valido.txt", "============= " + "Saque de " + vlTransacao + " realizado. Saldo Atual: " + objConta.getSaldo() + " =============");
			
			// Saldo Final
			JOptionPane.showMessageDialog(null, "Saldo Final: " + objConta.getSaldo());
			
			//Log do Saque menor que o saldo
			objArquivo.salvaAquivo("Saldo_Final.txt", "============= " + "Saldo Final: " + objConta.getSaldo() + " =============");			
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Exce��o ao manipular dados: " + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			if (objAgencia != null)
				objAgencia = null;
			if (objCliente != null)
				objCliente = null;				
			if (objConta != null)
				objConta = null;
			if (objArquivo != null)
				objArquivo = null;
		}
		
		System.gc();
		System.exit(0);
		
	}

}
