package client.events.executables.internalChanges.serverInteractions;

import client.pages.musicDiary.Diary2;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.services.factories.MusicDiaryFactory;
import server.services.factories.TextManagerFactory;
import server.services.factories.UserDiaryManagerFactory;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendDiaryPost implements ExecuteServer {
    Diary2 diary2;

    public ExecuteSendDiaryPost(Diary2 diary2){
        this.diary2 = diary2;
    }

    @Override
    public void execute() {
        User mainUser = localDatabase.getMainUser();
        UserDiaryContent userDiaryContent  = localDatabase.getModel(mainUser.getDiary());

        MText diaryBody = generateMText(diary2.getBody());
        MAudio audio = diary2.getAudio();
        MMusic music = diary2.getMusic();
        MImage image = diary2.getImage();

        MDiaryPost diary = generateMDiaryPost(mainUser, diaryBody, diary2.getTitle(), image, music, audio);

        userDiaryContent.getDiaryKeys().add(diary.getKey());

        //------------------Pushing.
        List<ServerModel> pushList = Utils.newList();

        pushList.add(diary);
        pushList.add(diaryBody);
        pushList.add(userDiaryContent);
        if(audio.getKey() != 0){
            pushList.add(audio);
        }
        if(music.getKey() != 0){
            pushList.add(music);
        }
        if(image.getKey() != 0){
            pushList.add(image);
        }
        localDatabase.pushModel(pushList);
    }


    private MText generateMText(String text){
        MText diaryBody = TextManagerFactory.createTextManager().createText(text, 0);
        diaryBody.setKey(localDatabase.generateKey());

        return diaryBody;
    }

    private MDiaryPost generateMDiaryPost(User mainUser, MText diaryBody, String diaryTitle, MImage image, MMusic music, MAudio audio){
        MDiaryPost diaryPost = MusicDiaryFactory.createMusicDiary().createDiaryPost(mainUser, image.getKey(), music.getKey(), audio.getKey(), diaryTitle, diaryBody.getKey());

        diaryPost.setTimeStamp(System.currentTimeMillis());

        diaryPost.setKey(localDatabase.generateKey());

        return diaryPost;
    }


}
