import java.util.Arrays;

public class LeetCode167 { //Two Sum II - Input Array Is Sorted
   /*Dado um array indexado 1 de números inteiros que já está classificado em ordem não decrescente, encontre dois números tais que eles somem um número alvo específico. Sejam esses dois números numbers[index1] e numbers[index2] onde 1 <= index1 < index2 < numbers.length.

Retorne os índices dos dois números, index1 e index2, adicionados por um como um array inteiro [index1, index2] de comprimento 2.

*/
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int search = Arrays.binarySearch(numbers,target - numbers[i]);
            if (i + 1 < numbers.length && search > -1 && numbers[i+1] != target - numbers[i])
                return new int[] {i + 1, search + 1};
            else if (i + 1 < numbers.length && numbers[i + 1] == target - numbers[i])
                return new int[] {i+1, i + 2};


            }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15},9)));
    }}


