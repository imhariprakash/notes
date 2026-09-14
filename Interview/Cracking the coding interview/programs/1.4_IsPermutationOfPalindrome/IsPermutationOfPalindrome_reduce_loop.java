public class IsPermutationOfPalindrome 
{
    /*
        * Not necessarily optimal - just shifts the loop - check frequency - atmostOnceOdd to the frequency funtion itself
    */
    public static void main(String[] args) 
    {
        char[] str = {'t', 'a', 'c', 't', 'c', 'o', 'a', 'p', 'a', 'p', 'a'};
        System.out.println(isPermutationOfPalindrome(str));
    }

    public static boolean isPermutationOfPalindrome(char[] str) 
    {
        int[] table = new int['z' - 'a' + 1];
        int countOdd = 0;

        for (char ch : str) 
        {
            if (ch >= 'a' && ch <= 'z') 
            {
                int index = ch - 'a';
                table[index]++;

                if (table[index] % 2 == 1) 
                {
                    countOdd++;
                } 
                else 
                {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }
}
