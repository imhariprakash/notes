public class CompressStringUsingStringConcat
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

        // Pre-size capacity to str.length() to prevent dynamic array re-allocations
        StringBuilder compressedString = new StringBuilder(str.length());
        int characterCount = 0;

        for (int i = 0; i < str.length(); i++) 
        {
            characterCount++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
            {
                compressedString.append(str.charAt(i)); 
                compressedString.append(characterCount);
                characterCount = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }
}
