package ctc;

/**
 * Created by Shalini Hemachandran on 1/12/2017.
 */
public class StringHasUniqueCharacters
{

    public static void main(String[] args)
    {
// other solution ask venky
        System.out.println(hasUniqueChars("aaaaaaa"));

    }

    static boolean hasUniqueChars(String string)
    {
        if (string.length() > 256)
            return false;
        boolean[] check = new boolean[256];

        for (int i = 0; i < string.length(); i++)
        {
            if (check[string.charAt(i)])
                return false;

            check[string.charAt(i)] = true;
        }

        return true;
    }


}
