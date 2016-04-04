package tools.serverTools.databases;

import server.model.media.*;
import server.model.serverKey.MServerKey;
import server.model.social.MComment;
import server.model.social.MConversation;
import server.model.social.MDiaryPost;
import server.model.structureModels.ServerModel;
import server.model.user.*;
import tools.AudioTools.AudioCreator;
import tools.serverTools.generators.SerialGenerator;
import tools.utilities.Utils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** *
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualDatabase {
    private Map<Long, ServerModel> data;
    private Map<String, Long> hashtag_key;
    private Map<String, Long> username_key;
    private List<Long> updatedKeys;
    public SerialGenerator generator = SerialGenerator.getGenerator();
    public SerialGenerator HVGenerator = SerialGenerator.getHGenerator(1000);

    public VirtualDatabase() throws IOException{
        init();
    }

    public void init() throws IOException{
        this.username_key = new ConcurrentHashMap<>();
        this.hashtag_key = new ConcurrentHashMap<>();
        this.data = new ConcurrentHashMap<>();
        this.updatedKeys = Utils.<Long>newList();

        initUserData();
        initMediaData();
        initSocialData();
        initHashtags();
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

        user1.getBandKeys().add(12000L);

        user2.getBandKeys().add(12001L);
        user2.getBandKeys().add(12002L);
        user2.getBandKeys().add(12004L);

        user3.getBandKeys().add(12002L);
        user3.getBandKeys().add(12003L);
    }

    private void initHashtags(){
        MHashtag hashtag1 = generateHashtags("Sorry", 20000);

        MHashtag hashtag2 = generateHashtags("MissingU", 20001);

        MHashtag hashtag3 = generateHashtags("Weeknd", 20002);

        MHashtag hashtag4 = generateHashtags("RnB", 20003);

        MHashtag hashtag5 = generateHashtags("Pop", 20004);

        MHashtag hashtag6 = generateHashtags("M5", 20005);

        MHashtag hashtag7 = generateHashtags("Bieber", 20006);

        MHashtag hashtag8 = generateHashtags("Kanye", 20007);

        MHashtag hashtag9 = generateHashtags("Ed", 20008);

        MHashtag hashtag10 = generateHashtags("LoveYourself", 20009);


        data.put(hashtag1.getKey(),hashtag1);
        data.put(hashtag2.getKey(),hashtag2);
        data.put(hashtag3.getKey(),hashtag3);
        data.put(hashtag4.getKey(),hashtag4);
        data.put(hashtag5.getKey(),hashtag5);
        data.put(hashtag6.getKey(),hashtag6);
        data.put(hashtag7.getKey(),hashtag7);
        data.put(hashtag8.getKey(),hashtag8);
        data.put(hashtag9.getKey(),hashtag9);
        data.put(hashtag10.getKey(),hashtag10);
    }

    private MHashtag generateHashtags(String tag, long key){
        MHashtag hashtag = new MHashtag();
        hashtag.setKey(key);
        hashtag.setHashtag(tag);
        hashtag.setMusicKeys(Utils.newList());

        return hashtag;
    }


    private void initMediaData(){

//        Image
//        MImage image1 = generateTestImage("Alice's Profile", "UserProfiles//Alice_After_The_War.png");
//        MImage image2 = generateTestImage("Benny's Profile", "UserProfiles//Benny_After_The_War.png");
//        MImage image3 = generateTestImage("Cindy's Profile", "UserProfiles//Cindy_After_The_War.png");
//
//        Audio
//        MAudio audio1 = generateTestAudio("Audio_1.mp3");
//        MAudio audio2 = generateTestAudio("Audio_2.mp3");
//        MAudio audio3 = generateTestAudio("Audio_3.mp3");
//
//        Music
//        MMusic music1 = generateTestMusic("Music_1", audio1);
//        MMusic music2 = generateTestMusic("Music_2", audio2);
//        MMusic music3 = generateTestMusic("Music_3", audio3);
//
//        Hashtag
//        MHashtag tag1 = generateTestHashtags("#Happy");
//        MHashtag tag2 = generateTestHashtags("#Sad");
//        MHashtag tag3 = generateTestHashtags("#Love");
//
//        List<Long> music_tag1 = tag1.getMusicKeys();
//        List<Long> music_tag2 = tag2.getMusicKeys();
//        List<Long> music_tag3 = tag3.getMusicKeys();
//
//        music_tag1.add(music1.getKey());
//        music_tag2.add(music2.getKey());
//        music_tag3.add(music3.getKey());

        User user1 = (User)data.get(1L);
        User user2 = (User)data.get(2L);
        User user3 = (User)data.get(3L);

        UserProfile profile1 = (UserProfile)data.get(user1.getProfile());
        UserProfile profile2 = (UserProfile)data.get(user2.getProfile());
        UserProfile profile3 = (UserProfile)data.get(user3.getProfile());

        profile1.setImageKey(-11L);
        profile2.setImageKey(-12L);
        profile3.setImageKey(-13L);

    }

    private void initSocialData(){
        User user1 = (User)data.get(1L);
        User user2 = (User)data.get(2L);
        User user3 = (User)data.get(3L);

        generateConversation(user1, user2);
        generateConversation(user1, user3);
        generateConversation(user2, user3);

        MText alice_text = generateText("My name is Alice and I love this song.");
        MText benny_text = generateText("My name is Benny and I love this song.");
        MText cindy_text = generateText("My name is Benny and I love this song.");

        generateStaticDiaryPost("Title1", user1, alice_text.getKey(), 2999999, 10000);
        generateStaticDiaryPost("Title2", user2, benny_text.getKey(), 5999999, 10001);
        generateStaticDiaryPost("Title3", user3, cindy_text.getKey(), 8999999, 10002);
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
        updatedKeys.add(model.getKey());
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
        MServerKey serverKey = new MServerKey();

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
        serverKey.setKey(
                generator.generateSerial());

        //ArtistProfile Attributes
        profile.setUsername(username);
        profile.setDescription("I am " + username + ".");
        profile.setImageKey(0);//i.e. empty

        //Conversation Attributes
        conversations.setConvoKeys(new ArrayList<Long>());

        //ActivityLog Attributes
        log.setLog(Utils.<String>newList());

        //UploadedContent Attributes
        content.setPostKeys(Utils.<Long>newList());

        //DiaryContent Attributes
        diary.setDiaryKeys(Utils.<Long>newList());

        //User friends.
        List<Long> friendList = Utils.newList();

        //User artists
        List<Long> bandList = Utils.newList();

        //ServerState
        serverKey.setCurrentKey(0L);

        //Assign to user.
        user.setProfile(profile.getKey());
        user.setConversations(conversations.getKey());
        user.setLog(log.getKey());
        user.setContent(content.getKey());
        user.setDiary(diary.getKey());
        user.setFriendKeys(friendList);
        user.setBandKeys(bandList);
        user.setKeyState(serverKey.getKey());

        //Put into database.
        data.put(user.getKey(), user);
        data.put(profile.getKey(), profile);
        data.put(conversations.getKey(), conversations);
        data.put(log.getKey(), log);
        data.put(content.getKey(), content);
        data.put(diary.getKey(), diary);
        data.put(serverKey.getKey(), serverKey);
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

//        image.setImage(path);

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

    private void generateStaticDiaryPost(String title, User creator, long description, long image, long music){
        MDiaryPost diaryPost = new MDiaryPost();

        diaryPost.setTitle(title);

        diaryPost.setCreator(creator.getKey());

        diaryPost.setText(description);

        diaryPost.setImageKey(image);

        diaryPost.setMusicKey(music);

        diaryPost.setComments(Utils.<Long>newList());

        generateComment(diaryPost, creator);

        diaryPost.setKey(generator.generateSerial());

        UserDiaryContent content = (UserDiaryContent) data.get(creator.getDiary());

        content.getDiaryKeys().add(diaryPost.getKey());

        data.put(diaryPost.getKey(), diaryPost);
    }

    private void generateComment(MDiaryPost post, User creator){
        UserProfile profile = (UserProfile)data.get(creator.getProfile());

        MComment comment = new MComment();
        comment.setKey(generator.generateSerial());

        comment.setCreator(creator.getKey());
        comment.setText("I'm " + profile.getUsername() + ", this is a server comment.");
        comment.setAudio(Utils.<Long>newList());
        comment.setMusic(Utils.<Long>newList());
        comment.setLikes(Utils.<Long>newList());

        post.getComments().add(comment.getKey());
        data.put(comment.getKey(), comment);
    }

    public List<Long> getUpdatedKeys() {
        return updatedKeys;
    }
}
