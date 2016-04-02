package client.pages.pageInternal.serverClientInteractions;

import driver.GameLoop;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.soundCloud.MBand;
import server.model.soundCloud.MMusicAlbum;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.services.factories.ImageManagerFactory;
import tools.AudioTools.AudioCreator;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * AlbumsArt: 8000
 * Audio: 9000
 * Music: 10000
 * Hashtag: 11000
 * MBand: 12000
 *
 * ProfileImages: -11
 *                -12
 *                -13
 *
 * DiaryImages:   2999999
 *                5999999
 *                8999999
 *
 * ArtistImages: 100
 *
 *
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class VeryBeginningInitializer extends Talkers{

    /*------------------------------------------------------------------------*/

    @Override
    @Deprecated
    public void init() {

    }

    public void init(String username){
        modelStorage.loginUser(username);

        TalkerFactory.getFriendTalker().init();
    }

    /*------------------------------------------------------------------------*/



    @Override
    public void pull() {
        super.setWaiting(true);

        long key = 1;

        //Users
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(key++);
        }

        //UserContents
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
        }

        //Images
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(key++);

        //Audio
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MAudio.class.getName(), key++);

        //Music
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MMusic.class.getName(), key++);

        //Hashtag
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(key++);

        //Conversations
        for(int i = 0; i < 3 ; i++){
            modelStorage.requestModelFromServer(key++);
        }

        //Text
        for(int i = 0; i < 3 ; i++){
            modelStorage.requestModelFromServer(key++);
        }

        //DiaryPosts
        for(int i = 0; i < 6 ; i++){
            modelStorage.requestModelFromServer(key++);
        }

        //TODO LMAO
//        modelStorage.requestModelFromServer(3000001);

        totalOriginalModels = key;
    }

    @Override
    public void push() {

        //TODO robovm
//+        AudioCreator.initializeAll();

        pushProfileImages();
        pushDiaryImages();
        pushArtistImages();
        pushMBands();

        GameLoop.ISPUSHING = true;
    }

    private void pushProfileImages(){
        MImage image1 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Alice_After_The_War.png");
        MImage image2 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Benny_After_The_War.png");
        MImage image3 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Cindy_After_The_War.png");

        image1.setKey(-11L);
        image2.setKey(-12L);
        image3.setKey(-13L);

        image1.setName("Alice's Profile");
        image2.setName("Benny's Profile");
        image3.setName("Cindy's Profile");

        modelStorage.pushModel(image1);
        modelStorage.pushModel(image2);
        modelStorage.pushModel(image3);
    }

    private void pushDiaryImages(){
        MImage image4 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Alice_After_The_War.png");
        MImage image5 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Benny_After_The_War.png");
        MImage image6 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Cindy_After_The_War.png");

        image4.setKey(2999999L);
        image5.setKey(5999999L);
        image6.setKey(8999999L);

        image4.setName("Alice's Profile");
        image5.setName("Benny's Profile");
        image6.setName("Cindy's Profile");

        modelStorage.pushModel(image4);
        modelStorage.pushModel(image5);
        modelStorage.pushModel(image6);
    }

    private void pushArtistImages(){
        MImage artist1 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//AdamLevine.png");
        MImage artist2 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//EdSheeran.png");
        MImage artist3 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//JustinBieber.png");
        MImage artist4 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//JustinTimberlake.png");
        MImage artist5 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//KanyeWest.png");
        MImage artist6 = ImageManagerFactory.createImageManager().createNewImage("ArtistProfiles//TheWeeknd.png");


        artist1.setName("AdamLevine's Profile Pic");
        artist2.setName("EdSheeran's Profile Pic");
        artist3.setName("JustinBieber's Profile Pic");
        artist4.setName("JustinTimberlake's Profile Pic");
        artist5.setName("KanyeWest's Profile Pic");
        artist6.setName("The Weekend's Profile Pic");

        artist1.setKey(100L);
        artist2.setKey(101L);
        artist3.setKey(102L);
        artist4.setKey(103L);
        artist5.setKey(104L);
        artist6.setKey(105L);

        modelStorage.pushModel(artist1);
        modelStorage.pushModel(artist2);
        modelStorage.pushModel(artist3);
        modelStorage.pushModel(artist4);
        modelStorage.pushModel(artist5);
        modelStorage.pushModel(artist6);
    }

    private void pushMBands(){
//        Map<String, List<MMusic>> artistMap = AudioCreator.artistToMMusic;

        String[] artists = {
                "Maroon 5",
                "Ed Sheeran",
                "Justin Bieber",
                "Justin Timberlake",
                "Kanye West",
                "The Weeknd"
        };
                //TODO remove robovm;
        for(String artist: artists){
            MBand mBand = new MBand();

            if(artist.equals("Maroon 5")){
                mBand.setKey(12000L);
                mBand.setDescription("Adam Noah Levine is an American singer, songwriter, multi-instrumentalist and actor. He is the lead vocalist for the Los Angeles pop rock band Maroon 5.");
                mBand.setBandImage(100L);
            } else
            if(artist.equals("Ed Sheeran")){
                mBand.setKey(12001L);
                mBand.setDescription("Edward Christopher \"Ed\" Sheeran is an English singer-songwriter and musician. He was born in Hebden Bridge in Yorkshire and raised in Framlingham, Suffolk.");
                mBand.setBandImage(101L);
            } else
            if(artist.equals("Justin Bieber")){
                mBand.setKey(12002L);
                mBand.setDescription("Justin Drew Bieber is a Canadian singer and songwriter. After a talent manager discovered him through his YouTube videos covering songs in 2007 and signed to RBMG, Bieber released his debut EP, My World, in late 2009.");
                mBand.setBandImage(102L);
            } else
            if(artist.equals("Justin Timberlake")){
                mBand.setKey(12003L);
                mBand.setDescription("Justin Randall Timberlake is an American singer, songwriter, actor, and record producer. He appeared on the television shows Star Search and The All-New Mickey Mouse Club as a child.");
                mBand.setBandImage(103L);
            } else
            if(artist.equals("Kanye West")){
                mBand.setKey(12004L);
                mBand.setDescription("Kanye Omari West is an American hip hop recording artist, songwriter, record producer, fashion designer, and entrepreneur.");
                mBand.setBandImage(104L);
            } else
            if(artist.equals("The Weeknd")){
                mBand.setKey(12005L);
                mBand.setDescription("Abęl Makkonen Tesfaye, known professionally by his stage name The Weeknd, is a Canadian singer, songwriter and record producer. In late 2010, Tesfaye anonymously uploaded several songs to YouTube under the name \"The Weeknd\".");
                mBand.setBandImage(105L);
            }
            else{
                throw new NoSuchElementException();
            }

            /*
            mBand.setSongs(getKeys(artistMap.get(artist)));
            mBand.setAlbums(getAlbums(artistMap.get(artist)));
             */

            mBand.setSongs(Utils.<Long>newList());
            mBand.setAlbums(Utils.<Long>newList());
            mBand.setName(artist);

            modelStorage.pushModel(mBand);
        }
    }

    private List<Long> getAlbums(List<MMusic> modelList){
        List<Long> keyList = Utils.newList();
//        List<String, MMusicAlbum> album;

        for(MMusic music: modelList){
            music.getAlbum();
        }

        return keyList;
    }

    private List<Long> getKeys(List<MMusic> modelList){
        List<Long> keyList = Utils.newList();
        for(ServerModel model: modelList){
            keyList.add(model.getKey());
        }

        return keyList;
    }






    @Override
    public boolean isUpdated() {
        boolean initialUpdate = super.checkOriginalUpdate();

        if(!initialUpdate){
            return false;
        }

        boolean updateFriend = TalkerFactory.getFriendTalker().isUpdated();
        boolean updateProfiles = TalkerFactory.getProfileTalker().isUpdated();

        boolean[] talkers = {
                updateFriend,
                updateProfiles
        };

        for(boolean truth: talkers){
            if(!truth){
                return false;
            }
        }

        super.setWaiting(initialUpdate);
        return initialUpdate;
    }

    @Override
    public void update(float dt) {
        if(!super.checkOriginalUpdate()){
            return;
        }

        talkerInit();
    }

    private void talkerInit(){
        FriendTalker ft = TalkerFactory.getFriendTalker();
        ProfileTalker pt = TalkerFactory.getProfileTalker();
        ft.update(0);
        for(User friend: ft.getAllFriends()){
            pt.init(friend);
            pt.update(0);

        }
    }
}
