public class ColaCircular 
{
    private int[] cola;
    private int frente, finalCola, tamaño, capacidad;

    public ColaCircular(int capacidad) 
    {
        this.capacidad = capacidad;
        cola = new int[capacidad];
        frente = 0;
        finalCola = -1;
        tamaño = 0;
    }

    public boolean estaLlena() 
    {
        return tamaño == capacidad;
    }

    public boolean estaVacia() 
    {
        return tamaño == 0;
    }

    public void encolar(int elemento) 
    {
        if (estaLlena()) 
        {
            System.out.println("Cola llena, no se puede encolar");
            return;
        }
        finalCola = (finalCola + 1) % capacidad; 
        cola[finalCola] = elemento;
        tamaño++;
    }

    public int desencolar() 
    {
        if (estaVacia()) 
        {
            System.out.println("Cola vacía, no se puede desencolar");
            return -1;
        }
        int elemento = cola[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return elemento;
    }

    public void imprimir() 
    {
        if (estaVacia()) 
        {
            System.out.println("Cola vacía");
            return;
        }
        System.out.println("Elementos en la cola:");
        for (int i = 0; i < tamaño; i++) 
        {
            int index = (frente + i) % capacidad;
            System.out.print(cola[index] + " ");
        }
        System.out.println();
    }
}
