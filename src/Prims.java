
class Prims {

	public void printMST(int inicio[], int graph[][]) {
		for (int i = 1; i < Main.qntd; i++)
			System.out.println("Inicial: " + (i + 1) + " -> " + (inicio[i] + 1) + "  Custo: " + graph[i][inicio[i]]);
	}

	public void primMST(int graph[][]) {
		int inicio[] = new int[Main.qntd];
		int chave[] = new int[Main.qntd];
		Boolean passou[] = new Boolean[Main.qntd];

		for (int i = 0; i < Main.qntd; i++) {
			chave[i] = Integer.MAX_VALUE;
			passou[i] = false;
		}
		chave[0] = 0;
		inicio[0] = -1;
		for (int contador = 0; contador < Main.qntd - 1; contador++) {
			int u = menorChave(chave, passou);
			passou[u] = true;
			for (int v = 0; v < Main.qntd; v++)
				if (graph[u][v] != 0 && passou[v] == false && graph[u][v] < chave[v]) {
					inicio[v] = u;
					chave[v] = graph[u][v];
				}
		}
		printMST(inicio, graph);
	}

	public int menorChave(int chave[], Boolean passou[]) {
		int min = Integer.MAX_VALUE, min_pos = -1;
		for (int v = 0; v < Main.qntd; v++)
			if (passou[v] == false && chave[v] < min) {
				min = chave[v];
				min_pos = v;
			}
		return min_pos;
	}
}