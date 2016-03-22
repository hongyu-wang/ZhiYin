package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import server.model.media.MAudio;
import server.model.media.MMusic;
import server.model.social.MComment;
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

    }

    @Override
    public void push() {

    }

    @Override
    public boolean isUpdated() {
        return false;
    }
}
