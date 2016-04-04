package com.badlogic.gdx.scenes.scene2d.ui;

import client.tools.TagParser;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.IntArray;

import java.util.*;
import java.util.List;


/**
 *
 * Created by Hongyu Wang on 4/4/2016.
 */
public class LabelTextArea extends WorkingTextArea{
    private static Map<String, Float> characterSets;

    private void initCharacterSets(BitmapFont bmf){
        if (characterSets == null){
            characterSets = new Hashtable<>();
            GlyphLayout layout = new GlyphLayout();
            for (String character : "`1234567890-=~!@#$%^&*()_+qwertyyuiop[]\\QWERTYUIOP{}|asdfghjkl;'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>? ".split("")) {

                layout.setText(bmf, character);
                float width = layout.width;// contains the width of the current set text
                characterSets.put(character, width);
            }

        }


    }



    public LabelTextArea(String text, Skin skin) {
        super(text, skin, false);


        TextFieldStyle style = getStyle();

        TextFieldStyle style2 = new TextFieldStyle(style);
        style2.font.getData().markupEnabled = true;

        style2.background = null;

        setStyle(style2);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                wordUnderCursor(x);

                updateCurrentLine();
            }
        });
    }






    @Override
    protected void drawCursor(Drawable cursorPatch, Batch batch, BitmapFont font, float x, float y) {

    }

    @Override
    protected void drawText (Batch batch, BitmapFont font, float x, float y) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        initCharacterSets(font);
        Queue<int []> chars = TagParser.checkForTag(displayText+"");

        int [] current = null;
        if (!chars.isEmpty())
            current = chars.remove();


        int total = 0;
        float offsetY = 0;
        boolean resetOnNewLine = false;
        for (int i = firstLineShowing * 2; i < (firstLineShowing + getLinesShowing()) * 2 && i < linesBreak.size; i += 2) {
            int value = -1;
            if (current != null){
                value = current[0];
            }

            int currentWidth = 0;
            for (int j = linesBreak.items[i]; j < linesBreak.items[i+1];j++) {
                if (total != value && !resetOnNewLine) {
                    font.draw(batch, displayText, x + currentWidth, y + offsetY, j, j + 1, 0, Align.left, false);
                    currentWidth += characterSets.get("" + displayText.subSequence(j, j + 1));
                    total++;
                } else {
                    if (current!= null) {
                        int tagSection = Math.min(linesBreak.items[i + 1], current[1]);
                        CharSequence tempText = "[#FF0000]"+displayText.subSequence(j, tagSection)+"[#FFFFFF]";
                        font.draw(batch, tempText, x + currentWidth, y + offsetY, 0, Align.left, false);

                        for (String character : displayText.subSequence(j, tagSection).toString().split("")){
                            if (character.length()>0) {
                                currentWidth += characterSets.get(character);
                                total++;
                            }
                        }

                        j += displayText.subSequence(j, tagSection).length()-1;
                        resetOnNewLine = current[1] > tagSection;
                        if (!chars.isEmpty()) {
                            current = chars.remove();
                            value = current[0];
                        }
                    }

                }

            }
            offsetY -= font.getLineHeight();
        }
    }


    @Override
    protected int[] wordUnderCursor (int at) {
        int right = text.length(), left = 0, index = at;
        for (; index < right; index++) {
            if (!isWordCharacter(text.charAt(index))) {
                right = index;
                break;
            }
        }
        for (index = at - 1; index > -1; index--) {
            if (index >= text.length()){
                continue;
            }
            if (!isWordCharacter(text.charAt(index))) {
                left = index + 1;
                break;
            }
        }
        System.out.println(text.substring(left, right));
        getStage().unfocus(this);
        return new int[] {left, right};
    }


}
