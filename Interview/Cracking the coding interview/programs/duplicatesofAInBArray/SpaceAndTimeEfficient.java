/*
  * Input: 2 sorted arrays - like merging two sorted arrays: O(N) time, O(1): space possible
*/

public class DuplicateElementsOfAInB 
{
    public static void main(String[] args) 
    {
        int[] arrayA = {13, 27, 35, 40, 49, 55, 59};
        int[] arrayB = {17, 35, 39, 40, 55, 58, 60};

        int i = 0;
        int j = 0;

        while (i < arrayA.length && j < arrayB.length) 
        {
            if (arrayA[i] == arrayB[j]) 
            {
                System.out.println("Matched : " + arrayA[i] + " at index " + j + " of B.");
                i++;
                j++;
            } 
            else if (arrayA[i] < arrayB[j]) 
            {
                i++;
            } 
            else 
            {
                j++;
            }
        }
    }
}
