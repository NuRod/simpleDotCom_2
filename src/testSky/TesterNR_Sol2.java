package testSky;

public class TesterNR_Sol2 {

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
        int a = 53;
        int b = 1253345;

        System.out.println("\n* * * Test , A:"+ a + " B:"+b);

        //String userGuess = in.nextLine();

        Solution sol= new Solution();
        int c = sol.solution(a,b);
        System.out.println("* Solution is in pos.:"+ c);

        /*
        * User Test 2
        * */
        a= 53;
        b = 11253345;

        System.out.println("\n* * * Test , A:"+ a + " B:"+b);

        //String userGuess = in.nextLine();

        sol= new Solution();
        c = sol.solution(a,b);
        System.out.println("* Solution is in pos.:"+ c);

        /*
        * User Test 3
        * */
        a= 53;
        b = 15334531;

        System.out.println("\n* * * Test , A:"+ a + " B:"+b);

        //String userGuess = in.nextLine();

        sol= new Solution();
        c = sol.solution(a,b);
        System.out.println("* Solution is in pos.:"+ c);

        /*
        * User Test 4 (neg)
        * */
        a= 53;
        b = 999999999;
        System.out.println("\n* * * Test , A:"+ a + " B:"+b);

        sol= new Solution();
        c = sol.solution(a,b);
        System.out.println("* Solution is in pos.:"+ c);

        /*
        * User Test 5 (neg)
        * */
        a= 0;
        b = 0;
        System.out.println("\n* * * Test , A:"+ a + " B:"+b);

        sol= new Solution();
        c = sol.solution(a,b);
        System.out.println("* Solution is in pos.:"+ c);




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
