 class IsOneEditAwaySeparateLogic
 {
    public static void main(String[] args)
    {
        String first = "pale";
        String second = "bale";
        boolean isOneEditAway = false;
        if(first.length() == second.length())
        {
            isOneEditAway = IsOneEditAwaySeparateLogic.isOneEditAway(first, second);
        }
        else
        {
            if(first.length() > second.length())
            {
                isOneEditAway = IsOneEditAwaySeparateLogic.isOneInsertionAway(first, second);
            }
            else
            {
                isOneEditAway = IsOneEditAwaySeparateLogic.isOneInsertionAway(second, first);
            }
        }
        System.out.println(isOneEditAway);
    }

    public static boolean isOneEditAway(String first, String second)
    {
        boolean isDifferenceFound = false;
        for(int indexOfFirst = 0; indexOfFirst < first.length(); indexOfFirst++)
        {
            if(first.charAt(indexOfFirst) != second.charAt(indexOfFirst))
            {
                if(isDifferenceFound)
                {
                    return false;
                }
                isDifferenceFound = true;
            }
        }
        return true;
    }

    public static boolean isOneInsertionAway(String first, String second)
    {
        if(first.length() - second.length() > 1)
        {
            return false;
        }
        int indexOfSecond = 0;
        boolean isDifferenceFound = false;
        for(int indexOfFirst = 0; indexOfFirst < first.length(); indexOfFirst++)
        {
            if(second.length() > indexOfSecond)
            {
                if(first.charAt(indexOfFirst) != second.charAt(indexOfSecond))
                {
                    if(isDifferenceFound)
                    {
                        return false;
                    }
                    isDifferenceFound = true;
                }
                else
                {
                    indexOfSecond++;
                }
            }
            else
            {
                if(isDifferenceFound)
                {
                    return false;
                }
                isDifferenceFound = true;
            }
        }

        return true;
    }

}
