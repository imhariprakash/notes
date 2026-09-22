public class IsOneEditAwaySeparateLogicWithOptimisation
{
    /* 
      * Removed nested if - inside main
      * No need for if (second.length() > indexOfSecond) logic, redundant: isDifferenceFound variable in insertion function
    */
    public static void main(String[] args) 
    {
        String first = "pale";
        String second = "bale";

        boolean result;
        if (first.length() == second.length()) 
        {
            result = isOneReplacementAway(first, second);
        } 
        else if (first.length() - second.length() == 1) 
        {
            result = isOneInsertionAway(first, second); // first is longer
        } 
        else if (second.length() - first.length() == 1) 
        {
            result = isOneInsertionAway(second, first); // second is longer
        } 
        else 
        {
            result = false; // Length difference >= 2
        }

        System.out.println(result);
    }

    // Lengths are identical: checks for <= 1 character replacement
    private static boolean isOneReplacementAway(String s1, String s2) 
    {
        boolean differenceFound = false;
        for (int i = 0; i < s1.length(); i++) 
        {
            if (s1.charAt(i) != s2.charAt(i)) 
            {
                if (differenceFound) 
                {
                    return false;
                }
                differenceFound = true;
            }
        }
        return true;
    }

    // 'longer' is strictly 1 character longer than 'shorter'
    private static boolean isOneInsertionAway(String longer, String shorter) 
    {
        int indexLonger = 0;
        int indexShorter = 0;

        while (indexLonger < longer.length() && indexShorter < shorter.length()) 
        {
            if (longer.charAt(indexLonger) != shorter.charAt(indexShorter)) 
            {
                // If pointers are already desynchronized, this is a 2nd mismatch
                if (indexLonger != indexShorter) 
                {
                    return false;
                }
                indexLonger++; // Skip inserted char in longer string
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
