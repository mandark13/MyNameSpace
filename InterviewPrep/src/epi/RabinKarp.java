package epi;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class RabinKarp
{


    public static void main(String[] args)
    {
        System.out.println(getIndex("ABC","GACGCCA"));
    }

    public static int getIndex(String s, String t)
    {

        if (s.length() > t.length())
            return -1;
        int pow = 1;
        int tHash = 0;
        int sHash = 0;
        int base = 26;

        for (int i = 0; i < s.length(); i++)
        {
            pow = i == 0 ? 1 : pow * base;
            tHash = tHash * base + t.charAt(i);
            sHash = sHash * base + s.charAt(i);
        }


        for (int i = s.length(); i < t.length(); i++)
        {
            if (tHash == sHash && t.substring(i - s.length(), i).equals(s))
            {
                return i - s.length();
            }

            //little confusion
            tHash -= t.charAt(i-s.length()) * pow;
            tHash = tHash * base + t.charAt(i);
        }

        if (tHash == sHash && t.substring(t.length() - s.length()).equals(s))
        {
            return t.length() - s.length();
        }

        return -1;
    }
}
