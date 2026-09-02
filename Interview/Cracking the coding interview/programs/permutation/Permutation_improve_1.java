/*
  * 1st program: Permutation.java - doesnt prints lexicographically:
    abc
    acb
    bca
    bac
    cab
    cba
  * Now changed that to print lexicographically: swapped how remaining string is calculated - first substring must come first
  * No change in space, time, depth
*/

public class Permutation
{
    public static void main(String[] args)
    {
        String str = "abc";
        permutation(str, "");
    }
    
    private static void permutation(String str, String prefix)
    {
        if(str.length() == 0)
        {
            System.out.println(prefix);
        }
        else
        {
            for(int i = 0; i < str.length(); i++)
            {
                String remaining =  str.substring(0, i) + str.substring(i + 1);
                permutation(remaining, prefix + str.charAt(i));
            }
        }
    }
}
