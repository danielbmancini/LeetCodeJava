public class LeetCode50{
        /*
        Implemente a função pow(x, n), que calcula x elevado à potência n (ou seja, xⁿ).
         */
    public double myPow(double x, int n) {
        double pow = 1;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        while (n != 0){
            if( (n & 1) != 0) //compara o ultimo bit de n com 1, 1 & 0 = 0 -> par, 1 & 1 = 1 -> impar
                pow *= x;

            x *= x;
            n >>>= 1; // desloca todos os bits signed para a direita, então n /= 2;
        }

        return pow;
    }

    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();

        System.out.println(leetCode50.myPow(2,10));
    }
}