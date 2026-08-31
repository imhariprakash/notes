import java.util.Map;
import java.util.HashMap;

public class FrequencyOfAInB
{
    public static void main(String[] args)
    {
      /*
        * Previously calculating frequency for each window caused: O( B * S)
        * Current: Only the current incoming element: add, outgoing element: sub - using memoization
        * Printing index: hence O(B)
        * If printing the string itself : O(B * S) : S for printing substring
      */
        String small = "abbc";
        String large = "cbabadcbbabbcbabaabccbabc"; 
        
        if (small == null || large == null || small.isEmpty() || large.isEmpty()) 
        {
            throw new IllegalArgumentException("Input strings must not be null or empty");
        }

        if (small.length() > large.length()) 
        {
            return; // No matches possible, exit gracefully
        }

        Map<Character, Integer> frequencyOfSmall = getFrequency(small);
        int uniqueCharCountInSmall = frequencyOfSmall.size();
        Map<Character, Integer> frequencyOfWindow = getFrequency(large, 0, small.length() - 2);
        int matchedCharCount = getMatchedCharCount(frequencyOfSmall, frequencyOfWindow);
        
        for(int i = small.length() - 1; i < large.length(); i++)
        {
            int windowStartingIndex = i - (small.length() - 1);
            
            // --- INCOMING CHARACTER ---
            char incomingChar = large.charAt(i);
            int prevIncomingFreq = frequencyOfWindow.getOrDefault(incomingChar, 0);
            int currIncomingFreq = prevIncomingFreq + 1;
            frequencyOfWindow.put(incomingChar, currIncomingFreq);
            
            matchedCharCount = getUpdatedMatchedCount(incomingChar, prevIncomingFreq, currIncomingFreq, frequencyOfSmall, matchedCharCount);

            // --- EVALUATE MATCH ---
            if(matchedCharCount == uniqueCharCountInSmall)
            {
                System.out.println("(" + windowStartingIndex + "," + i + ")");
            }

            // --- OUTGOING CHARACTER ---
            char outgoingChar = large.charAt(windowStartingIndex);
            int prevOutgoingFreq = frequencyOfWindow.getOrDefault(outgoingChar, 0);
            int currOutgoingFreq = prevOutgoingFreq - 1;
            frequencyOfWindow.put(outgoingChar, currOutgoingFreq);
            
            matchedCharCount = getUpdatedMatchedCount(outgoingChar, prevOutgoingFreq, currOutgoingFreq, frequencyOfSmall, matchedCharCount);
        }
    }

    private static int getUpdatedMatchedCount(char ch, int prevFreq, int currFreq, Map<Character, Integer> frequencyOfSmall, int matchedCount)
    {
        if (!frequencyOfSmall.containsKey(ch))
        {
            return matchedCount;
        }

        int targetFrequency = frequencyOfSmall.get(ch);
        boolean wasMatch = (prevFreq == targetFrequency);
        boolean isMatch = (currFreq == targetFrequency);

        if (!wasMatch && isMatch)
        {
            ++matchedCount;
        }
        else if (wasMatch && !isMatch)
        {
            --matchedCount;
        }

        return matchedCount;
    }

    private static int getMatchedCharCount(Map<Character, Integer> frequencyMapA, Map<Character, Integer> frequencyMapB)
    {
        int matchedCharCount = 0;
        for(Character ch : frequencyMapA.keySet())
        {
            if(frequencyMapB.containsKey(ch) && frequencyMapA.get(ch).equals(frequencyMapB.get(ch)))
            {
                ++matchedCharCount;
            }
        }
        return matchedCharCount;
    }

    private static Map<Character, Integer> getFrequency(String str)
    {
        return getFrequency(str, 0, str.length() - 1);
    }

    private static Map<Character, Integer> getFrequency(String str, int startIndex, int endIndex)
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = startIndex; i <= endIndex; i++)
        {
            frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        return frequencyMap;
    }
}
