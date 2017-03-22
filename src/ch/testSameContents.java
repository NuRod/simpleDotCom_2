import java.util.Scanner;

public class testSameContents {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int N = in.nextInt();
        String[] a = { "a" , "b"};
                //in.nextLine();
        String[] b = { "a" , "b"};
                //in.nextLine();
        System.out.println(" Written a -> " + a );
        System.out.println(" Written b -> " + b );
        //System.exit(1);

        //char[][] c ={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        sameContents sc = new sameContents();

        System.out.println( "Result is same?:"+ sc.isSameContents(a,b) );


        //System.out.println("Result:" + str.substring(mini,maxi));
        //System.out.println("Result:" + str[0]);
    }
}
