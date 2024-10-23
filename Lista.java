
public interface Lista<T>
{
    void agregar(T item);
    void eliminar(T item);
    boolean buscar(T item);
    int tamaño();
}