package tools.AudioTools;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.robovm.apple.avfoundation.AVAsset;
import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVMetadataItem;
import org.robovm.apple.foundation.*;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MSnapShot;
import tools.utilities.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Kevin on 3/11/2016.
 *
 * A class that gives the capability to create an MAudio object from an audio file.
 *
 */
public final class AudioCreator {

    private static ModelStorage ms = ModelStorageFactory.createModelStorage();;

    private static NSFileManager fm = new NSFileManager();

    private static long musicKey = 10000L;

    private static long audioKey = 9000L;

    private static Map<String, Long> albumToKey;

    public static Map<String,MMusic> songNameToMMusic;

    public static Map<String, List<MMusic>> artistToMMusic;

    public static Map<Long, MAudio> keyToMAudio = new TreeMap<Long,MAudio>();

    public static void initializeAll(){

        albumToKey = Utils.newMap();
        albumToKey.put("Songs About Jane",8000L);
        albumToKey.put("Purpose (Deluxe Edition)",8001L);
        albumToKey.put("The 20/20 Experience",8002L);
        albumToKey.put("Yeezus",8003L);
        albumToKey.put("Beauty Behind The Madness",8004L);
        albumToKey.put("X (Wembley Edition)",8005L);


        for(String s : albumToKey.keySet()){
            MImage albumArt = new MImage();
            albumArt.setKey(albumToKey.get(s));
            String q = s;
            if(q.equals("The 20/20 Experience"))
                q = "The 20:20 Experience";
            FileHandle fh = Gdx.files.internal("Thumbnails/"+q+".jpg");

            albumArt.setImage(fh.readBytes());

            albumArt.setName(s);
            //ms.pushModel(albumArt);
        }
        //Top Singles, Tagged

        songNameToMMusic = new TreeMap<String,MMusic>();
        artistToMMusic = new TreeMap<String, List<MMusic>>();


        String filePath = "/Users/Paul/ZhiYin/android/assets/MusicAssets";

        NSArray urls = new NSArray();
        try {
            urls = fm.getContentsOfDirectoryAtPath(filePath);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        for(Object f : urls) {
            if(!f.toString().equals(".DS_Store")) {
                File mp3 = new File(new File(filePath), f.toString());
                NSURL url = new NSURL(mp3.toURI().toString());
                MMusic m = createMMusicFromFilePath(url);
                assert(m.getAlbumArt()!=0L);
                songNameToMMusic.put(m.getName(), m);
                if (!artistToMMusic.containsKey(m.getArtist())) {
                    artistToMMusic.put(m.getArtist(), new ArrayList<MMusic>());
                }
                List<MMusic> temp = artistToMMusic.get(m.getArtist());
                temp.add(m);
                artistToMMusic.put(m.getArtist(), temp);

                //1mS0C00lz - paul's password
            }
        }


        //Artists: The Weeknd, Justin Bieber, Justin Timberlake, Ed Sheeran, Maroon 5, Kanye West
        System.out.println(songNameToMMusic.get("On Sight").getMusicKey());
        System.out.println("done");

    }

    private AudioCreator(){

    }

    public static MAudio createFromFilePath(String filePath){
        //NSData data = NSData.read(new NSURL(filePath));

        NSData data = fm.getContentsAtPath(filePath);

        return createMAudio(data);
    }

    public static MAudio createFromFilePath(NSURL filePath){

        NSData data = NSData.read(filePath);

        return createMAudio(data);

    }

    public static MMusic createMMusicFromFilePath(NSURL filePath){
        MAudio audio = createMAudio(NSData.read(filePath));

        MMusic music = getMetaData(filePath);
        music.setMusicKey(audio.getKey());
        music.setKey(musicKey);
        musicKey++;
        music.setComments(Utils.newList());
        //ms.pushModel(music);

        return music;
    }


    public static MSnapShot createSnapShot(long voice, long song,int start, int end){
        MSnapShot ss = new MSnapShot();
        ss.setKey(ms.generateKey());
        ss.setMessage(voice);
        ss.setSong(song);
        ss.setStartTime(start);
        ss.setEndTime(end);
        return ss;
    }

    public static MAudio createMAudio(NSData data){
        MAudio song = new MAudio();

        song.setKey(audioKey);

        song.setmData(data.getBytes());
        AVAudioPlayer temp;
        try {

            temp = new AVAudioPlayer(data);
            song.setTrackLength(temp.getDuration());

        } catch (NSErrorException e) {
            e.printStackTrace();
        }

        //ms.pushModel(song);
        keyToMAudio.put(audioKey,song);
        audioKey++;
        return song;
    }

    private static MMusic getMetaData(NSURL filePath){
        MMusic music = new MMusic();
        NSArray<AVMetadataItem> metadata = (new AVAsset(filePath)).getCommonMetadata();
        for(AVMetadataItem item : metadata){
            if(item.getCommonKey().toString().equals("title")) {
                music.setName(item.getStringValue());
            }
            if(item.getCommonKey().toString().equals("albumName")) {
                music.setAlbum(item.getStringValue());

                music.setAlbumArt(albumToKey.get(item.getStringValue()));

            }

            if(item.getCommonKey().toString().equals("artist"))
                music.setArtist(item.getStringValue());


        }
        return music;
    }
}
