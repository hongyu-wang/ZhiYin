package server.model.social;
import server.model.media.*;

/** A model of all basic information for MusicDiary.
 *
 *      -audio
 *      -image
 *      -music
 *      -text
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MDiaryPost extends MPost {
    private long audioKey = 0;
    private long imageKey = 0;
    private long musicKey = 0;
    private long textKey = 0;

    /**Returns the audioKey of the MusicDiary.
     *
     * @return  The audioKey.
     */
    public long getAudioKey(){
        return this.audioKey;
    }

    /**Returns the imageKey of the MusicDiary.
     *
     * @return  The imageKey.
     */
    public long getImageKey(){
        return this.imageKey;
    }

    /**Returns the musicKey of the MusicDiary.
     *
     * @return  The musicKey.
     */
    public long getMusicKey(){
        return this.musicKey;
    }

    /**Returns the textKey of the MusicDiary.
     *
     * @return  The textKey.
     */
    public long getTextKey(){
        return this.textKey;
    }

    public void setAudioKey(long audioKey){
        this.audioKey = audioKey;
    }

    public void setImageKey(long imageKey){
        this.imageKey = imageKey;
    }

    public void setMusicKey(long musicKey){
        this.musicKey = musicKey;
    }

    public void setTextKey(long textKey){
        this.textKey = textKey;
    }
}
