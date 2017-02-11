package epi;

/**
 * Created by Shalini Hemachandran on 1/12/2017.
 */
public class ExcelColumnEncoding
{

    public static void main(String[] args)
    {

        System.out.println(encodeColumnName("AAA"));

    }
//ASK
    public static int encodeColumnName(String excelColumn)
    {

        if (excelColumn.length() == 1)
            return excelColumn.charAt(0) - 'A';

        int result = 0;
        for (int i = 0; i < excelColumn.length(); i++)
        {
            result = result * 26 + excelColumn.charAt(i) - 'A' + 1 ;
            /*if (result == 0)
                result = 1;*/
        }

        return result;

    }
}
