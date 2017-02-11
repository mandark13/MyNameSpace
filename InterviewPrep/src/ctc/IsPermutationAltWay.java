package ctc;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class IsPermutationAltWay
{


    public static void main(String[] args)
    {
        System.out.println(isPermutationAltWay("LAP", "PAM"));
    }

    public static boolean isPermutationAltWay(String s, String t)
    {

        if (s.length() != t.length())
            return false;

        int[] num = new int[128];

        for (int i = 0; i < s.length(); i++)
        {
            num[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++)
        {
            num[t.charAt(i)]--;

            if (num[t.charAt(i)] < 0)
                return false;
        }

        return true;

    }
}
