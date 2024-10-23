public class ColaEnlazada<T> implements Cola<T> {
    private ListaEnlazada<T> lista;

    public ColaEnlazada() {
        lista = new ListaEnlazada<>();
    }

    @Override
    public void encolar(T item) {
        lista.agregar(item);
    }

    @Override
    public T desencolar() {
        T primero = lista.obtener(0);
        lista.eliminar(primero);
        return primero;
    }

    @Override
    public boolean esVacia() {
        return lista.tamaño() == 0;
    }

    @Override
    public void vaciar() {
        lista = new ListaEnlazada<>();
    }
}
