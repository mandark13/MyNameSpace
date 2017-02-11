package epi;

/**
 * Created by Shalini Hemachandran on 1/12/2017.
 */
public class TestPalindrome
{


    public static void main(String[] args)
    {

        System.out.println(testPalindrome("A man, a plan, a canal, Panama"));
        System.out.println(testPalindrome("Ray a ray"));
    }

    static boolean testPalindrome(String string)
    {
        int i = 0; int j = string.length() - 1;

        while (i < j)
        {
            while (!Character.isLetterOrDigit(string.charAt(i)) && i < j)
                ++i;
            while (!Character.isLetterOrDigit(string.charAt(j)) && i < j)
                --j;
            if (Character.toLowerCase(string.charAt(i)) != Character.toLowerCase(string.charAt(j)))
                return false;

            ++i;
            --j;
        }

        return true;

    }
}
