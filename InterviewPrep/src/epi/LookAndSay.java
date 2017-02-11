package epi;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class LookAndSay
{


    public static void main(String[] args)
    {
        String string = getString(8);
        System.out.println(string);
    }

    public static String getString(int n)
    {
        String s = "1";

        for (int i = 1; i < n; i++)
        {
            s = nextString(s);
        }

        return s;
    }

    private static String nextString(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
        {
            int count = 1;
            while ( ((i+1) < s.length()) && s.charAt(i) == s.charAt(i + 1))
            {
                ++i;
                ++count;
            }
            stringBuilder.append(count+"");
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

}
