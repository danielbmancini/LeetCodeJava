import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode27 { // Remove Element
    /*Dado um array inteiro nums e um inteiro val, remova todas as ocorrências de val em nums no local.
A ordem dos elementos pode ser alterada. Então retorne o número de elementos em nums que não são iguais a val.*/
    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
            if(nums[i] == val){
                nums[i] = 101;
                count++;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> pointers = new ArrayList<>();
        for (int num : nums) {
            if (num != 101)
                pointers.add(num);
        }

        int size = nums.length - count;
        for (int i = 0; i < size; i++)
            nums[i] = pointers.get(i);
        System.out.println(Arrays.toString(nums));


        return size;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {3,2,2,3},3));
    }
}
