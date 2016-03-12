package server.model.media;


import server.model.structureModels.ServerModel;
import java.util.Vector;


/**A piece of audio that has not been identified as a piece of music yet.
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MAudio extends ServerModel {
    public static final int MODE_STREAM = -1;


    private Vector<byte[]> mData = new Vector<>();
    private String trackName;
    private int sampleRate;
    private String album;



    public MAudio() {

    }

    public void write(byte[] ba, int i, int length)
    {
        while (mData.size() > 10) Thread.yield();

        //System.out.println("SOUND IN: "+length+" bytes");
        mData.addElement(ba);
    }

    public Vector<byte[]> getmData(){
        return mData;
    }

    public String getName(){
        return trackName;
    }

}