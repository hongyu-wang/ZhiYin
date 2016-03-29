package client.events.executables.internalChanges.conversation;

import client.pages.musicDiary.Diary2;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MDiaryPost;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.model.user.UserProfile;
import server.services.factories.CommentManagerFactory;
import server.services.factories.MusicDiaryFactory;
import server.services.factories.TextManagerFactory;
import server.services.factories.UserDiaryManagerFactory;
import server.services.implementations.diaryService.MusicDiaryImplementation;
import server.services.implementations.mediaService.TextManagerImplementation;
import server.services.interfaces.models.MusicDiary;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendDiaryPost implements Executable {
    Diary2 diary2;

    public ExecuteSendDiaryPost(Diary2 diary2){
        this.diary2 = diary2;
    }

    @Override
    public void execute() {
        ModelStorage ms = ModelStorageFactory.createModelStorage();

        User mainUser = ms.getMainUser();
        UserDiaryContent userDiaryContent  = ms.getModel(mainUser.getDiary());

        List<Long> diaryKeys = userDiaryContent.getDiaryKeys();

        String diaryTitle = diary2.getTitle();

        MText diaryBody = TextManagerFactory.createTextManager().createText(diary2.getBody(), 0);
        diaryBody.setKey(ms.generateKey());

        //TODO FIx all dis shit
        MDiaryPost diary = MusicDiaryFactory.createMusicDiary().createDiaryPost(mainUser, -1, -1, diaryTitle, diaryBody.getKey());

        diary.setKey(ms.generateKey());

        diaryKeys.add(diary.getKey());

        UserDiaryManagerFactory.createUserDiaryManager().addDiaryPost(userDiaryContent, diary);

        ms.pushModel(diary);
        ms.pushModel(userDiaryContent);
    }

}
