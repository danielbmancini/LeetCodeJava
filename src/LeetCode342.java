public class LeetCode342 {
    /*
    Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.
     */

    //Solução em tempo constante da pergunta log_4(n) ∈ ℕ, com Newton-Raphson.
    //x_n+1 = x_n - (4^x_n - x)/ (4^x_n * ln(4) )
    public boolean isPowerOfFour(int n) {
        if (n < 0)
            return false;
        int iteracoes = 50;
        double approx = 15;
        double epsilon = 0.001;
        float ln4 = 1.386294361119F;


        for (int i = 0; i < iteracoes; i++)
            approx = approx - (Math.pow(4,approx) - n) / (Math.pow(4,approx) * ln4);


        return Math.abs(Math.round(approx) - approx) < epsilon;
    }

    public static void main(String[] args) {
        LeetCode342 leetCode342 = new LeetCode342();

        System.out.println(leetCode342.isPowerOfFour(1073741824));
    }

}
