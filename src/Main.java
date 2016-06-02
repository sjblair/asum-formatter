import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for turning text into ASUM format.
 *
 * @author Stuart Blair
 * @since 02/06/2016
 */
public class Main {

    /**
     * Where the magic happens!
     * @param args Make sure to have preprocessed the input file!
     */
    public static void main(String... args) throws IOException {
        List<String> wordmap = new ArrayList<>();
        for(String s : FileUtils.readLines(new File("C:\\Users\\Stuart Blair\\Desktop\\afilter.txt"))) {
            String[] temp = s.split(" ");
            for(String ss : temp) {
                if(!wordmap.contains(ss)) {
                    wordmap.add(ss);
                }
            }
        }

        List<String> documents = FileUtils.readLines(new File("C:\\Users\\Stuart Blair\\Desktop\\afilter.txt"));
        for(String s : documents) {
            String[] temp = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String ss : temp) {
                if(wordmap.contains(ss)) {
                    sb.append((wordmap.indexOf(ss)) + " "); //ASUM STARTS INDEXING AT 0!!!
                } else {
                    sb.append(" ");
                }
            }
            FileUtils.writeStringToFile(new File("C:\\Users\\Stuart Blair\\Desktop\\BagOfSentences.txt"),"1\n" + sb.toString() + "\n",true);
        }
        FileUtils.writeLines(new File("C:\\Users\\Stuart Blair\\Desktop\\WordList.txt"),wordmap);
    }
}
