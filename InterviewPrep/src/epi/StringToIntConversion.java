package epi;

/**
 * Created by Shalini Hemachandran on 1/11/2017.
 */
public class StringToIntConversion
{

    public static void main(String[] args)
    {

        System.out.println(convertStringToInt("-12345678"));
        System.out.println(convertIntToString(-12345678));

    }
    public static int convertStringToInt(String number)
    {
        boolean isNegative = number.charAt(0) == '-';

        int result = 0;
        for (int i = isNegative ? 1 : 0; i < number.length(); i++)
        {
            int digit = number.charAt(i) - '0';
            result = result * 10 + digit;
        }

        return isNegative ? -result : result;
    }

    public static String convertIntToString(int number)
    {
        boolean isNegative = false;
        if (number < 0)
        {
            number = -number;
            isNegative = true;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (number != 0)
        {
            int remainder = number % 10;
            stringBuilder.append(remainder+"");
            number = number / 10;
        }

        if (isNegative)
            stringBuilder.append("-");
        return stringBuilder.reverse().toString();
    }
}
