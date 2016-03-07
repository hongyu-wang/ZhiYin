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
    private MAudio audio;
    private MImage image;
    private MMusic music;
    private MText text;

    private long audioKey = 0;
    private long imageKey = 0;
    private long musicKey = 0;
    private long textKey = 0;

    /**Returns the audio of the MusicDiary.
     *
     * @return  The audio.
     */
    public MAudio getAudio(){
        return this.audio;
    }

    /**Returns the image of the MusicDiary.
     *
     * @return  The image.
     */
    public MImage getImage(){
        return this.image;
    }

    /**Returns the music of the MusicDiary.
     *
     * @return  The music.
     */
    public MMusic getMusic(){
        return this.music;
    }

    /**Returns the text of the MusicDiary.
     *
     * @return  The text.
     */
    public MText getText(){
        return this.text;
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

    /**Returns the textKey of the MusicDiary.
     *
     * @return  The textKey.
     */
    public long getTextKey(){
        return this.textKey;
    }

    public void setAudio(MAudio audio){
        this.audio = audio;
    }

    public void setImage(MImage image){
        this.image = image;
    }

    public void setMusic(MMusic music){
        this.music = music;
    }

    public void setText(MText text){
        this.text = text;
    }
}
