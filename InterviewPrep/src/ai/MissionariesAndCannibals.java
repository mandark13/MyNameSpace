package ai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalini Hemachandran on 1/28/2017.
 */
public class MissionariesAndCannibals
{

    List<Integer> possibleBinaryStrings = new ArrayList<>();

    public void recurse(int aggregate, List<List<Integer>> possibleValues, List<Integer> tmpList)
    {

        if (aggregate == 1)
        {
            possibleValues.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < possibleBinaryStrings.size(); i++)
        {
            Integer binaryString = possibleBinaryStrings.get(0);

            if (valid(binaryString, aggregate))
            {
                tmpList.add(binaryString);
                recurse(aggregate | binaryString, possibleValues, tmpList);
                tmpList.remove(binaryString);
            }
        }
    }

    private boolean valid(Integer binary, Integer aggregate)
    {
        int currentAggr = binary | aggregate;
        String currAggrString = String.valueOf(currentAggr);
        int noOfCannibals = 0;
        for (int i = 0; i < 3; i++)
        {
            if (currAggrString.charAt(i) == 0)
                continue;
            noOfCannibals++;
        }

        int noOfMissionaries = 0;
        for (int i = 3; i < currAggrString.length(); i++)
        {
            if (currAggrString.charAt(i) == 0)
                continue;
            noOfMissionaries++;
        }
        return noOfCannibals <= noOfMissionaries;
    }

}
