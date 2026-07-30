public class LeetCode231 {
    /*
    Dado um número inteiro n, retorne verdadeiro se ele for uma potência de dois. Caso contrário, retorne falso.

Um número inteiro n é uma potência de dois se existir um número inteiro x tal que n == 2^x.
     */

    /*
    IS-POWER-OF-TWO(n)
1  if n ≤ 0
2      return FALSE
3  if n & (n − 1) = 0
4      return TRUE
5  else
6      return FALSE
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }

    //Solução em tempo constante da pergunta log_2(n) ∈ ℕ, com Newton-Raphson.
    //x_n+1 = x_n - (2^x_n - x)/ (2^x_n * ln(2) )
    public boolean isPowerOfTwoRaphson(int n) {
        if (n < 0)
            return false;
        int iteracoes = 1000;
        double approx = 0;
        double epsilon = 0.0001;
        double ln2 = Math.log(2);


        for (int i = 0; i < iteracoes; i++)
            approx = approx - (Math.pow(2, approx) - n) / (Math.pow(2, approx) * ln2);


        return Math.abs(Math.round(approx) - approx) < epsilon;
    }

    public static void main(String[] args) {
        LeetCode231 leetCode231 = new LeetCode231();

        System.out.println(leetCode231.isPowerOfTwoRaphson(2097152));
        System.out.println(leetCode231.isPowerOfTwoRaphson(256));
        System.out.println(leetCode231.isPowerOfTwoRaphson(2048));


    }
}
