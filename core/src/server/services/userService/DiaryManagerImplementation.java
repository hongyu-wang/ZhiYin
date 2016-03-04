package server.services.userService;

import server.model.musicDiary.DiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class DiaryManagerImplementation implements DiaryManager {
    @Override
    public UserDiaryContent requestAllDiaryContent(String user) {
        UserDiaryContent diary = new UserDiaryContent();
        return diary;
        //TODO request from server
    }

    @Override
    public User addDiaryPost(User user, DiaryPost diaryPost) {
//        user.getDiary().getDiaryKeys().add(diaryPost.getKey());
        user.getDiary().getDiaryposts().add(diaryPost);
        return user;
        //TODO implement keys
        //TODO request change to server
    }
}
