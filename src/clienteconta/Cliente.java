package clienteconta;

/*	
 * Esta classe define regras de negócio para Clientes
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package clienteconta
 *  
*/

class Cliente {

    private String nome;
    private String cpf;
    
	/*
	 * @param nome
	 * 			Carrega o nome 
	 */	
    private void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * @return nome
	 * 					Retorna o Nome do Cliente 
	 */	
	public String getNome() {
		return nome;
	}
	
	/*
	 * @return cpf
	 * 					Retorna cpf do Cliente 
	 */	
	public String getCpf() {
		return cpf;
	}

	/*
	 * @param cpf
	 * 			Carrega o cpf 
	 */	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/*
	 * Construtor 
	 */		
    public Cliente(String nomeCliente, String cpfCliente) {
        this.setCpf(cpfCliente);
        this.setNome(nomeCliente);
    }
    
	/*
	 * Destructor 
	 */	 
    public void finalize() {
        System.out.println("Destructor");
    }    

	/*
	 * Imprime dados do Objeto no Console 
	 */	       
    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Nome do cliente :" + this.getNome());
        System.out.println("CPF:" + this.getCpf());
        System.out.println("----------------------");
    }
    
}