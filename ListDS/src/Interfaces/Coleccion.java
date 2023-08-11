package Interfaces;

public interface Coleccion<T> extends Iterable<T>{
	public void agrega(T elemento);
	public void elimina(T elemento);
	public boolean contiene(T elemento);
	public boolean esVacia();
	public int getElementos();
	public void limpia();
}
