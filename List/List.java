package List;

import javax.sound.sampled.BooleanControl;

import List.ADTList;
import Nodes.Node;

public class List implements ADTList {
    private int nData;
    private Node primerNodo;

    public List() {
        nData = 0;
        primerNodo = null;
    }

    public List(Node elemento) {
        primerNodo = new Node(elemento);
        nData++;
    }

    public int cardinalidad() {
        return nData;
    }

    @Override
    public boolean estaVacia() {
        if (primerNodo == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void vaciar() {
        primerNodo = null;
        nData = 0;
    }

    @Override
    public Node contiene(Object elem) {
        Node node = primerNodo;
        while (node != null && !node.element.equals(elem)) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void sustituir(Object elem, Object nuevo) {
        Node n = contiene(elem);
        if (n != null) {
            n.element = nuevo;
        }
    }

    @Override
    public Object primerElemento() {
        return primerNodo;
    }

    @Override
    public void agregar(Object elem) {
        primerNodo = new Node(elem, primerNodo);
        nData++;
    }

    @Override
    public void eliminar(Object elem) {
        Node pos = primerNodo, anterior = null;
        while (pos != null && !pos.element.equals(elem)) {
            anterior = pos;
            pos = pos.next;
        }
        if (pos != null) {
            if (pos == primerNodo) {
                primerNodo = primerNodo.next;
            } else {
                anterior.next = pos.next;
            }
            nData--;
        }

    }

    public java.util.Iterator<Object> iterador() {
        return new MiIterador();
    }

    private class MiIterador implements java.util.Iterator<Object> {
        private Node posicion = primerNodo;

        public boolean hasNext() {
            return posicion != null;
        }

        public Object next() throws java.util.NoSuchElementException {
            if (hasNext()) {
                Object o = posicion.element;
                posicion = posicion.next;
                return o;
            } else {
                throw new IllegalStateException();
            }
        }

    }

}
