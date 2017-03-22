package chap06;

import java.util.ArrayList;
//commented
public class DotComTesterNR_final {

    public static void main(String[] args) {
        int numofGuesses =0;
        boolean isAlive = true;
        GameHelper helper = new GameHelper();
        DotCom dot = new DotCom();
        int randonNum = (int) (Math.random()*5);

        //int[] locations = {randonNum, randonNum+1, randonNum+2};
        ArrayList<String> locations = new ArrayList<String>();
        locations.add(""+ randonNum);
        locations.add(""+ randonNum+1);
        locations.add(""+ randonNum+2);

        dot.setLocationCells(locations);

        /*
        * Positive Tests
        * */

        System.out.println("\n* * * Positive Tests:");

        int [] posTest= {randonNum, randonNum+1, randonNum+2};
        testerRoutine("Pos: inside range", "hit and kill", posTest, dot);

        /*
        * Negative Tests
        * */

        System.out.println("\n* * * Negative Tests:");

        int [] negTests = {((randonNum == 0) ? (randonNum-5):randonNum-1), randonNum+3, randonNum+4};
        testerRoutine(" Neg: out of range:", "miss", negTests, dot);

        negTests = new int [] {randonNum, randonNum, randonNum};
        testerRoutine("Neg: same hit 3 times" ,"hit", negTests, dot);

        /*
        * User Tests
        * */
        System.out.println("\n* * * User Tests:");

        while( isAlive == true ){
            String userGuess = helper.getUserInput("gi'me a number:");
            String result = dot.checkYourself(userGuess);
            numofGuesses++;
            System.out.println("Test: userGuess="  + userGuess + //
                    " result:" + result );
            if (result.equals("kill")){
                isAlive=false;
                System.out.println("You took.. "+numofGuesses +" Guesses");
            }

        }
        System.out.println("\nReal locations were:");
        for (int i=0; i < locations.size();i++) {
            System.out.print("" + locations.get(i) + " ");
        }
    }

    public static String evaluator(String str, String expStr, String expStr2){
        //System.out.println("Debug:" + (str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "Passed" : "Failed"));
        return str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "- - -> Passed Ok. " : "- - ->  ! ! ! Failed ! ! ! ";
    }

    public static String evaluator(String str, String expStr){
        return evaluator(str,expStr,expStr);
    }


    public static void testerRoutine(String outTest,String testStrExpected, int[] testArray, Object objj){
        System.out.println("\n\t" + outTest);
        DotCom obj = (DotCom) objj;

        for (int i: testArray ) {
            String userGuess = Integer.toString(i);
            String result = obj.checkYourself(userGuess);

            System.out.print("Test: userGuess=" + userGuess + " result:" + result + " " );
            switch (testStrExpected) {
                case "hit and kill":
                    System.out.println("expected:" + testStrExpected + "\n Status:" + evaluator(result, "hit", "kill"));
                    break;
                case "hit":
                    System.out.println("expected:" + testStrExpected + "\n Status:" + evaluator(result, "hit"));
                    break;
                case "kill":
                    System.out.println("expected:" + testStrExpected + "\n Status:" + evaluator(result, "kill"));
                    break;
                case "miss":
                    System.out.println("expected:" + testStrExpected + "\n Status:" + evaluator(result, "miss"));
                    break;
            }
        }
    }

}
