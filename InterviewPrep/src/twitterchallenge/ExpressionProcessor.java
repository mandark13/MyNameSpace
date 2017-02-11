package twitterchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalini Hemachandran on 1/23/2017.
 */
public class ExpressionProcessor
{

    public static void main(String[] args)
    {
        System.out.println(processExpression("(AB) C ((DE)F)/S"));
    }
    public static String processExpression(String expressionAndOper)
    {
        String[] split = expressionAndOper.split("/");

        if (split.length == 1 || split[1].isEmpty())
            return split[0];

        String operSequence = split[1];

        char[] chars = operSequence.toCharArray();

        String newString = null;
        String oldString = split[0];
        for (char aChar : chars)
        {
            switch (aChar)
            {
                case 'R':
                    char[] charArray = oldString.toCharArray();
                    reverse(charArray);
                    newString = new String(charArray);
                    break;
                case 'S':

                    newString = removeBraceAroundFirstExpAndFollSubExps(oldString);
                    break;
            }
            oldString = newString;
        }

        return newString;
    }

    private static String removeBraceAroundFirstExpAndFollSubExps(String oldString)
    {
        char[] chars = oldString.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();


        List<Integer> openBracketIdx = new ArrayList<>();
        List<Integer> closeBracketIdx = new ArrayList<>();
        List<Integer> bracketsToBeRemoved = new ArrayList<>();
        boolean metFirstOpen = false;

        for (int i = 0; i < chars.length; i++)
        {


            char c = chars[i];
            if (c == '(')
            {
                if (!metFirstOpen)
                {
                    metFirstOpen = true;
                    continue;
                }
                openBracketIdx.add(i);
            }

            if (c == ')')
            {
                if (openBracketIdx.size() > 1)
                {
                    bracketsToBeRemoved.add(openBracketIdx.remove(openBracketIdx.size() - 1));
                    bracketsToBeRemoved.add(i);
                }
            }

        }


        for (int i = 0; i < chars.length; i++)
        {
            if (bracketsToBeRemoved.contains(i))
            {
                continue;
            }
            stringBuilder.append(chars[i]);
        }

        String newString = stringBuilder.toString();

        metFirstOpen = false;
        char[] chars1 = newString.toCharArray();

        if (chars1[0] == '(')
        {
            for (int i = 0; i < chars1.length; i++)
            {

                if (!metFirstOpen && chars1[i] == '(')
                {
                    chars1[i] = ' ';
                    metFirstOpen = true;
                    continue;
                }

                if (metFirstOpen && chars1[i] == ')')
                {
                    chars1[i] = ' ';
                    break;
                }
            }
        }



            StringBuilder stringBuilder1 = new StringBuilder();

            for (char c : chars1)
            {
                if (c == ' ')
                {
                    continue;
                }
                stringBuilder1.append(c);
            }

            return stringBuilder1.toString();
        }





    private static void reverse(char[] charArray)
    {
        int start = 0;
        int stop = charArray.length - 1;
        while ( start < stop )
        {
            char tmp = charArray[start];
            charArray[start] = charArray[stop];
            charArray[stop] = tmp;
            start++;
            stop--;
        }

        for (int i = 0; i < charArray.length; i++)
        {
            if (charArray[i] == ')')
                charArray[i] = '(';
            else if (charArray[i] == '(')
                charArray[i] = ')';
        }
    }
}
