package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
/*
Use two additional variables to mark whether the first row ,first col should be set to 0 or not.
Then use the first row and first col to store which rows and cols should be set to 0;
*/
public class zeroMatrix_1_8 {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        boolean rowFlag = false;
        boolean colFlag = false;
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0]==0)
            {
                colFlag = true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][i]==0)
            {
                rowFlag = true;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j] = 0;
            }
        }
        if(colFlag)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
        if(rowFlag)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                matrix[0][i] = 0;
            }
        }
    }

}
