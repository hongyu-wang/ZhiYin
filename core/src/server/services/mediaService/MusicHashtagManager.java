package server.services.mediaService;

import server.model.media.Hashtag;

/**
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface MusicHashtagManager {
    /**Checks whether or not the hashtag exists within the server.
     *
     * @param hashtagName   The string hashtagName.
     * @return              True if the string corresponds to a server hashtag.
     */
    boolean validateHashtag(String hashtagName);

    /**Returns a hashtag object of relevant information.
     *
     * @return  The Hashtag model of string hashtag.
     */
    Hashtag requestHashTag(String hashtagName);

    /**Adds a new hashtag to the server.
     *
     * @param hashtag   The new hashtag object.
     */
    void pushHashTag(Hashtag hashtag);

    /**Returns a new Hashtag based on a string.
     *
     * @param hashtagName   The text of the new hashtag.
     * @return              The new hashtag.
     */
    Hashtag createNewHashTag(String hashtagName);
}
