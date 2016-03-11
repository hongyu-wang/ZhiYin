package server.services.mediaService;

import server.model.media.MText;
import server.services.serviceInterfaces.TextManager;

/**
 * Created by Kevin Zheng on 2016-03-07.
 */
public class TextManagerImplementation implements TextManager {
    @Override
    public MText requestText(long key) {
        MText text = new MText();
        text.setKey(key);

        int type = 0;
        text.setType(type);
        //TODO request from server.

        String textString = null;
        text.setText(textString);
        //TODO request from server.

        return text;
    }

    @Override
    public MText modifyType(MText text, int type) {
        text.setType(type);
        return text;
        //TODO request change to server.
    }

    @Override
    public MText modifyText(MText text, String textString) {
        text.setText(textString);
        return text;
        //TODO request change to server.
    }
}
