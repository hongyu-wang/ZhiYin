package server.services.serviceInterfaces;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface MusicDiary {

    /**Modify the audio.
     *
     * @param diaryPost      The MDiaryPost.
     * @param audio          The audio.
     * @return               The modified MDiaryPost model.
     */
    MDiaryPost modifyAudio(MDiaryPost diaryPost, MAudio audio);

    /**Modify the image.
     *
     * @param diaryPost      The MDiaryPost.
     * @param image          The image.
     * @return               The modified MDiaryPost model.
     */
    MDiaryPost modifyImage(MDiaryPost diaryPost, MImage image);

    /**Modify the image.
     *
     * @param diaryPost      The MDiaryPost.
     * @param music          The music.
     * @return               The modified MDiaryPost model.
     */
    MDiaryPost modifyMusic(MDiaryPost diaryPost, MMusic music);

    /**Modify the image.
     *
     * @param diaryPost      The MDiaryPost.
     * @param text          The text.
     * @return               The modified MDiaryPost model.
     */
    MDiaryPost modifyText(MDiaryPost diaryPost, MText text);
}
