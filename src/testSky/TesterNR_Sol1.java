package testSky;
import java.util.ArrayList;
import java.util.Scanner;

public class TesterNR_Sol1 {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int N = in.nextInt();

        //GameHelper helper = new GameHelper();
        //SimpleDotCom dot = new SimpleDotCom();
        //int randonNum = (int) (Math.random()*5);

        //int[] locations = {randonNum, randonNum+1, randonNum+2};

        /*
        * User Test 1
        * */
        System.out.println("\nPrint N numbers and substitute the ones multiple than 3,5,7 by strings ");
        int n = 15;
        Solution sol=new Solution();

        sol.solution(n);






    }






    public static String evaluator(String str, String expStr, String expStr2){
        //System.out.println("Debug:" + (str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "Passed" : "Failed"));
        return str.equalsIgnoreCase(expStr) || str.equalsIgnoreCase(expStr2) ? "- - -> Passed Ok. " : "- - ->  ! ! ! Failed ! ! ! ";
    }

    public static String evaluator(String str, String expStr){
        return evaluator(str,expStr,expStr);
    }


    public static void testerRoutine(String outTest,String testStrExpected, int[] testArray, Object objj){
       /* System.out.println("\n\t" + outTest);
        SimpleDotCom obj = (SimpleDotCom) objj;

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
        }*/
    }

}
