package clienteconta;

import clienteconta.Agencia;
import clienteconta.Cliente;

/*	
 * Esta classe define regras de negócio para Contas
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package clienteconta
 *  
*/

class Conta {

    //Atributos privados e encapsulados, não permite alteração exerna
	private double saldoConta;
    private String numeroConta;
    private Cliente titularConta;
    private Agencia agenciaConta;

	/*
	 * @return saldoConta
	 * 					Retorna Saldo da Conta  
	 */	    
    public double getSaldo() {
        return saldoConta;
    }
    
	/*
	 * @return agenciaConta
	 * 					Retorna agencia da Conta  
	 */	    
    public Agencia getAgencia() {
        return agenciaConta;
    }
    
	/*
	 * @return numeroConta
	 * 					Retorna numero da Conta 
	 */	    
    public String getNumero() {
        return numeroConta;
    }
    
	/*
	 * @return titularConta
	 * 					Retorna Titulr Conta  
	 */	    
    public Cliente getTitular() {
        return titularConta;
    }

	/*
	 * Construtor 
	 */	    
    public Conta(double saldoInicial, String numConta, Cliente titConta, Agencia agConta) {
        
    	saldoConta = saldoInicial;
        numeroConta = numConta;
        titularConta = titConta;
        agenciaConta = agConta;       
    }
    
	/*
	 * Destructor 
	 */	      
    public void finalize() {
        System.out.println("Destructor");
    }    

	/*
	 * Reliza um saque na Conta, verificando saldo suficiente e valor saque positivo
	 * 
	 * @param valorSaque
	 * 				  Valor do saque na conta	  
	 */	    
    public boolean saque(double valorSaque) {
        System.out.println("Realizando saque de R$ " + valorSaque + " da conta " + numeroConta);
        if (valorSaque > 0) {
            if (this.saldoConta >= valorSaque) 
            	this.saldoConta -= valorSaque;
            else {
            	System.out.println("Saldo insuficiente !");
            	return false;
            }
        } else {
            System.out.println("O valor de saque deve ser positivo");
            return false;
        }
        
        return true;
    }

	/*
	 * Reliza um deposito na Conta, verificando valor depósito positivo
	 * 
	 * @param valorDesposito
	 * 				  Valor do depósito na conta	  
	 */    
    public boolean deposito(double valorDesposito) {
        System.out.println("Realizando deposito de R$" + valorDesposito + " da conta " + numeroConta);
        if (valorDesposito >= 0) {
            this.saldoConta += valorDesposito;
        } 
        else
        { 
            System.out.println("O valor do deposito deve ser positivo");
            return false;
        }
        
        return true;
    }

	/*
	 * Imprime dados do Objeto no Console 
	 */	       
    public void imprimeDados() {
        System.out.println("\n----------------------------");
        System.out.println(" AGENCIA :" + agenciaConta.getNumero());
        System.out.println(" NR CONTA: " + numeroConta);
        System.out.println(" TITULAR : " + titularConta.getNome());
        System.out.println(" SALDO   : R$" + saldoConta);
        System.out.println("-----------------------------\n");
    }

}
