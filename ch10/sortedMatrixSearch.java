package ch10;

/**
 * Created by lipingxiong on 10/1/15.
 10.9
 */
public class sortedMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return  false;
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=n-1;
        while(i<m && j>=0){
            if(target==matrix[i][j]) return true;
            else if( target > matrix[i][j]){
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
