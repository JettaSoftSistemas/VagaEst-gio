package clienteconta;

import clienteconta.Agencia;
import clienteconta.Cliente;

class Conta {

    private double saldoConta;
    private String numeroConta;
    private Cliente titularConta;
    private Agencia agenciaConta;
    
    public double getSaldo() {
        return saldoConta;
    }
    public Agencia getAgencia() {
        return agenciaConta;
    }
    public String getNumero() {
        return numeroConta;
    }
    public Cliente getTitular() {
        return titularConta;
    }

    public Conta(double saldoInicial, String numConta, Cliente titConta, Agencia agConta) {
        
    	saldoConta = saldoInicial;
        numeroConta = numConta;
        titularConta = titConta;
        agenciaConta = agConta;       
    }

    public void finalize() {
        System.out.println("Destructor");
    }    

    public boolean saque(double valorSaque) {
        System.out.println("Realizando saque de R$ " + valorSaque + " da conta " + numeroConta);
        if (valorSaque > 0) {
            if (saldoConta >= valorSaque) 
                saldoConta -= valorSaque;
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

    public void imprimeDados() {
        System.out.println("\n----------------------------");
        System.out.println(" AGENCIA :" + agenciaConta.getNumero());
        System.out.println(" NR CONTA: " + numeroConta);
        System.out.println(" TITULAR : " + titularConta.getNome());
        System.out.println(" SALDO   : R$" + saldoConta);
        System.out.println("-----------------------------\n");
    }

}
