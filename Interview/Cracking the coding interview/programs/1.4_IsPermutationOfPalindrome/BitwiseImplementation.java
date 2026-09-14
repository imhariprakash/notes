public class IsPermutationOfPalindrome {
    /*
     * Assumptions: Character set is strictly 'a' through 'z'.
     *
     * Complexity:
     *   - Time Complexity:  O(N) single pass over the array
     *   - Space Complexity: O(1) auxiliary space (one 32-bit integer)
     *
     * Core Bitwise Insight:
     *   - XOR (^) toggles each character's bit: 0 -> odd, 1 -> even.
     *   - (n & (n - 1)) clears the Lowest Significant Bit (LSB).
     *   - If the result is 0, the number has at most one bit set
     *     (0 bits for even-length palindromes, 1 bit for odd-length).
    */
    public static void main(String[] args) {
        char[] str = {'t', 'a', 'c', 't', 'c', 'o', 'a', 'p', 'a', 'p', 'a'};
        boolean isPermutation = isPermutationOfPalindrome(str);
        System.out.println(isPermutation);
    }

    private static boolean isPermutationOfPalindrome(char[] str) {
        int oddFrequencyCharacters = 0;

        for (char ch : str) {
            oddFrequencyCharacters ^= (1 << (ch - 'a'));
        }

        return (oddFrequencyCharacters & (oddFrequencyCharacters - 1)) == 0;
    }
}

/*
  public static void main(String[] args) 
  {
        // Test 1: Given problem case (tactcoapapa -> tacapopacat)
        test("tactcoapapa".toCharArray(), true);

        // Test 2: All characters have even frequencies
        test("abba".toCharArray(), true);

        // Test 3: Single character
        test("a".toCharArray(), true);

        // Test 4: Two odd frequencies ('a' and 'b' each appear once)
        test("ab".toCharArray(), false);

        // Test 5: Classic CTCI example (tactcoa -> taco cat)
        test("tactcoa".toCharArray(), true);

        // Test 6: Three odd frequencies ('a', 'b', 'c')
        test("abc".toCharArray(), false);
    }
*/

/*
   * Core Bitwise Mechanics:
   * 1. XOR (^) toggles the bit for each character:
   *      odd occurrences  -> bit remains 1
   *      even occurrences -> bit flips back to 0
   *
   * 2. (n & (n - 1)) clears the Lowest Significant Bit (LSB):
   *      - 0 bits set (all even counts, e.g., "abba"):
   *          n = 0b0000 (0)
   *          n - 1 = -1 (all 1s in two's complement)
   *          0 & -1 == 0 -> true
   *
   *      - 1 bit set (one odd count, e.g., "tactcoa"):
   *          n     = 0b00010000 (16)
   *          n - 1 = 0b00001111 (15)
   *          n & (n - 1) == 0b00000000 (0) -> true
   *
   *      - 2+ bits set (multiple odd counts, e.g., "abc"):
   *          n     = 0b00000111 (7)
   *          n - 1 = 0b00000110 (6)
   *          n & (n - 1) == 0b00000110 != 0 -> false
*/
