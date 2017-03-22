package chap05;
import java.util.ArrayList;

public class SimpleDotCom {
    //int[] locationCells;
    private ArrayList<String> locationCells;
    int numOfHits = 0;

    public void setLocationCells(ArrayList<String> locs)
    {
        locationCells = locs;
    }
    public void resetNumOfHits()
    {
        numOfHits = 0;
    }

    public String checkYourself(String stringGuess) {
        //int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        // stringGuess is in the array , then return the int index of the first occurrence or else is negative -1
        int index = locationCells.indexOf(stringGuess);
        if (index >= 0) {
            System.out.println("debug:"+stringGuess+" index:"+index+" cell:"+locationCells.get(index));
            //location positive i.e. found first occurrence
            locationCells.remove(index); //remove
            numOfHits++;
        if (locationCells.isEmpty()) result = "kill";
        else result = "hit";
        }
        System.out.println("debug:"+stringGuess+" index:"+index);
        /*String result = "miss";

        for (int cell: locationCells)
        {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length)
        {
            result = "kill";
            resetNumOfHits();
        }
        //System.out.println(result);
*/
        return result;
    }
}
