package client.component.basicComponents;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class WorkingTextArea extends TextArea {
    public WorkingTextArea(String text, Skin skin) {
        super(text, skin);
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
}
