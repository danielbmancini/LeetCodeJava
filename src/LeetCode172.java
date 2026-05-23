public class LeetCode172 {
    //Given an integer n, return the number of trailing zeroes in n!.
    //complexidade logarítmica
    public static int trailingZeroes(int n) {
        double max = Math.log(n) / Math.log(5);
        int zeroes = 0;
        for (int i = 0; i < max; i++) {
            zeroes += (int) Math.floor(n / Math.pow(5,i + 1)); //matemática direta, mas todas essas operações não são necessárias
        }

        return zeroes;
    }

    public static int trailingZeroes2(int n) {
        double max = Math.log(n) / Math.log(5);
        int zeroes = 0;
        for (int i = 0; i < max; i++) {
            n /= 5;
            zeroes += n;
        }

        return zeroes;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes2(0));
    }


}
