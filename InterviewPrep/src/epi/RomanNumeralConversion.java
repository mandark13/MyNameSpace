package epi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class RomanNumeralConversion
{
    static Map<Character, Integer> charIntMap = new HashMap<>();

    static
    {
        charIntMap.put('I', 1);
        charIntMap.put('V', 5);
        charIntMap.put('X', 10);
        charIntMap.put('L', 50);
        charIntMap.put('C', 100);
        charIntMap.put('D', 500);
        charIntMap.put('M', 1000);
    }


    public static void main(String[] args)
    {
        System.out.println(convertRoman("LIX"));
    }

    public static int convertRoman(String s)
    {
        int sum = charIntMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; --i)
        {
            if (charIntMap.get(s.charAt(i)) < charIntMap.get(s.charAt(i+1)))
            {
                sum -= charIntMap.get(s.charAt(i));
            }
            else
            {
                sum += charIntMap.get(s.charAt(i));
            }
        }

        return sum;
    }
}
