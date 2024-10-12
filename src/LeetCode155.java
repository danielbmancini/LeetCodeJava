import java.util.ArrayList;
import java.util.Comparator;

//Projete uma pilha que suporte push, pop, top e recuperação do elemento mínimo em tempo constante.
/*
 * Projete uma pilha que suporte push, pop, top e recuperação do elemento mínimo em tempo constante.

Implemente a classe MinStack:

MinStack() inicializa o objeto da pilha.
void push(int val) coloca o elemento val na pilha.
void pop() remove o elemento no topo da pilha.
int top() obtém o elemento do topo da pilha.
int getMin() recupera o elemento mínimo na pilha.

Você deve implementar uma solução com complexidade de tempo O(1) para cada função.
 */
public class LeetCode155 { //Min Stack
    ArrayList<Integer> arrayList;
    ArrayList<Integer> minimaList;
    public LeetCode155() {
        arrayList = new ArrayList<>();
        minimaList = new ArrayList<>();
    }

    public void push(int val) {
        arrayList.add(val);

        if(minimaList.isEmpty() || val <= minimaList.get(minimaList.size() - 1))
            minimaList.add(val);

    }

    public void pop() {
        int removed = arrayList.remove(arrayList.size() - 1);
        if( minimaList.contains(removed))
            minimaList.remove((Integer) removed);
    }


    public int top() {
        return arrayList.get(arrayList.size() - 1);
    }

    public int getMin() {
        if(!minimaList.isEmpty())
            return minimaList.get(minimaList.size() - 1);
        else
            return arrayList.get(0);
    }

    public static void main(String[] args) {
        LeetCode155 leetCode155 = new LeetCode155();

        leetCode155.push(1);
        leetCode155.push(2);
        System.out.println(leetCode155.top());
        System.out.println(leetCode155.getMin());
        leetCode155.pop();
        System.out.println(leetCode155.getMin());
        System.out.println(leetCode155.top());
    }
}
