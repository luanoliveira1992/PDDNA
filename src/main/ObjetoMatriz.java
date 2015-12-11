package main;

public class ObjetoMatriz {
	
	//Valor do nó
	private int valor;
	
	//Quem deu origem ao valor do nó
	private String  origem;
	
	public ObjetoMatriz(int valor, String origem) {
		this.valor = valor;
		this.origem = origem;
	}
	
	
	
	@Override
	public String toString() {
		return  valor + "-" + origem ;
	}

    

	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	

}
