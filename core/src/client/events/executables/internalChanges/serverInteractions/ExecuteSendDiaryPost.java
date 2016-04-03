package client.events.executables.internalChanges.serverInteractions;

import client.pages.musicDiary.Diary2;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.services.factories.MusicDiaryFactory;
import server.services.factories.TextManagerFactory;
import server.services.factories.UserDiaryManagerFactory;

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
        MDiaryPost diary = generateMDiaryPost(mainUser, diaryBody, diary2.getTitle());

        userDiaryContent.getDiaryKeys().add(diary.getKey());

        ServerModel[] pushList = {
                diary,
                diaryBody,
                userDiaryContent
        };

        localDatabase.pushModel(pushList);
    }


    private MText generateMText(String text){
        MText diaryBody = TextManagerFactory.createTextManager().createText(text, 0);
        diaryBody.setKey(localDatabase.generateKey());

        return diaryBody;
    }

    private MDiaryPost generateMDiaryPost(User mainUser, MText diaryBody, String diaryTitle){
        MDiaryPost diaryPost = MusicDiaryFactory.createMusicDiary().createDiaryPost(mainUser, -1, -1, diaryTitle, diaryBody.getKey());

        diaryPost.setTimeStamp(System.currentTimeMillis());

        diaryPost.setKey(localDatabase.generateKey());

        return diaryPost;
    }


}
