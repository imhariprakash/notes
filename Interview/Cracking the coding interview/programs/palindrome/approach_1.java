import java.util.Map;
import java.util.HashMap;

public class FrequencyOfAInB
{
  /*
    * O(B * S): each window - s char - s comparison
    * More optimisation: In case of non-existent characters: move i to non_char_index + 1 -> still O(B * S) in worst case - all are existing char of small string
  */
    public static void main(String[] args)
    {
        String small = "abbc";
        String large = "cbabadcbbabbcbabaabccbabc"; 
        Map<Character, Integer> frequencyOfSmall = getFrequencyOfString(small);
        for(int i = 0; i < large.length() - small.length(); i++)
        {
            printIfPalindrome(large, i, i + small.length() - 1, frequencyOfSmall);
        }
    }

    private static Map<Character, Integer> getFrequencyOfString(String str)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(Character ch : str.toCharArray())
        {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap;
    }

    private static void printIfPalindrome(String str, int startIndex, int endIndex, Map<Character, Integer> frequencyMap)
    {
        Map<Character, Integer> frequencyMapCopy = new HashMap<>(frequencyMap);
        for(int i = startIndex; i <= endIndex; i++)
        {
            boolean isCharacterAbsent = !frequencyMapCopy.containsKey(str.charAt(i));
            boolean isCharCountExceeds = isCharacterAbsent ? Boolean.FALSE : frequencyMapCopy.get(str.charAt(i)) < 1;
            if(isCharacterAbsent || isCharCountExceeds)
            {
                return;
            }
            frequencyMapCopy.put(str.charAt(i), frequencyMapCopy.get(str.charAt(i)) - 1);
        }
        System.out.println(str.substring(startIndex, endIndex + 1));
    }
}
