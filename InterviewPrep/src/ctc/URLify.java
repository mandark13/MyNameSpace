package ctc;

import java.util.Arrays;

/**
 * Created by Shalini Hemachandran on 2/5/2017.
 */
public class URLify
{


    public static void main(String[] args)
    {
        System.out.println(urlify("Mr John Smith", 13));
    }

    public static String urlify(String s, int totalLength)
    {
        char[] chars = s.toCharArray();

        int spaceCount = 0;

        for (char aChar : chars)
        {
            if (aChar == ' ')
                spaceCount++;
        }


        int index = totalLength + spaceCount * 2;


        char[] newChars = Arrays.copyOf(chars, index);

        int j = index - 1;

        for (int i = chars.length - 1; i >= 0; i--)
        {
            if (chars[i] == ' ')
            {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            }
            else
            {
                newChars[j--] = chars[i];
            }
        }


        return new String(newChars);

    }
}
