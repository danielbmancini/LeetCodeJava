import java.util.ArrayList;

public class LeetCode36 { //Valid Sudoku
    /*Determine se um tabuleiro de Sudoku 9 x 9 é válido.
      Este problema é um queridinho meu, e no futuro próximo publicarei um gênero de solução para isto.
     * */
    private static final int sudokuSize = 9;

    public static boolean isValidSudoku(char[][] board) {
        for (ArrayList<Character>[] chars : constructList(board)) {
            for (int i = 0; i < Math.sqrt(sudokuSize); i++) {
                //System.out.println(chars[i]);
                if (chars[i].stream().filter(Character::isDigit).distinct().count() !=
                        chars[i].stream().filter(Character::isDigit).count())
                    return false;
            }
        }
        return true;
    }

    private static ArrayList<ArrayList<Character>[]> constructList(char[][] board) {
        ArrayList<ArrayList<Character>[]> arrayList = new ArrayList<>();
        ArrayList<Character> box = new ArrayList<>();
        for (int i = 0; i < sudokuSize; i++) {
            for (int j = 0; j < sudokuSize; j++) {
                ArrayList<Character> row = getRow(i, board);
                ArrayList<Character> column = getColumn(j, board);
                int dim = (int) Math.sqrt(sudokuSize);
                if (i % dim == 0 && j % dim == 0)
                    box = getBox(i, j, board);
                arrayList.add(new ArrayList[]{row, column, box});
            }
        }
        return arrayList;

    }

    private static ArrayList<Character> getRow(int index, char[][] board) {
        ArrayList<Character> row = new ArrayList<>();
        for (char character : board[index])
            row.add(character);
        return row;
    }

    private static ArrayList<Character> getColumn(int index, char[][] board) {
        ArrayList<Character> column = new ArrayList<>();
        for (int i = 0; i < sudokuSize; i++) {
            char character = board[i][index];
            column.add(character);
        }

        return column;
    }

    private static ArrayList<Character> getBox(int row, int column, char[][] board) {
        ArrayList<Character> box = new ArrayList<>();
        for (int i = 0; i < Math.sqrt(sudokuSize); i++)
            for (int j = 0; j < Math.sqrt(sudokuSize); j++) {
                box.add(board[row + i][column + j]);
            }

        return box;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
