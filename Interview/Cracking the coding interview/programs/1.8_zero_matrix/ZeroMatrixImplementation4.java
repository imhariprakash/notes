/**
    Question: 1.8. Zero matrix: If an element in an M x N matrix is 0, set its entire row and column to 0.
     *  Implementation 4:
        * O(1) space - use the first row and first column of the matrix itself as the markers (instead of separate arrays):
            1. Before marking, check separately if the first row has a zero and if the first column has a zero (two flags).
            2. First pass (from index 1): for every zero at (i, j), mark matrix[0][j] = 0 and matrix[i][0] = 0.
            3. Second pass: zero out every row i whose matrix[i][0] == 0, and every column j whose matrix[0][j] == 0.
            4. Finally, zero out the first row if its flag is set, and the first column if its flag is set.
    * Why the two flags?
     *  The first row and first column get overwritten with markers, so I lose whether they ORIGINALLY had a zero.
     *  Saving that up front (before marking) keeps the original information.
     *  They must be two separate flags - one shared flag zeroes both even when only one had a zero (see Implementation4Wrong).
    * Why the first row/column are zeroed LAST?
     *  They hold the markers. Zeroing them earlier would overwrite the markers before the second pass reads them.
    * Why it still works when the first row/column already have original zeroes:
     *  An original zero at [0][j] means column j must be zeroed anyway - so it already acts as a correct marker.
     *  Same for an original zero at [i][0] -> row i.
    * Complexity:
     *  Time  : O(M * N) to mark + O(M * N) to zero rows + O(N * M) to zero columns -> O(M * N)
     *  Space : O(1) - only two booleans (best possible for this problem).
 */
public class ZeroMatrixImplementation4
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
        ZeroMatrixImplementation4.setZeroesToMatrix(matrix);
        ZeroMatrixImplementation4.printMatrix(matrix);
    }

    private static void setZeroesToMatrix(int[][] matrix)
    {
        boolean isFirstRowHasZero = ZeroMatrixImplementation4.isFirstRowHasZero(matrix);
        boolean isFirstColumnHasZero = ZeroMatrixImplementation4.isFirstColumnHasZero(matrix);
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                ZeroMatrixImplementation4.setRowToZero(matrix, i);
            }
        }
        for(int i = 1; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                ZeroMatrixImplementation4.setColumnToZero(matrix, i);
            }
        }
        if(isFirstRowHasZero)
        {
            ZeroMatrixImplementation4.setRowToZero(matrix, 0);
        }
        if(isFirstColumnHasZero)
        {
            ZeroMatrixImplementation4.setColumnToZero(matrix, 0);
        }
    }

    private static boolean isFirstRowHasZero(int[][] matrix)
    {
        //Is first row has any zero elements
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isFirstColumnHasZero(int[][] matrix)
    {
        //Is first column has any zero elements
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                return true;
            }
        }
        return false;
    }

    private static void setRowToZero(int[][] matrix, int rowIndex)
    {
        for(int i = 0; i < matrix[rowIndex].length; i++)
        {
            matrix[rowIndex][i] = 0;
        }
    }

    private static void setColumnToZero(int[][] matrix, int columnIndex)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            matrix[i][columnIndex] = 0;
        }
    }

    private static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print("[");
            for(int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}