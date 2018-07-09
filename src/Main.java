import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int qntd;

	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("src/data2.txt")).useDelimiter("\n");
		String linha = s.next();
		Scanner conteudo = new Scanner(linha).useDelimiter(" ");
		qntd = conteudo.nextInt();
		Grafo grafo = new Grafo(qntd);
		while (s.hasNext()) {
			String linhaAresta = s.next();
			addData(linhaAresta, grafo);
		}
	 printgrafo(grafo);
		int linhamatriz[] = new int[qntd];
		int matrizgrafo[][] = new int[qntd][qntd];

		for (int x = 0; x < qntd; x++) {
			for (int m = 0; m < qntd; m++) {
				linhamatriz[m] = addMatriz(grafo, x, m);
			}

			for (int y = 0; y < qntd; y++) {
				matrizgrafo[x][y] = linhamatriz[y];
			}
		}
		Prims prim = new Prims();
		prim.primMST(matrizgrafo);

	}

	static int addMatriz(Grafo grafo, int vertice, int fim) {
		for (Aresta aresta : grafo.conhecidos[vertice]) {
			if (aresta.getFim() == fim) {
				return aresta.getCusto();
			}
		}
		return 0;

	}

	static void addData(String linhaAresta, Grafo grafo) {
		Scanner conteudoAresta = new Scanner(linhaAresta).useDelimiter("[ \n]");
		int inicio = conteudoAresta.nextInt() - 1;
		int fim = conteudoAresta.nextInt() - 1;
		int custo = conteudoAresta.next().charAt(0) - '0';
		addVertice(grafo, inicio, fim, custo);
	}

	static void addVertice(Grafo grafo, int src, int dest, int custo) {
		grafo.conhecidos[src].addFirst(new Aresta(dest, custo));
		grafo.conhecidos[dest].addFirst(new Aresta(src, custo));
	}

	static void printgrafo(Grafo grafo) {
		for (int v = 0; v < grafo.V; v++) {
			System.out.println("Pontos ligados ao vertice " + (v + 1));
			for (Aresta aresta : grafo.conhecidos[v]) {
				System.out.println("Ligação: " + (aresta.getFim() + 1) + " || Custo: " + aresta.getCusto());
			}
			System.out.println("---------------------------");
		}
	}

}