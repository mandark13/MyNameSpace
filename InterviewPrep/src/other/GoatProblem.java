package other;

/**
 * Created by Shalini Hemachandran on 1/28/2017.
 */
public class GoatProblem
{

    public static void main(String[] args)
    {

    }

    public int maxGrass(int[][] a, int i , int j)
    {
        if (i == a.length || j == a[0].length)
            return 0;
        return a[i][j] == 1 ? 1 + Math.max(maxGrass(a, i, j-1), maxGrass(a, i+1, j)) :  Math.max(maxGrass(a, i, j-1), maxGrass(a, i+1, j));
    }

}
