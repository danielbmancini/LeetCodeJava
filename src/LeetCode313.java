import java.util.ArrayList;

public class LeetCode313 {
    public ArrayList<Integer> genUglies(int n, int[] primes){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        int[] pointers = new int[primes.length];

        while (numbers.size() < n){
            long[] candidates = new long[primes.length];

            long nextNumber = Long.MAX_VALUE;

            for (int i = 0; i < primes.length; i++) {
                candidates[i] = (long) primes[i] * numbers.get(pointers[i]);
                nextNumber = Math.min(candidates[i],nextNumber);
            }
            numbers.add((int) nextNumber);

            for (int i = 0; i < primes.length; i++) {
                if (candidates[i] == nextNumber) {
                    pointers[i]++;
                }
            }
        }
        return numbers;
    }

    public int nthSuperUglyNumber(int n, int[] primes) { //n <= 10^5
    /*
    Um número super feio é um inteiro positivo cujos fatores primos pertencem ao vetor `primes`.

Dado um inteiro `n` e um vetor de inteiros `primes`, retorne o n-ésimo número super feio.

O n-ésimo número super feio tem a garantia de caber em um inteiro com sinal de 32 bits.
     */
        ArrayList<Integer> nums = genUglies(n,primes);

        return nums.get(n - 1);

    }
}
