package tools.AudioTools;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import org.robovm.apple.avfoundation.AVAsset;
import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVMetadataItem;
import org.robovm.apple.foundation.*;
import server.model.media.MAudio;
import server.model.media.MMusic;
import server.model.media.MSnapShot;

/**
 * Created by Kevin on 3/11/2016.
 *
 * A class that gives the capability to create an MAudio object from an audio file.
 *
 */
public class AudioCreator {

    private static ModelStorage ms;

    private static NSFileManager fm;

    private AudioCreator(){

        ms = ModelStorageFactory.createModelStorage();
        fm = new NSFileManager();

    }

    public static MAudio createFromFilePath(String filePath){
        NSData data = NSData.read(new NSURL(filePath));

        return createMAudio(data);
    }

    public static MAudio createFromFilePath(NSURL filePath){

        NSData data = NSData.read(filePath);

        return createMAudio(data);

    }

    public static MMusic createMMusicFromFilePath(NSURL filePath){
        MAudio audio = createMAudio(NSData.read(filePath));

        MMusic music = new MMusic();
        //music.setMusicKey(ms.generateKey());


        NSArray<AVMetadataItem> metadata = (new AVAsset(filePath)).getCommonMetadata();
        for(AVMetadataItem item : metadata){
            if(item.getCommonKey().toString().equals("title")) {
                music.setName(item.getStringValue());
            }

            if(item.getCommonKey().toString().equals("albumName"))
                music.setAlbum(item.getStringValue());

            if(item.getCommonKey().toString().equals("artist"))
                music.setArtist(item.getStringValue());
        }
        return music;
    }


    public static MSnapShot createSnapShot(long voice, long song,int start, int end){
        MSnapShot ss = new MSnapShot();
        //ss.setKey(ms.generateKey());
        ss.setMessage(voice);
        ss.setSong(song);
        ss.setStartTime(start);
        ss.setEndTime(end);
        return ss;
    }

    public static MAudio createMAudio(NSData data){
        MAudio song = new MAudio();

        //song.setKey(ms.generateKey());
        song.setmData(data);
        AVAudioPlayer temp;
        try {

            temp = new AVAudioPlayer(data);
            song.setTrackLength(temp.getDuration());

        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        return song;
    }
}
