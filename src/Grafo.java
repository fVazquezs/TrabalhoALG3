import java.util.LinkedList;

public class Grafo {
		int V;
		LinkedList<Aresta> conhecidos[];

		Grafo(int V) {
			this.V = V;
			conhecidos = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				conhecidos[i] = new LinkedList<>();
			}
		}
		
	}