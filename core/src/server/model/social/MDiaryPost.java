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
    private String title;
    private long audioKey;
    private long imageKey;
    private long musicKey;

    /**Returns the title of the MusicDiary.
     *
     * @return  The title of the diary.
     */
    public String getTitle(){
        return title;
    }

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

    public void setTitle(String title){ this.title = title; }

    public void setAudioKey(long audioKey){
        this.audioKey = audioKey;
    }

    public void setImageKey(long imageKey){
        this.imageKey = imageKey;
    }

    public void setMusicKey(long musicKey){
        this.musicKey = musicKey;
    }
}
