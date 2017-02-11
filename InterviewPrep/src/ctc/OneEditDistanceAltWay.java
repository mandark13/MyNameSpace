package ctc;

import java.util.Arrays;

/**
 * Created by Shalini Hemachandran on 2/6/2017.
 */
public class OneEditDistanceAltWay
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

        int i = calculateEditDistance(s, t, 0, 0);

        System.out.println(i);
        return i == 1;
    }

    public static int calculateEditDistance(String s, String t, int i, int j)
    {
        if (i == s.length())
            return 0;

        if (j == t.length())
            return 0;

        if (s.charAt(i) != t.charAt(j))
            return mini(calculateEditDistance(s, t, i + 1, j) +1, calculateEditDistance(s, t, i, j + 1) + 1, calculateEditDistance(s, t, i + 1, j + 1) + 1);

        return calculateEditDistance(s, t, i + 1, j + 1);
    }


    public static int mini(int... a)
    {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(a[0]);
        return a[0];

    }
}
