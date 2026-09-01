/*
  * Intuitive - just write the tree: just written code what i done: loop -> prefix, remaining (order maintained): a, bc -> ab, c -> abc
  * Issues: multiple substrings - more memory, more garbage collection, repeated char produces duplicate permutations
  * Can't pass index alone - any order! - not possible by passing index instead of substring
*/

/*
                   abc
              /     |      \
          a,bc     b,ca    c, ab
        /     \   /   \    /   \
      ab,c  ac,b bc,a ba,c ca,b cb,c
      abc   acb  bca  bac  cab  cbc
*/

public class Permutation
{
    public static void main(String[] args)
    {
        String str = "abcd";
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
                String remaining = str.substring(i + 1) + str.substring(0, i);
                permutation(remaining, prefix + str.charAt(i));
            }
        }
    }
}
