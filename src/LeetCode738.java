public class LeetCode738 {
    /*
    An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
     */
    public int monotoneIncreasingDigits(int n) {
        char[] a = String.valueOf(n).toCharArray();

        int i = a.length;

        for (int j = a.length - 1; j > 0; j--) {
            if (a[j - 1] > a[j]) {
                a[j - 1]--;
                i = j;
            }
        }
        for (int k = i; k < a.length ; k++) {
            a[k] = '9';
        }

        return Integer.parseInt(String.valueOf(a));
    }
}
