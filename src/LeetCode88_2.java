import java.util.Arrays;

public class LeetCode88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < copy.length) {

            if (i == m || j == n) {
                if (i == m && j == n)
                    break;
                if (i == m) {
                    copy[k++] = nums2[j++];
                    continue;
                }
                if (j == n) {
                    copy[k++] = nums1[i++];
                    continue;
                }
            } else {
                if (nums1[i] < nums2[j])
                    copy[k++] = nums1[i++];
                else if (nums2[j] < nums1[i])
                    copy[k++] = nums2[j++];
                else {
                    copy[k++] = nums1[i++];
                    copy[k++] = nums2[j++];
                }
            }

        }

        nums1 = Arrays.copyOf(copy, copy.length);

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        LeetCode88_2 leetCode88_2 = new LeetCode88_2();
        leetCode88_2.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
    }
}
