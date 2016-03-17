package tools.serverTools.databases;

import server.model.media.MImage;
import server.model.structureModels.ServerModel;
import server.model.user.*;
import tools.serverTools.server.ServerInteraction;
import tools.utilities.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** *
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualDatabase {
    //User by Name
    Map<String, Long> username_key;

//    //UserModels
//    Map<Long, User> users;
//
//    //Profile
//    Map<Long, UserProfile> userProfiles;
//
//    //Conversation
//    Map<Long, UserConversations> userConversations;
//
//    //ActivityLog
//    Map<Long, UserActivityLog> userActivityLog;
//
//    //UploadedContent
//    Map<Long, ServerModel> userUploadedContent;
//
//    //DiaryContent
//    Map<Long, ServerModel> userDiaryContent;

    Map<Long, ServerModel> data;



    public VirtualDatabase() throws IOException{
        init();
    }


    public void init() throws IOException{
        initUsersByName();
        initData();
    }

    private void initUsersByName(){
        this.username_key = new HashMap<>();
    }

    private void initData() throws IOException{
//        this.users = new HashMap<>();
//        this.userProfiles = new HashMap<>();
//        this.userConversations = new HashMap<>();
//        this.userActivityLog = new HashMap<>();
//        this.userUploadedContent = new HashMap<>();
//        this.userDiaryContent = new HashMap<>();



        this.data = new HashMap<>();



        User user1 = new User();
        user1.setKey(1L);
        this.data.put(1L, user1);

        /**
        //User Profile
        UserProfile profile = new UserProfile();
        profile.setKey(ServerInteraction.getServer().getSerial());
        profile.setUsername("user1");
        profile.setDescription("The first user of ZhiYin.");

        MImage image = new MImage();
        image.setKey(ServerInteraction.getServer().getSerial());
        image.setImage(ImageIO.read(new File("image")));

        profile.setImageKey(image.getKey());

        //User Convo
        UserConversations convos = new UserConversations();
        convos.setKey(ServerInteraction.getServer().getSerial());
        convos.setConvoKeys(Utils.<Long>newList());

        //User Diary
        UserDiaryContent diary = new UserDiaryContent();
        diary.setKey(ServerInteraction.getServer().getSerial());
        diary.setDiaryKeys(Utils.<Long>newList());

        //User Content
        UserUploadedContent content = new UserUploadedContent();
        content.setKey(ServerInteraction.getServer().getSerial());
        content.setPostKeys(Utils.<Long>newList());

        //User Activity
        UserActivityLog log = new UserActivityLog();
        log.setKey(ServerInteraction.getServer().getSerial());
        log.setLog(Utils.<String>newList());

        user1.setProfile(profile.getKey());
        user1.setContent(content.getKey());
        user1.setDiary(diary.getKey());
        user1.setLog(log.getKey());
        user1.setConversations(convos.getKey());
        user1.setFriends(Utils.<Long>newList());
        **/
    }

    /**Gets a model from the database.
     *
     * @param key   The key of the model.
     * @return
     */
    public ServerModel getModel(long key){
        return data.get(key);
    }

    /**Sets a model into the database.
     *
     * @param model The model.
     */
    public void setModel(ServerModel model){
        data.put(model.getKey(), model);
    }



}
