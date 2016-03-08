package server.services.mediaService;

import server.model.media.MHashtag;

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
    long requestAuthenticationKey(String hashtagName);

    /**Returns a hashtag object of relevant information.
     *
     * @return  The MHashtag model of string hashtag.
     */
    MHashtag requestHashTag(long hashtagKey);

    /**Adds a new hashtag to the server.
     *
     * @param hashtag   The new hashtag object.
     */
    void pushHashTag(MHashtag hashtag);

    /**Returns a new MHashtag based on a string.
     *
     * @param hashtagName   The text of the new hashtag.
     * @return              The new hashtag.
     */
    MHashtag createNewHashTag(String hashtagName);
}
