package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A user of Zhi Yin. Contains all the necessary information for the user.
 *
 * A model filled with the information on a user.
 *
 *      - UserProfileManager:
 *          -Basic user information.
 *      - Conversations
 *      - Diary Content
 *      - Uploaded Content
 *      - Activity Log
 *
 * Created by Kevin Zheng on 2016-02-18.
 */
public class User extends ServerModel {
    public long getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(long profileKey) {
        this.profileKey = profileKey;
    }

    /**
     * The key to the userProfile.
     */
    private long profileKey;
    /**
     * The key to the userConversations.
     */
    private long conversations;
    /**
     * The key to the userDiary.
     */
    private long diary;
    /**
     * The key to the userLog.
     */
    private long log;
    /**
     * The key to the userContent.
     */
    private long content;
    /**
     * The current generated key count.
     */
    private long keyState;


    public long getConversations() {
        return conversations;
    }

    public void setConversations(long conversations) {
        this.conversations = conversations;
    }

    public long getDiary() {
        return diary;
    }

    public void setDiary(long diary) {
        this.diary = diary;
    }

    public long getLog() {
        return log;
    }

    public void setLog(long log) {
        this.log = log;
    }

    public long getContent() {
        return content;
    }

    public void setContent(long content) {
        this.content = content;
    }

    public long getKeyState() {
        return keyState;
    }

    public void setKeyState(long keyState) {
        this.keyState = keyState;
    }

    public long getSnapChat() {
        return snapChat;
    }

    public void setSnapChat(long snapChat) {
        this.snapChat = snapChat;
    }

    public List<Long> getFriendKeys() {
        return friendKeys;
    }

    public void setFriendKeys(List<Long> friendKeys) {
        this.friendKeys = friendKeys;
    }

    public List<Long> getBandKeys() {
        return bandKeys;
    }

    public void setBandKeys(List<Long> bandKeys) {
        this.bandKeys = bandKeys;
    }

    /**

     * The current snapchat.
     */
    private long snapChat;
    /**
     * The keys to the friends.
     */
    private List<Long> friendKeys;

    /**
     * The keys to the bands.
     */
    private List<Long> bandKeys;
}
