import java.util.Arrays;

public class LeetCode88 { //Merge Sorted Array

    /*Você recebe dois arrays inteiros nums1 e nums2, classificados em ordem não decrescente, e dois inteiros m e n, representando o número de elementos em nums1 e nums2, respectivamente.

Mescle nums1 e nums2 em um único array classificado em ordem não decrescente.
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
