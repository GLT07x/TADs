
public interface Pila<T>
{
    void apilar(T item);
    T desapilar();
    T tope();
    boolean esVacia();
    void vaciar();
}