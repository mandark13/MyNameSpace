package epi;

import java.util.Arrays;

/**
 * Created by Shalini Hemachandran on 1/12/2017.
 */
public class ReverseWordsInaSentence
{

    public static void main(String[] args)
    {
        System.out.println("Shalini implies evil");
        System.out.println(Arrays.toString(reverseWordsInaSentence("Shalini implies evil")));

    }
    public static char[] reverseWordsInaSentence(String string)
    {
        char[] charArray = string.toCharArray();
        reverse(0,charArray.length, charArray);


        int start = 0;
        for (int i = 0; i < charArray.length; i++)
        {

            if (charArray[i] != ' ')
                continue;

            reverse(start, i, charArray);
            start = i + 1;

        }

        reverse(start, charArray.length, charArray);

        return charArray;
    }

    private static void reverse(int start, int end, char[] charArray)
    {
        int stop = end - 1;
        while ( start < stop )
        {
            char tmp = charArray[start];
            charArray[start] = charArray[stop];
            charArray[stop] = tmp;
            start++;
            stop--;
        }
    }
}
