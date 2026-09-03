/*
  O(N) time, hash map: O(N): solution - not space efficient
*/

import java.util.HashMap;

public class DuplicateElementsOfAInB 
{
    public static void main(String[] args) 
    {
        int[] arrayA = {13, 27, 35, 40, 49, 55, 59};
        int[] arrayB = {17, 35, 39, 40, 55, 58, 60};
        HashMap<Integer, Boolean> mapB = new HashMap<>();

        for(int i : arrayB)
        {
            mapB.put(i, Boolean.TRUE);
        }

        for(int i : arrayA)
        {
            if(mapB.getOrDefault(i, Boolean.FALSE))
            {
                System.out.println("Element " + i + " is found");
            }
        }
    }
}
