package calculocontainer;

import calculocontainer.Caixa;

/*	
 * Esta classe define regras de negócio para Containers
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package calculocontainer
 *  
*/

public class Container {

	private String descricaoContainer;
	private float larguraContainer;
	private float comprimentoContainer;
	private float alturaContainer;
	
	public static enum Status_Container { POSSUI_ESPACO, PREENCHIDO }
	private Status_Container statusContainer;
	private Caixa caixasArmazenadas;
	
	public Caixa getCaixasArmazenadas() {
		return caixasArmazenadas;
	}
	public void setCaixasArmazenadas(Caixa caixasArmazenadas) {
		this.caixasArmazenadas = caixasArmazenadas;
	}	
	public Status_Container getStatusContainer() {
		return statusContainer;
	}
	public void setStatusContainer(Status_Container status) {
		this.statusContainer = status;
	}	
	public String getDescricaoContainer() {
		return descricaoContainer;
	}
	private void setDescricaoContainer(String descricao) {
		this.descricaoContainer = descricao;
	}
	public float getLarguraContainer() {
		return larguraContainer;
	}
	private void setLarguraContainer(float largura) {
		this.larguraContainer = largura;
	}
	public float getComprimentoContainer() {
		return comprimentoContainer;
	}
	private void setComprimentoContainer(float comprimento) {
		this.comprimentoContainer = comprimento;
	}
	public float getAlturaContainer() {
		return alturaContainer;
	}
	private void setAlturaContainer(float altura) {
		this.alturaContainer = altura;
	}	
	
	public Container(String descricao, float largura, float comprimento, float altura, Status_Container status,  Caixa objCaixa) {
		
		setDescricaoContainer(descricao);
		setLarguraContainer(largura);
		setComprimentoContainer(comprimento);
		setAlturaContainer(altura);
		setStatusContainer(status);
		setCaixasArmazenadas(objCaixa);
		setStatusContainer(Container.Status_Container.POSSUI_ESPACO);
		
	}
	
	public void finalize() {
		
		if (caixasArmazenadas != null)
			caixasArmazenadas = null;
		
	}

}
