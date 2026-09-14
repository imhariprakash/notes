class ReplaceWhiteSpace
{
    public static void main(String[] args)
    {
        char[] str = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        int len = 13;
        int index = str.length - 1;
        
        for(int i = len - 1; i >= 0; i--)
        {
            if(str[i] == ' ')
            {
                replaceWhiteSpace(str, index);
                index = index - 3;
            }
            else
            {
                str[index] = str[i];
                --index;
            }
        }
        for(int i = 0; i < str.length; i++)
        {
            System.out.print(str[i]);
        }
    }

    private static void replaceWhiteSpace(char[] str, int index)
    {
        str[index] = '0';
        str[index - 1] = '2';
        str[index - 2] = '%';
    }
}
