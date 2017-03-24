import chap06.DotCom;
import chap06.GameHelper;
import java.util.ArrayList;

public class DotComTesterNR_final {
    // Done the game
    public static void main(String[] args)
    {
        int numofGuesses =0;

        GameHelper helper = new GameHelper();

        int randomNum = (int) (Math.random()*5);
        
        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        DotCom dot = setupIt(randomNum);
        //int[] locations = {randomNum, randomNum+1, randomNum+2};

        /*
        * Negative Tests
        * */
        System.out.println("\n* * * Negative Tests:");
        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        dot = setupIt(randomNum);

        int [] negTests = {((randomNum == 0) ? (randomNum+5):randomNum-1), randomNum+3, randomNum+4};
        testerRoutine(" Neg: out of range:", "miss", negTests, dot);


        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        dot = setupIt(randomNum);
        negTests = new int [] {(randomNum+1),(randomNum+1),(randomNum+1)};
        testerRoutine("Neg: same hit 3 times should fail 2n and 3rd" ,"hit miss miss", negTests, dot);

        /*
        * Positive Tests
        * */
        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        dot = setupIt(randomNum);

        System.out.println("\n* * * Positive Tests:");
        boolean isAlive = true;
        int [] posTest= {randomNum, (randomNum+1), (randomNum+2)};
        testerRoutine("Pos: inside range", "hit and kill", posTest, dot);


        /*
        * User Tests
        * */
        System.out.println("\n* * * User Tests:");
        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        dot = setupIt(randomNum);

        while( isAlive == true ){
            String userGuess = helper.getUserInput("gi'me a number [0;4]:");
            String result = dot.checkYourself(userGuess);
            numofGuesses++;
            System.out.println("Test: userGuess="  + userGuess + //
                    " result:" + result );
            if (result.equals("kill")){
                isAlive=false;
                System.out.println("You took.. "+numofGuesses +" Guesses"+ "(best: 3)");
            }

        }
        // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
        dot = setupIt(randomNum);
        System.out.println("\nReal locations were:");
        for (int i=0; i < dot.locationCells.size();i++) {
            System.out.print("" + dot.locationCells.get(i) + " ");
        }
    }
        
    // Should get the random number and return the dotCom filled with 3 numbers (consecutive numbers)
    public static DotCom setupIt(int randomNum){
         
        ArrayList<String> locations = new ArrayList<String>();
        locations.add(""+ randomNum);
        locations.add(""+ (randomNum+1));
        locations.add(""+ (randomNum+2));
        //System.out.println("\n* * * random number 0 :"+locations.get(0).toString());
        //System.out.println("\n* * * random number 1 :"+locations.get(1).toString());
        //System.out.println("\n* * * random number 2 :"+locations.get(2).toString());

        DotCom doto = new DotCom();
        doto.setLocationCells(locations);
        return doto;
    
    }

    public static String evaluator(String str, String expStr, String expStr2){
        //System.out.println("Debug:" + (str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "Passed" : "Failed"));
        return str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "- - -> Passed Ok. " : "- - ->  ! ! ! Failed ! ! ! ";
    }

    public static String evaluator(String str, String expStr){
        return evaluator(str,expStr,expStr);
    }

//testerRoutine(" Neg: out of range:", "miss", negTests, dot);
    public static void testerRoutine(String outTest,String testStrExpected, int[] testArray, Object objj) {
        System.out.println("\n\t" + outTest);
        DotCom obj = (DotCom) objj;
        int j=0;
        for (int i : testArray) {
            String userGuess = Integer.toString(i);
            String result = obj.checkYourself(userGuess);

            System.out.print("Test: userGuess=" + userGuess + " result:" + result + " ");
            switch (testStrExpected) {
                case "hit and kill":
                    if ( j == 2 ) System.out.println("expected:kill \n Status:" + evaluator(result, "kill"));
                    else System.out.println("expected:hit \n Status:" + evaluator(result, "hit"));
                    break;
                case "hit miss miss":
                    if ( j == 0 ) System.out.println("expected:hit \n Status:" + evaluator(result, "hit"));
                    else System.out.println("expected:miss \n Status:" + evaluator(result, "miss"));
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
            j++;
        }
    }

}
