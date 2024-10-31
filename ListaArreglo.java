import java.util.Arrays;
import java.util.Scanner;

public class ListaArreglo<T> implements Lista<T> 
{
    private T[] arreglo;
    private int tamaño;

    public ListaArreglo(int capacidad) 
    {
        arreglo = (T[]) new Object[capacidad];
        tamaño = 0;
    }

    @Override
    public void agregar(T item) 
    {
        if (tamaño == arreglo.length) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("0 = no aumentar capacidad; 1 = aumentar");
            int aumento = scanner.nextInt();
            if(aumento == 1)
            {
                arreglo = Arrays.copyOf(arreglo, tamaño * 2);
            }else
            {
                throw new IllegalArgumentException("lleno, no se puede agregar");
            } 
        }
        arreglo[tamaño++] = item;
    }

    @Override
    public void eliminar(T item)
    {
        for (int i = 0; i < tamaño; i++)
        {
            if (arreglo[i].equals(item)) 
            {
                for (int j = i; j < tamaño - 1; j++)
                {
                    arreglo[j] = arreglo[j + 1];
                }
                arreglo[--tamaño] = null;
                return;
            }
        }
    }

    @Override
    public boolean buscar(T item) 
    {
        for (int i = 0; i < tamaño; i++) 
        {
            if (arreglo[i].equals(item)) 
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int tamaño() 
    {
        return tamaño;
    }
    
    @Override
    public T obtener(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return arreglo[index];
    }
}