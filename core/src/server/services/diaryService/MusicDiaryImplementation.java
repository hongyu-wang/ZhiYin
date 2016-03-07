package server.services.diaryService;

import server.model.social.MDiaryPost;
import server.model.media.*;
import server.services.mediaService.ImageManagerImplementation;
import server.services.mediaService.AudioManagerImplementation;
import server.services.mediaService.MusicManagerImplementation;
import server.services.mediaService.TextManagerImplementation;

/**
 * Created by calin on 06/03/2016.
 */
public class MusicDiaryImplementation implements MusicDiary {
    @Override
    public MDiaryPost requestDiaryPostData(long diaryPostKey){
        MDiaryPost diaryPost = new MDiaryPost();

        long key = 0;
        diaryPost.setKey(key);

        MAudio audio = new AudioManagerImplementation().requestAudio(diaryPost.getAudioKey());
        diaryPost.setAudio(audio);

        MImage image = new ImageManagerImplementation().requestImage(diaryPost.getImageKey());
        diaryPost.setImage(image);

        MMusic music = new MusicManagerImplementation().requestMusic(diaryPost.getMusicKey());
        diaryPost.setMusic(music);

        MText text = new TextManagerImplementation().requestText(diaryPost.getTextKey());
        diaryPost.setText(text);

        return diaryPost;
        //TODO request from server.
    }

    @Override
    public MDiaryPost modifyAudio(MDiaryPost diaryPost, MAudio audio){
        diaryPost.setAudio(audio);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public MDiaryPost modifyImage(MDiaryPost diaryPost, MImage image){
        diaryPost.setImage(image);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public MDiaryPost modifyMusic(MDiaryPost diaryPost, MMusic music){
        diaryPost.setMusic(music);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public MDiaryPost modifyText(MDiaryPost diaryPost, MText text){
        diaryPost.setText(text);
        return diaryPost;
        //TODO request change to server.
    }
}
