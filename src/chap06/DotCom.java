package chap06;

import java.util.ArrayList;

public class DotCom{
    //private ArrayList<String> locArray;
    public ArrayList<String> locationCells;

    public DotCom(){}
    public DotCom(DotCom Dcom){
        this.locationCells = Dcom.locationCells;
    }
    public void setLocationCells(ArrayList<String> loc2)
    {
        locationCells = loc2;
    }
    
    public String checkYourself(String userInput)
    {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            System.out.println("\n....userInput "+userInput+" hit!....removing from array index:"+ Integer.toString(index));
            if (locationCells.isEmpty()) {
                result = "kill";
            }
            else
            {
                result = "hit";
            }
        }else {
        System.out.println("ERROR searching index of string: "+ userInput);
        }
        return result;
    }

    //TODO:  all the following code was added and should have been included in the book
    private String name;
    public void setName(String string) {
        name = string;
    }
}
