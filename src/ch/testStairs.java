import java.io.*;
import java.util.*;

public class testStairs {
    public static void main(String[] args) {
        //int N = 9;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String str = "shit dawmned";
        System.out.println(" Written -> "+ N);
        //System.exit(1);
        int mini=3;
        int maxi=7;

        char[][] c = new char[N][N];
        char[] chars = new char [N];
        //char[][] c ={{'1','2','3'},{'4','5','6'},{'7','8','9'}};

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                c[i][j] = 'O';

                if ( i >= N-1-j ) {
                    c[i][j] = '#';
                }
                System.out.print( c[i][j] );
                chars[j] = c[i][j];
                if ( j == N-1 ) System.out.println("");
                 //c[j] = '#';
                //}
            }

            //str=chars.toString()

        }


        System.out.println("Result:" + str.substring(mini,maxi));
        //System.out.println("Result:" + str[0]);
    }
}

/*    You can use s.indexOf(' '); If it returns -1 the string does not contain spaces.

        Also, you can use switch(s.charAt(0)){ case 'a': case 'b': ... break; case 'c': ... }

        in place of the multiple if.






        Summarize other answers I found 11 main ways to do this (see below). And I wrote some performance tests (see results below):

Ways to convert an InputStream to a String:

Using IOUtils.toString (Apache Utils)
String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
Using CharStreams (guava)
String result = CharStreams.toString(new InputStreamReader(
      inputStream, Charsets.UTF_8));
Using Scanner (JDK)
Scanner s = new Scanner(inputStream).useDelimiter("\\A");
String result = s.hasNext() ? s.next() : "";
Using Stream Api (Java 8). Warning: This solution convert different line breaks (like \r\n) to \n.
String result = new BufferedReader(new InputStreamReader(inputStream))
  .lines().collect(Collectors.joining("\n"));
Using parallel Stream Api (Java 8). Warning: This solution convert different line breaks (like \r\n) to \n.
String result = new BufferedReader(new InputStreamReader(inputStream)).lines()
   .parallel().collect(Collectors.joining("\n"));
Using InputStreamReader and StringBuilder (JDK)
final int bufferSize = 1024;
final char[] buffer = new char[bufferSize];
final StringBuilder out = new StringBuilder();
Reader in = new InputStreamReader(inputStream, "UTF-8");
for (; ; ) {
    int rsz = in.read(buffer, 0, buffer.length);
    if (rsz < 0)
        break;
    out.append(buffer, 0, rsz);
}
return out.toString();
Using StringWriter and IOUtils.copy (Apache Commons)
StringWriter writer = new StringWriter();
IOUtils.copy(inputStream, writer, "UTF-8");
return writer.toString();
Using ByteArrayOutputStream and inputStream.read (JDK)
ByteArrayOutputStream result = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int length;
while ((length = inputStream.read(buffer)) != -1) {
    result.write(buffer, 0, length);
}
// StandardCharsets.UTF_8.name() > JDK 7
return result.toString("UTF-8");
Using BufferedReader (JDK). Warning: This solution convert different line breaks (like \n\r) to line.separator system property (for example, in Windows to "\r\n").
String newLine = System.getProperty("line.separator");
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
StringBuilder result = new StringBuilder();
String line; boolean flag = false;
while ((line = reader.readLine()) != null) {
    result.append(flag? newLine: "").append(line);
    flag = true;
}
return result.toString();
Using BufferedInputStream and ByteArrayOutputStream (JDK)
BufferedInputStream bis = new BufferedInputStream(inputStream);
ByteArrayOutputStream buf = new ByteArrayOutputStream();
int result = bis.read();
while(result != -1) {
    buf.write((byte) result);
    result = bis.read();
}
// StandardCharsets.UTF_8.name() > JDK 7
return buf.toString("UTF-8");
Using inputStream.read() and StringBuilder (JDK). Warning: This solution has problem with Unicode, for example with Russian text (work correctly only with non-Unicode text)
int ch;
StringBuilder sb = new StringBuilder();
while((ch = inputStream.read()) != -1)
    sb.append((char)ch);
reset();
return sb.toString();
Warning:

Solutions 4, 5 and 9 convert different line breaks to one.
Solution 11 can't work correctly with Unicode text
Performance tests

Performance tests for small String (length = 175), url in github (mode = Average Time, system = Linux, score 1,343 is the best):

              Benchmark                        Mode  Cnt   Score   Error  Units
8. ByteArrayOutputStream and read (JDK)        avgt   10   1,343 ± 0,028  us/op
6. InputStreamReader and StringBuilder (JDK)   avgt   10   6,980 ± 0,404  us/op
10.BufferedInputStream, ByteArrayOutputStream  avgt   10   7,437 ± 0,735  us/op
11.InputStream.read() and StringBuilder (JDK)  avgt   10   8,977 ± 0,328  us/op
7. StringWriter and IOUtils.copy (Apache)      avgt   10  10,613 ± 0,599  us/op
1. IOUtils.toString (Apache Utils)             avgt   10  10,605 ± 0,527  us/op
3. Scanner (JDK)                               avgt   10  12,083 ± 0,293  us/op
2. CharStreams (guava)                         avgt   10  12,999 ± 0,514  us/op
4. Stream Api (Java 8)                         avgt   10  15,811 ± 0,605  us/op
9. BufferedReader (JDK)                        avgt   10  16,038 ± 0,711  us/op
5. parallel Stream Api (Java 8)                avgt   10  21,544 ± 0,583  us/op
Performance tests for big String (length = 50100), url in github (mode = Average Time, system = Linux, score 200,715 is the best):

              Benchmark                        Mode  Cnt   Score        Error  Units
8. ByteArrayOutputStream and read (JDK)        avgt   10   200,715 ±   18,103  us/op
1. IOUtils.toString (Apache Utils)             avgt   10   300,019 ±    8,751  us/op
6. InputStreamReader and StringBuilder (JDK)   avgt   10   347,616 ±  130,348  us/op
7. StringWriter and IOUtils.copy (Apache)      avgt   10   352,791 ±  105,337  us/op
2. CharStreams (guava)                         avgt   10   420,137 ±   59,877  us/op
9. BufferedReader (JDK)                        avgt   10   632,028 ±   17,002  us/op
5. parallel Stream Api (Java 8)                avgt   10   662,999 ±   46,199  us/op
4. Stream Api (Java 8)                         avgt   10   701,269 ±   82,296  us/op
10.BufferedInputStream, ByteArrayOutputStream  avgt   10   740,837 ±    5,613  us/op
3. Scanner (JDK)                               avgt   10   751,417 ±   62,026  us/op
11.InputStream.read() and StringBuilder (JDK)  avgt   10  2919,350 ± 1101,942  us/op
Graphs (performance tests depending on Input Stream length in Windows 7 system)
enter image description here

Performance test (Average Time) depending on Input Stream length in Windows 7 system:

 length  182    546     1092    3276    9828    29484   58968

 test8  0.38    0.938   1.868   4.448   13.412  36.459  72.708
 test4  2.362   3.609   5.573   12.769  40.74   81.415  159.864
 test5  3.881   5.075   6.904   14.123  50.258  129.937 166.162
 test9  2.237   3.493   5.422   11.977  45.98   89.336  177.39
 test6  1.261   2.12    4.38    10.698  31.821  86.106  186.636
 test7  1.601   2.391   3.646   8.367   38.196  110.221 211.016
 test1  1.529   2.381   3.527   8.411   40.551  105.16  212.573
 test3  3.035   3.934   8.606   20.858  61.571  118.744 235.428
 test2  3.136   6.238   10.508  33.48   43.532  118.044 239.481
 test10 1.593   4.736   7.527   20.557  59.856  162.907 323.147
 test11 3.913   11.506  23.26   68.644  207.591 600.444 1211.545
        */