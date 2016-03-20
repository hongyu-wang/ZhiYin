package tools.AudioTools;

import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVURLAsset;
import org.robovm.apple.coremedia.CMTime;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
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

    public static NSData createFromFilePath(String filePath){
        return NSData.read(new NSURL(filePath));
    }

    public static MAudio createFromFilePath(NSURL filePath){

        NSData data = NSData.read(filePath);

        return createMAudio(data);

    }

    public static MSnapShot createSnapShot(long voice, long song,int start, int end){
        MSnapShot ss = new MSnapShot();
        ss.setMessage(voice);
        ss.setSong(song);
        ss.setStartTime(start);
        ss.setEndTime(end);
        return ss;
    }

    public static MAudio createMAudio(NSData data){
        MAudio song = new MAudio();
        AVAudioPlayer temp;
        try {
            temp = new AVAudioPlayer(data);
            double duration = temp.getDuration();
            song.setTrackMinutes((int)(duration/60));
            song.setTrackSeconds((int) (duration % 60));
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        return song;
    }
}
