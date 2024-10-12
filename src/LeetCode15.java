import java.util.*;

public class LeetCode15 { //3Sum
    /*Dado um array inteiro nums, retorne todos os tripletos [nums[i], nums[j], nums[k]] tais que i != j, i != k, e j != k, e nums[i] + nums[j] + nums[k] == 0.

Observe que o conjunto de soluções não deve conter tripletos duplicados.*/
    public static List<List<Integer>> threeSum(int[] nums) { //incomplete
        HashSet<List<Integer>> lists = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int c = -(nums[i] + nums[j]);

                int search = -1;
                int count = 0;
                while (search == -1 && count < nums.length ) {
                    count++;
                    search = binarySearch2(nums, j + 1, nums.length , c);
                    //System.out.println(search);
                  //  if (search == j)
                       // search = binarySearch2(nums, j, nums.length - 1, c);
                    // if (search > -1)
                      //  break;
                }


                if(search == -1)
                    continue;
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                newList.add(nums[j]);
                newList.add(nums[search]);
                newList.sort(Comparator.naturalOrder());

                    lists.add(newList);
                System.out.println(newList);
            }

        }

        return new ArrayList<>(lists);
    }

    public static void main(String[] args) {
        System.out.println("\n\n" + threeSum(new int[]{1,2,-2,-1}));
    }

   /* private static int binarySearch2(int[] nums,int key){
        int a = Arrays.binarySearch(nums,key);

        if (a < 0)
            return -1;
        else
            return a;
    }*/

    private static int binarySearch2(int[] nums,int fromIndex,int toIndex, int key){
        int a = Arrays.binarySearch(nums,fromIndex,toIndex,key);

        if (a < 0)
            return -1;
        else
            return a;
    }
}
