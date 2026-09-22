public class CompressStringUsingStringBuilderAndPreCalculation
{
    public static void main(String[] args) 
    {
        String str = "aabcccccaaa";
        System.out.println(compress(str));
    }

    public static String compress(String str)
    {
        if (str == null || str.isEmpty()) 
        {
            return str;
        }

        int finalLength = getCompressedLength(str);
        if (finalLength >= str.length()) 
        {
            return str;
        }

        // Exact capacity allocated upfront — zero array copies or resizing
        StringBuilder compressed = new StringBuilder(finalLength);
        int characterCount = 0;

        for (int i = 0; i < str.length(); i++) 
        {
            characterCount++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
            {
                compressed.append(str.charAt(i));
                compressed.append(characterCount);
                characterCount = 0;
            }
        }

        return compressed.toString();
    }

    private static int getCompressedLength(String str)
    {
        int compressedLength = 0;
        int characterCount = 0;

        for (int i = 0; i < str.length(); i++) 
        {
            characterCount++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) 
            {
                // 1 char for the letter + digit count of the frequency (no String allocation)
                compressedLength += 1 + getDigitCount(characterCount);
                characterCount = 0;
            }
        }

        return compressedLength;
    }

    private static int getDigitCount(int count)
    {
        int digits = 0;
        while (count > 0)
        {
            digits++;
            count /= 10;
        }
        return digits;
    }
}
