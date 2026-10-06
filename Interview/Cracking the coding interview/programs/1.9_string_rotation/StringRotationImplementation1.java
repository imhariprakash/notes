/**
    Question: 1.9. String Rotation: check if s2 is a rotation of s1 using only one call to isSubstring.
     *  Implementation 1:
        * Brute force isSubString - on mismatch go back to (start of attempt) + 1, match only if index2 == subString.length().
    * Complexity:
     *  Time  : isSubString O(N * M) -> isRotatedString O(N^2) (searching N chars inside 2N chars)
     *  Space : O(N) for rotatedString + rotatedString (isSubString itself is O(1))
 */
public class StringRotationImplementation1
{
    public static void main(String[] args) 
    {
        String string = "watermelon";
        String rotatedString = "ermelonwat";
        boolean isRotatedString = StringRotationImplementation1.isRotatedString(string, rotatedString);
        System.out.println(isRotatedString);
    }

    private static boolean isRotatedString(String string, String rotatedString)
    {
        // string = xy, rotatedString = yx  (watermelon: x = wat, y = ermelon -> ermelonwat)
        // yx + yx = y(xy)x -> always contains xy, so one isSubString call is enough
        // Lengths must match - else "water" is found inside "ermelonwatermelonwat"
        if(string.length() != rotatedString.length())
        {
            return false;
        }
        return isSubString(rotatedString + rotatedString, string);
    }

    private static boolean isSubString(String string, String subString)
    {
        int index1 = 0;
        int index2 = 0;
        while(string.length() > index1 && subString.length() > index2)
        {
            if(string.charAt(index1) == subString.charAt(index2))
            {
                index1++;
                index2++;
            }
            else
            {
                index1 = index1 - index2 + 1;
                index2 = 0;
            }
        }
        return index2 == subString.length();
    }
}
