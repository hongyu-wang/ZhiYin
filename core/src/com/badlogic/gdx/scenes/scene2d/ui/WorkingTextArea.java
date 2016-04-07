package com.badlogic.gdx.scenes.scene2d.ui;
import client.singletons.StateManager;
import client.tools.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputListener;


/**
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class WorkingTextArea extends TextArea implements Constants {


    public static boolean getKeyboardIsVisible() {
        return keyboardIsVisible;
    }



    private static boolean keyboardIsVisible = false;

    private boolean firstTime = true;


    public WorkingTextArea(String text, Skin skin) {
        super(text, skin);

        addListener(new InputListener(){
            @Override
            public boolean handle(Event e) {
                if (firstTime){
                    setText("");
                    firstTime = false;
                }
                if (newLineAtEnd()){

                    resetText();
                    if (WorkingTextArea.keyboardIsVisible) {
                        WorkingTextArea.keyboardIsVisible = false;
                        StateManager.getInstance().translateStage();
                    }
                    return true;
                }
                return false;
            }
        });
        setOnscreenKeyboard(new OnscreenKeyboard() {
            @Override
            public void show(boolean visible) {
                if (getY() - getHeight() < KEY_BOARD_HEIGHT) {
                    WorkingTextArea.keyboardIsVisible = true;
                }
                StateManager.getInstance().translateStage();
                Gdx.input.setOnscreenKeyboardVisible(visible);

            }
        });


    }




    protected WorkingTextArea(String text, Skin skin, boolean test) {
        super(text, skin);

    }

    protected void resetText(){

        setText(this.text.trim());


        this.updateDisplayText();
    }



//    String insert (int position, CharSequence text, String to) {
//        if (to.length() == 0) return text.toString();
//        try {
//            return to.substring(0, position) + text + to.substring(position, to.length());
//        }catch (StringIndexOutOfBoundsException e) {
//            System.out.println(text);
//            System.out.println(to);
//        }
//        return to;
//    }

//    @Override
//    protected int[] wordUnderCursor (int at) {
//        String text = this.text;
//        int start = at, right = text.length(), left = 0, index = start;
//        for (; index < right; index++) {
//            if (!isWordCharacter(text.charAt(index))) {
//                right = index;
//                break;
//            }
//        }
//        for (index = start - 1; index > -1; index--) {
//            if (index >= text.length()){
//                continue;
//            }
//            if (!isWordCharacter(text.charAt(index))) {
//                left = index + 1;
//                break;
//            }
//        }
//        return new int[] {left, right};
//    }



//
//    protected int letterUnderCursor (float x) {
//        if (linesBreak.size > 0) {
//            if (cursorLine * 2 >= linesBreak.size) {
//                return text.length();
//            } else {
//                float[] glyphPositions = this.glyphPositions.items;
//                int start = linesBreak.items[cursorLine * 2];
//                x += glyphPositions[start];
//                int end = linesBreak.items[cursorLine * 2 + 1];
//                int i = start;
//                for (; i <= end; i++)
//                    if (glyphPositions[i] > x) break;
//                if (i >= glyphPositions.length)
//                    return Math.max(0, i - 1);
//                if (glyphPositions[i] - x <= x - glyphPositions[i - 1]) return i;
//                return Math.max(0, i - 1);
//            }
//        } else {
//            return 0;
//        }
//    }
}
