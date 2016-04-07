package com.badlogic.gdx.scenes.scene2d.ui;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayHashtag;
import client.tools.TagParser;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;

import java.util.*;


/**
 *
 * Created by Hongyu Wang on 4/4/2016.
 */
public class LabelTextArea extends WorkingTextArea{
    private static Map<String, Float> characterSets;

    public static final String RED = "[#FF0000]";
    public static final String GREY = "[#696969]";


    private String color;

    private static void initCharacterSets(BitmapFont bmf){
        if (characterSets == null){
            characterSets = new Hashtable<>();
            GlyphLayout layout = new GlyphLayout();
            for (String character : ("`1234567890-=~!@#$%^&*()_+qwertyyuiop[]\\QWERTYUIOP{}|asdf" +
                    "ghjkl;'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>? ").split("")) {

                layout.setText(bmf, character);
                float width = layout.width;// contains the width of the current set text
                characterSets.put(character, width);
            }

        }


    }

    public LabelTextArea(String text, Skin skin){
        this(text, skin, GREY);
    }


    public LabelTextArea(String text, Skin skin, String color) {
        super(text, skin, false);



        this.color = color;

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


        setOnscreenKeyboard(new TextField.OnscreenKeyboard(){
            @Override
            public void show(boolean visible) {

            }
        });

    }








    @Override
    protected void drawCursor(Drawable cursorPatch, Batch batch, BitmapFont font, float x, float y) {

    }

    @Override
    protected void drawText (Batch batch, BitmapFont font, float x, float y) {
        initCharacterSets(font);

        Queue<int []> chars = TagParser.checkForTag(displayText+"");

        int [] current = null;
        if (!chars.isEmpty())
            current = chars.remove();


        int total = 0;
        float offsetY = 0;
        for (int i = firstLineShowing * 2; i < (firstLineShowing + getLinesShowing()) * 2 && i < linesBreak.size; i += 2) {
            int value = -1;
            if (current != null){
                value = current[0];
            }

            int currentWidth = 0;
            for (int j = linesBreak.items[i]; j < linesBreak.items[i+1];j++) {
                if (total != value) {
                    font.draw(batch, displayText, x + currentWidth, y + offsetY, j, j + 1, 0, Align.left, false);
                    currentWidth += characterSets.get("" + displayText.subSequence(j, j + 1));
                    total++;
                } else {
                    if (current!= null) {
                        int tagSection = Math.min(linesBreak.items[i + 1], current[1]);
                        CharSequence tempText = color+displayText.subSequence(j, tagSection)+"[#FFFFFF]";
                        font.draw(batch, tempText, x + currentWidth, y + offsetY, 0, Align.left, false);

                        for (String character : displayText.subSequence(j, tagSection).toString().split("")){
                            if (character.length()>0) {
                                currentWidth += characterSets.get(character);
                                total++;
                            }
                        }

                        j += displayText.subSequence(j, tagSection).length()-1;
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

        if (TagParser.checkValid(text.substring(left + 1, right))){
            System.out.println(text.substring(left + 1, right));
            new ExecutePlayHashtag(text.substring(left, right)).execute();
        }


        getStage().unfocus(this);
        return new int[] {left, right};
    }

    @Override
    protected boolean isWordCharacter(char c) {
        return super.isWordCharacter(c) || c == '#';
    }
}
