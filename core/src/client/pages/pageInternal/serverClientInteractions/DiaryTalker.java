//package client.pages.pageInternal.serverClientInteractions;
//
//import server.model.media.MAudio;
//import server.model.media.MImage;
//import server.model.media.MMusic;
//import server.model.media.MText;
//import server.model.social.MComment;
//import server.model.social.MDiaryPost;
//import tools.utilities.Utils;
//
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * Created by Hongyu Wang on 3/21/2016.
// */
//public class DiaryTalker extends Talkers{
//    private static Map<Long, DiaryHelper> userDiaries = Utils.newMap();
//
//    private DiaryHelper currentDiary;
//
//    //Getters and Setters
//    public String getText() {
//        return currentDiary.getText();
//    }
//
//    public String getImage() {
//        return currentDiary.getImage();
//    }
//
//    public MMusic getMusic() {
//        return currentDiary.getMusic();
//    }
//
//    public MAudio getUserRecording() {
//        return currentDiary.getUserRecording();
//    }
//
//    public List<MComment> getAllComments() {
//        return currentDiary.getAllComments();
//    }
//
//    @Deprecated
//    @Override
//    public void init() {
//
//    }
//
//    public void init(MDiaryPost post){
//        if(userDiaries.containsKey(post.getKey())){
//            currentDiary = userDiaries.get(post.getKey());
//        }
//        else{
//            currentDiary = new DiaryHelper();
//            currentDiary.init(post);
//
//            userDiaries.put(post.getKey(), currentDiary);
//        }
//    }
//
//
//    @Override
//    public void pull() {
//        currentDiary.pull();
//    }
//
//    @Override
//    public void push() {
//        currentDiary.push();
//    }
//
//    @Override
//    public boolean isUpdated() {
//        return currentDiary.isUpdated();
//    }
//
//    @Override
//    public void update(float dt) {
//        currentDiary.update(dt);
//    }
//
//    @Override
//    public boolean isWaiting(){
//        return currentDiary.isWaiting();
//    }
//
//
//    private class DiaryHelper extends Talkers{
//        private MDiaryPost diaryPost;
//
//        //--Interface Fields
//        private String text;
//        private String image;
//        private MMusic music;
//        private MAudio userRecording;
//
//        private List<MComment> mComments;
//
//        //Getters and Setters
//        public String getText() {
//            return text;
//        }
//
//        public String getImage() {
//            return image;
//        }
//
//        public MMusic getMusic() {
//            return music;
//        }
//
//        public MAudio getUserRecording() {
//            return userRecording;
//        }
//
//        public List<MComment> getAllComments() {
//            return mComments;
//        }
//
//    /*------------------------------------------------------------------------*/
//
//        @Deprecated
//        @Override
//        public void init() {
//
//        }
//
//        public void init(MDiaryPost diaryPost){
//            this.diaryPost = diaryPost;
//        }
//
//    /*------------------------------------------------------------------------*/
//
//        /**
//         *
//         * @param dt The rate of change of updating
//         */
//        @Override
//        public void update(float dt) {
//            MText postText = localDatabase.getModel(this.diaryPost.getText());
//            if(postText != null)
//                text = postText.getText();
//
//            MImage postImage = localDatabase.getModel(this.diaryPost.getAudioKey());
//            if(postImage != null)
//                //image = postImage.getImage();
//
//            music = localDatabase.getModel(this.diaryPost.getMusicKey());
//            userRecording = localDatabase.getModel(this.diaryPost.getAudioKey());
//        }
//
//        @Override
//        public void pull() {
//            localDatabase.requestModelFromServer(diaryPost.getImageKey());
//            localDatabase.requestModelFromServer(diaryPost.getText());
//            localDatabase.requestModelFromServer(diaryPost.getMusicKey());
//            localDatabase.requestModelFromServer(diaryPost.getAudioKey());
//
//            for(long key: diaryPost.getComments()){
//                localDatabase.requestModelFromServer(key);
//            }
//        }
//
//        @Override
//        public void push() {
//
//            //Text, Texture, Music, Audio
//            MText postText = localDatabase.getModel(this.diaryPost.getText());
//            MImage postImage = localDatabase.getModel(this.diaryPost.getAudioKey());
//
//            postText.setText(text);
//            //postImage.setImage(image);
//
//            diaryPost.setMusicKey(music.getKey());
//            diaryPost.setAudioKey(userRecording.getKey());
//
//            //Comments
//            while(mComments.size() > diaryPost.getComments().size()){
//                MComment comment = mComments.get(diaryPost.getComments().size());
//
//                diaryPost.getComments().add(comment.getKey());
//
//                localDatabase.pushModel(comment);
//            }
//            localDatabase.pushModel(postText);
//            localDatabase.pushModel(postImage);
//            localDatabase.pushModel(diaryPost);
//        }
//
//        @Override
//        public boolean isUpdated() {
//            if(text == null || image == null || music == null || userRecording == null){
//                return false;
//            }
//
//            if(mComments == null){
//                return false;
//            }
//
//            for(MComment comment: mComments){
//                if(comment == null){
//                    return false;
//                }
//            }
//
//            return true;
//        }
//    }
//
//}
