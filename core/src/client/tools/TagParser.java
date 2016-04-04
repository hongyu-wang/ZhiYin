package client.tools;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

/**
 * This is a basic TagParser class
 *
 * The class will read a message and then parse for all tags
 *
 * Created by Hongyu Wang on 3/29/2016.
 */
public class TagParser {
    private static String [] hashtags = {
        "Sorry",
        "MissingU",
        "Weeknd",
        "RnB",
        "Pop",
        "M5",
        "Bieber",
        "Kanye",
        "Ed",
        "LoveYourself"
    };

    private int startIndex, endIndex;

    private String enclosedTag;

    /**
     * This is a test main.
     * @param args  Main args man.
     */
    public static void main (String args []){
        String input = "";
        Scanner in = new Scanner(System.in);
        String regex = "";
        while (!input.equals("exit")){
            input = in.nextLine();
            regex = in.nextLine();
            Pattern checkRegex = Pattern.compile(regex);
            Matcher regexMatcher = checkRegex.matcher(input);

            while (regexMatcher.find()){
                System.out.println(regexMatcher.group());
            }

        }
    }



    private TagParser(int startIndex, String enclosedTag){
        this.startIndex = startIndex;
        this.enclosedTag = enclosedTag;
        this.endIndex = startIndex + enclosedTag.length();
    }




    private static boolean checkValid(String tag){
        for (String str : hashtags){
            if (str.equals(tag)) {
                return true;
            }
        }
        return false;

    }


    /**
     * This reads a string message then returns a list of TagParser objects.
     */
    public static List<TagParser> checkForTag(String message){
        Pattern checkRegex = Pattern.compile("#[A-Za-z]*");
        Matcher regexMatcher = checkRegex.matcher(message);

        List<TagParser> tags = new ArrayList<>();

        while (regexMatcher.find()){
            if (regexMatcher.group().length() != 0){

                String hashTag = regexMatcher.group();
                if (checkValid(hashTag.substring(1)))
                    tags.add(new TagParser(regexMatcher.start(), hashTag));
            }
        }

        return tags;
    }

    public String toString(){
        return startIndex + " " + endIndex + " " + enclosedTag;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getEnclosedTag() {
        return enclosedTag;
    }
}
