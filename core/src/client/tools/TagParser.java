package client.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a basic TagParser class
 *
 * The class will read a message and then parse for all tags
 *
 * Created by Hongyu Wang on 3/29/2016.
 */
public class TagParser {
    public static final String [] allTags = {
        "happy", "sad"
    };

    private int startIndex, endIndex;

    private String enclosedTag;




    private TagParser(int startIndex, String enclosedTag){
        this.startIndex = startIndex;
        this.enclosedTag = enclosedTag.substring(1);
        this.endIndex = startIndex + enclosedTag.length();
    }




    public static boolean checkValid(String tag){
        for (String str : allTags){
            if (str.equals(tag))
                return true;
        }
        return false;

    }


    /**
     * This reads a string message then returns a list of TagParser objects.
     * @param message
     * @return
     */
    public static List<TagParser> checkForTag(String message){

        String current = "";

        int startPos = 0;

        boolean record = false;

        List<TagParser> tagParsers = new ArrayList<>();


        for (int i = 0; i < message.length(); i++){
            if (message.charAt(i) == '#'){

                current += '#';
                record = true;
                startPos = i;
            }


            else if (current.length() > 0 && message.charAt(i) == ' '){
                if (checkValid(current))
                    tagParsers.add(new TagParser(startPos, current));
                record = false;
                current = "";
            }


            if (record){
                current += message.charAt(i);
            }
        }

        if (record){
            if (checkValid(current))
                tagParsers.add(new TagParser(startPos, current));
        }
        return tagParsers;
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
