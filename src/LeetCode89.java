import java.util.*;
import java.util.stream.Collectors;

public class LeetCode89 {
    //Given an integer n, return any valid n-bit gray code sequence.
   // #static Random rand = new Random();


    public static List<String> grayCode(int n) {
        SkewedRandomGenerator rand;

        LinkedHashSet<String> set = new LinkedHashSet<>();

        StringBuilder num = new StringBuilder();

        num.append("0".repeat(n));
        set.add(num.toString());

        int len; //size do set
        int count = 0;
        double k = 1900;
        int index;
        rand = new SkewedRandomGenerator(n,0);
        while (set.size() < Math.pow(2,n)){
            rand.setSkewFactor(set.size());
            index = rand.nextInt();
            //System.out.println(index);
            flipRandomBit(num,index);
            len = set.size();
            System.out.println(len);
            set.add(num.toString());
          //  System.out.println(num);
            if(len == set.size()) {
                flipRandomBit(num, index); //flip back
            }
        }

       return set.stream()
              // .map(Integer::valueOf)
               .collect(Collectors.toList());
    }

    public static void flipRandomBit(StringBuilder sb, int index) {

        char currentChar = sb.charAt(index);

        if (currentChar == '1') {
            sb.setCharAt(index, '0');
        } else {
            sb.setCharAt(index, '1');
        }

    }


    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }


}
 class SkewedRandomGenerator{

    private final Random random;

    private final int n;
    private double skewFactor;

    public SkewedRandomGenerator(int n, double skewFactor) {
    if (n <= 1) throw new IllegalArgumentException("n must be greater than 1");
    if (skewFactor < 0 || skewFactor > Math.pow(2, n)) throw new IllegalArgumentException("skewFactor out of range");

    this.n = n;
    this.skewFactor = skewFactor;
    this.random = new Random();
}

public int nextInt() {
    double skewedValue = Math.pow(random.nextDouble(), getSkew());
    return (int) (skewedValue * (n - 1)) + 1;
}

private double getSkew() {
    // Normalize skewFactor to range [0, 1]
    return skewFactor / Math.pow(2, n);
}

public void setSkewFactor(double skf){
        this.skewFactor = skf;
     }
}