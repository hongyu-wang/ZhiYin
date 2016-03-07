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
public class DiaryPost extends Post {
    private Audio audio;
    private Image image;
    private Music music;
    private Text text;

    private long audioKey = 0;
    private long imageKey = 0;
    private long musicKey = 0;
    private long textKey = 0;

    /**Returns the audio of the MusicDiary.
     *
     * @return  The audio.
     */
    public Audio getAudio(){
        return this.audio;
    }

    /**Returns the image of the MusicDiary.
     *
     * @return  The image.
     */
    public Image getImage(){
        return this.image;
    }

    /**Returns the music of the MusicDiary.
     *
     * @return  The music.
     */
    public Music getMusic(){
        return this.music;
    }

    /**Returns the text of the MusicDiary.
     *
     * @return  The text.
     */
    public Text getText(){
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

    public void setAudio(Audio audio){
        this.audio = audio;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public void setMusic(Music music){
        this.music = music;
    }

    public void setText(Text text){
        this.text = text;
    }
}
