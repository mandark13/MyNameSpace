package other;

/**
 * Created by Shalini Hemachandran on 1/28/2017.
 */
public class DiceSum
{

    public static void main(String[] args)
    {

    }


    public int diceSumPossible(int sum, int faceValue)
    {

        if (sum == 0)
            return 1;

        if (sum < 0)
            return 0;

        int possibleWays = 0;
        for (int i = 1; i <= faceValue; i++)
        {
             possibleWays += diceSumPossible(sum - i, faceValue);
        }

        return possibleWays;

    }
}
