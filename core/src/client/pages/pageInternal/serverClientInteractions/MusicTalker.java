package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.social.MComment;
import server.model.soundCloud.MBand;
import server.model.soundCloud.MMusicPost;
import server.model.user.User;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-22.
 */
public class MusicTalker extends Talkers{
    private MMusic mMusic;
    private MImage mImage;

    //--Interface Fields
    private String image;
    private String name;
    private String artist;
    private String album;
    private MAudio music;

    private List<MHashtag> mHashtags;
    private List<MComment> mComments;
    private List<MComment> audioComments;

    //Getters and Setters
    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public MAudio getMusicData() { return music; }

    public List<MHashtag> getHashtags() {
        return mHashtags;
    }

    public List<MComment> getComments() {
        return mComments;
    }

    public List<MComment> getAudioComments() {
        return audioComments;
    }


    /*------------------------------------------------------------------------*/

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MMusic music){
        this.mMusic = music;
    }

    public void addNewComment(MComment comment){

    }


    /*------------------------------------------------------------------------*/

    @Override
    public void pull() {
        super.setWaiting(true);

        modelStorage.requestModelFromServer(MImage.class.getName(), mMusic.getAlbumArt());
        modelStorage.requestModelFromServer(MAudio.class.getName(), mMusic.getMusicKey());

        //SOCIAL MEDIA
        for(long key : mMusic.getComments()){
            modelStorage.requestModelFromServer(MComment.class.getName(), key);
        }

        //TODO Hashtags
    }

    @Override
    public void push() {

    }

    @Override
    public boolean isUpdated() {
        if(name == null)
            return false;

        if(album == null)
            return false;

        if(artist == null)
            return false;

        if(music == null)
            return false;

        if(mImage == null)
            return false;

        if(mMusic.getComments().size() != (mComments.size() + audioComments.size())){
            return false;
        }

        super.setWaiting(false);
        return true;

    }

    @Override
    public void update(float dt) {
        name = mMusic.getName();
        album = mMusic.getAlbum();
        artist = mMusic.getArtist();

        music = modelStorage.getModel(mMusic.getMusicKey());
        mImage = modelStorage.getModel(mMusic.getAlbumArt());

        if(mImage != null){
            image = mImage.getImage();
        }

        //SOCIAL MEDIA
        List<MComment> newComments = Utils.newList();
        List<MComment> newAudioComments = Utils.newList();

        for(long key: mMusic.getComments()){
            MComment comment = modelStorage.getModel(key);
            updateComments(newComments, newAudioComments, comment);
        }

        mComments = newComments;
        audioComments = newAudioComments;
    }

    private void updateComments(List newComments, List audioComments, MComment comment){
        if(comment == null){
            return;
        }

        if(comment.getAudio().size() == 0){
            newComments.add(comment);
        }
        else{
            audioComments.add(comment);
        }
    }
}
