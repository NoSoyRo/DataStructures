package Graph;

import Graph.ADTGraph;
import List.List;
import Nodes.Node;

import java.sql.Array;

public class Graph implements ADTGraph {
    private List[] V; // = new List[]
    private int nNodos;
    private int nOcupados;

    public Graph() {
        V = null;
        nOcupados = 0;
    }

    public Graph(int cantidad) {
        V = new List[cantidad];
        nOcupados++;
    }

    @Override
    public void agregarNodoAGafica() {
        V[nOcupados + 1] = new List();
        nOcupados++;
    }

    @Override
    public void agregarBordeAGrafica(int[] arr) {
        V[arr[0]].agregar(V[arr[1]]);
        V[arr[1]].agregar(V[arr[0]]);
    }

    @Override
    public void agregarNodoYBordeAGrafica(int[] arr) {
        V[nOcupados + 1] = new List();
        V[arr[0]].agregar(V[arr[1]]);
        V[arr[1]].agregar(V[arr[0]]);
        nOcupados++;
    }

}
