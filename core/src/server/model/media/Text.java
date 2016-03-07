package server.model.media;

import server.model.structureModels.ServerModel;

/**Stylized Text Class
 *
 * Created by Kevin Zheng on 2016-03-06.
 */
public class Text extends ServerModel {
    private int type;
    private String text;

    /**Gets the string text of the text object.
     *
     * @return  The string message.
     */
    public String getText() {
        return text;
    }

    /**Gets the style of the text object.
     *
     * @return  The integer type.
     */
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public void setText(String text) {
        this.text = text;
    }
}
