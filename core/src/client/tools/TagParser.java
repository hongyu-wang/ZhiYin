package client.tools;

import java.util.*;
import java.util.regex.*;

/**
 * This is a basic TagParser class
 *
 * The class will read a message and then parse for all tags
 *
 * Created by Hongyu Wang on 3/29/2016.
 */
public final class TagParser {
    private static String[] hashtags = {
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

    /**
     * This is a test main.
     *
     * @param args Main args man.
     */
    public static void main(String args[]) {
        String input = "";
        Scanner in = new Scanner(System.in);
        String regex = "";
        while (!input.equals("exit")) {
            input = in.nextLine();
            regex = in.nextLine();
            Pattern checkRegex = Pattern.compile(regex);
            Matcher regexMatcher = checkRegex.matcher(input);

            while (regexMatcher.find()) {
                System.out.println(regexMatcher.group());
            }

        }
    }


    public static boolean checkValid(String tag) {
        for (String str : hashtags) {
            if (str.equals(tag)) {
                return true;
            }
        }
        return false;

    }


    public static Queue<int[]> checkForTag(String message) {
        Pattern checkRegex = Pattern.compile("#[A-Za-z0-9]*");
        Matcher regexMatcher = checkRegex.matcher(message);
        Queue<int[]> tagIndices = new ArrayDeque<>();
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {

                String hashTag = regexMatcher.group();
                if (checkValid(hashTag.substring(1))) {
                    tagIndices.add(new int[]{regexMatcher.start(), regexMatcher.end()});
                }

            }
        }
        return tagIndices;


    }
}