public class IsOneEditAwayMerged 
{
    /*
      * Time: 
        * Best case: When length of string 1 and 2 differs more than 1 (early exit)
        * Worst case: same length : O(n)
        * Average: O(n): where n is the length of shorter string!
      * Space: No auxillary space: O(1)
    */
    public static void main(String[] args) 
    {
        String first = "pale";
        String second = "bale";

        boolean result = first.length() > second.length()
                ? isOneEditAway(first, second)
                : isOneEditAway(second, first);

        System.out.println(result);
    }

    private static boolean isOneEditAway(String longer, String shorter) 
    {
        if (longer.length() - shorter.length() > 1) 
        {
            return false;
        }

        int indexLonger = 0;
        int indexShorter = 0;
        boolean isDifferenceFound = false;

        while (indexLonger < longer.length() && indexShorter < shorter.length()) 
        {
            if (longer.charAt(indexLonger) != shorter.charAt(indexShorter)) 
            {
                if (isDifferenceFound) 
                {
                    return false;
                }
                isDifferenceFound = true;

                indexLonger++;
                if (longer.length() == shorter.length()) 
                {
                    indexShorter++;
                }
            } 
            else 
            {
                indexLonger++;
                indexShorter++;
            }
        }
        return true;
    }
}
