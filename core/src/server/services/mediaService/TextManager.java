package server.services.mediaService;

import server.model.media.MText;

/**
 * Created by Kevin Zheng on 2016-03-06.
 */
public interface TextManager {
    /**Requests the piece of text.
     *
     * @param key   The key.
     * @return      The new MText.
     */
    MText requestText(long key);

    /**Modify the type of the MText.
     *
     * @param text  The MText object.
     * @param type  The style type of the text.
     * @return      The modified text.
     */
    MText modifyType(MText text, int type);

    /**Modify the text of the MText.
     *
     * @param text          The MText object.
     * @param textString    The string content of the MText.
     * @return              The modified text.
     */
    MText modifyText(MText text, String textString);


}
