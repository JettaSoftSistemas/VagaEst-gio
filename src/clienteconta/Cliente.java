package clienteconta;

class Cliente {

    private String nome;
    private String cpf;
    
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
    public Cliente(String nomeCliente, String cpfCliente) {
        this.setCpf(cpfCliente);
        this.setNome(nomeCliente);
    }

    public void finalize() {
        System.out.println("Destructor");
    }    

    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Nome do cliente :" + this.getNome());
        System.out.println("CPF:" + this.getCpf());
        System.out.println("----------------------");
    }
    
}