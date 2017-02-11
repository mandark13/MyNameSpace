package epi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class IpGeneration
{


    public static void main(String[] args)
    {
        System.out.println(getIpAddresses("19216811"));
    }
    public static List<String> getIpAddresses(String s)
    {
        List<String> ips = new ArrayList<>();


        for (int i = 1; i < 4 && i < s.length(); i++)
        {
            String first = s.substring(0,i);

            if (valid(first))
            {
                for (int j = 1; j < 4 && i+j < s.length(); j++)
                {
                    String second = s.substring(i,i+j);

                    if (valid(second))
                    {
                        for (int k = 1; k < 4 && i+j+k < s.length(); k++)
                        {
                            String third = s.substring(i+j,i+j+k);
                            String fourth = s.substring(i+j+k);
                            if (valid(third) && valid(fourth))
                                ips.add(first+"."+second+"."+third+"." + fourth);
                        }
                    }
                }
            }
        }

        return ips;
    }

    private static boolean valid(String s)
    {
        if (s.length() > 3)
            return false;
        if (s.startsWith("0") && s.length() > 1)
            return false;

        int v = Integer.parseInt(s);

        return v <= 255 && v >= 0;
    }
}
