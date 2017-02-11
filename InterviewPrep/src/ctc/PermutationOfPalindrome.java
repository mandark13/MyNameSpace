package ctc;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class PermutationOfPalindrome
{

    public static void main(String[] args)
    {
        System.out.println(isPalindromePermutation("Tact Coa"));
        System.out.println(isPalindromePermutation("Shalini h"));
    }


    public static boolean isPalindromePermutation(String s)
    {

        int[] table = new int[26];
        int countOdd = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int i1 = getCharNumber(s.charAt(i));

            if (i1 == -1)
                continue;

            table[getCharNumber(s.charAt(i))]++;

            if (table[getCharNumber(s.charAt(i))] % 2 == 1)
            {
                countOdd++;
            }
            else
            {
                countOdd--;
            }


        }

        return countOdd <= 1;

    }

    public static int getCharNumber(char c)
    {
        int a = Character.getNumericValue('a');

        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z)
        {
            return val - a;
        }

        return -1;
    }
}
