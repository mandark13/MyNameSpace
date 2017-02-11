package ctc;

import static ctc.PermutationOfPalindrome.getCharNumber;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class PermutationOfPalindromeAltWay
{

    public static void main(String[] args)
    {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome("Shalini h"));
    }

    public static boolean isPermutationOfPalindrome(String s)
    {
        int bit = 0;

        for (int i = 0; i < s.length(); i++)
        {
            bit = toggleBit(bit, s.charAt(i));
        }

        return (bit & (bit -1)) <= 1;
    }

    private static int toggleBit(int bit, char c)
    {


        int val = getCharNumber(c);

        if (val < 0)
            return bit;

        int maskValue = 1 << val;

        if ((bit & maskValue) == 0)
        {
            bit |= maskValue;
        }
        else
        {
            bit &= ~maskValue;
        }

        return bit;

    }
}
