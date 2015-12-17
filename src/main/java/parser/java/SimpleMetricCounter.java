package parser.java;

import java.io.*;

/**
 * Created by RichardG on 17.12.2015.
 */
public class SimpleMetricCounter {

    private int linesOfCode;

    private int realLinesOfCode;

    private boolean noCurrentMultiLineComment;

    public SimpleMetricCounter(InputStream inputStream) throws IOException {
        parse(inputStream);
    }

    private void parse(InputStream inputStream) throws IOException {
        BufferedReader stream = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        while ((line = stream.readLine()) != null){
            line = line.trim();
            linesOfCode++;

            if(line.length() > 0){
                if(noCurrentMultiLineComment && line.contains("/*")){

                }

                if(noCurrentMultiLineComment && !line.startsWith("//")){
                    realLinesOfCode++;
                }
            }
        }
    }

    private boolean isLineMultilineComment(String line){
        int indexOfMultilineCommentStart = line.indexOf("/*");
        int indexOfMultilineCommentEnd = line.indexOf("*/");
        boolean isLineStartingMultilineComment = indexOfMultilineCommentStart >= 0
                && indexOfMultilineCommentStart > indexOfMultilineCommentEnd;
        return isLineStartingMultilineComment;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public int getRealLinesOfCode() {
        return realLinesOfCode;
    }
}
