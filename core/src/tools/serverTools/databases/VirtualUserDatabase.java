package tools.serverTools.databases;

import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserActivityLog;
import server.model.user.UserConversations;
import server.model.user.UserProfile;

import java.util.List;
import java.util.Map;

/** *
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualUserDatabase implements VirtualDatabase{
    //User by Name
    Map<String, Long> username_key;

    //UserModels
    Map<Long, User> users;
    Map<Long, List<Long>> friends;

    //Profile
    Map<Long, UserProfile> userProfiles;
    Map<Long, String> username;
    Map<Long, String> description;
    Map<Long, Long> images;

    //Conversation
    Map<Long, UserConversations> userConversations;
    Map<Long, List<Long>> conversations;

    //ActivityLog
    Map<Long, UserActivityLog> userActivityLog;
    Map<Long, List<String>> log;

    //UploadedContent
    Map<Long, ServerModel> userUploadedContent;

    //DiaryContent
    Map<Long, ServerModel> userDiaryContent;

    public void init(){
        initUsersByName();
        initUsers();
    }

    private void initUsersByName(){
        this.username_key = username_key;
    }

    private void initUsers(){
        this.users = users;
        this.userProfiles = userProfiles;
        this.userConversations = userConversations;
        this.userActivityLog = userActivityLog;
        this.userUploadedContent = userUploadedContent;
        this.userDiaryContent = userDiaryContent;
    }
}
