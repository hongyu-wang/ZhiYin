package client.events.executables.internalChanges.serverInteractions;

import client.pages.musicDiary.Diary2;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.services.factories.MusicDiaryFactory;
import server.services.factories.TextManagerFactory;
import server.services.factories.UserDiaryManagerFactory;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendDiaryPost implements ExecutePush {
    Diary2 diary2;

    public ExecuteSendDiaryPost(Diary2 diary2){
        this.diary2 = diary2;
    }

    @Override
    public void execute() {

        User mainUser = localDatabase.getMainUser();
        UserDiaryContent userDiaryContent  = localDatabase.getModel(mainUser.getDiary());

        List<Long> diaryKeys = userDiaryContent.getDiaryKeys();

        String diaryTitle = diary2.getTitle();

        MText diaryBody = TextManagerFactory.createTextManager().createText(diary2.getBody(), 0);
        diaryBody.setKey(localDatabase.generateKey());

        MDiaryPost diary = MusicDiaryFactory.createMusicDiary().createDiaryPost(mainUser, -1, -1, diaryTitle, diaryBody.getKey());

        diary.setKey(localDatabase.generateKey());

        diaryKeys.add(diary.getKey());

        UserDiaryManagerFactory.createUserDiaryManager().addDiaryPost(userDiaryContent, diary);

        localDatabase.pushModel(diary);
        localDatabase.pushModel(userDiaryContent);
    }

}
