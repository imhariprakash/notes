 class IsPermutationOfPalindrome
{
    /*
        * Assumptions: chat set: a-z - ignore others
    */
    public static void main(String[] args)
    {
        char[] str = {'t', 'a', 'c', 't', 'c', 'o', 'a', 'p', 'a', 'p', 'a'};
        int[] frequency = IsPermutationOfPalindrome.getFrequency(str);
        boolean isAtmostOneOdds = isAtmostOneOdds(frequency);
        System.out.println(isAtmostOneOdds);
    }

    private static boolean isAtmostOneOdds(int[] frequency) 
    {
        boolean isOddFound = false;
        for (int count : frequency) 
        {
            if (count % 2 == 1) 
            {
                if (isOddFound)
                {
                    return false;
                }
                isOddFound = true;
            }
        }
        return true;
    }

    private static int[] getFrequency(char[] str)
    {
        int[] frequency = new int['z' - 'a' + 1];
        for(char ch : str)
        {
            frequency[ch - 'a']++;
        }
        return frequency;
    }
}
