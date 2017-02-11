package epi;

/**
 * Created by Shalini Hemachandran on 1/11/2017.
 */
public class BaseConversion
{

    public static void main(String[] args)
    {

        System.out.println(convertBase("1001", 2, 10));

    }

    public static String convertBase(String number, int currentBase, int futureBase)
    {
        boolean isNegative = false;

        if (number.charAt(0) == '-')
        {
            isNegative = true;
        }

        int num = 0;


        for (int i = isNegative ? 1 : 0; i < number.length(); i++)
        {
            int digit = Character.isDigit(number.charAt(i)) ? number.charAt(i) - '0' : number.charAt(i) - 'A' + 10;
            num = num * currentBase + digit;
        }


        System.out.println("Number " + num);

        return isNegative ? "-" : "" + (num == 0 ? "0" : convertToBase(num, futureBase));
    }

    private static String convertToBase(int num, int futureBase)
    {
        if (num == 0)
            return "";
        return convertToBase(num/futureBase, futureBase) + (char)(num % futureBase >= 10 ? (num % futureBase) + 'A' - 10 : num % futureBase + '0');
    }
}
