public class ColaArreglo<T> implements Cola<T> {
    private ListaArreglo<T> lista;

    public ColaArreglo(int capacidad) {
        lista = new ListaArreglo<>(capacidad);
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
        lista = new ListaArreglo<>(lista.tamaño());
    }
}
