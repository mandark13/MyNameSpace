package ctc;

import java.util.Arrays;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class StringIsPermutation
{


    public static void main(String[] args)
    {
        System.out.println(isPermutation("PAL", "LAM"));
    }

    public static boolean isPermutation(String s, String t)
    {
        if (s.length() != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();


        Arrays.sort(sChars);
        Arrays.sort(tChars);



        return new String(sChars).equals(new String(tChars));

    }
}
