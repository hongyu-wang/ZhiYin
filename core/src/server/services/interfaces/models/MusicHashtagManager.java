package server.services.interfaces.models;

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
