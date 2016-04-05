package server.model.media;

import server.model.structureModels.ServerModel;

/**Stylized MText Class
 *
 * Created by Kevin Zheng on 2016-03-06.
 */
public class MText extends ServerModel {
    /**
     * The style of the text.
     */
    private int type;
    /**
     * The string content of the text.
     */
    private String text;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
