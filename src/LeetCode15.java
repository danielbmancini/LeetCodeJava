import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LeetCode15 { //3Sum
    /*Dado um array inteiro nums, retorne todos os tripletos [nums[i], nums[j], nums[k]] tais que i != j, i != k, e j != k, e nums[i] + nums[j] + nums[k] == 0.

Observe que o conjunto de soluções não deve conter tripletos duplicados.*/
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        3Sum(S,0):
    impose monotonic structure on S

    for each unique choice x in S:
        search for unique pairs (y, z) in the remaining ordered region
        such that:

            y + z = -x

        emit canonical triple (x, y, z)
         */
        Arrays.sort(nums);


        return IntStream.range(0, nums.length - 2) //range inclusivo
                .filter(i -> i == 0 || nums[i] != nums[i - 1])
                .boxed()
                .flatMap(i -> twoSumAfter(nums, i).stream())
                .toList();
    }

    private static List<List<Integer>> twoSumAfter(int[] nums, int anchor) {
        //janela de procura, inclusive
        int lo = anchor + 1;
        int hi = nums.length - 1;

        List<List<Integer>> matches = new ArrayList<>();

        while (hi > lo) {//dois candidatos na janela
            int pairHi = nums[hi];
            int pairLo = nums[lo];
            int anchorValue = nums[anchor];
            if (pairHi + pairLo == -anchorValue) { // "x + y + z = 0"
                matches.add(List.of(pairLo, pairHi, anchorValue));


                //diminuir janela
                hi--;
                lo++;

                while (lo < hi && nums[lo] == nums[lo - 1]) { //próximo 'lo' é duplicata
                    lo++;
                }

                while (lo < hi && nums[hi] == nums[hi + 1]) { //próximo 'hi' é duplicada
                    hi--;
                }

            } else if (pairHi + pairLo < -anchorValue) { //condição de falsificação 1
                lo++;
            } else { //condição de falsificação 2
                hi--;
            }


        }
        return matches;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
