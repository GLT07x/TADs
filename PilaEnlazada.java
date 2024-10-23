public class PilaEnlazada<T> implements Pila<T> 
{
    private ListaEnlazada<T> lista;

    public PilaEnlazada()
    {
        lista = new ListaEnlazada<>();
    }

    @Override
    public void apilar(T item)
    {
        lista.agregar(item); 
    }

    @Override
    public T desapilar()
    {
        if (lista.tamaño() == 0)
        {
            return null; 
        }
        T tope = obtenerTope();
        lista.eliminar(tope); 
        return tope;
    }

    @Override
    public T tope()
    {
        return obtenerTope();
    }

    private T obtenerTope()
    {
        ListaEnlazada.Nodo<T> actual = lista.cabeza;
        while (actual.siguiente != null)
        {
            actual = actual.siguiente;
        }
        return actual.data;
    }

    @Override
    public boolean esVacia()
    {
        return lista.tamaño() == 0;
    }

    @Override
    public void vaciar()
    {
        while (!esVacia())
        {
            desapilar();
        }
    }
}