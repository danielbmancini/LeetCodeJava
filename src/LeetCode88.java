import java.util.Arrays;

public class LeetCode88 {
    /*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = Arrays.copyOf(nums1,m+n);

        int insertionPoint1 = m - 1;
        int insertionPoint2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if(insertionPoint2 < 0 && insertionPoint1 < 0 )
                break;
            if(insertionPoint1 < 0)
                nums1[i] = nums2[insertionPoint2--];
            if(insertionPoint2 < 0)
                nums1[i] = nums1[insertionPoint1--];

            if(nums2[insertionPoint2] >= nums1Copy[insertionPoint1])
                nums1[i] = nums2[insertionPoint2--];
            else
                nums1[i] = nums1[insertionPoint1--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1,3,nums2,3);
    }


}
