package epi;

import java.util.Arrays;

/**
 * Created by Shalini Hemachandran on 1/12/2017.
 */
public class ReplaceAsAndBs
{

    public static void main(String[] args)
    {

        System.out.println(Arrays.toString(replaceasAndBs("ccccccc")));

    }

    public static char[] replaceasAndBs(String s)
    {
        char[] string = s.toCharArray();

        int writeIdx = 0;
        int aCount = 0;
        for (int i = 0; i < string.length; i++)
        {
            if (string[i] != 'b' )
            {
                string[writeIdx++] = string[i];
            }

            if (string[i] == 'a')
            {
                aCount++;
            }

        }

        int currIdx = writeIdx - 1;
        writeIdx = writeIdx + aCount - 1;

        string = Arrays.copyOf(string, writeIdx + 1);

        while (currIdx >= 0)
        {
            if (string[currIdx] == 'a')
            {
                string[writeIdx--] = 'd';
                string[writeIdx--] = 'd';
            }
            else
            {
                string[writeIdx--] = string[currIdx];
            }

            currIdx--;
        }


        return string;





    }
}
