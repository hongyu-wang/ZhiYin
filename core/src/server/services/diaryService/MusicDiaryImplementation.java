package server.services.diaryService;

import server.model.social.DiaryPost;
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
    public DiaryPost requestDiaryPostData(long diaryPostKey){
        DiaryPost diaryPost = new DiaryPost();

        long key = 0;
        diaryPost.setKey(key);

        Audio audio = new AudioManagerImplementation().requestAudio(diaryPost.getAudioKey());
        diaryPost.setAudio(audio);

        Image image = new ImageManagerImplementation().requestImage(diaryPost.getImageKey());
        diaryPost.setImage(image);

        Music music = new MusicManagerImplementation().requestMusic(diaryPost.getMusicKey());
        diaryPost.setMusic(music);

        Text text = new TextManagerImplementation().requestText(diaryPost.getTextKey());
        diaryPost.setText(text);

        return diaryPost;
        //TODO request from server.
    }

    @Override
    public DiaryPost modifyAudio(DiaryPost diaryPost, Audio audio){
        diaryPost.setAudio(audio);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public DiaryPost modifyImage(DiaryPost diaryPost, Image image){
        diaryPost.setImage(image);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public DiaryPost modifyMusic(DiaryPost diaryPost, Music music){
        diaryPost.setMusic(music);
        return diaryPost;
        //TODO request change to server.
    }

    @Override
    public DiaryPost modifyText(DiaryPost diaryPost, Text text){
        diaryPost.setText(text);
        return diaryPost;
        //TODO request change to server.
    }
}
