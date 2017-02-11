package coursera;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * Created by Shalini Hemachandran on 1/10/2017.
 */
public class KaratsubaMultiplication
{

    public static void main(String[] args)
    {

        BigInteger num1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");

        BigInteger num2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627") ;

        BigInteger product = karatsuba(num1, num2);

        System.out.println(product);

    }

    public static BigInteger karatsuba(BigInteger num1, BigInteger num2)
    {


        if (num1.compareTo(new BigInteger("10")) == -1 || num2.compareTo(new BigInteger("10")) == -1 )
        {
            return num1.multiply(num2);
        }
        int size = Math.max(num1.toString().length(), num2.toString().length());
        int halfSize = (int) Math.floor(size/2);


        double pow = Math.pow(10, halfSize);

        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(0);
        String s = decimalFormat.format(pow);

        String s2 = decimalFormat.format(Math.pow(10, 2*halfSize));


        BigInteger[] highLow1 = num1.divideAndRemainder(new BigInteger(s));
        BigInteger[] highLow2 = num2.divideAndRemainder(new BigInteger(s));

        BigInteger lastTerm = karatsuba(highLow1[1], highLow2[1]);
        BigInteger middleTerm = karatsuba(highLow1[1].add(highLow1[0]), highLow2[1].add(highLow2[0]));
        BigInteger firstTerm = karatsuba(highLow1[0], highLow2[0]);

        return firstTerm.multiply(new BigInteger(s2)).add(middleTerm.subtract(firstTerm).subtract(lastTerm).multiply(new BigInteger(s))).add(lastTerm);
    }
}
