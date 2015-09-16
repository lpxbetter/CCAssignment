package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
/*
Rotate layer by layer
 */
public class rotateImage_1_7 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return;
        int layerNum = matrix.length/2;
        for(int layer=0;layer<layerNum;layer++)
        {
            for(int i=layer;i<matrix.length-layer-1;i++)
            {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length-1-i][layer];
                matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
                matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
                matrix[i][matrix.length-1-layer] = temp;
            }
        }
    }
}
