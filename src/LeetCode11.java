import java.util.PriorityQueue;
import java.util.Queue;

/*Você recebe uma altura de array inteiro de comprimento n. Há n linhas verticais desenhadas de modo que os dois pontos finais da i-ésima linha são (i, 0) e (i, height[i]).

Encontre duas linhas que, juntamente com o eixo x, formam um recipiente, de modo que o recipiente contenha a maior quantidade de água.

Retorne a quantidade máxima de água que um recipiente pode armazenar.*/
public class LeetCode11 {
    public static int maxArea(int[] height) { //correto, mas peca com o limite de tempo em certas soluções grandes
        Queue<Integer> records = new PriorityQueue<>() ;
        records.add(0);
        for (int i = 0; i < height.length; i++)
            for (int j = 0; j < height.length; j++){

                int minimum = Math.min(height[i],height[j]);
                double calculation;
               // if(!records.isEmpty())
                    calculation = records.peek() - (j-i + 1)*minimum;
                if( calculation < 0)
                records.add((j - i) * Math.min(height[i], height[j]));
                if(records.size() > 1)
                    records.poll();
            }


        return records.peek();

    }





    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
