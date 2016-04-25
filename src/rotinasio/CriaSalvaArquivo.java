package rotinasio;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/*	
 * Esta classe manipula Arquivos Texto no disco rigido
 * 
 * @author: Julio Cesar
 * @version: 1.0
 * @see: https://github.com/jclafi/VagaEst-gio.git
 * @see: package rotinasio
 *  
*/

public class CriaSalvaArquivo {
	
	private String nomeArquivo;
	private String valorArquivo;
	
	/*
	 * @return valorArquivo
	 * 					Retorna Valor do Arquivo Texto 
	 */	
	public String getValorArquivo() {
		return valorArquivo;
	}
	
	/*
	 * @param valorArquivo 
	 * 					Carrega Conte�do do Arquivo Texto
	 */	
	public void setValorArquivo(String valorArquivo) {
		this.valorArquivo = valorArquivo;
	}
	
	/*
	 * @return nomeArquivo
	 * 					Retorna Nome do Arquivo Texto 
	 */	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	/*
	 * @param nomeArquivo 
	 * 					Carrega Descri��o do Arquivo Texto
	 */		
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	/*
	 * @see Constructor
	 */	
	public CriaSalvaArquivo() {
		System.out.println("In�cio da cria��o do Objeto CriaSalvaArquivo - Constructor");	
	}

	/*
	 * @see Desctructor 
	 */		
	public void finalize() {
		System.out.println("T�rmino do uso Objeto CriaSalvaArquivo - Destructor");
	}	

	/*
		Este � o m�todo principal que grava e l� os dados do arquivo   
    */	
	public void salvaArquivo() {

		File arquivo = new File(nomeArquivo);
		try {

			// Somente cria o arquivo se ele n�o existe
			if (!arquivo.exists()) {
				if (!arquivo.createNewFile()) {
					System.out.println("Falha ao criar o arquivo");
				}
			} else 
			{
				// Se o arquivo existe apaga o mesmo
				if (arquivo.delete())
					if (!arquivo.createNewFile())
						System.out.println("Falha ao criar o arquivo");
			}

			// Abre o arquivo e grava os dados
			if ((arquivo.isFile()) && (arquivo.canWrite())) {

				FileWriter dados = new FileWriter(arquivo);
				BufferedWriter escreve = new BufferedWriter(dados);
				try {
					escreve.write(valorArquivo);
					escreve.close();
						
				} finally {
					escreve = null;
					dados = null;
				}
			}

			// L� os dados gravados
			if ((arquivo.isFile()) && (arquivo.canRead())) {

				FileReader dados = new FileReader(arquivo);
				BufferedReader leitura = new BufferedReader(dados);
				try {
					String line;
					{
						line = leitura.readLine();
						System.out.println(line);
					} while ((line = leitura.readLine()) != null);
					leitura.close();
				} finally {
					leitura = null;
					dados = null;
				}
			}

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Exce��o I/O: " + ex.getMessage());
			System.out.println("Exce��o I/O: " + ex.getMessage());			
			ex.printStackTrace();			
		} 
		finally {
			if (arquivo != null)
				arquivo = null;
		}
	}
}