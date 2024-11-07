import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class LeetCode52 {
    // N-Queens II
    /*
     * O quebra-cabeça n-queens é o problema de colocar n rainhas em um tabuleiro de
     * xadrez n x n de forma que nenhuma das duas rainhas ataque uma à outra.
     * 
     * Dado um inteiro n, retorne o número de soluções distintas para o
     * quebra-cabeça n-queens.
     */

    private static final int N = 8;
    private static int[][] board = new int[N][N];
    private static final Random random = new Random();
    private static ArrayList<int[]> queens;
    private static final ArrayList<Function<int[], int[]>> diagonals = new ArrayList<>();
    private static final double trials = expectedTrials(Math.pow(2, N)); // per exponential growth
    // initialize arrays and ArrayLists in the start of the program
    static ArrayList<int[][]> list = new ArrayList<>();

    static {
        shuffle();

        diagonals.add(aPosition -> new int[] { aPosition[0] + 1, aPosition[1] + 1 }); // southeast
        diagonals.add(aPosition -> new int[] { aPosition[0] + 1, aPosition[1] - 1 }); // southwest
        diagonals.add(aPosition -> new int[] { aPosition[0] - 1, aPosition[1] - 1 }); // northwest
        diagonals.add(aPosition -> new int[] { aPosition[0] - 1, aPosition[1] + 1 }); // northeast
    }

    private static void shuffle() {
        for (int[] row : board)
            Arrays.fill(row, 0);
        queens = new ArrayList<>();
        for (int i = 0; i < N; i++)
            queens.add(new int[] { random.nextInt(N), i }); // every queen is put in a different row
    }

    private static void assignConflicts(int row, int column) {
        int count = queens.get(column)[0] == row ? -2 : -1; // corrects the variable to not include the queen in this
                                                            // column
        for (int i = 0; i < N; i++) {
            if (queens.get(column)[0] == i)
                count++;
            if (queens.get(i)[0] == row)
                count++;
        }

        for (Function<int[], int[]> diagonal : diagonals) {
            int[] position = diagonal.apply(new int[] { row, column }); // the position parameter of this method mapped
                                                                        // to a diagonal
            while (isOnBoard(position)) {
                if (queens.get(position[1])[0] == position[0])
                    count++;
                position = diagonal.apply(position); // further maps to a diagonal
            }
        }
        board[row][column] = count;
    }

    public static void main(String[] args) {

        int trial = 0;

        while (true) { // 'repairing' loop.
            int swaps = 0;
            boolean reached = false;
            for (int column = 0; column < N; column++) {
                int row = searchMinimumRow(column);
                if (queens.get(column)[0] != row) { // if 'row' is in fact a new row
                    swaps++;
                    queens.get(column)[0] = row; // queen' new position in this column is 'row'
                }
                if (solutionReached()) {
                    reached = true;
                    break;
                }
            }
            if (reached) {
                if (list.isEmpty()) {
                    list.add(board);
                    continue;
                }
                if (trial++ >= trials){
                    System.out.println(list.size());
                    System.exit(0);
                
                }

                boolean equal = false;
                for (int[][] arr : list)
                    if (Arrays.deepEquals(arr, board)) {
                        equal = true;
                        break;
                    }

                if (!equal)
                    list.add(board);

                shuffle();
                continue;
            }
            if (swaps == 0) // shuffles if stuck in a local minimum
                shuffle();

        }

      

    }

    private static boolean isOnBoard(int[] aPosition) {
        return aPosition[0] < N && aPosition[0] >= 0 && aPosition[1] >= 0 && aPosition[1] < N;
    }

    private static int searchMinimumRow(int column) { // returns the row with the least number of conflicts in this
                                                      // column
        for (int row = 0; row < N; row++)
            assignConflicts(row, column);
        int minRow = 0;
        for (int i = 0; i < N; i++)
            if (board[i][column] < board[minRow][column])
                minRow = i;
        return minRow;
    }

    private static boolean solutionReached() {
        boolean solutionReached = true;

        for (int[] position : queens) {
            assignConflicts(position[0], position[1]);
            solutionReached = board[position[0]][position[1]] == 0 && solutionReached;
        }
        return solutionReached;
    }

    public static double expectedTrials(double k) {
        double expectedValue = 0.0;

        for (int i = 1; i <= k; i++) {
            expectedValue += 1.0 / i;
        }

        return k * expectedValue;
    }

    private static void printSolutionFiltered() {
        System.out.println();
        for (int[] row : board)
            System.out.println(Arrays.toString(row)
                    .replaceAll("1", "0")
                    .replaceAll("-0", "1")
                    .replaceAll("[^1, \\[\\]]", "0"));
    }

    public static boolean areEqual(int[][] array1, int[][] array2) {
        // Check if both arrays are null or if their lengths differ
        if (array1 == null || array2 == null) {
            return false; // If one is null and the other isn't, they are not equal
        }

        // Assuming both arrays have the same size as mentioned
        int rows = array1.length;
        int cols = array1[0].length;

        // Check if the number of rows and columns are the same
        if (array2.length != rows || array2[0].length != cols) {
            return false;
        }

        // Compare each element
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false; // If any element is different, arrays are not equal
                }
            }
        }

        return true; // Arrays are equal if no differences were found
    }
}
