//package client.pages.pageInternal.serverClientInteractions;
//
//
////--PRIVATE HELPER CLASS
//
//import server.model.media.MAudio;
//import server.model.social.MComment;
//
///**PRIVATE HELPER CLASS FOR COMMENTS
// *
// */
//public class CommentTalker extends Talkers {
//    private MComment mComment;
//
//    public String text;
//    public MAudio audio;
//
//    @Deprecated
//    @Override
//    public void init() {
//
//    }
//
//    public void init(MComment comment) {
//        this.mComment = comment;
//    }
//
//
//    @Override
//    public void pull() {
//        super.setWaiting(true);
//
////        localDatabase.requestModelFromServer(mComment.getText());
//        localDatabase.requestModelFromServer(mComment.getAudio().get(0));
//    }
//
//    @Override
//    public void push() {
//        return;
//    }
//
//    @Override
//    public boolean isUpdated() {
//        if (text == null) {
//            return false;
//        }
//
//        if (audio == null) {
//            return false;
//        }
//
//        super.setWaiting(false);
//        return true;
//    }
//
//    @Override
//    public void update(float dt) {
////        MText userText = localDatabase.getModel(mComment.getText());
//
////        text = userText.getText();
//
//        audio = localDatabase.getModel(mComment.getAudio().get(0));
//
//
//    }
//}