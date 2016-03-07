package server.services.diaryService;

import server.model.musicDiary.DiaryPost;
import server.model.media.*;
import server.services.mediaService.ImageManagerImplementation;

/**
 * Created by calin on 06/03/2016.
 */
public class MusicDiaryImplementation implements MusicDiary {
    @Override
    public DiaryPost requestDiaryPostData(long diaryPostKey){
        DiaryPost diaryPost = new DiaryPost();

        long key = 0;           //Server request
        diaryPost.setKey(key);

        Audio audio = null;     //Server request
        diaryPost.setAudio(audio);

        Image image = null;     //Server request
        diaryPost.setImage(image);

        Music music = null;     //Server request
        diaryPost.setMusic(music);

        Text text = null;       //Server request
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
