public class LeetCode190 {
        //Inverte os bits de um número inteiro com sinal de 32 bits.
    // https://www.geeksforgeeks.org/dsa/write-an-efficient-c-program-to-reverse-bits-of-a-number/
    /*
REVERSE-BITS(num)
1  n ← 32
2  reverse ← 0
3  for i ← 0 to n − 1
4      if (num ≫ i) ∧ 1 = 1
5          reverse ← reverse ∨ (1 ≪ (n − 1 − i))
6  return reverse
     */
    public int reverseBits(int n) {
        int count = 32;
        int reverse = 0;

        for (int i = 0; i <= count - 1; i++) {
            if (((n >> i) & 1) == 1)
                reverse = reverse | (1 << (count-1-i));
        }

        return reverse;
    }
}
