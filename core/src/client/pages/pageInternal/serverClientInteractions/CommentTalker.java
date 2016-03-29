package client.pages.pageInternal.serverClientInteractions;


//--PRIVATE HELPER CLASS

import server.model.media.MAudio;
import server.model.media.MText;
import server.model.social.MComment;

/**PRIVATE HELPER CLASS FOR COMMENTS
 *
 */
public class CommentTalker extends Talkers {
    private MComment mComment;

    public String text;
    public MAudio audio;

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MComment comment) {
        this.mComment = comment;
    }


    @Override
    public void pull() {
        super.setWaiting(true);

//        modelStorage.requestModelFromServer(mComment.getText());
        modelStorage.requestModelFromServer(mComment.getAudio().get(0));
    }

    @Override
    public void push() {
        return;
    }

    @Override
    public boolean isUpdated() {
        if (text == null) {
            return false;
        }

        if (audio == null) {
            return false;
        }

        super.setWaiting(false);
        return true;
    }

    @Override
    public void update(float dt) {
//        MText userText = modelStorage.getModel(mComment.getText());

//        text = userText.getText();

        audio = modelStorage.getModel(mComment.getAudio().get(0));


    }
}