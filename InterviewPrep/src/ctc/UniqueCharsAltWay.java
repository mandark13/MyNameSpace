package ctc;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class UniqueCharsAltWay
{


    public static void main(String[] args)
    {
        System.out.println(uniqueAltWay("abcs"));
    }

    public static boolean uniqueAltWay(String s)
    {
        int check = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int value = s.charAt(i);
            if ((check & (1 << value)) > 0)
            {
                return false;
            }

            check |= 1 << value;
        }

        return true;
    }
}
