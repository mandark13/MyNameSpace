package ctc;

/**
 * Created by Shalini Hemachandran on 2/6/2017.
 */
public class OneEditDistance
{

    public static void main(String[] args)
    {
        System.out.println(isOneEditDistance("pale", "ple"));
        System.out.println(isOneEditDistance("pales", "pale"));
        System.out.println(isOneEditDistance("pale", "bale"));
        System.out.println(isOneEditDistance("pale", "bae"));
    }

    public static boolean isOneEditDistance(String s, String t)
    {
        if (s.length() == t.length())
            return isOneUpdateAway(s,t);

        if (s.length() < t.length())
            return isOneAddAway(s,t);

        if (s.length() > t.length())
            return isOneAddAway(t, s);

        return false;
    }


    private static boolean isOneAddAway(String s, String t)
    {
        if ((t.length() - s.length()) > 1)
        return false;

        int index1 = 0;
        int index2 = 0;

        while (index1 < s.length() && index2 < t.length())
        {
            if (s.charAt(index1) != t.charAt(index2))
            {
                if (index1 != index2)
                    return false;

                index2++;
            }
            else
            {
                index1++;
                index2++;
            }

        }

        return true;
    }

    private static boolean isOneUpdateAway(String s, String t)
    {
        boolean oneUpdate = false;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != t.charAt(i))
            {
                if (oneUpdate)
                    return false;
                oneUpdate = true;
            }
        }
        return true;
    }
}
