package main;

public class Programa {
	public String seq1 = "GAATTCAGTTA";
	public String seq2 = "GGATCGA";
	public ObjetoMatriz[] alinhamento[];

	public void preencheInicial() {
		this.alinhamento = new ObjetoMatriz[seq1.length() + 1][seq2.length() + 1];

		this.alinhamento[0][0] = new ObjetoMatriz(0, "-");
		;
		// Prenche todos os valores da primeira linha
		for (int i = 1; i < seq1.length() + 1; i++) {
			this.alinhamento[i][0] = new ObjetoMatriz(-4 * i, "-");
		}

		// Preenche todos os valores da primeira coluna
		for (int j = 1; j < seq2.length() + 1; j++) {
			this.alinhamento[0][j] = new ObjetoMatriz(-4 * j, "-");
		}
	}

	public ObjetoMatriz prencheValores(int i, int j) {

		String[] origens = new String[] { "D", "C", "L" };
		
		ObjetoMatriz resultado = null;

		// o maior valor conhecido é inicialmente
		// o menor valor possível para um inteiro;
		int maiorValor = Integer.MIN_VALUE;
		int[] valoresTemporal = new int[3];

		// Verificamos os três valores possíveis, e ficaremos com o maior
		valoresTemporal[0] = calculaPrimeiroValor(i, j, maiorValor);
		valoresTemporal[1] = calculaSegundoValor(i, j, maiorValor);
		valoresTemporal[2] = calcularTerceiroValor(i, j, maiorValor);
		
		for (int k = 0; k < valoresTemporal.length; k++) {
			if(valoresTemporal[k] > maiorValor){
				resultado = new ObjetoMatriz(valoresTemporal[k], origens[k]);
				maiorValor =  valoresTemporal[k];
			}
		}

		return resultado;

	}

	private int calcularTerceiroValor(int i, int j, int maiorValor) {
		int valorAuxiliar;
		// Terceiro valor:
		valorAuxiliar = this.alinhamento[i - 1][j].getValor() - 4;

		if (valorAuxiliar < maiorValor) {
			valorAuxiliar = maiorValor;
		}
		return valorAuxiliar;
	}

	private int calculaSegundoValor(int i, int j, int maiorValor) {
		int valorAuxiliar;
		// Segundo valor:
		valorAuxiliar = this.alinhamento[i][j - 1].getValor() - 4;

		if (valorAuxiliar < maiorValor) {
			valorAuxiliar = maiorValor;
		}
		return valorAuxiliar;
	}

	private int calculaPrimeiroValor(int i, int j, int maiorValor) {
		// Primeiro valor:
		int valorAuxiliar = this.alinhamento[i - 1][j - 1].getValor();
		valorAuxiliar += this.seq1.charAt(i - 1) == this.seq2.charAt(j - 1) ? 5 : -3;
		if (valorAuxiliar < maiorValor) {
			valorAuxiliar = maiorValor;
		}
		return valorAuxiliar;
	}

	//Preenche a tabela de alinhamento
	//Procurando o melhor alinhamento possível
	public void procurAlinhamento() {
		for (int i = 1; i < seq2.length() + 1; i++) {
			for (int j = 1; j < seq1.length() + 1; j++) {
				this.alinhamento[j][i] = prencheValores(j, i);
			}
		}
		exibeResultado();
	}

	public void exibeResultado() {
		String linha = "";
		for (int i = 0; i < seq2.length() + 1; i++) {
			linha = "";
			for (int j = 0; j < seq1.length() + 1; j++) {
				linha += "  " + this.alinhamento[j][i];
			}
			System.out.println(linha);
		}
	}

	public static void main(String[] args) {
		Programa programa = new Programa();
		// Passos do algoritmo
		programa.preencheInicial();
		programa.procurAlinhamento();
	}

}
