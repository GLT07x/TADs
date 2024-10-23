import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;
public class NumUtils
{
    /*public ListNumUtils()
    {
        
    }*/
    
    public LinkedList<Integer> randomLinkedList(int N)
    {
        LinkedList<Integer> lista = new LinkedList<>();
        Random random = new Random();
        
        for (int i = 0; i < N; i++){
            int numeroAleatorio = random.nextInt(5);
            lista.add(numeroAleatorio);
        }
        
        return lista;
    }
    
    public ArrayList<Integer> randomArrayList(int N)
    {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < N; i++){
            int numeroAleatorio = random.nextInt(5);
            lista.add(numeroAleatorio);
        }
        
        return lista;
    }
    
    public boolean containNum(int N, int numero)
    {
        ArrayList<Integer> lista = randomArrayList(N);
        System.out.print(lista);
        return lista.contains(numero);
    }
    
    public void bubbleSort(int N)
    {
        ArrayList<Integer> lista = randomArrayList(N);
        System.out.println(lista);
        int n = lista.size();
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) 
        {
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++)
            {
                if (lista.get(j) > lista.get(j + 1)) 
                {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambio = true;
                }
            }

            if (!intercambio)
            {
                break;
            }
        }
        
        System.out.println(lista);
    }
    
    public boolean balanceo(String expresion) 
    {
        Stack<Character> pila = new Stack<>();

        for(int i = 0; i < expresion.length(); i++) 
        {
            char c = expresion.charAt(i);

            if(c == '(') 
            {
                pila.push(c);
            }
            else if(c == ')') 
            {
                if(pila.isEmpty()) 
                {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }
    
    public boolean balanceoPilaE(String expresion) 
    {
        PilaEnlazada<Character> pila = new PilaEnlazada<>();
        for (char c : expresion.toCharArray()) 
        {
            if (c == '(') 
            {
                pila.apilar(c);
            } else if (c == ')') 
            {
                if (pila.esVacia()) 
                {
                    return false;
                }
                pila.desapilar();
            }
        }
        return pila.esVacia();
    }
    
    public boolean balanceoPilaA(String expresion) 
    {
        PilaArreglo<Character> pila = new PilaArreglo<>(expresion.length());
        for (char c : expresion.toCharArray()) 
        {
            if (c == '(') 
            {
                pila.apilar(c);
            } else if (c == ')') 
            {
                if (pila.esVacia()) 
                {
                    return false;
                }
                pila.desapilar();
            }
        }
        return pila.esVacia();
    }
}
