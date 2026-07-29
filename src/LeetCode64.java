public class LeetCode64 {

    public int minPathSumMonteCarlo(int[][] grid) { //aproximação monte carlo, eficiente apenas para matrizes pequenas
        int samenessKounter = 0;
        int min = Integer.MAX_VALUE;

        while (samenessKounter < 10) {
            int[][] sequence = generateSequence(grid.length - 1, grid[0].length - 1);

            int sequenceValue = 0;
            int i = 0, j = 0;

            for (int[] increment : sequence) {
                sequenceValue += grid[i][j];
                i += increment[0];
                j += increment[1];
            }
            sequenceValue += grid[i][j];

            if (sequenceValue == min) {
                samenessKounter++;
            } else if (sequenceValue < min) {
                min = sequenceValue;
                //samenessKounter = 0;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode64 leetCode64 = new LeetCode64();
        int[][] grid = {{7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5}, {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6}, {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8}, {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4}, {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4}, {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9}, {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4}, {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2}, {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3}, {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7}, {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7}, {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}};
        System.out.println(leetCode64.minPathSumMonteCarlo(grid));
        System.out.println(leetCode64.minPathSum(grid));
    }

    /*
    MINIMUM-PATH-SUM(A, m, n)
1  let dp[1..m, 1..n] be a new table
2  dp[1,1] ← A[1,1]
3  for j ← 2 to n
4      dp[1,j] ← dp[1,j-1] + A[1,j]          ▹ first row
5  for i ← 2 to m
6      dp[i,1] ← dp[i-1,1] + A[i,1]          ▹ first column
7  for i ← 2 to m
8      for j ← 2 to n
9          dp[i,j] ← A[i,j] + min(dp[i-1,j], dp[i,j-1])
10 return dp[m,n]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

        return dp[m - 1][n - 1];
    }


    public static int[][] generateSequence(int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("m and n must be non-negative");
        }

        int len = m + n;
        int[][] seq = new int[len][];

        int idx = 0;
        for (int i = 0; i <= m - 1; i++) {
            seq[idx++] = new int[]{1, 0};
        }
        for (int i = 0; i <= n - 1; i++) {
            seq[idx++] = new int[]{0, 1};
        }
        //gerador xor-shift
        long state = System.nanoTime();
        if (state == 0) state = 0xDEADBEEFCAFEBABEL;

        for (int i = len - 1; i > 0; i--) {
            state ^= state << 13;
            state ^= state >>> 7;
            state ^= state << 17;
            int j = (int) ((state & 0x7FFFFFFFL) % (i + 1));

            int[] tmp = seq[i];
            seq[i] = seq[j];
            seq[j] = tmp;
        }

        return seq;
    }

}
