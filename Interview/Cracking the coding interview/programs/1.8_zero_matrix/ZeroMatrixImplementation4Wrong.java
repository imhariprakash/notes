/**
    Question: 1.8. Zero matrix: If an element in an M x N matrix is 0, set its entire row and column to 0.
     *  Implementation 4 (WRONG - kept for reference):
        * O(1) space - use the first row and first column of the matrix itself as the markers:
            1. Before marking, check if the first row / first column originally has a zero (single flag here - this is the bug).
            2. First pass (from index 1): for every zero at (i, j), mark matrix[0][j] = 0 and matrix[i][0] = 0.
            3. Second pass: zero out every row i whose matrix[i][0] == 0, and every column j whose matrix[0][j] == 0.
            4. Finally, if the flag is set, zero out the first row and the first column.
    * Why it fails?
     *  I used ONE flag (isFirstRowOrColumnHasZero) for TWO different facts:
            - does the first row have a zero?
            - does the first column have a zero?
     *  If only one of them has a zero, step 4 still zeroes BOTH the first row and the first column.
     *  Failing example:
            input    [[2, 0, 8], [3, 5, 5]]
            expected [[0, 0, 0], [3, 0, 5]]
            got      [[0, 0, 0], [0, 0, 5]]   -> (1, 0) wrongly zeroed
            Only the first row had a zero (at [0][1]), but the first column also got wiped.
     *  The test in main() passes only by luck - its zero is at [0][0], which belongs to both the first row and the first column.
    * Fix: use two separate flags - firstRowHasZero and firstColumnHasZero - and zero each one only if its own flag is set.
    * What is still correct here:
     *  - Starting the first pass from index 1, so the markers don't mix with the first row/column check.
     *  - Zeroing the first row/column LAST - doing it earlier would overwrite the markers before they are read.
    * Complexity (once fixed):
     *  Time  : O(M * N)
     *  Space : O(1)
 */
public class ZeroMatrixImplementation4Wrong
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
        ZeroMatrixImplementation4Wrong.setZeroesToMatrix(matrix);
        ZeroMatrixImplementation4Wrong.printMatrix(matrix);
    }

    private static void setZeroesToMatrix(int[][] matrix)
    {
        boolean isFirstRowOrColumnHasZero = ZeroMatrixImplementation4Wrong.isFirstRowOrColumnHasZero(matrix);
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
                ZeroMatrixImplementation4Wrong.setRowToZero(matrix, i);
            }
        }
        for(int i = 1; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                ZeroMatrixImplementation4Wrong.setColumnToZero(matrix, i);
            }
        }
        if(isFirstRowOrColumnHasZero)
        {
            ZeroMatrixImplementation4Wrong.setRowToZero(matrix, 0);
            ZeroMatrixImplementation4Wrong.setColumnToZero(matrix, 0);
        }
    }

    private static boolean isFirstRowOrColumnHasZero(int[][] matrix)
    {
        //Is first column has any zero elements
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                return true;
            }
        }
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