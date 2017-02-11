package epi;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class RunLengthEncoding
{

    public static void main(String[] args)
    {
        System.out.println(runLengthEncoding("aaaabcccaa"));
        System.out.println(runLengthDecoding("4a1b3c2a"));

    }
    public static String runLengthEncoding(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (i < s.length())
        {
            int count = 1;
            int j = i;
            while (((j+1) < s.length()) && (s.charAt(j) == s.charAt(j+1)))
            {
                count++;
                j++;
            }

            stringBuilder.append(count+"");
            stringBuilder.append(s.charAt(i));
            i = i + count;
        }

        return stringBuilder.toString();
    }

    public static String runLengthDecoding(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++)
        {

            if (Character.isDigit(s.charAt(i)))
            {
                count = count * 10 + s.charAt(i) - '0';
            }
            else
            {
                System.out.println("Count " + count);
                for (int j = 0; j < count; j++)
                {
                    stringBuilder.append(s.charAt(i));
                }
                count = 0;
            }
        }

        return stringBuilder.toString();
    }
}
