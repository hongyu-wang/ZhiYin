package server.services.interfaces.models;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.user.User;

/**
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface MusicDiary {

    MDiaryPost createDiaryPost(User user, long image, long music, long audio, String title, long description);

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
}
