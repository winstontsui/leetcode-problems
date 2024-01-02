/*
 * Leetcode 73: Set Matrix Zeroes. Java. Medium.
 * Nasty problem containing arrays and matrices. O(n*m) runtime and O(1) spacetime.
 * Must solve problem in place, which means not using more than O(1) space.
 * The trick is to use the first row and column to store whether to zero out that row or column.
 * An extra variable here is necessary, use this depending on if matrix[0][0] is used to zero out that first row or column.
 * 1/1/2024 Winston Tsui
*/

class Solution73 {
    public void setZeroes(int[][] matrix) {
        int checker = 0;

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    if (j == 0)
                        checker = 1;
                    else 
                        matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //TODO: Rewrite. This isn't written well because I don't need to check if j != 0.
        for (int i = 1; i<matrix.length; i++){
            for (int j = 1; j<matrix[0].length; j++){
                if (j != 0 && matrix[0][j] == 0 || j==0 && checker == 1)
                    matrix[i][j] = 0;
                if (j !=0 && matrix[i][0] == 0 || j==0 && checker == 1)
                    matrix[i][j] = 0;
            }
        }

        //matrix[0][0] determines first row zeroing out, checker==1 determines first column zeroing out.
        if (matrix[0][0] == 0){
            for (int j=0; j<matrix[0].length; j++)
                matrix[0][j] = 0;
        }

        if (checker == 1){
            for (int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
