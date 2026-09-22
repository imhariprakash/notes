public class CompressStringUsingConcat 
{
    public static void main(String[] args) 
    {
        String str = "aabcccccaaa";
        System.out.println(getCompressedString(str));
    }

    private static String getCompressedString(String str) 
    {
        if (str == null || str.isEmpty()) 
        {
            return str;
        }

        String compressedString = "";
        int characterCount = 0;

        for (int i = 0; i < str.length(); i++) 
        {
            characterCount++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
            {
                compressedString += str.charAt(i) + String.valueOf(characterCount);
                characterCount = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString : str;
    }
}
