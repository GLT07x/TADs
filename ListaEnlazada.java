public class ListaEnlazada<T> implements Lista<T> 
{
    protected static class Nodo<T> 
    {
        T data;
        Nodo<T> siguiente;

        Nodo(T data) 
        {
            this.data = data;
            this.siguiente = null;
        }
    }

    protected Nodo<T> cabeza;
    private int tamaño;

    public ListaEnlazada() 
    {
        this.cabeza = null;
        this.tamaño = 0;
    }

    @Override
    public void agregar(T item) 
    {
        Nodo<T> nuevo = new Nodo<>(item);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
        tamaño++;
    }

    @Override
    public void eliminar(T item)
    {
        if (cabeza == null) return;

        if (cabeza.data.equals(item)) 
        {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo<T> temp = cabeza;
        while (temp.siguiente != null && !temp.siguiente.data.equals(item)) 
        {
            temp = temp.siguiente;
        }

        if (temp.siguiente != null)
        {
            temp.siguiente = temp.siguiente.siguiente;
            tamaño--;
        }
    }

    @Override
    public boolean buscar(T item)
    {
        Nodo<T> temp = cabeza;
        while (temp != null)
        {
            if (temp.data.equals(item)) return true;
            temp = temp.siguiente;
        }
        return false;
    }

    @Override
    public int tamaño() 
    {
        return tamaño;
    }
    
    public T obtener(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.data; 
    }
}