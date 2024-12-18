import java.util.Arrays;

public class LeetCode88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         * Você recebe dois arrays inteiros nums1 e nums2, classificados em ordem não
         * decrescente, e dois inteiros m e n, representando o número de elementos em
         * nums1 e nums2, respectivamente.
         * 
         * Mescle nums1 e nums2 em um único array classificado em ordem não decrescente.
         * 
         * O array classificado final não deve ser retornado pela função, mas sim
         * armazenado dentro do array nums1. Para acomodar isso, nums1 tem um
         * comprimento de m + n, onde os primeiros m elementos denotam os elementos que
         * devem ser mesclados, e os últimos n elementos são definidos como 0 e devem
         * ser ignorados. nums2 tem um comprimento de n.
         */
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
