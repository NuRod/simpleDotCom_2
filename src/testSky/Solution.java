package testSky;

import java.util.ArrayList;

/**
 * Created by nunorod on 16/03/2017.
 */

public class Solution {

    /* print to output in each separate line int numbers from 1 .... N
    *   If this number is multiple of {3, 5, 7} then the output must be replaced by {"Fizz", "Buzz", "Woof"}
    *   If the number have multiple factors then it must be replaced by the respective strings
    *   Test 1 */
    public void solution(int N) {
        // write your code in Java SE 8

        int[] nums_f = new int[N];
        int[] nprime = {3, 5, 7};
        String[] sprime = {"Fizz", "Buzz", "Woof"};
        ArrayList<String> aList = new ArrayList<String>();
        int a = 0;
        int factor = 1;
        int fnum =0;

        for(int j=1;j<=N;j++) {
            while( factor <= j) {
                /* Prime Factorization is finding which prime numbers multiply together to make the original number. */
                fnum = j / factor;
                System.out.println("Num "+j+" is multiple of "+ factor + " (" + fnum+ ")" );
                //aList;
                if (j % factor == 0){
                    System.out.println("Num "+j+" is factorized in "+factor);
                    //break;
                }
                factor++;

            }

        }

    }


    /* Given 2 non-negative integers A and B it returns the position(s) where A occurs in B;
    *  If do not occurs then returns -1
    *  */
    public int solution(int A, int B) {
            // write your code in Java SE 8
        /* System.out.println("\nReal locations were:");
        for (int i=0; i < locations.size();i++) {
            System.out.print("" + locations.get(i) + " ");
        }*/
        String a = ""+A;
        String b = ""+B;
        if (b.contains(a)){
            System.out.println("B contains A substring. ");
            int d=b.indexOf(a);
            return d;
        } else {
            return -1;
        }
    }

}
