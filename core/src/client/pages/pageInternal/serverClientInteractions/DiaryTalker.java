package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MDiaryPost;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class DiaryTalker extends Talkers{
    private MDiaryPost diaryPost;

    //--Interface Fields
    private String text;
    private Texture image;
    private MMusic music;
    private MAudio userRecording;

    private List<MComment> mComments;
    private Map<MComment, String> comments;
    private Map<MComment, MAudio> oneSecAudioComments;

    //Getters and Setters
    public String getText() {
        return text;
    }

    public Texture getImage() {
        return image;
    }

    public MMusic getMusic() {
        return music;
    }

    public MAudio getUserRecording() {
        return userRecording;
    }

    public List<MComment> getAllComments() {
        return mComments;
    }

    public String getCommentText(MComment comment) {
        return comments.get(comment);
    }

    public MAudio getOneSecCommentAudio(MComment comment) {
        return oneSecAudioComments.get(comment);
    }

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
        MText postText = modelStorage.getModel(this.diaryPost.getTextKey());
        if(postText != null)
            text = postText.getText();

        MImage postImage = modelStorage.getModel(this.diaryPost.getAudioKey());
        if(postImage != null)
            image = postImage.getImage();

        music = modelStorage.getModel(this.diaryPost.getMusicKey());
        userRecording = modelStorage.getModel(this.diaryPost.getAudioKey());


        List<MComment> newCommentsList = Utils.<MComment>newList();

        for(long key: diaryPost.getComments()){
            newCommentsList.add(modelStorage.getModel(key));
        }
    }

    @Override
    public void pull() {
        modelStorage.requestModelFromServer(MImage.class.getName(), diaryPost.getImageKey());
        modelStorage.requestModelFromServer(MText.class.getName(), diaryPost.getTextKey());
        modelStorage.requestModelFromServer(MMusic.class.getName(), diaryPost.getMusicKey());
        modelStorage.requestModelFromServer(MAudio.class.getName(), diaryPost.getAudioKey());

        for(long key: diaryPost.getComments()){
            modelStorage.requestModelFromServer(MComment.class.getName(), key);
        }
    }

    @Override
    public void push() {
        MText postText = modelStorage.getModel(this.diaryPost.getTextKey());
        MImage postImage = modelStorage.getModel(this.diaryPost.getAudioKey());

        postText.setText(text);
        postImage.setImage(image);

        diaryPost.setMusicKey(music.getKey());
        diaryPost.setAudioKey(userRecording.getKey());

        while(mComments.size() > diaryPost.getComments().size()){

        }

        modelStorage.pushModel(postText);
        modelStorage.pushModel(postImage);
        modelStorage.pushModel(diaryPost);
    }

    @Override
    public boolean isUpdated() {
        return false;
    }
}
