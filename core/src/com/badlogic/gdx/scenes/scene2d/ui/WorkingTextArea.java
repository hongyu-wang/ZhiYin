package com.badlogic.gdx.scenes.scene2d.ui;
import com.badlogic.gdx.scenes.scene2d.utils.ZhiYinRealClickListener;



/**
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class WorkingTextArea extends TextArea {

    public WorkingTextArea(String text, Skin skin) {
        super(text, skin);

        addListener(new ZhiYinRealClickListener(this));
    }



    String insert (int position, CharSequence text, String to) {
        if (to.length() == 0) return text.toString();
        try {
            return to.substring(0, position) + text + to.substring(position, to.length());
        }catch (StringIndexOutOfBoundsException e) {
            System.out.println(text);
            System.out.println(to);
        }
        return to;
    }

    @Override
    protected int[] wordUnderCursor (int at) {
        String text = this.text;
        int start = at, right = text.length(), left = 0, index = start;
        for (; index < right; index++) {
            if (!isWordCharacter(text.charAt(index))) {
                right = index;
                break;
            }
        }
        for (index = start - 1; index > -1; index--) {
            if (index >= text.length()){
                continue;
            }
            if (!isWordCharacter(text.charAt(index))) {
                left = index + 1;
                break;
            }
        }
        return new int[] {left, right};
    }

    protected int letterUnderCursor (float x) {
        if (linesBreak.size > 0) {
            if (cursorLine * 2 >= linesBreak.size) {
                return text.length();
            } else {
                float[] glyphPositions = this.glyphPositions.items;
                int start = linesBreak.items[cursorLine * 2];
                x += glyphPositions[start];
                int end = linesBreak.items[cursorLine * 2 + 1];
                int i = start;
                for (; i <= end; i++)
                    if (glyphPositions[i] > x) break;
                if (i >= glyphPositions.length)
                    return Math.max(0, i - 1);
                if (glyphPositions[i] - x <= x - glyphPositions[i - 1]) return i;
                return Math.max(0, i - 1);
            }
        } else {
            return 0;
        }
    }
}
