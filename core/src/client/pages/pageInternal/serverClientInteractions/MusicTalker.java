package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.social.MComment;
import server.model.user.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-22.
 */
public class MusicTalker extends Talkers{

    public Texture image;
    public String name;
    public User creator;

    public List<MHashtag> mHashtags;
    public List<MComment> mComments;
    public List<MAudio>   audioComments;

    public Map<MComment, String> comments;

    /*------------------------------------------------------------------------*/


    @Override
    public void init() {

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
