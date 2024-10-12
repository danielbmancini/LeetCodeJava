import java.util.Arrays;

public class LeetCode80 { //Remove Duplicates from Sorted Array II

    /*
     * Dado um array inteiro nums classificado em ordem não decrescente, remova algumas duplicatas no local de modo que cada elemento único apareça no máximo duas vezes. A ordem relativa dos elementos deve ser mantida a mesma.

Como é impossível alterar o comprimento do array em algumas linguagens, você deve, em vez disso, colocar o resultado na primeira parte do array nums. Mais formalmente, se houver k elementos após a remoção das duplicatas, os primeiros k elementos de nums devem conter o resultado final. Não importa o que você deixar além dos primeiros k elementos.

Retorne k após colocar o resultado final nos primeiros k slots de nums.

Não aloque espaço extra para outro array. Você deve fazer isso modificando o array de entrada no local com O(1) de memória extra.

Juiz personalizado:

O juiz testará sua solução com o seguinte código:

int[] nums = [...]; // Matriz de entrada
int[] expectedNums = [...]; // A resposta esperada com o comprimento correto

int k = removeDuplicates(nums); // Chama sua implementação

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
assert nums[i] == expectedNums[i];
}

Se todas as asserções forem aprovadas, sua solução será aceita.
     */
    public static void main(String[] args) {
        LeetCode80 leetCode80 = new LeetCode80();

        int k = leetCode80.removeDuplicates(new int[]{1, 1, 1, 2});
        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 10000;
        }

        int pointer = nums[0];
        int count = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pointer) {
                pointer = nums[i];
                count = 0;
            }
            if (++count > 2) {
                nums[i] = -1;
                n++;
            }
        }

        rearrange(nums);
        return nums.length - n;
    }

    public void rearrange(int[] nums) {
        int index = 0;
        for (int n = 0; n < nums.length; n++)
            if (nums[n] >= 0)
                nums[index++] = nums[n] - 10000;

        System.out.println(Arrays.toString(nums));
    }

}
