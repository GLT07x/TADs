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
        T tope = tope();
        lista.eliminar(tope); 
        return tope;
    }

    @Override
    public T tope()
    {
        return lista.obtener(lista.tamaño() - 1);
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