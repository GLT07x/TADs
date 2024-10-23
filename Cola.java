
public interface Cola<T>
{
    void encolar(T item);
    T desencolar();
    boolean esVacia();
    void vaciar();
}