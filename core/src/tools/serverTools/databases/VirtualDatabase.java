package tools.serverTools.databases;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.*;
import server.model.social.MConversation;
import server.model.social.MDiaryPost;
import server.model.structureModels.ServerModel;
import server.model.user.*;
import server.services.factories.MusicDiaryFactory;
import server.services.factories.TextManagerFactory;
import server.services.interfaces.models.TextManager;
import tools.AudioTools.AudioCreator;
import tools.serverTools.generators.SerialGenerator;

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
    public SerialGenerator generator = SerialGenerator.getGenerator();
    public SerialGenerator HVGenerator = SerialGenerator.getHGenerator(1000);

    public VirtualDatabase() throws IOException{
        init();
    }

    public void init() throws IOException{
        this.username_key = new HashMap<>();
        this.hashtag_key = new HashMap<>();
        this.data = new HashMap<>();

        initUserData();
        initMediaData();
        initSocialData();
    }

    private void initUserData(){
        username_key.put("Alice", 1L);
        username_key.put("Benny", 2L);
        username_key.put("Cindy", 3L);

        generator.generateSerial();
        generator.generateSerial();
        generator.generateSerial();

        generateTestUser("Alice", 1L);
        generateTestUser("Benny", 2L);
        generateTestUser("Cindy", 3L);

        User user1 = (User)data.get(1L);
        User user2 = (User)data.get(2L);
        User user3 = (User)data.get(3L);

        user1.getFriendKeys().add(user2.getKey());
        user1.getFriendKeys().add(user3.getKey());

        user2.getFriendKeys().add(user1.getKey());
        user2.getFriendKeys().add(user3.getKey());

        user3.getFriendKeys().add(user1.getKey());
        user3.getFriendKeys().add(user2.getKey());
    }

    private void initMediaData(){
        //TODO created all media here.

        //Image
        MImage image1 = generateTestImage("Alice's Profile", "UserProfiles//Alice_After_The_War.png");// TODO path
        MImage image2 = generateTestImage("Benny's Profile", "UserProfiles//Benny_After_The_War.png");// TODO path
        MImage image3 = generateTestImage("Cindy's Profile", "UserProfiles//Cindy_After_The_War.png");// TODO path

        //Audio
//        MAudio audio1 = generateTestAudio("Audio_1.mp3");// TODO path
//        MAudio audio2 = generateTestAudio("Audio_2.mp3");// TODO path
//        MAudio audio3 = generateTestAudio("Audio_3.mp3");// TODO path

        //Music
//        MMusic music1 = generateTestMusic("Music_1", audio1);// TODO path
//        MMusic music2 = generateTestMusic("Music_2", audio2);// TODO path
//        MMusic music3 = generateTestMusic("Music_3", audio3);// TODO path

        //Hashtag
        MHashtag tag1 = generateTestHashtags("#Happy");
        MHashtag tag2 = generateTestHashtags("#Sad");
        MHashtag tag3 = generateTestHashtags("#Love");

        List<Long> music_tag1 = tag1.getMusicKeys();
        List<Long> music_tag2 = tag2.getMusicKeys();
        List<Long> music_tag3 = tag3.getMusicKeys();

//        music_tag1.add(music1.getKey());
//        music_tag2.add(music2.getKey());
//        music_tag3.add(music3.getKey());

        //TODO add media to users here.
        User user1 = (User)data.get(1L);
        User user2 = (User)data.get(2L);
        User user3 = (User)data.get(3L);

        UserProfile profile1 = (UserProfile)data.get(user1.getProfile());
        UserProfile profile2 = (UserProfile)data.get(user2.getProfile());
        UserProfile profile3 = (UserProfile)data.get(user3.getProfile());

        profile1.setImageKey(image1.getKey());
        profile2.setImageKey(image2.getKey());
        profile3.setImageKey(image3.getKey());
    }

    private void initSocialData(){
        User user1 = (User)data.get(1L);
        User user2 = (User)data.get(2L);
        User user3 = (User)data.get(3L);

        generateConversation(user1, user2);
        generateConversation(user1, user3);
        generateConversation(user2, user3);

        MText alice_text = generateText("");
        MText benny_text = generateText("");
        MText cindy_text = generateText("");

        generateDiaryPost("Title", user1, alice_text, generateTestImage("ImageName", "ImagePath"), /*music*/ null);

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

    private void generateTestUser(String username, long key) {
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
                generator.generateSerial());
        conversations.setKey(
                generator.generateSerial());
        log.setKey(
                generator.generateSerial());
        content.setKey(
                generator.generateSerial());
        diary.setKey(
                generator.generateSerial());

        //ArtistProfile Attributes
        profile.setUsername(username);
        profile.setDescription("I am " + username + ".");
        profile.setImageKey(0);//i.e. empty

        //Conversation Attributes
        conversations.setConvoKeys(new ArrayList<Long>());

        //ActivityLog Attributes
        log.setLog(new ArrayList<String>());

        //UploadedContent Attributes
        content.setPostKeys(new ArrayList<Long>());

        //DiaryContent Attributes
        diary.setDiaryKeys(new ArrayList<Long>());

        //User friends.
        List<Long> friendList = new ArrayList<Long>();

        //Assign to user.
        user.setProfile(profile.getKey());
        user.setConversations(conversations.getKey());
        user.setLog(log.getKey());
        user.setContent(content.getKey());
        user.setDiary(diary.getKey());
        user.setFriendKeys(friendList);

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

        tag.setKey(generator.generateSerial());

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

        image.setKey(generator.generateSerial());

        image.setName(name);

        image.setImage(path);

        image.setName(name);

        data.put(image.getKey(), image);

        return image;
    }

    private MAudio generateTestAudio(String path){
        MAudio audio = AudioCreator.createFromFilePath(path);

        audio.setKey(generator.generateSerial());

        data.put(audio.getKey(), audio);

        return audio;
    }

    private MMusic generateTestMusic(String name, MAudio audio){
        MMusic music = new MMusic();

        music.setKey(HVGenerator.generateSerial());

        music.setName(name);

        music.setMusicKey(audio.getKey());

        data.put(music.getKey(), music);

        return music;
    }

    private MText generateText(String message){
        MText text = new MText();

        text.setKey(generator.generateSerial());

        text.setText(message);

        text.setType(0);

        data.put(text.getKey(), text);

        return text;
    }


    private void generateConversation(User user1, User user2){
        UserConversations convo_1 = (UserConversations)data.get(user1.getConversations());
        UserConversations convo_2 = (UserConversations)data.get(user2.getConversations());

        MConversation one_two = new MConversation();

        one_two.setKey(generator.generateSerial());

        one_two.setMessageList(new ArrayList<Long>());

        List<Long> one = new ArrayList<Long>();

        one.add(user1.getKey());
        one.add(user2.getKey());

        one_two.setParticipants(one);

        convo_1.getConvoKeys().add(one_two.getKey());
        convo_2.getConvoKeys().add(one_two.getKey());

        data.put(one_two.getKey(), one_two);
    }

    private void generateDiaryPost(String title, User creator, MText description, MImage image, MMusic music){
        MDiaryPost diaryPost = MusicDiaryFactory.createMusicDiary().createDiaryPost(creator, image, music, title, description);

        diaryPost.setKey(generator.generateSerial());

        UserDiaryContent content = (UserDiaryContent) data.get(creator.getDiary());

        content.getDiaryKeys().add(diaryPost.getKey());

        data.put(diaryPost.getKey(), diaryPost);
    }
}
