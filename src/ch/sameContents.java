/**
 * Created by nunorod on 13/03/2017.
 * compare 2 string arrays for the same contents in any order (if the shorter array contains the longer one)
 * { a , b , a} == { a , a , b} != { a , b }
 *
 *
 * incomplete
 *
 *
 */
public class sameContents {

    public  sameContents() {
    }

    static boolean isSameContents(String[] a, String[] b) {


        for (int i = 0; i < a.length; i++) {
            char[] achars = new char[a[i].length()];
            char[] bchars = new char[b[i].length()];
            achars = a[i].toCharArray();
            bchars = b[i].toCharArray();

            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
