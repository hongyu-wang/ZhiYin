package tools.AudioTools;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.foundation.NSURLConnection;
import org.robovm.rt.bro.ptr.BytePtr;
import server.model.media.MAudio;

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
        return NSData.read(filePath);
    }

    //public MAudio createFromFilePath(String path, )

}
