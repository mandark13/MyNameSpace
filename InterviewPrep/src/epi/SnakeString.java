package epi;

/**
 * Created by Shalini Hemachandran on 2/4/2017.
 */
public class SnakeString
{

    public static void main(String[] args)
    {
        System.out.println(snakeString("Shalini Hemachandran"));
    }
    public static String snakeString(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t");

        for (int i = 1; i < s.length(); i += 4)
        {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append("\t");
        }

        stringBuilder.append("\n");

        for (int i = 0; i < s.length(); i += 2)
        {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append("\t");
            stringBuilder.append("\t");
        }
        stringBuilder.append("\n");
        for (int i = 3; i < s.length(); i += 4)
        {
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append("\t");
            stringBuilder.append(s.charAt(i));
            stringBuilder.append("\t");


        }

        return stringBuilder.toString();
    }
}
