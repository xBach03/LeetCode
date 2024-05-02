public class MatrixBinSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = (row * col) - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int midNum = matrix[mid / col][mid % col];
            System.out.println(midNum);
            if(target == midNum) {
                return true;
            } else if(target > midNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] Args) {
        System.out.println(searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 15));
    }
}
