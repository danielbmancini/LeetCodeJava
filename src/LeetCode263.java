public class LeetCode263 {
    /*
    Um número "feio" é um inteiro positivo que não possui nenhum fator primo além de 2, 3 e 5.

Dado um inteiro n, retorne verdadeiro se n for um número "feio".
     */
    public boolean isUgly1(int n) {
        if (n == 1)
            return true;
        if (n == 0)
            return false;

        String num = String.valueOf(n);
        char lastDigit = num.charAt(num.length() - 1);

        if ( "024568".indexOf(lastDigit) == -1 && !isDivisibleBy3(num))
            return false;




        while(n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;


        return (n == 1);
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }

    private boolean isDivisibleBy3(String str) {
        int sum = 0;

        for (char c : str.toCharArray()) {
            sum += c - '0';
        }

        return sum % 3 == 0;
    }


}
