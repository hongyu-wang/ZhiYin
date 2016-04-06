package client.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by Hongyu Wang on 4/2/2016.
 */
public interface Constants {
    float M = 0.5F;

    int LEFT = -1;
    int RIGHT = 1;

    int WIDTH = 750;

    int HEIGHT = 1334;

    int KEY_BOARD_HEIGHT = (int)(HEIGHT*0.3);

    int RECIEVED_READ = 1;
    int RECIEVED_UNREAD = 2;
    int SENT_READ = 3;
    int SENT_UNREAD = 4;

    /**
     * This turns on the yellow lines in the buttons.
     */
    boolean playAnimation = true;


    boolean WINDOWS = false;

    boolean MAC = true;

    boolean os = WINDOWS;

    static String getCurrentTimestamp(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date df = new Date(time);
        return sdf.format(df);
    }




}