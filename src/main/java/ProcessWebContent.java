
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @author Anthony Carta
 */
public class ProcessWebContent {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param args the arguments for the main method
     */
    public static void main(String[] args) {
        System.out.println(ProcessWebContent.urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(ProcessWebContent.oneWordCount(ProcessWebContent.urlToString("http://erdani.com/tdpl/hamlet.txt"), WORD_TO_BE_SEARCHED));
        System.out.println(ProcessWebContent.numberOfUniqueWords(ProcessWebContent.urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Count the number of words in a given String.
     *
     * @param message the message to be counted for number of words
     * @return the number of words in the message
     */
    public static int wordCount(final String message) {
        return message.toUpperCase().split(" ").length;
    }

    /**
     * Count the number of words in a given String.
     *
     * @param message the message to be counted for number of words
     * @param word the word to be counted
     * @return the number of instances the word occurs in a message
     */
    public static int oneWordCount(final String message, final String word) {
        return message.toUpperCase().split(word.toUpperCase()).length;
    }

    /**
     * Count the number of words in a given String.
     *
     * @param message the message to be counted for number of unique words
     * @return the number of unique words in the message
     */
    public static int numberOfUniqueWords(final String message) {
        String[] messageArray = message.split(" ");
        ArrayList<String> uniqueWords = new ArrayList<String>();
        for (int i = 0; i < messageArray.length; i++) {
            if (!uniqueWords.contains(messageArray[i])) {
                uniqueWords.add(messageArray[i]);
            }
        }
        return uniqueWords.size();
    }

    /**
     *  The word to be searched.
     *  <p>
     *  this value can be changed
     */
    public static final String WORD_TO_BE_SEARCHED = "prince";
}
