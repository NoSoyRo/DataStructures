package List;

import Nodes.Node;

public interface ADTList {
    public boolean estaVacia();

    public void vaciar();

    public void agregar(Object elem);

    public Object contiene(Object elem);

    public Object primerElemento();

    public void eliminar(Object elem);

    public void sustituir(Object orig, Object nuevo);

    public java.util.Iterator<Object> iterador();
}
