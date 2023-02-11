package Graph;

import Graph.ADTGraph;
import List.List;
import Nodes.Node;

import java.sql.Array;

public class Graph implements ADTGraph {
    private List[] V; // = new List[]
    private int nNodos;

    public Graph() {
        V = null;
    }

    public Graph(int cantidad) {
        V = new List[cantidad];
    }

    @Override
    public void agregar(Node node) {
        /*
         * TODO: Implementar la interfaz de agregdo y la de eliminado, pero
         * no debes preocuparte porque la implementacion es cero
         * complicada porque solo tienes que hacer un arreglo de listas
         * y ya sea partir el metodo en dos: un metodo para agregar nodo
         * a la grafica y el otro para agregar una Edge o conexion
         * por un lado:
         * metodo agregarNodoAGrafica -> agrega una lista vacia al Array.
         * metodo agregarEdge -> admite dos parametros:
         * ++ int inicio;
         * ++ int final;
         * Finalmente lo unico que hace
         * es agregar el pointer final de
         * cada lista en el final el inicial
         * y en el final el incial.
         * metodo eliminarNodo -> recibe un entero, se elimina la
         * lista
         * del array se recorren los restantes
         * del array
         * o no, y solamente se elimina de
         * cada elemento de la lista
         * los pointers de las listas
         * y luego la lista:
         * 1ro se itera sobre la lista y se
         * eliminan los
         * nodos de las listas que lo
         * contengan
         * 2do se elimina la lista del array.
         */
    }
}
