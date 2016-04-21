package clienteConta;

class Agencia {

    private String numeroAgencia;
    private int numeroBanco;

	public String getNumero() {
		return numeroAgencia;
	}

	private void setNumero(String numero) {
		this.numeroAgencia = numero;
	}

	public int getBanco() {
		return numeroBanco;
	}

	private void setBanco(int banco) {
		this.numeroBanco = banco;
	}

    public Agencia(String num, int bc) {
        setNumero(num);
        setBanco(bc);
    }
    
    public void finalize() {
        System.out.println("Destructor");
    }

    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Agencia Nr. " + getNumero());
        System.out.println("Banco Nr. " + getBanco());
        System.out.println("----------------------");
    }
}
