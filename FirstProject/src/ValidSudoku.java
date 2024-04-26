import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> setBox1 = new HashSet<>();
        HashSet<Character> setBox2 = new HashSet<>();
        HashSet<Character> setBox3 = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if(i == 3 || i == 6) {
                setBox1 = new HashSet<>();
                setBox2 = new HashSet<>();
                setBox3 = new HashSet<>();
            }
            for(int j = 0; j < 9; j++) {
                if(j < 3) {
                    if(setBox1.contains(board[i][j])) {
                        return false;
                    } else if(board[i][j] != '.') {
                        setBox1.add(board[i][j]);
                    }
                } else if(j >= 3 && j < 6) {
                    if(setBox2.contains(board[i][j])) {
                        return false;
                    } else if(board[i][j] != '.') {
                        setBox2.add(board[i][j]);
                    }
                } else {
                    if(setBox3.contains(board[i][j])) {
                        return false;
                    } else if(board[i][j] != '.') {
                        setBox3.add(board[i][j]);
                    }
                }
                if(set.contains(board[i][j])) {
                    return false;
                } else if(board[i][j] != '.') {
                    set.add(board[i][j]);
                }

            }
            set = new HashSet<>();
        }
        set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(set.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    set.add(board[j][i]);
                }

            }
            set = new HashSet<>();
        }
        return true;
    }
    public static void main(String[] Args) {
        System.out.println(isValidSudoku(new char[][] {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
