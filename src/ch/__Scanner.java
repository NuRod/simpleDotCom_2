import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nunorod on 13/03/2017.
 */
class S_canner{
    private int int1,int2;
    private String s;
    InputStream inputS;
    int size=10;
    byte[] b = new byte[size];

    S_canner(InputStream input){
        inputS= input;
        int1=0;
        int2=0;
    }

    public String next(){
        s=inputS.toString();
        return s;
    }

    public int nextInt(){
        try {
            String ss;
            while ( ( int1 = inputS.read(b) ) != -1 );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return int1;
    }



}//class Scanner