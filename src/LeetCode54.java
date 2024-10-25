import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {
        LeetCode54 leetCode54 = new LeetCode54();

        System.out.println(leetCode54.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        int i = 0;
        int j = -1;

        while (list.size() < matrix.length * matrix[0].length) {
            int[] positions = nextPosition(i, j, pos);

            if (positions[0] == matrix.length || positions[0] < 0 ||
                    positions[1] == matrix[0].length || positions[1] < 0 || matrix[positions[0]][positions[1]] == 101) {
                pos++;
                continue;
            }

            i = positions[0];
            j = positions[1];

            list.add(matrix[i][j]);
            System.out.println(matrix[i][j]);
            matrix[i][j] = 101;
            System.out.println("size = " + list.size());
        }

        return list;
    }

    public int[] nextPosition(int i, int j, int pos) {
        pos = pos % 4;

        switch (pos) {
            case 0: // direita
                return new int[] { i, j + 1 };
            case 1: // baixo
                return new int[] { i + 1, j };
            case 2: // esquerda
                return new int[] { i, j - 1 };
            case 3: // cima
                return new int[] { i - 1, j };
            default:
                return new int[] { i, j };
        }
    }

}
