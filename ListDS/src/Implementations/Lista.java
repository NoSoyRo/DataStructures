package Implementations;

import java.util.Iterator;

import Interfaces.Coleccion;
import Interfaces.IteradorLista;

// Nota que si dejamos solo Coleccion<T> solamente me va a contextualizar el generico T a los elementos de mi codigo 
// que sean definidos en mi interfaz Coleccion<T> y no los nuevos metodos, para los nuevos metodos usamos el Lista<T>

public class Lista<T> implements Coleccion<T> {

	public class Nodo {

		public Nodo anterior;
		public Nodo siguiente;
		public T actualElemento;

		public Nodo(T elemento) {
			this.actualElemento = elemento;
		}
	}

	public class Iterador implements IteradorLista<T> {

		public Nodo anterior;
		public Nodo siguiente;

		public Iterador() {
			anterior = null;
			siguiente = cabeza;
		}

		@Override
		public boolean hasPrevious() {
			if (anterior == null) {
				return false;
			}
			return true;
		}

		@Override
		public T previous() {
			if (anterior == null) {
				return null;
			}
			T data = this.siguiente.actualElemento;
			this.siguiente = this.anterior;
			this.anterior = this.anterior.anterior;
			return data;
		}

		@Override
		public boolean hasNext() {
			if (siguiente == null) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			if (siguiente == null) {
				return null;
			}
			T data = this.anterior.actualElemento;
			this.anterior = this.siguiente;
			this.siguiente = this.siguiente.siguiente;
			return data;
		}

		@Override
		public void start() {
			this.anterior = null;
			this.siguiente = cabeza;
		}

		@Override
		public void end() {
			this.siguiente = null;
			this.anterior = rabo;
		}

	}

	private Nodo cabeza;
	private Nodo rabo;
	private int longitud;

	public Nodo getCabeza() {
		return cabeza;
	}

	public Nodo getRabo() {
		return rabo;
	}

	public int getLongitud() {
		return longitud;
	}

	@Override
	public Iterator<T> iterator() {
		Iterador iterador = new Iterador();
		return iterador;
	}

	@Override
	public void agrega(T elemento) {
		// cuando lo veas como que a=b y b=objeto significa que a apunta al mimso objeto
		// que apunta b ---> objeto
		// por lo tanto si cambio algo de a tipo a.cambio entonces cuando escriba a b
		// tambien habra notado ese cambio.
		if (cabeza != null) {
			Nodo nuevo = new Nodo(elemento);
			nuevo.anterior = rabo;
			rabo.siguiente = nuevo;
			rabo = nuevo;
			this.longitud += 1;
			return;
		}
		Nodo nuevo = new Nodo(elemento);
		cabeza = nuevo;
		rabo = nuevo;
		this.longitud += 1;
	}

	// Elimina todos los elementos que son element
	@Override
	public void elimina(T elemento) {
		Nodo n = this.cabeza;
		while (n != null) {
			if (n.actualElemento == elemento) {
				n.anterior.siguiente = n.siguiente;
				n.siguiente.anterior = n.anterior;
				this.longitud -= 1;
				// return; si queremos eliminar la primera coincidencia
			}
			n = n.siguiente;
		}
		return;

	}

	@Override
	public boolean contiene(T elemento) {
		Nodo n = this.cabeza;
		while (n != null) {
			if (n.actualElemento == elemento) {
				return true;
			}
			n = n.siguiente;
		}
		return false;
	}

	@Override
	public boolean esVacia() {
		return this.cabeza == null;
	}

	@Override
	public int getElementos() {
		return this.longitud;
	}

	@Override
	public void limpia() {
		this.cabeza = null;
		this.rabo = null;
	}

	@Override
	public String toString() {
		return "Listirijilla";
	}

	public void agregaFinal(T elemento) {
		this.rabo.siguiente = new Nodo(elemento);
		this.rabo.siguiente.anterior = this.rabo;
		this.rabo = this.rabo.siguiente;
		this.longitud += 1;
	}

	public void agregaInicio(T elemento) {
		this.cabeza.anterior = new Nodo(elemento);
		this.cabeza.anterior.siguiente = this.cabeza;
		this.cabeza = this.cabeza.anterior;
		this.longitud += 1;
	}

	// Empezando cuenta en 1
	public T get(int i) {
		if (i>this.longitud) {
			return null;
		}
		Nodo nAuxGet = this.cabeza;
		int j = 1;
		while (nAuxGet != null) {
			if (i==j) {
				return nAuxGet.actualElemento;
			}
			j++;
			nAuxGet = nAuxGet.siguiente;
		}
		return null;
	}
	
	// Nota que crear una copia dfe la lista significa crear una copia de ella es crear los mismos nodos pero con una ubicacion de memoria nueva, 
	// no es crear referencias a los mismos objetos.
	public Lista<T> copia() {
		Lista<T> copiaLista = new Lista<>(); // Asignacion automatica
		copiaLista.cabeza = new Nodo(this.cabeza.actualElemento);
		copiaLista.rabo = copiaLista.cabeza;
		Nodo nAuxCopia = this.cabeza;
		while (nAuxCopia.siguiente != null) {
			copiaLista.agregaFinal(nAuxCopia.siguiente.actualElemento);
			nAuxCopia = nAuxCopia.siguiente;
		}
		return copiaLista;
	}

}
