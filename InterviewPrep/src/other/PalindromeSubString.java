package other;

/**
 * Created by Shalini Hemachandran on 1/28/2017.
 */
public class PalindromeSubString
{

    public static void main(String[] args)
    {

    }


    public static int palidromeSubString(String s, int i, int j)
    {

        if (i == j)
            return 1;

        if (i > j)
            return 0;

        if (s.charAt(i) == s.charAt(j))
        {
            int length = palidromeSubString(s, i + 1, j - 1);
            if (length == (j - i - 2))
            {
                return s.length();
            }
            return Math.max(palidromeSubString(s, i, j - 1), palidromeSubString(s, i + 1, j));

        }
        else
        {
            return Math.max(palidromeSubString(s, i, j - 1), palidromeSubString(s, i + 1, j));
        }
    }
}
