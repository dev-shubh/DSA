package lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    /*
        current code is limited. You can read only the first line of the file. What if you’d like to
        return the first two lines instead or even the word used most frequently? Ideally, you’d like to
        reuse the code doing setup and cleanup and tell the processFile method to perform different
        actions on the file.
    */
    public static String processFileBadWay() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/shumishra/Projects/DSA/src/lambdas/data.txt"));
            return bufferedReader.readLine(); // readLine reads a single line.
        }
        catch (Exception e) {

        }
        return null;
    }

    /*      Passing behavior is exactly what lambdas are for. So what should the new processFile method
            look like if you wanted to read two lines at once? You basically need a lambda that takes a
            BufferedReader and returns a String. For example, here’s how to print two lines of a
            BufferedReader:
                    String result = processFile((BufferedReader br) ->
                                                br.readLine() + br.readLine());
     */
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor)  throws IOException{
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/shumishra/Projects/DSA/src/lambdas/data.txt"));
            return bufferedReaderProcessor.process(bufferedReader);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public static void main(String[] args) throws IOException {

        // Process First Line using processFile
        String oneLine = Reader.processFile( (br) -> { return br.readLine();});

        // Process First Line using processFile
        String twoLines = Reader.processFile( (br) -> { return br.readLine() + " " +  br.readLine(); });

        // Process All Lines using processFile
        String allLines = Reader.processFile( (br) -> {
            final String[] content = {""};
            br.lines().distinct().forEach(line -> content[0] += line + " ");
            return content[0];
        });

        System.out.println(oneLine);
        System.out.println(twoLines);
        System.out.println(allLines);
    }


}
