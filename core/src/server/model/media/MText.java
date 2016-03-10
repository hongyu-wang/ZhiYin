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

    /**Returns the style type of the MText.
     *
     * @return  The style type of the text.
     */
    public int getType() {
        return type;
    }
    /**Returns the text content of the MText.
     *
     * @return  The text contents of the MText.
     */
    public String getText() {
        return text;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}
