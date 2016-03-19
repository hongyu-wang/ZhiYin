package tools.serverTools.databases;

import com.badlogic.gdx.graphics.Texture;
import org.robovm.apple.foundation.NSData;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.structureModels.ServerModel;
import server.model.user.*;
import tools.AudioTools.AudioCreator;
import tools.serverTools.server.ServerInteraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** *
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualDatabase {
    private Map<Long, ServerModel> data;
    private Map<String, Long> hashtag_key;
    private Map<String, Long> username_key;

    public VirtualDatabase() throws IOException{
        init();
    }


    public void init() throws IOException{
        this.username_key = new HashMap<>();
        this.hashtag_key = new HashMap<>();
        this.data = new HashMap<>();

        initUserData();
        initMediaData();
    }

    private void initUserData(){
        username_key.put("Alice", 1L);
        username_key.put("Benny", 2L);
        username_key.put("Cindy", 3L);

        assert ServerInteraction.getServer().getSerial() == 1;
        assert ServerInteraction.getServer().getSerial() == 2;
        assert ServerInteraction.getServer().getSerial() == 3;

        generateTestUser("Alice", 1);
        generateTestUser("Benny", 2);
        generateTestUser("Cindy", 3);
    }

    private void initMediaData(){
        //TODO created all media here.

        //Image
        MImage image1 = generateTestImage("ProfilePic_1", "//");// TODO path
        MImage image2 = generateTestImage("ProfilePic_2", "//");// TODO path
        MImage image3 = generateTestImage("ProfilePic_3", "//");// TODO path

        //Audio
        MAudio audio1 = generateTestAudio("Audio_1.mp3");// TODO path
        MAudio audio2 = generateTestAudio("Audio_2.mp3");// TODO path
        MAudio audio3 = generateTestAudio("Audio_3.mp3");// TODO path

        //Music
        MMusic music1 = generateTestMusic("Music_1", audio1);// TODO path
        MMusic music2 = generateTestMusic("Music_2", audio2);// TODO path
        MMusic music3 = generateTestMusic("Music_3", audio3);// TODO path

        //Hashtag
        MHashtag tag1 = generateTestHashtags("#Happy");
        MHashtag tag2 = generateTestHashtags("#Sad");
        MHashtag tag3 = generateTestHashtags("#Love");

        List<Long> music_tag1 = tag1.getMusicKeys();
        List<Long> music_tag2 = tag2.getMusicKeys();
        List<Long> music_tag3 = tag3.getMusicKeys();

        music_tag1.add(music1.getKey());
        music_tag2.add(music2.getKey());
        music_tag3.add(music3.getKey());

        //TODO add media to users here.
        User user1 = (User)data.get(1);
        User user2 = (User)data.get(2);
        User user3 = (User)data.get(3);

        UserProfile profile1 = (UserProfile)data.get(user1.getProfile());
        UserProfile profile2 = (UserProfile)data.get(user2.getProfile());
        UserProfile profile3 = (UserProfile)data.get(user3.getProfile());

        profile1.setImageKey(image1.getKey());
        profile2.setImageKey(image2.getKey());
        profile3.setImageKey(image3.getKey());
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

    /**Returns the key of the user based on a username.
     *
     * @param username
     * @return
     */
    public long getUserKeybyName(String username){
        return username_key.get(username);
    }

    private void generateTestUser(String username, int key) {
        User user =
                new User();
        UserProfile profile =
                new UserProfile();
        UserConversations conversations =
                new UserConversations();
        UserActivityLog log =
                new UserActivityLog();
        UserUploadedContent content =
                new UserUploadedContent();
        UserDiaryContent diary =
                new UserDiaryContent();

        //Set Keys.
        user.setKey(
                key);
        profile.setKey(
                ServerInteraction.getServer().getSerial());
        conversations.setKey(
                ServerInteraction.getServer().getSerial());
        log.setKey(
                ServerInteraction.getServer().getSerial());
        content.setKey(
                ServerInteraction.getServer().getSerial());
        diary.setKey(
                ServerInteraction.getServer().getSerial());

        //Profile Attributes
        profile.setUsername(username);
        profile.setDescription("I am " + username + ".");
        profile.setImageKey(0);//i.e. empty

        //Conversation Attributes
        conversations.setConvoKeys(new ArrayList<>());

        //ActivityLog Attributes
        log.setLog(new ArrayList<>());

        //UploadedContent Attributes
        content.setPostKeys(new ArrayList<>());

        //DiaryContent Attributes
        diary.setDiaryKeys(new ArrayList<>());

        //Assign to user.
        user.setProfile(profile.getKey());
        user.setConversations(conversations.getKey());
        user.setLog(log.getKey());
        user.setContent(content.getKey());
        user.setDiary(diary.getKey());

        //Put into database.
        data.put(user.getKey(), user);
        data.put(profile.getKey(), profile);
        data.put(conversations.getKey(), conversations);
        data.put(log.getKey(), log);
        data.put(content.getKey(), content);
        data.put(diary.getKey(), diary);
    }

    private MHashtag generateTestHashtags(String hashtag){
        MHashtag tag = new MHashtag();

        tag.setKey(ServerInteraction.getServer().getSerial());

        tag.setHashtag(hashtag);

        tag.setMusicKeys(
                new ArrayList<Long>()
        );

        hashtag_key.put(hashtag, tag.getKey());
        data.put(tag.getKey(), tag);

        return tag;
    }

    private MImage generateTestImage(String name, String path){
        MImage image = new MImage();

        image.setKey(ServerInteraction.getServer().getSerial());

        image.setName(name);

        image.setImage(new Texture(path));

        image.setName(name);

        return image;
    }

    private MAudio generateTestAudio(String path){
        MAudio audio = new MAudio();

        audio.setKey(ServerInteraction.getServer().getSerial());

        NSData data = AudioCreator.createFromFilePath(path);

        audio.setmData(data);

        return audio;
    }

    private MMusic generateTestMusic(String name, MAudio audio){
        MMusic music = new MMusic();

        music.setKey(ServerInteraction.getServer().getSerial());

        music.setName(name);

        music.setSong(audio);

        return music;
    }

}
