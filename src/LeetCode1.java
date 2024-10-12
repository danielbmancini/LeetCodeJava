/*
    Two Sum
    Dado um array de inteiros nums e um inteiro alvo, retorne os índices dos dois números de modo que a soma deles resulte no alvo.
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
                if(nums[j] + nums[i] == target){
                    returnArray[0] = i;
                    returnArray[1] = j;
                }
        }
        return returnArray;}
}
