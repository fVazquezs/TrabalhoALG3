class MST {

	private static int v = Main.qntd;

	int minchave(int chave[], Boolean passou[]) {
		int min = Integer.MAX_VALUE, min_pos = -1;

		for (int v = 0; v < v; v++)
			if (passou[v] == false && chave[v] < min) {
				min = chave[v];
				min_pos = v;
			}
		return min_pos + 1;
	}

	void printMST(Grafo incio, Grafo grafo) {
		for (int v = 1; v < incio.V; v++) {
			System.out.print("Inicial: "+(v + 1));
			Aresta print = null;
			for (Aresta aresta : incio.conhecidos[v]) {
				print = aresta;
			}
			System.out.println(" -> " + (print.getFim() + 1) + "  Custo: " + print.getCusto());
		}
		// for (int i = 1; i < v ; i++)
		// System.out.println(incio.conhecidos[i].get(0).getFim() + " - " + i + " " +
		// grafo.conhecidos[i].get(0).getCusto());

	}

	void primMST(Grafo grafo) {
		Grafo incio = new Grafo(v);
		int chave[] = new int[v];
		Boolean passou[] = new Boolean[v];

		for (int i = 0; i < v; i++) {
			chave[i] = Integer.MAX_VALUE;
			passou[i] = false;
		}
		// incio.conhecidos[0].add(new Aresta(0, -1));

		for (int count = 0; count < v - 1; count++) {
			int u = minchave(chave, passou);
			for (int i = 0; i < grafo.conhecidos.length; i++) {
				for (int x = 0; x < grafo.conhecidos[i].size(); x++) {
					if (passou[i] == false && grafo.conhecidos[i].get(x).getCusto() < chave[i]) {
						incio.conhecidos[i].add(
								new Aresta(grafo.conhecidos[i].get(x).getFim(), grafo.conhecidos[i].get(x).getCusto()));
						chave[i] = grafo.conhecidos[i].get(x).getCusto();
					}
				}
				passou[i] = true;

			}
		}
		printMST(incio, grafo);
	}

}