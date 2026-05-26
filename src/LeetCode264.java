import java.util.ArrayList;

public class LeetCode264 {
    /*
    Um número feio é um inteiro positivo cujos fatores primos se limitam a 2, 3 e 5.

Dado um inteiro n, retorne o n-ésimo número feio.
     */
    public int nthUglyNumber(int n) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1); //pre-computing numbers for n = 1690 should yield top 100% perfomance for both time and space
        
        int[] factors = {2,3,5};
        int[] pointers = {0,0,0};
        
        while (numbers.size() < n){
            int[] candidates = new int[factors.length]; //generalizável p/ problema 313

            int nextNumber = Integer.MAX_VALUE;

            for (int i = 0; i < factors.length; i++) {
                candidates[i] = factors[i] * numbers.get(pointers[i]);
                nextNumber = Math.min(candidates[i],nextNumber);
            }
            numbers.add(nextNumber);

            for (int i = 0; i < factors.length; i++) {
                if (candidates[i] == nextNumber) {
                    pointers[i]++;
                }
            }
        }
        return numbers.getLast();
    }
}
