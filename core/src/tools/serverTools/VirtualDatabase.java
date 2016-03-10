package tools.serverTools;

import server.model.structureModels.ServerModel;

import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualDatabase {
    //User by Name
    Map<Long, Map<String, Long>> username_key;

    //UserModels
    Map<Long, Map<Character, Object>> users;
    Map<Long, Map<Character, Object>> userProfiles;
    Map<Long, Map<Character, Object>> userConversations;
    Map<Long, Map<Character, Object>> userActivityLog;
    Map<Long, Map<Character, Object>> userUploadedContent;
    Map<Long, Map<Character, Object>> userDiaryContent;

    //SoundCloudModels
    Map<Long, Map<Character, Object>> musicPosts;
    Map<Long, Map<Character, Object>> playLists;

    //SocialModels
    Map<Long, Map<Character, Object>> groups;
    Map<Long, Map<Character, Object>> comments;
    Map<Long, Map<Character, Object>> conversations;
    Map<Long, Map<Character, Object>> diaryPosts;
    Map<Long, Map<Character, Object>> genericPosts;
    Map<Long, Map<Character, Object>> messages;
    Map<Long, Map<Character, Object>> posts;

    //MediaModels
    Map<Long, Map<Character, Object>> audio;
    Map<Long, Map<Character, Object>> images;
    Map<Long, Map<Character, Object>> musics;
    Map<Long, Map<Character, Object>> texts;

    public void init(){
        this.texts = texts;
        this.users = users;
        this.userProfiles = userProfiles;
        this.userConversations = userConversations;
        this.userActivityLog = userActivityLog;
        this.userUploadedContent = userUploadedContent;
        this.userDiaryContent = userDiaryContent;
        this.musicPosts = musicPosts;
        this.playLists = playLists;
        this.groups = groups;
        this.comments = comments;
        this.conversations = conversations;
        this.diaryPosts = diaryPosts;
        this.genericPosts = genericPosts;
        this.messages = messages;
        this.posts = posts;
        this.audio = audio;
        this.images = images;
        this.musics = musics;
        this.username_key = username_key;
    }

}
