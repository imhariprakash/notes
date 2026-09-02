/*
  * Space efficient - no substring creation (intutive)
  abc → swap → acb → print → swap-back → abc

                         abc
                 /        |        \
               abc       bac       cba
              /   \     /   \     /   \
            abc   acb  bac   bca  cba   cab
*/

public class Permutation
{
    public static void main(String[] args)
    {
        String str = "abc";
        permutation(str.toCharArray(), 0);
    }
    
    private static void permutation(char[] str, int prefix)
    {
        if(prefix == str.length - 1)
        {
            printCharArray(str);
        }
        else
        {
            for(int i = prefix; i < str.length; i++)
            {
                swap(str, i, prefix);
                permutation(str, prefix + 1);
                swap(str, prefix, i);
            }
        }
    }

    private static void swap(char[] str, int position1, int position2)
    {
        char temp = str[position1];
        str[position1] = str[position2];
        str[position2] = temp;
    }

    private static void printCharArray(char[] str)
    {
        for(char ch : str)
        {
            System.out.print(ch);
        }
        System.out.println();
    }
}


/*
                     [ | abc ]
                     prefix=0
                / i=0    | i=1    \ i=2
               /         |         \
          [ a | bc ] [ b | ac ] [ c | ba ]
           prefix=1   prefix=1   prefix=1
           /     \     /     \     /     \
        i=1     i=2  i=1     i=2  i=1     i=2
         /       \    /       \    /       \
    [ ab | c ] [ ac | b ] [ ba | c ] [ bc | a ] [ cb | a ] [ ca | b ]
     prefix=2   prefix=2   prefix=2   prefix=2   prefix=2   prefix=2
         |          |          |          |          |          |
       print      print      print      print      print      print
        abc        acb        bac        bca        cba        cab

[ | abc ]  prefix=0
│
├── i=0: swap(i=0, prefix=0)
│   abc → abc
│
│   [ a | bc ]  prefix=1
│   │
│   ├── i=1: swap(1,1)
│   │   abc → abc
│   │
│   │   [ ab | c ]  prefix=2
│   │   └── print: abc
│   │
│   │   ↩ swap-back(1,1)
│   │     abc → abc
│   │
│   └── i=2: swap(2,1)
│       abc → acb
│
│       [ ac | b ]  prefix=2
│       └── print: acb
│
│       ↩ swap-back(1,2)
│         acb → abc
│
│   ↩ return to prefix=0
│     swap-back(0,0)
│     abc → abc
│
├── i=1: swap(i=1, prefix=0)
│   abc → bac
│
│   [ b | ac ]  prefix=1
│   │
│   ├── i=1: swap(1,1)
│   │   bac → bac
│   │
│   │   [ ba | c ]  prefix=2
│   │   └── print: bac
│   │
│   │   ↩ swap-back(1,1)
│   │     bac → bac
│   │
│   └── i=2: swap(2,1)
│       bac → bca
│
│       [ bc | a ]  prefix=2
│       └── print: bca
│
│       ↩ swap-back(1,2)
│         bca → bac
│
│   ↩ return to prefix=0
│     swap-back(0,1)
│     bac → abc
│
└── i=2: swap(i=2, prefix=0)
    abc → cba

    [ c | ba ]  prefix=1
    │
    ├── i=1: swap(1,1)
    │   cba → cba
    │
    │   [ cb | a ]  prefix=2
    │   └── print: cba
    │
    │   ↩ swap-back(1,1)
    │     cba → cba
    │
    └── i=2: swap(2,1)
        cba → cab

        [ ca | b ]  prefix=2
        └── print: cab

        ↩ swap-back(1,2)
          cab → cba

    ↩ return to prefix=0
      swap-back(0,2)
      cba → abc
*/
