package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MConversation;
import server.model.social.MDiaryPost;
import server.model.user.UserDiaryContent;

import java.util.Map;

/**
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class DiaryTalker extends Talkers{
    private MDiaryPost diaryPost;

    public String text;
    public Texture image;
    public MMusic music;
    public MAudio userAudio;

    public List<MComment> mComments;
    public Map<MComment, String> comments;
    public Map<MComment, MAudio> oneSecAudioComments;


    /*------------------------------------------------------------------------*/

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MDiaryPost diaryPost){
        this.diaryPost = diaryPost;
    }

    /*------------------------------------------------------------------------*/

    /**
     *
     * @param dt The rate of change of updating
     */
    @Override
    public void update(float dt) {

    }

    @Override
    public void pull() {
        modelStorage.requestModelFromServer(MImage.class.getName(), diaryPost.getImageKey());
        modelStorage.requestModelFromServer(MText.class.getName(), diaryPost.getTextKey());
        modelStorage.requestModelFromServer(MMusic.class.getName(), diaryPost.getMusicKey());
        modelStorage.requestModelFromServer(MAudio.class.getName(), diaryPost.getAudioKey());

        for(long key: diaryPost.getComments()){
            modelStorage.requestModelFromServer(MConversation.class.getName(), key);
        }
    }

    @Override
    public void push() {

    }

    @Override
    public boolean isUpdated() {
        return false;
    }
}
