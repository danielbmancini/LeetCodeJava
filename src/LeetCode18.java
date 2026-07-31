import java.util.*;

public class LeetCode18 {
    /*
    Dado um array `nums` de n inteiros, retorne um array contendo todos os quádruplos únicos `[nums[a], nums[b], nums[c], nums[d]]` tais que:

0 <= a, b, c, d < n

a, b, c e d são distintos.

nums[a] + nums[b] + nums[c] + nums[d] == alvo

Você pode retornar a resposta em qualquer ordem.
     */

    /*
    FOUR-SUM(A, t)
    n ← A.length
    if n < 4
        return ∅
    sort A into nondecreasing order
    R ← ∅
    for i ← 0 to n-4
        if i > 0 and A[i] = A[i-1]          ▷ skip duplicate first elements
            continue
        ▷ solve the 3-Sum instance on the suffix A[i+1‥n-1]
        ▷ that must sum to t − A[i]
        S ← THREE-SUM(A, i+1, n-1, t − A[i]) -> leetcode15
        for each triple (x, y, z) ∈ S
            R ← R ∪ {(A[i], x, y, z)}
    return R
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> R = new ArrayList<>();

        if (n < 4)
            return R;
        Arrays.sort(nums);

        for (int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> triples = threeSum(nums,i+1,n-1, (long) target - nums[i]);

            for(List<Integer> triple : triples){
                List<Integer> quadruple = new ArrayList<>();
                quadruple.add(nums[i]);
                quadruple.add(triple.get(0));
                quadruple.add(triple.get(1));
                quadruple.add(triple.get(2));
                R.add(quadruple);
            }

        }
        return R;
    }

    /*
    THREE-SUM(A, lo, hi, t)                     ▷ find all unique triples in A[lo‥hi]
    R ← ∅
    for j ← lo to hi-2
        if j > lo and A[j] = A[j-1]          ▷ skip duplicate second elements
            continue
        left  ← j+1
        right ← hi
        while left < right
            s ← A[j] + A[left] + A[right]
            if s = t
                R ← R ∪ {(A[j], A[left], A[right])}
                left  ← left + 1
                right ← right - 1
                while left < right and A[left] = A[left-1]
                    left ← left + 1
                while left < right and A[right] = A[right+1]
                    right ← right - 1
            else if s < t
                left ← left + 1
            else
                right ← right - 1
    return R
     */
    public List<List<Integer>> threeSum(int[] nums, int lo, int hi, long target) {
        List<List<Integer>> R = new ArrayList<>();

        for (int j = lo; j <= hi - 2; j++) {
            if (j > lo && nums[j] == nums[j - 1])
                continue;
            int left = j + 1;
            int right = hi;
            while (left < right) {
                long s = (long) nums[j] + nums[left] + nums[right];
                if (s == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[j]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    R.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (s < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return R;
    }
}
