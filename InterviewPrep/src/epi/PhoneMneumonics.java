package epi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalini Hemachandran on 1/23/2017.
 */
public class PhoneMneumonics
{
    public static final String[] MAPPING = new String[]{"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV", "WXYZ"};

    public static void main(String[] args)
    {
        System.out.println(computeMnemonics("2276696"));

    }

    public static List<String> computeMnemonics(String number)
    {
        List<String> mneumonics = new ArrayList<>();
        computeMneumonic(mneumonics,new char[number.length()], 0, number);
        System.out.println(mneumonics.contains("ACRONYM"));
        return mneumonics;
    }

    private static void computeMneumonic(List<String> mneumonics, char[] partialMneumonic, int length, String number)
    {
        if (length == number.length())
        {
            mneumonics.add(new String(partialMneumonic));
            return;
        }

        for (int i = 0; i < MAPPING[number.charAt(length) - '0'].length(); i++)
        {
            partialMneumonic[length] = MAPPING[number.charAt(length) - '0'].charAt(i);
            computeMneumonic(mneumonics, partialMneumonic, length + 1, number);
        }


    }
}
