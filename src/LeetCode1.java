/*
    Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    08/2019
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
