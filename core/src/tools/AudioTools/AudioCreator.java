package tools.AudioTools;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.foundation.NSURLConnection;
import org.robovm.rt.bro.ptr.BytePtr;
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

    private AudioCreator(){

    }

    public static NSData createFromFilePath(NSURL filePath){
        //return NSFileManager.getContentsAtPath(filePath.getPath());
        return NSData.read(filePath);
    }

    public static MSnapShot createSnapShot(MAudio voice, MMusic song,int start, int end){
        MSnapShot ss = new MSnapShot();
        ss.setMessage(voice);
        ss.setSong(song);
        ss.setStartTime(start);
        ss.setEndTime(end);
        return ss;
    }

    //public MAudio createFromFilePath(String path, )

}
