package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.media.MMusic;
import server.model.social.MComment;
import server.model.soundCloud.MBand;
import server.model.soundCloud.MMusicPost;
import server.model.user.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-22.
 */
public class MusicTalker extends Talkers{
    private MMusicPost musicPost;
    private MMusic mMusic;

    //--Interface Fields
    private Texture image;
    private String name;
    private User creator;
    private MBand artist;
    private MAudio music;

    private List<MHashtag> mHashtags;
    private List<MComment> mComments;
    private List<MAudio>   audioComments;

    //Getters and Setters
    public Texture getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public User getCreator() {
        return creator;
    }

    public MAudio getMusicData() { return music; }

    public List<MHashtag> getHashtags() {
        return mHashtags;
    }

    public List<MComment> getComments() {
        return mComments;
    }

    public List<MAudio> getAudioComments() {
        return audioComments;
    }

    public String getCommentText(MComment comment){
        return comments.get(comment);
    }


    /*------------------------------------------------------------------------*/

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MMusicPost musicPost){
        this.musicPost = musicPost;
    }


    /*------------------------------------------------------------------------*/

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

    @Override
    public void update(float dt) {

    }
}
