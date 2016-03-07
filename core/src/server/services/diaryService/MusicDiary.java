package server.services.diaryService;
import server.model.media.Audio;
import server.model.media.Music;
import server.model.media.Image;
import server.model.media.Text;
import server.model.musicDiary.DiaryPost;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface MusicDiary {
    /**Requests the DiaryPost's data from the server.
     *
     * @param key   The user's key.
     * @return          The DiaryPost model.
     */
    DiaryPost requestDiaryPostData(long key);

    /**Modify the audio.
     *
     * @param diaryPost      The DiaryPost.
     * @param audio          The audio.
     * @return               The modified DiaryPost model.
     */
    DiaryPost modifyAudio(DiaryPost diaryPost, Audio audio);

    /**Modify the image.
     *
     * @param diaryPost      The DiaryPost.
     * @param image          The image.
     * @return               The modified DiaryPost model.
     */
    DiaryPost modifyImage(DiaryPost diaryPost, Image image);

    /**Modify the image.
     *
     * @param diaryPost      The DiaryPost.
     * @param music          The music.
     * @return               The modified DiaryPost model.
     */
    DiaryPost modifyMusic(DiaryPost diaryPost, Music music);

    /**Modify the image.
     *
     * @param diaryPost      The DiaryPost.
     * @param text          The text.
     * @return               The modified DiaryPost model.
     */
    DiaryPost modifyText(DiaryPost diaryPost, Text text);
}
