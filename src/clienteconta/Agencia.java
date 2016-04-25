package clienteconta;

/*	
 * Esta classe define regras de negócio para Agencias
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package clienteconta
 *  
*/

class Agencia {

    private String numeroAgencia;
    private int numeroBanco;

	/*
	 * @return valnumeroAgencia
	 * 					Retorna o Número da Agencia 
	 */
    public String getNumero() {
		return numeroAgencia;
	}

	/*
	 * @param numeroAgencia
	 * 					Carrega o Número da Agencia 
	 */	
    private void setNumero(String numero) {
		this.numeroAgencia = numero;
	}

	/*
	 * @return numeroBanco
	 * 					Retorna o Número do Banco 
	 */
	public int getBanco() {
		return numeroBanco;
	}

	/*
	 * @param banco
	 * 					Carrega o Número do Banco 
	 */		
	private void setBanco(int banco) {
		this.numeroBanco = banco;
	}

	/*
	 * Construtor 
	 */	
    public Agencia(String num, int bc) {
        setNumero(num);
        setBanco(bc);
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
        System.out.println("Agencia Nr. " + getNumero());
        System.out.println("Banco Nr. " + getBanco());
        System.out.println("----------------------");
    }
}
